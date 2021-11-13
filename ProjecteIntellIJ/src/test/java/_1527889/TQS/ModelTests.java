package _1527889.TQS;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
public class ModelTests {

    @ParameterizedTest
    @ValueSource(strings = {"facil","mitja","dificil"})
    void TestSetGetTargetDificultyMock(String t){
        ModelMock mm = new ModelMock();
        mm.setTargetDificultat(t);
        assertEquals(t, mm.demanarDificultat());
    }

    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
    void TestSetGetDemanarCasella(int x, int y){
        ModelMock mm = new ModelMock();

    }
}
