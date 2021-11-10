package _1527889.TQS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    //Test del Random real
    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
    void TestGetRandomMatrix(int n, int m) {
        Random ran = new Random();

        boolean[][] mat = ran.generateRandomMatrix(n,m);
        assertEquals(mat.length, n);
        assertEquals(mat[0].length, m);
    }
}
