package HerancaEPolimorfismo_exe02;

public class Cachorro extends AnimalTerrestreAB {

    public Cachorro() {

    }

    @Override
    public void morverse() {
        super.morverse(0);
    }

    @Override
    public void comer() {
        super.comer(0);
    }

    @Override
    public void dormir() {
        super.dormir(0);
    }

    @Override
    public void andar() {
        super.andar();
    }
}