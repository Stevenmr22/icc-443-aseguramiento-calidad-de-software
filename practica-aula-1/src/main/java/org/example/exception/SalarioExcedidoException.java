package org.example.exception;

public class SalarioExcedidoException extends RuntimeException {
    public SalarioExcedidoException(String message) {
        super(message);
    }
}
