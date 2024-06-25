package VirtualBookstoreProject;

public abstract class Livro {
    private String tituloDoLivro;
    private String autor;
    private String editora;
    private float preco;

    public Livro() {
    }

    public Livro(String tituloDoLivro, String autor, String editora, float preco) {
        this.tituloDoLivro = tituloDoLivro;
        this.autor = autor;
        this.editora = editora;
        this.preco = preco;
    }

    public String getTituloDoLivro() {
        return tituloDoLivro;
    }

    public void setTituloDoLivro(String tituloDoLivro) {
        this.tituloDoLivro = tituloDoLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Título: " + getTituloDoLivro() + "\n" +
                "Autor: " + getAutor() + "\n" +
                "Editora: " + getEditora() + "\n" +
                "Preço: " + getPreco() + "\n";
    }


}
