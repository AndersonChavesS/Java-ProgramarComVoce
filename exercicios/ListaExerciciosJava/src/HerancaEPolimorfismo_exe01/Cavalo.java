package HerancaEPolimorfismo_exe01;

public class Cavalo extends Animal {
    String cavaloCorrendo;

    public Cavalo(String nome, int idade, String emitirSom, String cavaloCorrendo) {
        super(nome, idade, emitirSom);
    }

    public String getCavaloCorrendo() {
        return cavaloCorrendo;
    }

    public void setCavaloCorrendo(String cavaloCorrendo) {
        this.cavaloCorrendo = cavaloCorrendo;
    }
}
