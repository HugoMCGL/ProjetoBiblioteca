package Biblioteca;
import Biblioteca.Data.*;
import Biblioteca.Estante.Livro;
import Biblioteca.Usuarios.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Acervo adicionado como atributo da bibloteca para guardar os livros dispoiveis dentro dela,
// criado pelo metodo getLivros

//fazerEmprestimo -> analisa a lista de livros, compara com a acervo e faz mudança do atributo
//emprestado dos livros do acervo de false para true (ou seja o livro esta emprestado)

//varias outros metodos para auxiliar pegaLivro e fazerEmprestimo

public class Biblioteca {
    LocalDate dataEntrega;
    static DataDia calculaData = new DataDia();

    private List<Livro> acervo;

     Livro livro1  = new Livro(10688, "Dom Casmurro", "Machado de Assis", "herbert richers");
     Livro livro2  = new Livro(10689, "Caçadas de Pedrinho", "Monteiro Lobato", "telecine");
     Livro livro3  = new Livro(10610, "Memórias póstumas de Brás Cubas", "Machado de Assis", "herbert richers");
     Livro livro4  = new Livro(10611, "O saci", "Monteiro Lobato", "telecine");
     Livro livro5  = new Livro(10612, "Despedida", "Cecília Meireles", "hollywood");
     Livro livro6  = new Livro(10613, "Missa do galo", "Machado de Assis", "telecine");
     Livro livro7  = new Livro(10614, "Elegia", "Cecília Meireles", "hollywood");
     Livro livro8  = new Livro(10615, "Relógio", "Mario Quintana", "Aleph");
     Livro livro9  = new Livro(10616, "Esperança", "Mario Quintana", "Suma");
     Livro livro10 = new Livro(10617, "A cabana do Pai Tomás", "Harriet Beecher Stowe", "Editora Rocco");
     Livro livro11 = new Livro(10618, "1984", "George Orwell", "Editora Rocha");
     Livro livro12 = new Livro(10619, "O Mundo se Despedaça", "Chinua Achebe", "Editora Ilustrador");
     Livro livro13 = new Livro(10620, "Dom Quixote", "Miguel de Cervantes", "Editora Pause");
     Livro livro14 = new Livro(10621, " Hamlet", "William Shakespeare", "Editora Bloco64");
     Livro livro15 = new Livro(10622, "Cem anos de solidão", "Gabriel García Márquez", "Editora Antartida");
     Livro livro16 = new Livro(10623, " Ilíada", "Homero", "Editora Assis");
     Livro livro17 = new Livro(10624, "Amada", "Toni Morrison", "Editora Avenida");
     Livro livro18 = new Livro(10625, "A Divina Comédia", "Dante Alighieri", "Editora America");
     Livro livro19 = new Livro(10626, " Romeu e Julieta", "William Shakespeare", "Editora Global");
     Livro livro20 = new Livro(10627, " Série Harry Potter", "JK Rowling", "Editora Brasil");

    public List<Livro> getAcervo() {
        return acervo = getLivros();
    }

    public void fazerEmprestimoDeLivro(List<Livro> livrosEmprestimo, Pessoa pessoa) throws IllegalArgumentException {

        verificaSePessoaJaEmprestou(pessoa);
        verificaSePessoaSuspensa(pessoa);
        if(pessoa instanceof Alunos) {
            isMaisQue(3, livrosEmprestimo);
            dataEntrega = calculaData.calcularDataAposDiasUteis(10);
        } else {
            isMaisQue(5, livrosEmprestimo);
            dataEntrega = calculaData.calcularDataAposDiasUteis(20);
        }
        confirmarEmprestimo(livrosEmprestimo, pessoa);

        pessoa.livroLista = List.copyOf(livrosEmprestimo);
        //System.out.println(pessoa.livroLista.toString());
        pessoa.setEmprestimoRealizado(true);
        System.out.println("O livro precisa ser devolvido até a data: "+dataEntrega+"\n");
        //livrosEmprestimo.clear();
    }

    private void verificaSePessoaSuspensa(Pessoa pessoa) {
        if(pessoa.isSuspenso()) {
            //System.err.println("Você está suspenso por não devolver os livros no prazo");
            throw new IllegalArgumentException("Você está suspenso realizou emprestimo");
        }
    }

    /*private boolean isMaisQue2(int n, List<Livro> livrosEmprestimo) {
        return (livrosEmprestimo.size() > n);
    }*/

    private void isMaisQue(int n, List<Livro> livrosEmprestimo) {
        if (livrosEmprestimo.size() > n) {
            throw new IllegalArgumentException("Você não pode pegar mais de " +n+ " livros");
        }
    }

    private void verificaSePessoaJaEmprestou(Pessoa pessoa) {
        if (pessoa.isEmprestimoRealizado()) {
            //System.err.println("Você já realizou emprestimo");
            throw new IllegalArgumentException("Você já realizou emprestimo");
        }
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

    private void verificaSeFoiEmprestado(Livro livro) {
        if(livro.getEmprestado()) {
            throw new IllegalArgumentException("Livro ja emprestado");
        }
    }

    private boolean verificaIgual(Livro livro, int i) {
        return acervo.get(i).getTitulo().equals(livro.getTitulo());
    }

    private void devolveLivro(){

    }

    private void isInAcervo(Livro livro) {
        if (!acervo.contains(livro)) {
            throw new IllegalArgumentException("Livro não está no acervo");
        }
    }


        private void confirmarEmprestimo(List<Livro> livros, Pessoa pessoa) throws IllegalArgumentException {
        int size = livros.size();
        System.out.println(size);
        int[] indicesAcervo = new int [size];
        Arrays.fill(indicesAcervo, -1);
        for (int j = 0; j < size; j ++) {
            for (int i = 0; i < acervo.size(); i++) {
                isInAcervo(livros.get(j));
                /*
                System.out.println();
                System.out.println(livros.get(j).getTitulo());
                System.out.println(acervo.get(i).getTitulo());
                System.out.println("Igualdade: " + verificaIgual(livros.get(j), i));
                System.out.println("Situação emprestimo: " + livros.get(j).getEmprestado());
                System.out.println();
                */
                /*if (!isInAcervo(livros.get(j))) {
                    System.out.println("Livro não está no acervo");
                    throw new IllegalArgumentException("Livro não está no acervo");
                }*/
                if (verificaIgual(livros.get(j), i)) {
                    verificaSeFoiEmprestado(livros.get(j));
                    indicesAcervo[j] = i;
                    break;
                }
            }

        }
        //AQUI É PARA VERFICAR OS IDICES E VER SE FORAM SALVOS PARA MUDAR O EMPRESTIMO
        if (verificaIndice(indicesAcervo, -1)) {
            for (int j : indicesAcervo) {
                acervo.get(j).setEmprestado(true);
            }
            //pessoa.livroList = livros;
           // System.out.println(pessoa.livroList.toString());
            System.out.println("Emprestimo realizado");
        }
    }

    private boolean verificaIndice(int[] n, int i) {
        int conta = 0;
        for (int k : n) {
            if (k != i) {
                conta++;
            }
        }
        return conta == n.length;
    }

    /*private void setIndice(int[] n) {
        Arrays.fill(n, -1);
    }*/

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
        acervo.add(livro11);
        acervo.add(livro12);
        acervo.add(livro13);
        acervo.add(livro14);
        acervo.add(livro15);
        acervo.add(livro16);
        acervo.add(livro17);
        acervo.add(livro18);
        acervo.add(livro19);
        acervo.add(livro20);
        return acervo;
    }
}