package _1527889.TQS;

//La declaramos hija de la clase que queremos imitar (Random). En esta classe devolverremos la matriz que nos hayan dado con el set
public class RandomMock implements IRandom {
    private boolean [][] mat;
    void setReturnMatrix(boolean[][] matr){
        mat = matr;
    }
    @Override
    public boolean[][] generateRandomMatrix(int n, int m) {
        return mat;
    }

    @Override
    public boolean[][] generateRandomMatrix(int n, int m, String dificultad) {
        return new boolean[0][];
    }
}

