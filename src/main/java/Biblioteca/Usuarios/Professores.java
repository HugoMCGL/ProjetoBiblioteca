package Biblioteca.Usuarios;

import Biblioteca.Estante.Livro;
import Biblioteca.Exception.LimiteLivrosExeption;

import java.util.ArrayList;
import java.util.List;

public class Professores extends Pessoa {
    private List<Livro> livrosAlugados;

    public Professores(String nome, double matricula, String email) {
        super(nome, matricula, email);
        this.livrosAlugados = new ArrayList<Livro>();
    }

    public void addLivro(Livro livro) throws LimiteLivrosExeption {
        if (livrosAlugados.size() < 5){
            this.livrosAlugados.add(livro);
            System.out.println(livro.getTitulo() + " alugado");
            return;
        }
        throw new LimiteLivrosExeption();
    }
}


