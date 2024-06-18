package HerancaEPolimorfismo_exe02;

abstract class AnimalVoadorAB extends AnimalAB {
    public int quantidadeDePatas;
    public int quantidadeDeAsas;
    public float envergaduraAsa;
    public float altura;

    public AnimalVoadorAB() {
    }

    public void voar() {
        System.out.println(" está voando...");
    }

    public abstract void comer();

    public abstract void morverse();

    public abstract void dormir();
}
