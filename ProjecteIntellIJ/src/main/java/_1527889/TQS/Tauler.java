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
        return matrix;
    }
    public void setRand(IRandom r){
        rand = r;
    }
    public IRandom getRand() {
        return rand;
    }

    public void generateBombs(){
        matrix = rand.generateRandomMatrix(i,j);
    }

    public int open(int n, int m){
        return 0;
    }

}
