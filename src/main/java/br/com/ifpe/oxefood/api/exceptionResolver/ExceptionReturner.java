package br.com.ifpe.oxefood.api.exceptionResolver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionReturner {
    private Object message;
    private Object localizedMessage;
    private Object cause;
    private Object exceptionType;
    private Object suppressed;

    public ExceptionReturner(Exception e) {
        this.message = e.getMessage();
        this.localizedMessage = e.getLocalizedMessage();
        this.cause = e.getCause();
        this.exceptionType = e.getClass().getName();
        this.suppressed = e.getSuppressed();
    }
}
