package org.example.model;

import org.example.enums.TipoEmpleado;

public class Empleado {
    private String nombre;
    private String apellido;
    private float tarifa;
    private int horasTrabajadas;
    TipoEmpleado tipoEmpleado;

    public Empleado(String nombre, String apellido, float tarifa, int horasTrabajadas, TipoEmpleado tipoEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tarifa = tarifa;
        this.horasTrabajadas = horasTrabajadas;
        this.tipoEmpleado = tipoEmpleado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public float getTarifa() {
        return tarifa;
    }
    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
    public float getHorasTrabajadas() {
        return horasTrabajadas;
    }
    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }
    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}
