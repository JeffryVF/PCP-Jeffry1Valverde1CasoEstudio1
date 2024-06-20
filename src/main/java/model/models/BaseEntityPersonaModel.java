package model.models;

public class BaseEntityPersonaModel {
    private int id;
    private String nombre;
    private int identificacion;
    private String email;
    private int estado;

    public BaseEntityPersonaModel() {
    }

    public BaseEntityPersonaModel(String nombre, int identificacion, String email, int estado) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.estado = estado;
    }

    public BaseEntityPersonaModel(int id, String nombre, int identificacion, String email, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
