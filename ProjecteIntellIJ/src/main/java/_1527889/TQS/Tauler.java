package _1527889.TQS;

import java.util.Objects;

public class Tauler {
    private int i;
    private int j;
    private boolean [][] matrix;
    private static IRandom rand;
    private String dificulty=null;

    public Tauler(int n, int m){i=n; j=m;}
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
    public void setDificulty(String d){
        if(Objects.equals(d, "facil") || Objects.equals(d, "mitja") || Objects.equals(d, "dificil"))
            dificulty = d;
    }
    public String getDificulty(){
        return dificulty;
    };
    public void generateBombs(){
        if(dificulty != null)
            matrix = rand.generateRandomMatrix(i,j,dificulty);
        else
            matrix = rand.generateRandomMatrix(i,j);
    }

    //Faltarà fer la recursivitat
    public int open(int n, int m){
        //asumim que els valors de n i m són correctes. Ho testejarà la vista

        if(matrix[n][m]){
            return -1; // BOOM
        }
        int cont = 0;
        for(int k=n-1;k<n+2;k++){
            if(k>=i || k < 0)
                continue;
            for(int l=m-1;l<m+2;l++){
                if(l>=j || l < 0)
                    continue;
                if(matrix[k][l])
                    cont++;
            }
        }
        return cont;
    }

}
