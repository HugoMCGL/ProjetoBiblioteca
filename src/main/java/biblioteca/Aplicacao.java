package biblioteca;

import biblioteca.estante.*;
import biblioteca.usuarios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args)  {

        System.out.println();
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataTesteEntrega = LocalDate.of(2021,12,30);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getAcervo();


        Pessoa inacio = new Alunos("Inacio", 2000, "Inacio@gmail.com: " + EnumClasse.ALUNO);
        Pessoa joao = new Alunos("Joao", 2001, "joao@gmail.com: " + EnumClasse.ALUNO);
        Pessoa julio = new Alunos("Julio", 2003, "julio@gmail.com: " + EnumClasse.ALUNO);

        Pessoa gustavo = new Professores("Gustavo", 1001, "gustavo@gmail.com: " + EnumClasse.PROFESSOR);
        Pessoa hugo = new Professores("Hugo", 1002, "Hugo@gmail.com: " + EnumClasse.PROFESSOR);
        Pessoa roberto = new Professores("Roberto", 1003, "roberto@gmail.com: " + EnumClasse.PROFESSOR);

        System.out.println("bem vindo a Biblioteca:\n");

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


        System.out.println();
        for (Livro l : listaLivrosDesejados) {
            System.out.println(l.toString());
        }


        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, joao);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("aqui");
        System.out.println(joao.getLivroLista().toString());
        System.out.println();
        listaLivrosDesejados.clear();
        System.out.println("aqui2");
        System.out.println(joao.getLivroLista().toString());
        System.out.println();

        listaLivrosDesejados.add(biblioteca.livro4);
        listaLivrosDesejados.add(biblioteca.livro5);
        listaLivrosDesejados.add(biblioteca.livro6);
        listaLivrosDesejados.add(biblioteca.livro7);
        listaLivrosDesejados.add(biblioteca.livro9);

        for (Livro l : listaLivrosDesejados) {
            System.out.println(l.toString());
        }

        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, gustavo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        listaLivrosDesejados.clear();

        listaLivrosDesejados.add(biblioteca.livro11);
        listaLivrosDesejados.add(biblioteca.livro12);
        listaLivrosDesejados.add(biblioteca.livro13);


        for (Livro l : listaLivrosDesejados) {
            System.out.println(l.toString());
        }

        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, inacio);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
            listaLivrosDesejados.clear();

        System.out.println(gustavo.getLivroLista().toString());
        System.out.println(gustavo.getDataEntrega());
        System.out.println(inacio.getLivroLista().toString());
        System.out.println(inacio.getDataEntrega());

        biblioteca.devolveLivro(inacio, dataTesteEntrega);

        System.out.println(inacio.getLivroLista());

    }
}