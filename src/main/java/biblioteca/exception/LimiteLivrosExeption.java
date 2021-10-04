package biblioteca.exception;

public class LimiteLivrosExeption extends Exception {

    public LimiteLivrosExeption() {
        super("Limite de livros atinjido.");
    }
}
