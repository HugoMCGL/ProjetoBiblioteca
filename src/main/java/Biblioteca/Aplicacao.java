package Biblioteca;

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

    public static void main(String[] args) {


        Biblioteca biblioteca = new Biblioteca();

        Pessoa inacio = new Alunos("Inacio", 2000, "Inacio@gmail.com: " + EnumClasse.Aluno);
        Pessoa joao = new Alunos("Joao", 2001, "joao@gmail.com: " + EnumClasse.Aluno);
        Pessoa julio = new Alunos("Julio", 2003, "julio@gmail.com: " + EnumClasse.Aluno);

        Pessoa gustavo = new Professores("Gustavo", 1001, "gustavo@gmail.com: " + EnumClasse.Professor);
        Pessoa hugo = new Professores("Hugo", 1002, "Hugo@gmail.com: " + EnumClasse.Professor);
        Pessoa roberto = new Professores("Roberto", 1003, "roberto@gmail.com: " + EnumClasse.Professor);


        Livro livro1 = new Livro(10688, "Dom Casmurro", "Machado de Assis", "herbert richers");
        Livro livro2 = new Livro(10689, "Caçadas de Pedrinho", "Monteiro Lobato", "telecine");
        Livro livro3 = new Livro(10610, "Memórias póstumas de Brás Cubas", "Machado de Assis", "herbert richers");
        Livro livro4 = new Livro(10611, "O saci", "Monteiro Lobato", "telecine");
        Livro livro5 = new Livro(10612, "Despedida", "Cecília Meireles", "hollywood");
        Livro livro6 = new Livro(10613, "Missa do galo", "Machado de Assis", "telecine");
        Livro livro7 = new Livro(10614, "Elegia", "Cecília Meireles", "hollywood");
        Livro livro8 = new Livro(10615, "Relógio", "Mario Quintana", "Aleph");
        Livro livro9 = new Livro(10616, "Esperança", "Mario Quintana", "Suma");
        Livro livro10 = new Livro(10617, "Quincas Borba", "Machado de Assis", "Editora Rocco");


        System.out.println(inacio.toString());
        System.out.println(joao.toString());
        System.out.println(julio.toString());

        System.out.println(gustavo.toString());
        System.out.println(hugo.toString());
        System.out.println(roberto.toString());

        System.out.println(livro1.toString());

        biblioteca.pegaLivro(livro1, joao);
    }
}