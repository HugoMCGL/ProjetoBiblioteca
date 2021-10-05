package biblioteca.usuarios;

import biblioteca.estante.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    protected final String nome;
    protected final double matricula;
    protected final String email;
    protected boolean emprestimoRealizado;
    protected boolean suspenso;
    protected List<Livro> livroLista = new ArrayList<>();
    protected LocalDate dataEntrega;
    protected LocalDate dataSuspensao;

    public Pessoa(String nome, double matricula, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        emprestimoRealizado = false;
        suspenso = false;
    }

    public boolean getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public void setEmprestimoRealizado(boolean emprestimoRealizado) {
        this.emprestimoRealizado = emprestimoRealizado;
    }

    public boolean getEmprestimoRealizado() {
        return emprestimoRealizado;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getLivroLista() {
        return livroLista;
    }

    public void setLivroLista(List<Livro> livroList) {
        this.livroLista = livroList;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }


    public LocalDate getDataSuspensao() {
        return dataSuspensao;
    }

    public void setDataSuspensao(LocalDate dataSuspensao) {
        this.dataSuspensao = dataSuspensao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", email='" + email + '\'' +
                '}';
    }
}