package Biblioteca;
import Biblioteca.Estante.Livro;
import Biblioteca.Exception.LimiteLivrosExeption;
import Biblioteca.Usuarios.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;


//Acervo adicionado como atributo da bibloteca para guardar os livros dispoiveis dentro dela,
// criado pelo metodo getLivros

//fazerEmprestimo -> analisa a lista de livros, compara com a acervo e faz mudança do atributo
//emprestado dos livros do acervo de false para true (ou seja o livro esta emprestado)

//varias outros metodos para auxiliar pegaLivro e fazerEmprestimo

public class Biblioteca {
    private List<Livro> acervo;

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

    public List<Livro> getAcervo() {
        return acervo = getLivros();
    }

    public void fazerEmprestimoDeLivro(List<Livro> livrosEmprestimo, Pessoa pessoa) throws IllegalArgumentException, LimiteLivrosExeption {

        if(pessoa instanceof  Alunos) {
            if (!isMaisQue(3, livrosEmprestimo)) {
                confirmarEmprestimo(livrosEmprestimo);
            } else {
                throw new IllegalArgumentException("Aluno não pode pegar mais de 3 livros");
            }
        } else {
            if (!isMaisQue(5, livrosEmprestimo)) {
                confirmarEmprestimo(livrosEmprestimo);
            } else {
                throw new IllegalArgumentException("Professor não pode pegar mais de 5 livros");
            }
        }

        if(pessoa instanceof Professores){
            for (Livro livro: livrosEmprestimo) {
                ((Professores) pessoa).addLivro(livro);

            }
        }else {
            for (Livro livro: livrosEmprestimo) {
                ((Alunos) pessoa).addLivro(livro);

            }
        }
    }

    private boolean isMaisQue(int n, List<Livro> livrosEmprestimo) {
        return (livrosEmprestimo.size() > n);
    }

    private boolean verificaAcervo(String titulo, int i) {
        return (acervo.get(i).getTitulo().equals(titulo) && !acervo.get(i).getEmprestado());
    }

    private void confirmarEmprestimo(List<Livro> livros) {
        int j = 0;
        for (int i = 0; i < livros.size(); i++) {
            if (verificaAcervo(livros.get(j).getTitulo(), i)) {
                acervo.get(i).setEmprestado(TRUE);
                j++;
            }
        }
        System.out.println("Emprestimo realizado");
    }

    public List<Livro> getLivros() {
        List<Livro> acervo = new ArrayList<>();
        acervo.add(livro1);
        acervo.add(livro2);
        acervo.add(livro3);
        acervo.add(livro4);
        acervo.add(livro5);
        acervo.add(livro6);
        acervo.add(livro7);
        acervo.add(livro8);
        acervo.add(livro9);
        acervo.add(livro10);
        return acervo;
    }
}