package _1527889.TQS;

//La declaramos hija de la clase que queremos imitar (Random). En esta classe devolverremos la matriz que nos hayan dado con el set
public class RandomMock implements IRandom {
    private boolean [][] mat;
    @Override
    public boolean[][] generateRandomMatrix(int n, int m) {
        return new boolean[0][];
    }
}

