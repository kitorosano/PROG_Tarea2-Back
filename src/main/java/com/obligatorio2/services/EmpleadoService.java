package com.obligatorio2.services;

import com.obligatorio2.config.ConexionDB;
import com.obligatorio2.mappers.EmpleadoMapper;
import com.obligatorio2.models.Empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class EmpleadoService implements IEmpleadoService{
  
  public Map<String, Empleado> findAll() {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String selectEmpleados = "SELECT *  FROM empleados ";
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(selectEmpleados);
      return EmpleadoMapper.mapToEmpleados(resultSet);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al obtener los empleados", e);
    } finally {
      try {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
  
  public Optional<Empleado> findByCorreo(String correo) {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String selectEmpleado = "SELECT * FROM empleados WHERE correo = '" + correo + "'";
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(selectEmpleado);
      return Optional.ofNullable(EmpleadoMapper.mapToEmpleado(resultSet));
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al obtener el empleado", e);
    } finally {
      try {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
  
  public void save(Empleado empleado) {
    Optional<Empleado> empleadoExiste = this.findByCorreo(empleado.getCorreo());
    String saveEmpleado;
    if(empleadoExiste.isPresent()) {
      saveEmpleado = "UPDATE empleados SET nombre = '" + empleado.getNombre() + "', apellido = '" + empleado.getApellido() + "', fecha_nacimiento = '" + empleado.getFechaNacimiento() + "', direccion = '" + empleado.getDireccion() + "' WHERE correo = '" + empleado.getCorreo() + "'";
    } else {
      saveEmpleado = "INSERT INTO `empleados` (`nombre`, `apellido`, `fecha_nacimiento`, `correo`, `direccion`, `activo`) " +
          "VALUES ('" + empleado.getNombre() + "', '" + empleado.getApellido() + "', '" + empleado.getFechaNacimiento() + "', '" + empleado.getCorreo() + "', '" + empleado.getDireccion() + "', " + empleado.getActivo() + ")";
    }
    Connection connection = null;
    Statement statement = null;
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      statement.executeUpdate(saveEmpleado);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al guardar el empleado", e);
    } finally {
      try {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
  
  public void updateEstado(String correo, boolean estado) {
    Connection connection = null;
    Statement statement = null;
    String updateEstadoEmpleado = "UPDATE empleados SET activo = " + estado + " WHERE correo = '" + correo + "'";
  
    try {
      connection = ConexionDB.getConnection();
      statement = connection.createStatement();
      statement.executeUpdate(updateEstadoEmpleado);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al conectar con la base de datos", e);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      throw new RuntimeException("Error al actualizar el estado del empleado", e);
    } finally {
      try {
        if (statement != null) statement.close();
        if (connection != null) connection.close();
      } catch (SQLException e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("Error al cerrar la conexión a la base de datos", e);
      }
    }
  }
}
