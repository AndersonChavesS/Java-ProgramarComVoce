package HerancaEPolimorfismo_exe01;

public class Preguica extends Animal {
    String subirEmArvore;

    public Preguica(String nome, int idade, String emitirSom, String subirEmArvore) {
        super(nome, idade, emitirSom);
    }

    public String getSubirEmArvore() {
        return subirEmArvore;
    }

    public void setSubirEmArvore(String subirEmArvore) {
        this.subirEmArvore = subirEmArvore;
    }
}
