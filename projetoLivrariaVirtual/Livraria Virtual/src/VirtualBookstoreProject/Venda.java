package VirtualBookstoreProject;

import java.util.ArrayList;

public class Venda {
    private ArrayList<Livro> livros;
    private static int numVendas = 0;
    private int numero;
    private String cliente;
    private float valor;

    public Venda(String cliente) {
        this.cliente = cliente;
        this.numero = numVendas++;
        this.livros = new ArrayList<>();
        this.valor = 0;
    }

    public void addLivro(Livro numero) {
        livros.add(numero);
        valor += numero.getPreco();

        if (numero instanceof Impresso) {
            ((Impresso) numero).atualizarEstoque();
            valor += ((Impresso) numero).getFrete();
        }
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
    }
}
