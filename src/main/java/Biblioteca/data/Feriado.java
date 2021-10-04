package Biblioteca.data;

import java.time.LocalDate;

public class Feriado {
    private LocalDate data;
    private String descricao;

    public Feriado(LocalDate data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }
}