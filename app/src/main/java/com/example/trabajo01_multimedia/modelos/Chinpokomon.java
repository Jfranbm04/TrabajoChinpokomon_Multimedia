package com.example.trabajo01_multimedia.modelos;

public class Chinpokomon {
    private String codigo;
    private String nombre;
    private String nivel;
    private String tipo;
    private String movimiento;
    private int imagen;

    public Chinpokomon(String codigo, String nombre, String nivel, String tipo, String movimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.movimiento = movimiento;
    }

    public Chinpokomon(String codigo, String nombre, String nivel, String tipo, String movimiento, int imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.movimiento = movimiento;
        this.imagen = imagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
