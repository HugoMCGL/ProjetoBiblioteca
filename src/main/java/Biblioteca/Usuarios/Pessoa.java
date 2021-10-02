package Biblioteca.Usuarios;

public class Pessoa {

    private String nome;
    private double matricula;
    private String email;

    public Pessoa() {
    }
    public Pessoa(String nome, double matricula, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;

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