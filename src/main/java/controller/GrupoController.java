package controller;

import model.DAO.GrupoDAO;
import model.models.GrupoModel;
import model.models.conexion;
import view.ConsoleView;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrupoController {
    private ConsoleView consoleView;
    private GrupoDAO grupoDAO;

    public GrupoController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = conexion.getConnection();
        this.grupoDAO = new GrupoDAO(connection);
    }

    public void agregarGrupo(String nombre, String descripcion){
        GrupoModel datos = new GrupoModel(nombre, descripcion, 1);

        try {
            grupoDAO.agregarGrupo(datos);
            consoleView.showMessage("Datos insertados.");
        } catch (SQLException e) {
            consoleView.errorMessage("Datos no insertados " + e);
        }
    }

    public void actualizarGrupo(int id, String nombre, String descripcion) {
        boolean encontrado = false;
        ArrayList<GrupoModel> grupos = null;
        try {
            grupos = grupoDAO.consultaGrupo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        GrupoModel datos = new GrupoModel(id, nombre, descripcion, 1);
        for (var tempGrupo:grupos){
            if (tempGrupo.getId() == datos.getId() && tempGrupo.getEstado() == 1) {
                try {
                    grupoDAO.actualizarGrupo(datos);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("Grupo no actualizado " + e);
                }
            }
        }

        if (encontrado){
            consoleView.showMessage("Datos actualizados");
        } else {
            consoleView.showMessage("El grupo no existe en el sistema!");
        }
    }

    public void eliminarGrupo(int id) {
        boolean encontrado = false;
        ArrayList<GrupoModel> grupos = null;
        try {
            grupos = grupoDAO.consultaGrupo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (var tempGrupo:grupos){
            if (tempGrupo.getId() == id && tempGrupo.getEstado() == 1) {
                try {
                    grupoDAO.eliminarGrupo(tempGrupo);
                    encontrado = true;
                } catch (SQLException e) {
                    consoleView.errorMessage("Grupo no eliminado " + e);
                }
            }
        }

        if (encontrado){
            consoleView.showMessage("Grupo eliminado");
        } else {
            consoleView.showMessage("El grupo no existe en el sistema!");
        }

    }

    public ArrayList<GrupoModel> consultaGrupo() {
        ArrayList<GrupoModel> grupos = null;
        try {
            grupos = grupoDAO.consultaGrupo();
        } catch (SQLException e) {
            consoleView.showMessage("Consulta no realizada " + e);
        }
        return grupos;
    }
}
