package biblioteca.usuarios;

import biblioteca.estante.Livro;

import java.util.ArrayList;
import java.util.List;

public class Alunos extends Pessoa {
    private List<Livro> livrosAlugados;

    public Alunos(String nome, double matricula, String email) {
        super(nome, matricula, email);
        this.livrosAlugados = new ArrayList<Livro>();
    }
}



