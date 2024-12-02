package br.com.ifpe.oxefood.util.exception;

public class ClienteException extends RuntimeException {
    
    public static final String MSG_DDD_INVALIDO ="O DDD informado é inválido só aceitamos DDD 81 o telefone informado foi: %s";

    private static final long serialVersionUID = 1L;

    public ClienteException(String message) {
        super(message);
    }

    public ClienteException(String message,String complemento) {
        super(String.format(message, complemento));
    }
    public ClienteException(String message, Throwable cause) {
        super(message, cause);
    }

}
