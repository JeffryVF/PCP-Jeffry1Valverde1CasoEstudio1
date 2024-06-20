package model.DAO;

import model.models.CursoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoDAO {
    private Connection connection;

    public CursoDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarCurso(CursoModel curso) throws SQLException {
        String query = "INSERT INTO `curso_jevf` (`nombre`, `descripcion`, `estado`) VALUES (?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, curso.getNombre());
            stmt.setString(2, curso.getDescripcion());
            stmt.setInt(3, curso.getEstado());
            stmt.execute();
        }
    }

    public void actualizarCurso(CursoModel curso) throws SQLException {
        String query = "UPDATE `curso_jevf` SET `id` = ?, `nombre` = ?, `descripcion` = ?, `estado` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, curso.getId());
            stmt.setString(2, curso.getNombre());
            stmt.setString(3, curso.getDescripcion());
            stmt.setInt(4, curso.getEstado());
            stmt.setInt(5, curso.getId());
            stmt.execute();
        }
    }

    public void eliminarCurso(CursoModel curso) throws SQLException {
        String query = "UPDATE `curso_jevf` SET `estado` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, 0);
            stmt.setInt(2, curso.getId());
            stmt.execute();
        }
    }

    public ArrayList<CursoModel> consultaCurso() throws SQLException {
        ResultSet rs = null;
        String query = "SELECT `id`, `nombre`, `descripcion`, `estado` FROM `curso_jevf`";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            rs = stmt.executeQuery();

            ArrayList<CursoModel> listCursos = new ArrayList<>();

            while (rs.next()) {
                CursoModel curso = new CursoModel();
                curso.setId(rs.getInt("id"));
                curso.setNombre(rs.getString("nombre"));
                curso.setDescripcion(rs.getString("descripcion"));
                curso.setEstado(rs.getInt("estado"));
                listCursos.add(curso);
            }
            rs.close();
            return listCursos;
        }
    }

}
