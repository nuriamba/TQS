package _1527889.TQS;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RandomTests {

    //Test del mock
    @ParameterizedTest
    @MethodSource(value = "_1527889.TQS.ParamProvider#matriusSimples")
    void TestSetGetReturnMatrix(boolean[][] mat) {
        RandomMock mock = new RandomMock();
        mock.setReturnMatrix(mat);
        //n i m són arbitraris ja que no canviaran la matriu que retornara el mock
        assertEquals(mock.generateRandomMatrix(2,3), mat);
    }
    //Test del Random real, dimensions
    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
    void TestGetRandomMatrix(int n, int m) {
        Random ran = new Random();

        boolean[][] mat = ran.generateRandomMatrix(n,m);
        assertEquals(mat.length, n);
        assertEquals(mat[0].length, m);
    }
    //Test del Random real, crearne varies i comprobar que efectivament són diferents.
    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","100,100","400,400"})
    void TestGetDifferentRandomMatrix(int n, int m) {
        Random ran = new Random();

        boolean[][] mat = ran.generateRandomMatrix(n,m);
        boolean[][] mat2 = ran.generateRandomMatrix(n,m);
        //big boards, little chance of coincidence.
        assertNotEquals(mat,mat2);

    }

    // TESTS DIFERENTS DIFICULTATS

    //Mocked
    @ParameterizedTest
    @MethodSource(value = "_1527889.TQS.ParamProvider#taulerDificultatsMock")
    void TestGetDifferentDificultyMatrixMocked(Pair<boolean[][], String> p) {
        int n = p.getValue0().length;
        int m = p.getValue0()[0].length;
        String dif = p.getValue1();
        RandomMock mock = new RandomMock();
        mock.setReturnMatrix(p.getValue0());
        int expected = 0;
        boolean[][] ret = mock.generateRandomMatrix(n, m, dif);

        //Contem bombas segons la dificultat
        if(dif == "facil"){
            expected = (int) (n*m* 0.25); // facil es 25% de prob de bomba
        }
        else if(dif == "mitja"){
            expected = (int) (n*m* 0.3333334); // mitja es 33% de prob de bomba
        }
        else if(dif == "dificil"){
            expected = (int) (n*m* 0.5); // dificil es 50% de prob de bomba
        }else{
            expected = 0;
        }
        int cont = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ret[i][j]){
                    cont++;
                }
            }
        }

        assertEquals(cont,expected);

    }

    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","100,100","400,400"})
    void TestGetDifferentDificultyMatrix(int n, int m){
        Random ran = new Random();

        boolean[][] matEasy = ran.generateRandomMatrix(n,m,"facil");
        int matEasyCont = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matEasy[i][j]){
                    matEasyCont++;
                }
            }
        }

        boolean[][] matMedium = ran.generateRandomMatrix(n,m,"mitja");
        int matMediumCont = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matMedium[i][j]){
                    matMediumCont++;
                }
            }
        }

        boolean[][] matHard = ran.generateRandomMatrix(n,m,"dificil");
        int matHardCont = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matHard[i][j]){
                    matHardCont++;
                }
            }
        }
        //big boards, little chance of coincidence.
        assert(matEasyCont < matMediumCont && matMediumCont < matHardCont);
    }
}
