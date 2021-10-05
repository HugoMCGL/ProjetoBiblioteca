package biblioteca.estante;

public class Livro {

    int isbn;
    String titulo, autor, editora;
    boolean emprestado;

    public Livro(int isbn, String titulo, String autor, String editora) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", emprestado='" + emprestado + '\'' +
                '}';
    }
}
