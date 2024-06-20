package controller;

import model.DAO.EstudianteDAO;
import model.models.EstudiateModel;
import model.models.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstudianteController {
    private ConsoleView consoleView;
    private EstudianteDAO estudianteDAO;

    public EstudianteController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = conexion.getConnection();
        this.estudianteDAO = new EstudianteDAO(connection);
    }

    //String query = "INSERT INTO `estudiante_jevf` (`id`, `nombre`, `identificacion`, `email`, `fecha_nacimiento`, `estado`) VALUES(?, ?, ?, ?, ?, ?)";

    public void agregarEstudiante(String nombre, int identificacion, String email, Date fechaNacimiento){
        EstudiateModel datos = new EstudiateModel(nombre, identificacion, email, fechaNacimiento, 1);

        try {
            estudianteDAO.agregarEstudiante(datos);
            consoleView.showMessage("Datos insertados.");
        } catch (SQLException e) {
            consoleView.errorMessage("Datos no insertados " + e);
        }
    }

    public void actualizarEstudiante(int id, String nombre, int identificacion, String email, Date fechaNacimiento) {
        boolean encontrado = false;
        ArrayList<EstudiateModel> estudiantes = null;
        try {
            estudiantes = estudianteDAO.consultaEstudiante();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        EstudiateModel datos = new EstudiateModel(id, nombre, identificacion, email, fechaNacimiento, 1);
        for (var tempEstudiante:estudiantes){
            if (tempEstudiante.getId() == datos.getId() && tempEstudiante.getEstado() == 1) {
                try {
                    estudianteDAO.actualizarEstudiante(datos);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("Estudiante no actualizado " + e);
                }
            }
        }

        if (encontrado){
                consoleView.showMessage("Datos actualizados");
        } else {
            consoleView.showMessage("El estudiante no existe en el sistema!");
        }
    }

    public void eliminarEstudiante(int id) {
        boolean encontrado = false;
        ArrayList<EstudiateModel> estudiantes = null;
        try {
            estudiantes = estudianteDAO.consultaEstudiante();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (var tempEstudiante:estudiantes){
            if (tempEstudiante.getId() == id && tempEstudiante.getEstado() == 1) {
                try {
                    estudianteDAO.eliminarEstudiante(tempEstudiante);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("Estudiante no eliminado " + e);
                }
            }
        }

        if (encontrado){
            consoleView.showMessage("Estudiante eliminado");
        } else {
            consoleView.showMessage("El estudiante no existe en el sistema!");
        }

    }

    public ArrayList<EstudiateModel> consultaEstudiante() {
        ArrayList<EstudiateModel> estudiantes = null;
        try {
            estudiantes = estudianteDAO.consultaEstudiante();
        } catch (SQLException e) {
            consoleView.showMessage("Consulta no realizada " + e);
        }
        return estudiantes;
    }
}
