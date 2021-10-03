package Biblioteca;

import Biblioteca.Exception.LimiteLivrosExeption;
import Biblioteca.Feriados.Feriado;
import Biblioteca.Estante.*;
import Biblioteca.Usuarios.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class Aplicacao {
    List<Feriado> feriadosList = getFeriados();
    LocalDate hoje = LocalDate.now();



    private static boolean isDiaUtil(LocalDate data) {
        DayOfWeek dayOfWeek = data.getDayOfWeek();
        return !(SATURDAY.equals(dayOfWeek) || SUNDAY.equals(dayOfWeek) || isFeriado(data));
    }

    public static boolean isFeriado(LocalDate data) {
        List<Feriado> feriados = getFeriados();
        for (Feriado f : feriados) {
            if (f.getData().isEqual(data)) {
                return true;
            }
        }
        return false;
    }

    private static List<Feriado> getFeriados() {
        List<Feriado> feriadosList = new ArrayList<>();
        feriadosList.add(new Feriado(LocalDate.of(2021, 1, 1), "Confraternização"));
        feriadosList.add(new Feriado(LocalDate.of(2021, 4, 2), "Páscoa"));
        feriadosList.add(new Feriado(LocalDate.of(2021, 4, 21), "Tiradentes"));
        feriadosList.add(new Feriado(LocalDate.of(2021, 5, 1), "Dia do Trabalho"));
        feriadosList.add(new Feriado(LocalDate.of(2021, 9, 7), "Independência"));
        feriadosList.add(new Feriado(LocalDate.of(2021, 10, 12), "Padroeira do Brasil"));
        feriadosList.add(new Feriado(LocalDate.of(2021, 11, 2), "Finados"));
        feriadosList.add(new Feriado(LocalDate.of(2021, 11, 15), "Proclamação da República"));
        feriadosList.add(new Feriado(LocalDate.of(2021, 12, 25), "Natal"));
        return feriadosList;
    }


    private static LocalDate calcularDataAposDiasUteis(int diasUteisDesejado) {
        LocalDate data = LocalDate.now();//hoje + 10 dias úteis
        int diasUteis = 0;

        while(diasUteis < diasUteisDesejado) {
            data = data.plusDays(1);
            if (isDiaUtil(data)) {
                diasUteis++;
            }
        }
        return data;
    }

    public static void main(String[] args)  {


        System.out.println();
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getAcervo();

        System.out.println(calcularDataAposDiasUteis(4));

        Pessoa inacio = new Alunos("Inacio", 2000, "Inacio@gmail.com: " + EnumClasse.Aluno);
        Pessoa joao = new Alunos("Joao", 2001, "joao@gmail.com: " + EnumClasse.Aluno);
        Pessoa julio = new Alunos("Julio", 2003, "julio@gmail.com: " + EnumClasse.Aluno);

        Pessoa gustavo = new Professores("Gustavo", 1001, "gustavo@gmail.com: " + EnumClasse.Professor);
        Pessoa hugo = new Professores("Hugo", 1002, "Hugo@gmail.com: " + EnumClasse.Professor);
        Pessoa roberto = new Professores("Roberto", 1003, "roberto@gmail.com: " + EnumClasse.Professor);


        System.out.println(inacio.toString());
        System.out.println(joao.toString());
        System.out.println(julio.toString());

        System.out.println(gustavo.toString());
        System.out.println(hugo.toString());
        System.out.println(roberto.toString());


        List<Livro> listaLivrosDesejados = new ArrayList<Livro>();
        listaLivrosDesejados.add(biblioteca.livro1);
        listaLivrosDesejados.add(biblioteca.livro2);
        listaLivrosDesejados.add(biblioteca.livro3);
       // listaLivrosDesejados.add(biblioteca.livro4);


        for (Livro l : listaLivrosDesejados) {
            System.out.println(l.toString());
        }

        //AQUI
        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, joao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        listaLivrosDesejados.clear();

        System.out.println(listaLivrosDesejados.toString());
        listaLivrosDesejados.add(biblioteca.livro10);
        listaLivrosDesejados.add(biblioteca.livro2);
        listaLivrosDesejados.add(biblioteca.livro3);
        System.out.println(listaLivrosDesejados.toString());

        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, gustavo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(biblioteca.livro10.getEmprestado());

        System.out.println("Teste");

    }
}
