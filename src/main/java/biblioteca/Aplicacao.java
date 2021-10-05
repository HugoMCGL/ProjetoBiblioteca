package biblioteca;

import biblioteca.estante.*;
import biblioteca.usuarios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {

        System.out.println();
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataTesteEntrega = LocalDate.of(2021, 12, 20);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getAcervo();

        Pessoa inacio = new Alunos("Inacio", 2000, "Inacio@gmail.com: " + EnumClasse.ALUNO);
        Pessoa joao = new Alunos("Joao", 2001, "joao@gmail.com: " + EnumClasse.ALUNO);
        Pessoa julio = new Alunos("Julio", 2003, "julio@gmail.com: " + EnumClasse.ALUNO);

        Pessoa gustavo = new Professores("Gustavo", 1001, "gustavo@gmail.com: " + EnumClasse.PROFESSOR);
        Pessoa hugo = new Professores("Hugo", 1002, "Hugo@gmail.com: " + EnumClasse.PROFESSOR);
        Pessoa roberto = new Professores("Roberto", 1003, "roberto@gmail.com: " + EnumClasse.PROFESSOR);

        System.out.println("Bem vindos a biblioteca:\n");
        System.out.println(inacio.toString());
        System.out.println(joao.toString());
        System.out.println(julio.toString());

        System.out.println(gustavo.toString());
        System.out.println(hugo.toString());
        System.out.println(roberto.toString());
        System.out.println();

        System.out.println("Empréstimos:\n");

        List<Livro> listaLivrosDesejados = new ArrayList<Livro>();
        /*listaLivrosDesejados.add(biblioteca.livro1);
        listaLivrosDesejados.add(biblioteca.livro2);
        listaLivrosDesejados.add(biblioteca.livro3);

        for (int i = 0; i < listaLivrosDesejados.size(); i++) {
            System.out.println(listaLivrosDesejados.get(i).toString());
        }


        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, joao);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        listaLivrosDesejados.clear();

        listaLivrosDesejados.add(biblioteca.livro4);
        listaLivrosDesejados.add(biblioteca.livro5);
        listaLivrosDesejados.add(biblioteca.livro6);
        listaLivrosDesejados.add(biblioteca.livro7);
        listaLivrosDesejados.add(biblioteca.livro9);

        for (int i = 0; i < listaLivrosDesejados.size(); i++) {
            System.out.println(listaLivrosDesejados.get(i).toString());
        }

            for (Livro l : listaLivrosDesejados) {
            }

            try {
                biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, gustavo);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            listaLivrosDesejados.clear();*/

            listaLivrosDesejados.add(biblioteca.livro1);
            listaLivrosDesejados.add(biblioteca.livro2);
            listaLivrosDesejados.add(biblioteca.livro3);

            for (int i = 0; i < listaLivrosDesejados.size(); i++) {

                System.out.println(listaLivrosDesejados.get(i).toString());
            }


                for (Livro l : listaLivrosDesejados) {
                    System.out.println(l.toString());
                }

                try {
                    biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, inacio);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

                listaLivrosDesejados.clear();

                biblioteca.devolveLivro(inacio, dataTesteEntrega);

        listaLivrosDesejados.add(biblioteca.livro1);
        listaLivrosDesejados.add(biblioteca.livro2);
        listaLivrosDesejados.add(biblioteca.livro3);


                try {
                    biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, inacio);
                }   catch (Exception e) {
                    System.err.println(e.getMessage());
                }


                listaLivrosDesejados.clear();

                for (Livro l : biblioteca.getAcervo()) {
                    System.out.println(l.toString());
                }
            }
        }

