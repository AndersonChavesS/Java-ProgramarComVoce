public abstract class Livro {
    private String titulo;
    private String autores;
    private String editora;
    private double preco;

    public Livro(String titulo, String autores, String editora, double preco) {
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutores() {
        return autores;
    }

    public String getEditora() {
        return editora;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autores: " + autores + ", Editora: " + editora + ", Preço: " + preco;
    }
}
