package Biblioteca;
import Biblioteca.Estante.Livro;
import Biblioteca.Exception.LimiteLivrosExeption;
import Biblioteca.Usuarios.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
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

       /* if(pessoa instanceof Professores){
            for (Livro livro: livrosEmprestimo) {
                ((Professores) pessoa).addLivro(livro);

            }
        }else {
            for (Livro livro: livrosEmprestimo) {
                ((Alunos) pessoa).addLivro(livro);

            }
        }*/
    }

    private boolean isMaisQue(int n, List<Livro> livrosEmprestimo) {
        return (livrosEmprestimo.size() > n);
    }

    /*private boolean verificaSituacaoDoEmprestimo(Livro livro, int i) {
        if (!acervo.contains(livro)) {
            System.out.println("Livro não está no acervo");
        }
        if (acervo.get(i).getTitulo().equals(livro.getTitulo())) {
            if (!livro.getEmprestado()) {
                System.out.println("Foi");
                return TRUE;
            }
            System.out.println("Livro ja emprestado");
            return FALSE;
        }
        System.out.println("Pula");
        return FALSE;
    }*/

    private boolean verificaSeFoiEmprestado(Livro livro) {
        return !livro.getEmprestado();
    }

    private boolean verificaIgual(Livro livro, int i) {
        return acervo.get(i).getTitulo().equals(livro.getTitulo());
    }

    private boolean isInAcervo(Livro livro) {
        return acervo.contains(livro);
    }


    private void confirmarEmprestimo(List<Livro> livros) {
        int size = livros.size();
        System.out.println(size);
        int[] indicesAcervo = new int [size];
        setIndice(indicesAcervo, -1);
        for (int j = 0; j < size; j ++) {
            for (int i = 0; i < acervo.size(); i++) {
                System.out.println();
                System.out.println(livros.get(j).getTitulo());
                System.out.println(acervo.get(i).getTitulo());
                System.out.println("Igualdade: " + verificaIgual(livros.get(j), i));
                System.out.println("Situação emprestimo: " + livros.get(j).getEmprestado());
                System.out.println();
                if (!isInAcervo(livros.get(j))) {
                    System.out.println("Livro não está no acervo");
                    break;
                }
                if (verificaIgual(livros.get(j), i)) {
                    if (verificaSeFoiEmprestado(livros.get(j))) {
                        System.out.println("Deu certo o emprestimo");
                        indicesAcervo[j] = i;
                        break;
                    }
                    System.out.println("Livro ja emprestado");
                    break;
                }
                System.out.println("Pula");
            }
        }

        //AQUI É PARA VERFICAR OS IDICES E VER SE FORAM SALVOS PARA MUDAR O EMRPESTIMO
        if (!verificaIndice(indicesAcervo, -1)) {
            for (int i = 0; i < indicesAcervo.length; i++) {
                acervo.get(indicesAcervo[i]).setEmprestado(TRUE);
            }
        }
        System.out.println("Emprestimo realizado");
    }

    private void setEmprestimo(int i) {
        acervo.get(i).setEmprestado(TRUE);
    }

    private boolean verificaIndice(int[] n, int i) {
        for (int j=0; j < n.length; j++) {
            if(n[j] != i) {
                return FALSE;
            }
        }
        return TRUE;
    }

    private void setIndice(int[] n, int i) {
        for (int j=0; j < n.length; j++) {
            n[j] = i;
        }
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