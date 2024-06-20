package model.models;

public class CursoModel extends BaseEntityConjuntoModel {
    public CursoModel() {
    }

    public CursoModel(int id, String nombre, String descripcion, int estado) {
        super(id, nombre, descripcion, estado);
    }

    public CursoModel(String nombre, String descripcion, int estado) {
        super(nombre, descripcion, estado);
    }
}
