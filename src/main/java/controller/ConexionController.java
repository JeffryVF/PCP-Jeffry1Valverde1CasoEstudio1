package controller;

import model.models.conexion;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionController {
    private ConsoleView consoleView;

    public ConexionController(ConsoleView consoleView){
        this.consoleView = consoleView;
    }

    public void openConnection(){
        Connection connection = conexion.getConnection();
        consoleView.showMessage("Conexion establecida.");
        try {
            connection.close();
        } catch (SQLException e) {
            consoleView.errorMessage("Conexion no establecida " + e.getMessage());
        }
    }
}
