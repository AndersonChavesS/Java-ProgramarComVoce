package HerancaEPolimorfismo_exe02;

abstract class AnimalMarinhoAB extends AnimalAB {
    public AnimalMarinhoAB() {
    }

    public void nadar() {
        System.out.println(" está nadando...");
    }

    public abstract void comer();

    public void moverse(float distancia) {
    }

    public abstract void moverse();

    public abstract void dormir();
}
