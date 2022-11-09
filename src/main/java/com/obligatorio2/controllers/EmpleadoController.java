package com.obligatorio2.controllers;

import com.obligatorio2.models.Empleado;
import com.obligatorio2.services.EmpleadoService;
import com.obligatorio2.services.IEmpleadoService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class EmpleadoController implements IEmpleado {
  private static EmpleadoController instance;
  private IEmpleadoService empleadoService;
  
  private EmpleadoController() {
    empleadoService = new EmpleadoService();
  }
  
  public static EmpleadoController getInstance() {
    if (instance == null) {
      instance = new EmpleadoController();
    }
    return instance;
  }
  
  
  
  /**
   * Metodo que obtiene todos los empleados registrados en la base de datos
   * @return Mapa con todos los empleados registrados en la base de datos
   */
  @Override
  public Map<String, Empleado> obtenerEmpleados() {
    return empleadoService.findAll();
  }
  
  /**
   * Metodo que obtiene un empleado registrado en la base de datos a partir de su nombre
   * @param nombre Nombre del empleado a buscar
   * @return Optional con el empleado encontrado
   */
  @Override
  public Optional<Empleado> obtenerEmpleado(String nombre){
    return empleadoService.findByNombre(nombre);
  }
  
  /**
   * Metodo que ingresa un empleado a la base de datos o lo actualiza si ya existe
   * @param empleado Objeto usuario a ingresar
   */
  @Override
  public void guardarEmpleado(Empleado empleado) {
    empleadoService.save(empleado);
  }
  
  /**
   * Metodo que cambiar estado activo de un empleado en la base de datos
   * @param nombre Nombre del empleado a cambiar estado
   * @param estado Boolean del nuevo estado del empleado
   */
  @Override
  public void cambiarEstadoEmpleado(String nombre, Boolean estado) {
    empleadoService.updateEstado(nombre, estado);
  }
  
}
