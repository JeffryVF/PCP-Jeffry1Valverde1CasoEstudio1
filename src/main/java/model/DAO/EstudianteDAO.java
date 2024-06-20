package model.DAO;

import model.models.EstudiateModel;
import java.sql.*;
import java.util.ArrayList;

public class EstudianteDAO {
    private Connection connection;

    public EstudianteDAO (Connection connection) {
        this.connection = connection;
    }

    public void agregarEstudiante(EstudiateModel estudiante) throws SQLException {
        String query = "INSERT INTO `estudiante_jevf` (`nombre`, `identificacion`, `email`, `fecha_nacimiento`, `estado`) VALUES(?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, estudiante.getNombre());
            stmt.setInt(2, estudiante.getIdentificacion());
            stmt.setString(3, estudiante.getEmail());
            stmt.setDate(4, (Date)estudiante.getFechaNacimiento());
            stmt.setInt(5, estudiante.getEstado());
            stmt.execute();
        }
    }

    public void actualizarEstudiante(EstudiateModel estudiante) throws SQLException {
        String query = "UPDATE `estudiante_jevf` SET `id` = ?, `nombre` = ?, \n" +
                       "`identificacion` = ?, `email` = ?, `fecha_nacimiento` = ?, \n" +
                       "`estado` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, estudiante.getId());
            stmt.setString(2, estudiante.getNombre());
            stmt.setInt(3, estudiante.getIdentificacion());
            stmt.setString(4, estudiante.getEmail());
            stmt.setDate(5, (Date)estudiante.getFechaNacimiento());
            stmt.setInt(6, estudiante.getEstado());
            stmt.setInt(7, estudiante.getId());
            stmt.execute();
        }
    }

    public void eliminarEstudiante(EstudiateModel estudiante) throws SQLException {
        String query = "UPDATE `estudiante_jevf` SET `estado` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, 0);
            stmt.setInt(2, estudiante.getId());
            stmt.execute();
        }
    }

    public ArrayList<EstudiateModel> consultaEstudiante() throws SQLException {
        ResultSet rs = null;
        String query = "SELECT `id`, `nombre`, `identificacion`, `email`, `fecha_nacimiento`, `estado` FROM `estudiante_jevf`";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            rs = stmt.executeQuery();

            ArrayList<EstudiateModel> listEstudiantes = new ArrayList<>();

            while (rs.next()) {
                EstudiateModel estudiate = new EstudiateModel();
                estudiate.setId(rs.getInt("id"));
                estudiate.setNombre(rs.getString("nombre"));
                estudiate.setIdentificacion(rs.getInt("identificacion"));
                estudiate.setEmail(rs.getString("email"));
                estudiate.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                estudiate.setEstado(rs.getInt("estado"));
                listEstudiantes.add(estudiate);
            }
            rs.close();
            return listEstudiantes;
        }
    }
}
