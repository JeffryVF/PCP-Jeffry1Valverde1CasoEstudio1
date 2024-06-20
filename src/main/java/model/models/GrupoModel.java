package model.models;

public class GrupoModel extends BaseEntityConjuntoModel {
    public GrupoModel() {
    }

    public GrupoModel(int id, String nombre, String descripcion, int estado) {
        super(id, nombre, descripcion, estado);
    }

    public GrupoModel(String nombre, String descripcion, int estado) {
        super(nombre, descripcion, estado);
    }
}
