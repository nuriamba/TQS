package _1527889.TQS;

import org.javatuples.Triplet;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Tauler {
    public static final int CASELLA_JA_OBERTA = 0;
    public static final int GAME_OVER = -1;
    public static final int SUCCESS = 1;
    public static final char TANCAT = 'X';
    public static final char CASELLA_OBERTA = '0';
    public static final char CASELLA_MARCADA = 'P';

    private int i;
    private int j;

    private char[][] tauler;
    private boolean [][] matrix;

    private static IRandom rand;
    private String dificulty=null;

    public Tauler(int n, int m){
        tauler = new char[n][m];
        for(int k=0;k<n;k++){
            for(int l=0;l<m;l++){
                tauler[k][l]= Tauler.TANCAT;
            }
        }
        i=n; j=m;
    }
    public int getN(){return i;}
    public int getM(){return j;}
    public boolean[][] getMatrix() {
        return matrix;
    }
    public char[][] getVista() {
        return tauler;
    }
    public void setRand(IRandom r){
        rand = r;
    }
    public IRandom getRand() {
        return rand;
    }
    public void setDificulty(String d){
        dificulty = d;
    }
    public String getDificulty(){
        return dificulty;
    };
    public void setVista(char[][] mat) {
        if(mat.length == i && mat[0].length == j)
            tauler = mat;
    }
    public void setCasellaMarcada(int x, int y){
        tauler[x][y] = Tauler.CASELLA_MARCADA;
    }
    public void generateBombs(){
        if(dificulty != null)
            matrix = rand.generateRandomMatrix(i,j,dificulty);
        else
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

    public int obre_rec(int x, int y) {
        if(tauler[x][y] != Tauler.CASELLA_OBERTA){
            int n = open(x,y);
            if(n == 0){
                tauler[x][y] = Tauler.CASELLA_OBERTA;
                for(int k=x-1;k<x+2;k++){
                    if(k>=i || k < 0)
                        continue;
                    for(int l=y-1;l<y+2;l++){
                        if(l>=j || l < 0)
                            continue;
                        obre_rec(k,l);
                    }
                }
            }
            else if(n == -1)
                return Tauler.GAME_OVER;
            else {
                tauler[x][y] = (char) (n + 48);
                return Tauler.SUCCESS;
            }
        }
        else{
            return Tauler.CASELLA_JA_OBERTA;
        }
        /*PSEUDOCODI
         * Si (i,j) és casella tancada
         *   n = Tauler.open(i,j)
         *   Si n == 0
         *       setCasella(i,j, '0')
         *       this.obre(i+-1, j+-1)
         *   Si n == -1
         *       return CODI_GAME_OVER
         *   Sino
         *       setCasella(i,j, n)
         * Sino
         *   return CODI_CASELLA_OCUPADA
         * */
        return 0;
    }


}
