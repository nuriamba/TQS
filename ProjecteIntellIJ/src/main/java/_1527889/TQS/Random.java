package _1527889.TQS;

import java.util.Objects;
import java.util.SplittableRandom;

public class Random implements IRandom{
    @Override
    public boolean[][] generateRandomMatrix(int n, int m) {
        java.util.Random rd = new java.util.Random(); // creating Random object from java utils
        boolean[][] mat = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=rd.nextBoolean();
            }
        }
        return mat;
    }

    @Override
    public boolean[][] generateRandomMatrix(int n, int m, String dificultad) {
         SplittableRandom rd = new SplittableRandom();

        boolean[][] mat = new boolean[n][m];
        if(Objects.equals(dificultad, "facil")){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    mat[i][j]= rd.nextInt(4) == 0;
                }
            }
        }
        else if(Objects.equals(dificultad, "mitja")){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    mat[i][j]= rd.nextInt(3) == 0;
                }
            }
        }
        else if(Objects.equals(dificultad, "dificil")){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    mat[i][j]= rd.nextInt(2) == 0;
                }
            }
        }
        return mat;
    }
}
