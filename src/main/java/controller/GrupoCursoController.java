package controller;

import model.DAO.GrupoCursoDAO;
import model.models.GrupoCursoModel;
import model.models.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrupoCursoController {
    private ConsoleView consoleView;
    private GrupoCursoDAO grupoCursoDAO;

    public GrupoCursoController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = conexion.getConnection();
        this.grupoCursoDAO = new GrupoCursoDAO(connection);
    }

    public void agregarGrupoCurso(int grupoId, int cursoId){
        GrupoCursoModel datos = new GrupoCursoModel(grupoId, cursoId);

        try {
            grupoCursoDAO.agregarGrupoCurso(datos);
            consoleView.showMessage("Datos insertados.");
        } catch (SQLException e) {
            consoleView.errorMessage("Datos no insertados " + e);
        }
    }

    public void actualizarGrupoCurso(int id, int grupoId, int cursoId) {
        boolean encontrado = false;
        ArrayList<GrupoCursoModel> grupoCurso = null;
        try {
            grupoCurso = grupoCursoDAO.consultaGrupoCurso();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        GrupoCursoModel datos = new GrupoCursoModel(id, grupoId, cursoId);
        for (var tempGrupoCurso:grupoCurso){
            if (tempGrupoCurso.getId() == datos.getId()) {
                try {
                    grupoCursoDAO.actualizarGrupoCurso(datos);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("La relación no se ha actualizado " + e);
                }
            }
        }

        if (encontrado){
            consoleView.showMessage("Datos actualizados");
        } else {
            consoleView.showMessage("La relación no existe en el sistema!");
        }
    }

    public ArrayList<GrupoCursoModel> consultaGrupoCurso() {
        ArrayList<GrupoCursoModel> grupoCurso = null;
        try {
            grupoCurso = grupoCursoDAO.consultaGrupoCurso();
        } catch (SQLException e) {
            consoleView.showMessage("Consulta no realizada " + e);
        }
        return grupoCurso;
    }

    public ArrayList<GrupoCursoModel> consultaGrupoCursoRelacionado() {
        ArrayList<GrupoCursoModel> grupoCursoR = null;
        try {
            grupoCursoR = grupoCursoDAO.consultaGrupoCursoRelacionado();
        } catch (SQLException e) {
            consoleView.showMessage("Consulta no realizada " + e);
        }
        return grupoCursoR;
    }
}
