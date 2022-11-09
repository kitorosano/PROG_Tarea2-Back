package com.obligatorio2.controllers;

import com.obligatorio2.models.Empleado;

import java.util.Map;
import java.util.Optional;

public interface IEmpleado {
  Map<String, Empleado> obtenerEmpleados();
  Optional<Empleado> obtenerEmpleado(String nombre);
  void guardarEmpleado(Empleado empleadodto);
  void cambiarEstadoEmpleado(String nombre, Boolean estado);
}
