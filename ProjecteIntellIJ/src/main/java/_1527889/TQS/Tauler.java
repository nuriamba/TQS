package _1527889.TQS;

public class Tauler {
    private int i;
    private int j;
    private boolean [][] matrix;
    private static IRandom rand;

    public Tauler(int n, int m){i=n; j=m;}
    public Tauler(){}
    public int getN(){return i;}
    public int getM(){return j;}
    public boolean[][] getMatrix() {
    }
    public void generateBombs(){}
    public void setRand(IRandom r){
        rand = r;
    }

    public IRandom getRand() {
        return rand;
    }
}
