package model.models;

public class GrupoCursoModel {
    private int id;
    private int grupoId;
    private String nombreGrupo;
    private String descripcionGrupo;
    private int estadoGrupo;
    private int cursoId;
    private String nombreCurso;
    private String descripcionCurso;
    private int estadoCurso;

    public GrupoCursoModel() {
    }

    public GrupoCursoModel(int id, int grupoId, int cursoId) {
        this.id = id;
        this.grupoId = grupoId;
        this.cursoId = cursoId;
    }

    public GrupoCursoModel(int grupoId, int cursoId) {
        this.grupoId = grupoId;
        this.cursoId = cursoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }

    public int getEstadoGrupo() {
        return estadoGrupo;
    }

    public void setEstadoGrupo(int estadoGrupo) {
        this.estadoGrupo = estadoGrupo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public int getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(int estadoCurso) {
        this.estadoCurso = estadoCurso;
    }
}
