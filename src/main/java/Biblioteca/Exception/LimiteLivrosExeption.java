package Biblioteca.Exception;

public class LimiteLivrosExeption extends Exception {

    public LimiteLivrosExeption() {
        super("Limite de livros atinjido.");
    }
}
