package com.obligatorio2.services;

import com.obligatorio2.models.Empleado;

import java.util.Map;
import java.util.Optional;

public interface IEmpleadoService {
  
  Map<String, Empleado> findAll();
  Optional<Empleado> findByCorreo(String correo);
  void save(Empleado empleado);
  void updateEstado(String correo, boolean estado);
}
