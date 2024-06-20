package model.DAO;

import model.models.GrupoModel;
import java.sql.*;
import java.util.ArrayList;

public class GrupoDAO {
    private Connection connection;

    public GrupoDAO(Connection connection){
        this.connection = connection;
    }


    public void agregarGrupo(GrupoModel grupo) throws SQLException {
        String query = "INSERT INTO `grupo_jevf` (`nombre`, `descripcion`, `estado`) VALUES (?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, grupo.getNombre());
            stmt.setString(2, grupo.getDescripcion());
            stmt.setInt(3, grupo.getEstado());
            stmt.execute();
        }
    }

    public void actualizarGrupo(GrupoModel grupo) throws SQLException {
        String query = "UPDATE `grupo_jevf` SET `id` = ?, `nombre` = ?, `descripcion` = ?, `estado` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, grupo.getId());
            stmt.setString(2, grupo.getNombre());
            stmt.setString(3, grupo.getDescripcion());
            stmt.setInt(4, grupo.getEstado());
            stmt.setInt(5, grupo.getId());
            stmt.execute();
        }
    }

    public void eliminarGrupo(GrupoModel grupo) throws SQLException {
        String query = "UPDATE `grupo_jevf` SET `estado` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, 0);
            stmt.setInt(2, grupo.getId());
            stmt.execute();
        }
    }

    public ArrayList<GrupoModel> consultaGrupo() throws SQLException {
        ResultSet rs = null;
        String query = "SELECT `id`, `nombre`, `descripcion`, `estado` FROM `grupo_jevf`";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            rs = stmt.executeQuery();

            ArrayList<GrupoModel> listGrupos = new ArrayList<>();

            while (rs.next()) {
                GrupoModel grupo = new GrupoModel();
                grupo.setId(rs.getInt("id"));
                grupo.setNombre(rs.getString("nombre"));
                grupo.setDescripcion(rs.getString("descripcion"));
                grupo.setEstado(rs.getInt("estado"));
                listGrupos.add(grupo);
            }
            rs.close();
            return listGrupos;
        }
    }
}
