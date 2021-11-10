package _1527889.TQS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomTests {

    @ParameterizedTest
    @MethodSource(value = "_1527889.TQS.ParamProvider#matriusSimples")
    void TestSetGetReturnMatrix(boolean[][] mat) {
        RandomMock mock = new RandomMock();
        mock.setReturnMatrix(mat);
        //n i m són arbitraris ja que no canviaran la matriu que retornara el mock
        assertEquals(mock.generateRandomMatrix(2,3), mat);
    }

}
