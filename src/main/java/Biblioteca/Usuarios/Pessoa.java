package Biblioteca.Usuarios;

import Biblioteca.Estante.Livro;

import java.util.List;

public class Pessoa {

    private String nome;
    private double matricula;
    private String email;
    private boolean emprestimoRealizado;
    private boolean suspenso;
    private List<Livro> livroList;

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
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", email='" + email + '\'' +
                '}';
    }
}