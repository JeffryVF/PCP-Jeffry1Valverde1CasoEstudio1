package controller;

import model.DAO.ProfesorDAO;
import model.models.ProfesorModel;
import model.models.conexion;
import view.ConsoleView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorController {
    private ConsoleView consoleView;
    private ProfesorDAO profesorDAO;

    public ProfesorController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = conexion.getConnection();
        this.profesorDAO = new ProfesorDAO(connection);
    }

    public void agregarProfesor(String nombre, int identificacion, String email, String departamento){
        ProfesorModel datos = new ProfesorModel(nombre, identificacion, email, departamento, 1);

        try {
            profesorDAO.agregarProfesor(datos);
            consoleView.showMessage("Datos insertados.");
        }catch (SQLException e) {
            consoleView.showMessage("Datos no insertados " + e);
        }
    }

    public void actulizarProfesor(int id, String nombre, int identificacion, String email, String departamento) {
        boolean encontrado = false;
        ArrayList<ProfesorModel> profesores = null;
        try {
            profesores = profesorDAO.consultaProfesor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ProfesorModel datos = new ProfesorModel(id, nombre, identificacion, email, departamento, 1);
        for (var tempProfesor:profesores){
            if (tempProfesor.getId() == datos.getId() && tempProfesor.getEstado() == 1) {
                try {
                    profesorDAO.actualizarProfesor(datos);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("Profesor no actualizado " + e);
                }
            }
        }

        if (encontrado){
            consoleView.showMessage("Datos actualizados");
        } else {
            consoleView.showMessage("El profesor no existe en el sistema!");
        }
    }

    public void eliminarProfesor(int id) {
        boolean encontrado = false;
        ArrayList<ProfesorModel> profesores = null;
        try {
            profesores = profesorDAO.consultaProfesor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (var tempProfesor:profesores){
            if (tempProfesor.getId() == id && tempProfesor.getEstado() == 1) {
                try {
                    profesorDAO.eliminarProfesor(tempProfesor);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("Profesor no eliminado " + e);
                }
            }
        }

        if (encontrado){
            consoleView.showMessage("Profesor eliminado");
        } else {
            consoleView.showMessage("El profesor no existe en el sistema!");
        }

    }

    public ArrayList<ProfesorModel> consultaProfesor() {
        ArrayList<ProfesorModel> profesores = null;
        try {
            profesores = profesorDAO.consultaProfesor();
        } catch (SQLException e) {
            consoleView.showMessage("Consulta no realizada " + e);
        }
        return profesores;
    }
}
