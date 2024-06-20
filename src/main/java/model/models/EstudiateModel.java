package model.models;

import java.util.Date;

public class EstudiateModel extends BaseEntityPersonaModel {
    private Date fechaNacimiento;

    public EstudiateModel() {
    }

    public EstudiateModel(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public EstudiateModel(int id, String nombre, int identificacion, String email, Date fechaNacimiento, int estado) {
        super(id, nombre, identificacion, email, estado);
        this.fechaNacimiento = fechaNacimiento;
    }

    public EstudiateModel(String nombre, int identificacion, String email, Date fechaNacimiento, int estado) {
        super(nombre, identificacion, email, estado);
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
