import java.util.ArrayList;
import java.util.List;

public class Venda {
    private static int numVendas = 0;
    private int numero;
    private String cliente;
    private double valor;
    private List<Livro> livros;

    public Venda(String cliente) {
        this.numero = ++numVendas;
        this.cliente = cliente;
        this.livros = new ArrayList<>();
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
        valor += livro.getPreco();
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    @Override
    public String toString() {
        return "Venda #" + numero + ", Cliente: " + cliente + ", Valor: " + valor + ", Livros: " + livros;
    }
}

