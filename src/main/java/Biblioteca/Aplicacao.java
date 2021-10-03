package Biblioteca;

import Biblioteca.Estante.*;
import Biblioteca.Usuarios.*;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args)  {

        System.out.println();
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.getAcervo();


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
        //listaLivrosDesejados.add(biblioteca.livro3);
        //listaLivrosDesejados.add(biblioteca.livro3);
        //listaLivrosDesejados.add(biblioteca.livro3);
       // listaLivrosDesejados.add(biblioteca.livro4);


        /*for (Livro l : listaLivrosDesejados) {
            System.out.println(l.toString());
        }*/

        //AQUI
        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, joao);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        listaLivrosDesejados.clear();

        System.out.println(listaLivrosDesejados.toString());
        listaLivrosDesejados.add(biblioteca.livro13);
        listaLivrosDesejados.add(biblioteca.livro14);
        listaLivrosDesejados.add(biblioteca.livro20);
        //listaLivrosDesejados.add(biblioteca.livro9);
        System.out.println(listaLivrosDesejados.toString());

        try {
            biblioteca.fazerEmprestimoDeLivro(listaLivrosDesejados, gustavo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Emprestimo do livro " + biblioteca.livro10.getTitulo() + ": " + biblioteca.livro10.getEmprestado());

        System.out.println("Teste");

    }
}
