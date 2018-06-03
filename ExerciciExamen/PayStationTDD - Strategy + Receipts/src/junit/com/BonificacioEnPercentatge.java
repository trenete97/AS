package junit.com;

public class BonificacioEnPercentatge implements BonificacioStrategy{

    double percentatge = 0.1;

    public int calculaBonificacio(int timeBought) {
        return (int) (percentatge * timeBought);
    }
    public void canviaPercentatge(double p){
        this.percentatge = p;
    }
}
