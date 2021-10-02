package Biblioteca;
import Biblioteca.Estante.Livro;
import Biblioteca.Exception.LimiteLivrosExeption;
import Biblioteca.Usuarios.*;

import java.util.List;

public class Biblioteca {
    public void pegaLivro(List<Livro> livros, Pessoa pessoa) throws LimiteLivrosExeption {
        if(pessoa instanceof Professores){
            for (Livro livro: livros) {
                ((Professores) pessoa).addLivro(livro);
            }
        }else {
            for (Livro livro: livros) {
                ((Alunos) pessoa).addLivro(livro);
            }
        }

    }
}
