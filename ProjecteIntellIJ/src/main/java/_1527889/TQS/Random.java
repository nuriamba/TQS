package _1527889.TQS;

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
        return new boolean[0][];
    }
}
