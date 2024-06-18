package HerancaEPolimorfismo_exe01;

public class Animal {
    public String nome;
    public int idade;
    public String emitirSom;

    public Animal(String nome, int idade, String emitirSom) {
        this.nome = nome;
        this.idade = idade;
        this.emitirSom = emitirSom;
    }

    public String getEmitirSom() {
        return emitirSom;
    }

    public void setEmitirSom(String emitirSom) {
        this.emitirSom = emitirSom;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
