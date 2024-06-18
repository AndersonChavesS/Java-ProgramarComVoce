package HerancaEPolimorfismo_exe02;

public interface AnimalIF {

    public void comer(float massa);

    public default void moverse(float distancia) {
    }

    void morverse(float distancia);

    public void dormir(float horas);
}
