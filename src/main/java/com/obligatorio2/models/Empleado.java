package com.obligatorio2.models;

import java.time.LocalDate;

public class Empleado {
  
  private String nombre;
  private String apellido;
  private LocalDate fechaNacimiento;
  private String correo;
  private String direccion;
  private boolean activo;
  
  public Empleado() {
  }
  
  public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String correo, String direccion) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.correo = correo;
    this.direccion = direccion;
    this.activo = true;
  }
  
  public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String correo, String direccion, boolean activo) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.correo = correo;
    this.direccion = direccion;
    this.activo = activo;
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
  
  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(LocalDate fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  
  public String getCorreo() {
    return correo;
  }
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  
  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  public boolean getActivo() {
    return activo;
  }
  public void setActivo(boolean activo) {
    this.activo = activo;
  }
  
  @Override
  public String toString() {
    return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", correo=" + correo + ", direccion=" + direccion + ", activo=" + activo + "]";
  }
}
