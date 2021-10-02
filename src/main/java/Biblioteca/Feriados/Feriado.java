package Biblioteca.Feriados;

import java.time.LocalDate;

public class Feriado {
     private LocalDate data;
     private String descricaoo;

    public Feriado(LocalDate data, String descricaoo) {
        this.data = data;
        this.descricaoo = descricaoo;
    }
}
