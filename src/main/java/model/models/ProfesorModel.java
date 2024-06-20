package model.models;

public class ProfesorModel extends BaseEntityPersonaModel {
    private String departamento;

    public ProfesorModel() {
    }

    public ProfesorModel(String departamento) {
        this.departamento = departamento;
    }

    public ProfesorModel(String nombre, int identificacion, String email, String departamento, int estado) {
        super(nombre, identificacion, email, estado);
        this.departamento = departamento;
    }

    public ProfesorModel(int id, String nombre, int identificacion, String email, String departamento, int estado) {
        super(id, nombre, identificacion, email, estado);
        this.departamento = departamento;
    }


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
