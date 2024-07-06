public class Impresso extends Livro {
    private double frete;
    private int estoque;

    public Impresso(String titulo, String autores, String editora, double preco, double frete, int estoque) {
        super(titulo, autores, editora, preco);
        this.frete = frete;
        this.estoque = estoque;
    }

    public double getFrete() {
        return frete;
    }

    public int getEstoque() {
        return estoque;
    }

    public void atualizarEstoque() {
        estoque--;
    }

    @Override
    public String toString() {
        return super.toString() + ", Frete: " + frete + ", Estoque: " + estoque;
    }
}
