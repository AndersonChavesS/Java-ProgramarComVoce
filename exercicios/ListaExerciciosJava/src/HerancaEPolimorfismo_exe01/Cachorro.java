package HerancaEPolimorfismo_exe01;

public class Cachorro extends Animal {
    String cachorroCorrendo;

    public Cachorro(String nome, int idade, String emitirSom, String cachorroCorrendo) {
        super(nome, idade, emitirSom);
    }

    public String getCachorroCorrendo() {
        return cachorroCorrendo;
    }

    public void setCachorroCorrendo(String cachorroCorrendo) {
        this.cachorroCorrendo = cachorroCorrendo;
    }
}
