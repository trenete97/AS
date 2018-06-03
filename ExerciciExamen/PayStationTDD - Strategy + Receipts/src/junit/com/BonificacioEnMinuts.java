package junit.com;

public class BonificacioEnMinuts implements BonificacioStrategy{

    private int minutsPerBonificacio = 5;
    public int calculaBonificacio(int timeBought) throws NoEsPotBonificar {

        if (timeBought < minutsPerBonificacio) throw new NoEsPotBonificar("No es pot bonificar: "+timeBought);
        return timeBought/minutsPerBonificacio;
    }
    public void canviaMinutsPerBonificacio(int m){
        this.minutsPerBonificacio = m;
    }
}
