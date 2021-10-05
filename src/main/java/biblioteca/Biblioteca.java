package biblioteca;
import biblioteca.data.*;
import biblioteca.estante.Livro;
import biblioteca.usuarios.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Biblioteca {

    LocalDate dataEntrega;
    LocalDate dataSuspensao;
    static DataDia calculaData = new DataDia();
    int dia, mes, ano;
    private List<Livro> acervo;

     Livro livro1  = new Livro(10688, "Dom Casmurro", "Machado de Assis", "herbert richers");
     Livro livro2  = new Livro(10689, "Caçadas de Pedrinho", "Monteiro Lobato", "telecinez");
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

        verificaSeAcabouDiasDeSuspensao(pessoa, LocalDate.of(2022, 03, 01));
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
        pessoa.setLivroLista(List.copyOf(livrosEmprestimo));
        pessoa.setDataEntrega(dataEntrega);
        pessoa.setEmprestimoRealizado(true);
        System.out.println("O livro precisa ser devolvido até a data: "+dataEntrega+"\n");
    }

    private void verificaSeAcabouDiasDeSuspensao(Pessoa pessoa, LocalDate hoje) {
        //soma a data de entrega + 10 ou 20 + dias de atraso
        if (pessoa.getDataEntrega() != null) {
            if (pessoa instanceof Alunos) {
                if (hoje.isAfter(pessoa.getDataSuspensao())) {
                    System.out.println(pessoa.getNome() + " não está mais suspenso");
                    pessoa.setSuspenso(false);
                    System.out.println(pessoa.isSuspenso());
                } else {
                    throw new IllegalArgumentException(pessoa.getNome() + " ainda suspenso");
                }
            }
        }
    }



    private void verificaSePessoaSuspensa(Pessoa pessoa) {
        if(pessoa.isSuspenso()) {
            //System.err.println("Você está suspenso por não devolver os livros no prazo");
            throw new IllegalArgumentException("Você está suspenso realizou emprestimo");
        }
    }
    private void isMaisQue(int n, List<Livro> livrosEmprestimo) {
        if (livrosEmprestimo.size() > n) {
            throw new IllegalArgumentException("Você não pode pegar mais de " +n+ " livros");
        }
    }
    private void verificaSePessoaJaEmprestou(Pessoa pessoa) {
        if (pessoa.isEmprestimoRealizado()) {
            throw new IllegalArgumentException("Você já realizou emprestimo");
        }
    }
    private void verificaSeFoiEmprestado(Livro livro) {
        if(livro.getEmprestado()) {
            throw new IllegalArgumentException("Livro ja emprestado");
        }
    }

    private boolean verificaIgual(Livro livro, int i) {
        return acervo.get(i).getTitulo().equals(livro.getTitulo());
    }

    public void devolveLivro(Pessoa pessoa, LocalDate entregaRealizada){


        if(entregaRealizada.isAfter(pessoa.getDataEntrega())) {
            pessoa.setSuspenso(true);
            dia = (Period.between(pessoa.getDataEntrega(), entregaRealizada).getDays());
            mes = (Period.between(pessoa.getDataEntrega(), entregaRealizada).getMonths());
            ano = (Period.between(pessoa.getDataEntrega(), entregaRealizada).getYears());

            dataSuspensao = entregaRealizada.plusDays(dia).plusMonths(mes).plusYears(ano);
            pessoa.setDataSuspensao(dataSuspensao);
            System.out.println("O aluno está suspenso até a seguinte data: "+pessoa.getDataSuspensao());
            pessoa.setLivroLista(new ArrayList<Livro>());
        }else{
            System.out.println("Livros devolvidos");
            pessoa.setLivroLista(new ArrayList<Livro>());
        }
        retornarLivro(pessoa.getLivroLista(), pessoa);
        pessoa.setEmprestimoRealizado(false);
    }


    private void isInAcervo(Livro livro) {
        if (!acervo.contains(livro)) {
            throw new IllegalArgumentException("Livro não está no acervo");
        }
    }
    private void confirmarEmprestimo(List<Livro> livros, Pessoa pessoa) throws IllegalArgumentException {
        int size = livros.size();
        int[] indicesAcervo = new int [size];
        Arrays.fill(indicesAcervo, -1);
        for (int j = 0; j < size; j ++) {
            for (int i = 0; i < acervo.size(); i++) {
                isInAcervo(livros.get(j));
                if (verificaIgual(livros.get(j), i)) {
                    verificaSeFoiEmprestado(livros.get(j));
                    indicesAcervo[j] = i;
                    break;
                }
            }
        }
        if (verificaIndice(indicesAcervo, -1)) {
            for (int j : indicesAcervo) {
                acervo.get(j).setEmprestado(true);

            }
            System.out.println("Emprestimo realizado");
        }
    }

    private void retornarLivro(List<Livro> livros, Pessoa pessoa) throws IllegalArgumentException {
        int size = livros.size();
        int[] indicesAcervo = new int [size];
        Arrays.fill(indicesAcervo, -1);
        for (int j = 0; j < size; j ++) {
            for (int i = 0; i < acervo.size(); i++) {
                if (verificaIgual(livros.get(j), i)) {
                    System.out.println("aqui");
                    indicesAcervo[j] = i;
                    break;
                }
            }
        }
        if (verificaIndice(indicesAcervo, -1)) {
            for (int j : indicesAcervo) {
                acervo.get(j).setEmprestado(false);
            }
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