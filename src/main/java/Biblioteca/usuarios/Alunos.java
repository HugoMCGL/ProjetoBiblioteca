package Biblioteca.usuarios;

import Biblioteca.estante.Livro;
import Biblioteca.exception.LimiteLivrosExeption;

import java.util.ArrayList;
import java.util.List;

public class Alunos extends Pessoa {
    private List<Livro> livrosAlugados;

    public Alunos(String nome, double matricula, String email) {
        super(nome, matricula, email);
        this.livrosAlugados = new ArrayList<Livro>();
    }
    public void addLivro(Livro livro) throws LimiteLivrosExeption {
        if (livrosAlugados.size() < 3){
            this.livrosAlugados.add(livro);
            System.out.println(livro.getTitulo() + " alugado");
            return;
        }
        throw new LimiteLivrosExeption();
    }
}



