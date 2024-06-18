package HerancaEPolimorfismo_exe02;

abstract class AnimalAB implements AnimalIF {

    public String nome;
    public String tipo;
    public int idade;
    public String habitat;
    public float peso;

    public AnimalAB() {
    }

    @Override
    public void comer(float massa) {
        System.out.println("Comeu uma quantidade de massa: " + massa + "kg");
    }

    @Override
    public void moverse(float distancia) {
        System.out.println("Moveu-se a " + distancia + " metros.");
    }

    @Override
    public void dormir(float horas) {
        System.out.println("Dormiu " + horas + " horas.");
    }
}
