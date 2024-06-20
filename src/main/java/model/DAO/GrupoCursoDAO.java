package model.DAO;

import model.models.GrupoCursoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrupoCursoDAO {
    private Connection connection;

    public GrupoCursoDAO(Connection connection){
        this.connection = connection;
    }

    public void agregarGrupoCurso(GrupoCursoModel grupoCurso) throws SQLException {
        String query = "INSERT INTO `grupo_curso_jevf` (`id`, `grupo_id`, `curso_id`) VALUES (?, ?, ?);";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, grupoCurso.getCursoId());
            stmt.setInt(2, grupoCurso.getGrupoId());
            stmt.setInt(3, grupoCurso.getCursoId());
            stmt.execute();
        }
    }

    public void actualizarGrupoCurso(GrupoCursoModel grupoCurso) throws SQLException {
        String query = "UPDATE `grupo_curso_jevf` SET `id` = ?, `grupo_id` = ?, `curso_id` = ? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, grupoCurso.getId());
            stmt.setInt(2, grupoCurso.getGrupoId());
            stmt.setInt(3, grupoCurso.getCursoId());
            stmt.setInt(4, grupoCurso.getId());
            stmt.execute();
        }
    }

    public ArrayList<GrupoCursoModel> consultaGrupoCurso() throws SQLException {
        ResultSet rs = null;
        String query = "SELECT `id`, `grupo_id`, `curso_id` FROM `grupo_curso_jevf`";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            rs = stmt.executeQuery();

            ArrayList<GrupoCursoModel> listGrupoCurso = new ArrayList<>();

            while (rs.next()) {
                GrupoCursoModel grupoCurso = new GrupoCursoModel();
                grupoCurso.setId(rs.getInt("id"));
                grupoCurso.setGrupoId(rs.getInt("grupo_id"));
                grupoCurso.setCursoId(rs.getInt("curso_id"));
                listGrupoCurso.add(grupoCurso);
            }
            rs.close();
            return listGrupoCurso;
        }
    }


    public ArrayList<GrupoCursoModel> consultaGrupoCursoRelacionado() throws SQLException {
        ResultSet rs = null;
        String query = "SELECT `grupo_curso_jevf`.`id`, `grupo_jevf`.`id` AS id_grupo, `grupo_jevf`.`nombre` AS nombre_grupo, `grupo_jevf`.`descripcion` AS descripcion_grupo, `grupo_jevf`.`estado` AS estado_grupo,\n" +
                "`curso_jevf`.`id` AS id_curso, `curso_jevf`.`nombre` AS nombre_curso, `curso_jevf`.`descripcion` AS descripcion_curso, `curso_jevf`.`estado` AS estado_curso\n" +
                "FROM `u484426513_poo224`.`grupo_curso_jevf`\n" +
                "JOIN `grupo_jevf` ON `grupo_curso_jevf`.`grupo_id` = `grupo_jevf`.`id`\n" +
                "JOIN `curso_jevf` ON `grupo_curso_jevf`.`curso_id` = `curso_jevf`.`id`\n";

        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            rs = stmt.executeQuery();

            ArrayList<GrupoCursoModel> listGrupoCurso = new ArrayList<>();

            while (rs.next()) {
                GrupoCursoModel grupoCurso = new GrupoCursoModel();
                grupoCurso.setId(rs.getInt("id"));
                grupoCurso.setGrupoId(rs.getInt("id_grupo"));
                grupoCurso.setNombreGrupo(rs.getString("nombre_grupo"));
                grupoCurso.setDescripcionGrupo(rs.getString("descripcion_grupo"));
                grupoCurso.setEstadoGrupo(rs.getInt("estado_grupo"));

                grupoCurso.setCursoId(rs.getInt("id_curso"));
                grupoCurso.setNombreCurso(rs.getString("nombre_curso"));
                grupoCurso.setDescripcionCurso(rs.getString("descripcion_curso"));
                grupoCurso.setEstadoCurso(rs.getInt("estado_curso"));
                listGrupoCurso.add(grupoCurso);
            }
            rs.close();
            return listGrupoCurso;
        }
    }
}
