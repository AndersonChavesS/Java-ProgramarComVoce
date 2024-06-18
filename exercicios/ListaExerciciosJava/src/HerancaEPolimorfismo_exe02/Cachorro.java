package HerancaEPolimorfismo_exe02;

public class Cachorro extends AnimalTerrestreAB {


    @Override
    public void comer() {
        super.moverse(0);
    }

    @Override
    public void moverse() {
        super.moverse(0);
    }

    @Override
    public void dormir() {
        super.dormir(0);
    }
}
