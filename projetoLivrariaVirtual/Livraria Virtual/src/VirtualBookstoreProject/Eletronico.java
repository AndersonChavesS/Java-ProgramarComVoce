package VirtualBookstoreProject;

import java.util.ArrayList;
import java.util.List;

public class Eletronico extends Livro {
    private static List<Eletronico> livros = new ArrayList<>();

    private int tamanho;

    public Eletronico(String titulo, String autor, String editora, float preco, int tamanho) {
        super(titulo, autor, editora, preco);
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void listarLivroEletronico() {
        for (Eletronico eletronico : livros) {
            System.out.println(eletronico.toString());
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tamanho: " + tamanho + "\n";
    }
}
