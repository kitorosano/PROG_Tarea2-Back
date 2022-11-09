package com.obligatorio2.mappers;

import com.obligatorio2.models.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EmpleadoMapper {
  
  public static Empleado mapToEmpleado(ResultSet rs) throws SQLException {
    Empleado empleado = new Empleado();
    empleado.setNombre(rs.getString("nombre"));
    empleado.setApellido(rs.getString("apellido"));
    empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
    empleado.setCorreo(rs.getString("correo"));
    empleado.setDireccion(rs.getString("direccion"));
    empleado.setActivo(rs.getBoolean("activo"));
    return empleado;
  }
  
  public static Map<String, Empleado> mapToEmpleados(ResultSet rs) throws SQLException {
    Map<String, Empleado> empleados = new java.util.HashMap<>();
    while (rs.next()) {
      Empleado empleado = mapToEmpleado(rs);
      empleados.put(empleado.getNombre(), empleado);
    }
    return empleados;
  }
  
}
