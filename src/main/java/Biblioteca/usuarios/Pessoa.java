package Biblioteca.usuarios;

import Biblioteca.estante.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;
    private double matricula;
    private String email;
    private boolean emprestimoRealizado;
    private boolean suspenso;
    private List<Livro> livroLista = new ArrayList<>();
    private LocalDate dataEntrega;
    private int diasAtraso;

    public Pessoa() {
    }

    public Pessoa(String nome, double matricula, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        emprestimoRealizado = false;
        suspenso = false;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public void setEmprestimoRealizado(boolean emprestimoRealizado) {
        this.emprestimoRealizado = emprestimoRealizado;
    }

    public boolean isEmprestimoRealizado() {
        return emprestimoRealizado;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getMatricula() {
        return matricula;
    }
    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
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