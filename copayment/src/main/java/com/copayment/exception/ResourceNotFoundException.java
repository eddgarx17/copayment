package com.copayment.exception;

public class ResourceNotFoundException extends  RuntimeException  {
  /**
   * excepción personalizada que se utiliza indicar que un recurso específico no ha sido encontrado.
   * */
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
