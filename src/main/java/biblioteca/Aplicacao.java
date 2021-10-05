package biblioteca;

import biblioteca.estante.*;
import biblioteca.usuarios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        System.out.println();
        LocalDate dataTesteEntrega = LocalDate.of(2021, 12, 20);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getAcervo();

        Pessoa inacio = new Alunos("Inacio", 2000, "Inacio@gmail.com: " + EnumClasse.ALUNO);
        Pessoa joao = new Alunos("Joao", 2001, "joao@gmail.com: " + EnumClasse.ALUNO);
        Pessoa julio = new Alunos("Julio", 2003, "julio@gmail.com: " + EnumClasse.ALUNO);

        Pessoa gustavo = new Professores("Gustavo", 1001, "gustavo@gmail.com: " + EnumClasse.PROFESSOR);

        System.out.println("Bem vindos a biblioteca:\n");

        List<Livro> listaLivrosDesejados = new ArrayList<>();
        listaLivrosDesejados.add(biblioteca.livro1);
        listaLivrosDesejados.add(biblioteca.livro2);
        listaLivrosDesejados.add(biblioteca.livro3);

        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, joao);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        listaLivrosDesejados.clear();

        try {
            biblioteca.devolveLivro(joao, dataTesteEntrega);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        listaLivrosDesejados.add(biblioteca.livro4);
        listaLivrosDesejados.add(biblioteca.livro5);
        listaLivrosDesejados.add(biblioteca.livro6);
        listaLivrosDesejados.add(biblioteca.livro7);
        listaLivrosDesejados.add(biblioteca.livro9);

        try {
                biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, gustavo);
            } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        listaLivrosDesejados.clear();
        listaLivrosDesejados.add(biblioteca.livro4);

        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, julio);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            biblioteca.devolveLivro(gustavo, dataTesteEntrega);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        listaLivrosDesejados.add(biblioteca.livro1);
        listaLivrosDesejados.add(biblioteca.livro2);
        listaLivrosDesejados.add(biblioteca.livro3);

        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, inacio);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        listaLivrosDesejados.clear();

        try {
            biblioteca.devolveLivro(inacio, dataTesteEntrega);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}

