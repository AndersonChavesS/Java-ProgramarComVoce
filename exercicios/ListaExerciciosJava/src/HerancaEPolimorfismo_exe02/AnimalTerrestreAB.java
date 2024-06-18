package HerancaEPolimorfismo_exe02;

abstract class AnimalTerrestreAB extends AnimalAB {
    public int quantidadeDePatas;
    public float altura;

    public AnimalTerrestreAB() {
    }

    public void andar() {
        System.out.println(" está Andando...");
    }

    public abstract void comer();

    public void moverse(float distancia) {
    }

    public abstract void moverse();

    public abstract void dormir();
}
