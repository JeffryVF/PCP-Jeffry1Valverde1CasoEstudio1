package model.DAO;

import model.models.ProfesorModel;
import java.sql.*;
import java.util.ArrayList;

public class ProfesorDAO {
    private Connection connection;

    public ProfesorDAO (Connection connection) {
        this.connection = connection;
    }

    public void agregarProfesor(ProfesorModel profesor) throws SQLException {
        String query = "INSERT INTO `profesor_jevf` (`nombre`, `identificacion`, `email`, `departamento`, `estado`) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, profesor.getNombre());
            stmt.setInt(2, profesor.getIdentificacion());
            stmt.setString(3, profesor.getEmail());
            stmt.setString(4, profesor.getDepartamento());
            stmt.setInt(5, profesor.getEstado());
            stmt.execute();
        }
    }

    public void actualizarProfesor(ProfesorModel profesor) throws SQLException {
        String query = "UPDATE `profesor_jevf` SET `id` = ?, `nombre` = ?, `identificacion` = ?, `email` = ?, `departamento` = ?, `estado` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, profesor.getId());
            stmt.setString(2, profesor.getNombre());
            stmt.setInt(3, profesor.getIdentificacion());
            stmt.setString(4, profesor.getEmail());
            stmt.setString(5, profesor.getDepartamento());
            stmt.setInt(6, profesor.getEstado());
            stmt.setInt(7, profesor.getId());
            stmt.execute();
        }
    }

    public void eliminarProfesor(ProfesorModel profesor) throws SQLException {
        String query = "UPDATE `profesor_jevf` SET `estado` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, 0);
            stmt.setInt(2, profesor.getId());
            stmt.execute();
        }
    }

    public ArrayList<ProfesorModel> consultaProfesor() throws SQLException {
        ResultSet rs = null;
        String query = "SELECT `id`, `nombre`, `identificacion`, `email`, `departamento`, `estado` FROM `profesor_jevf`";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            rs = stmt.executeQuery();

            ArrayList<ProfesorModel> listProfesores = new ArrayList<>();

            while (rs.next()) {
                ProfesorModel profesor = new ProfesorModel();
                profesor.setId(rs.getInt("id"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setIdentificacion(rs.getInt("identificacion"));
                profesor.setEmail(rs.getString("email"));
                profesor.setDepartamento(rs.getString("departamento"));
                profesor.setEstado(rs.getInt("estado"));
                listProfesores.add(profesor);
            }
            rs.close();
            return listProfesores;
        }
    }
}
