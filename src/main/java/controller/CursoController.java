package controller;

import model.DAO.CursoDAO;
import model.models.CursoModel;
import model.models.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoController {
    private ConsoleView consoleView;
    private CursoDAO cursoDAO;

    public CursoController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = conexion.getConnection();
        this.cursoDAO = new CursoDAO(connection);
    }

    public void agregarCurso(String nombre, String descripcion){
        CursoModel datos = new CursoModel(nombre, descripcion, 1);

        try {
            cursoDAO.agregarCurso(datos);
            consoleView.showMessage("Datos insertados.");
        } catch (SQLException e) {
            consoleView.errorMessage("Datos no insertados " + e);
        }
    }

    public void actualizarCurso(int id, String nombre, String descripcion) {
        boolean encontrado = false;
        ArrayList<CursoModel> cursos = null;
        try {
            cursos = cursoDAO.consultaCurso();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        CursoModel datos = new CursoModel(id, nombre, descripcion, 1);
        for (var tempCurso:cursos){
            if (tempCurso.getId() == datos.getId() && tempCurso.getEstado() == 1) {
                try {
                    cursoDAO.actualizarCurso(datos);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("Curso no actualizado " + e);
                }
            }
        }

        if (encontrado){
            consoleView.showMessage("Datos actualizados");
        } else {
            consoleView.showMessage("El curso no existe en el sistema!");
        }
    }

    public void eliminarCurso(int id) {
        boolean encontrado = false;
        ArrayList<CursoModel> cursos = null;
        try {
            cursos = cursoDAO.consultaCurso();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (var tempCurso:cursos){
            if (tempCurso.getId() == id && tempCurso.getEstado() == 1) {
                try {
                    cursoDAO.eliminarCurso(tempCurso);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("Curso no eliminado " + e);
                }
            }
        }

        if (encontrado){
            consoleView.showMessage("Curso eliminado");
        } else {
            consoleView.showMessage("El curso no existe en el sistema!");
        }

    }

    public ArrayList<CursoModel> consultaCurso() {
        ArrayList<CursoModel> cursos = null;
        try {
            cursos = cursoDAO.consultaCurso();
        } catch (SQLException e) {
            consoleView.showMessage("Consulta no realizada " + e);
        }
        return cursos;
    }
}
