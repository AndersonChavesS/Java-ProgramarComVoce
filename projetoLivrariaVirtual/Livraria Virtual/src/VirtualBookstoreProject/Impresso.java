package VirtualBookstoreProject;

import java.util.ArrayList;
import java.util.List;

public class Impresso extends Livro {
    private static List<Impresso> livros = new ArrayList<>();


    private float frete;
    private int estoque;


    public Impresso(String titulo, String autor, String editora, float preco, float frete, int estoque) {
        super(titulo, autor, editora, preco);
        this.frete = frete;
        this.estoque = estoque;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(Float frete) {
        this.frete = frete;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void atualizarEstoque() {
        if (estoque > 0) {
            estoque--;
        } else {
            System.out.println("Estoque esgotado");
        }
    }

    public void listarLivroImpresso() {
        for (Impresso impresso : livros) {
            System.out.println(impresso.toString());
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Frete: " + frete + "\n" +
                "Estoque: " + estoque + "\n";
    }
}
