package com.obligatorio2.mappers;

import com.obligatorio2.models.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EmpleadoMapper {
  
  public static Empleado mapToEmpleado(ResultSet rs) {
    try {
      if(!rs.next()) return null;
  
      Empleado empleado = new Empleado();
      empleado.setNombre(rs.getString("nombre"));
      empleado.setApellido(rs.getString("apellido"));
      empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
      empleado.setCorreo(rs.getString("correo"));
      empleado.setDireccion(rs.getString("direccion"));
      empleado.setActivo(rs.getBoolean("activo"));
      return empleado;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al mapear ResultSet a Empleado", e);
    }
  }
  
  public static Map<String, Empleado> mapToEmpleados(ResultSet rs){
    try {
      Map<String, Empleado> empleados = new java.util.HashMap<>();
      Empleado empleado = mapToEmpleado(rs);
      while(empleado != null) {
        empleados.put(empleado.getCorreo(), empleado);
        empleado = mapToEmpleado(rs);
      }
      return empleados;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al mapear ResultSet a EmpleadoMap", e);
    }
  }
  
}
