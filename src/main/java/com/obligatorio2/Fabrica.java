package com.obligatorio2;

import com.obligatorio2.controllers.EmpleadoController;
import com.obligatorio2.controllers.IEmpleado;

public class Fabrica {
  private static Fabrica instance;
  
  private Fabrica() {}
  
  public static Fabrica getInstance() {
    if (instance == null) {
      instance = new Fabrica();
    }
    return instance;
  }
  
  public IEmpleado getIEmpleado() {
    EmpleadoController empleadoController = EmpleadoController.getInstance();
    return empleadoController;
  }
}