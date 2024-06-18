package HerancaEPolimorfismo_exe02;

abstract class AnimalTerrestreAB extends AnimalAB {
    public int quantidadeDePatas;
    public float altura;

    public AnimalTerrestreAB() {
    }

    public void andar() {
        System.out.println(" Andando...");
    }
}
