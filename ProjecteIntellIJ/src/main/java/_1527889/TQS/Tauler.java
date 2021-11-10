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
        //asumim que els valors de n i m són correctes. Ho testejarà la vista
        if(matrix[n][m]){
            return -1; // BOOM
        }
        int cont = 0;
        for(int k=n-1;k<n+2;k++){
            if(k>=i || k < 0)
                break;
            for(int l=m-1;l<m+2;l++){
                if(l>=i || l < 0)
                    break;
                cont++;
            }
        }
        return cont;
    }

}
