package src.main.java.oo.exceptions;

import java.util.InputMismatchException;

public class ExcecaoDeEntradaInvalida extends InputMismatchException {
    public ExcecaoDeEntradaInvalida(String mensagem) {
        super(mensagem);
    }
}