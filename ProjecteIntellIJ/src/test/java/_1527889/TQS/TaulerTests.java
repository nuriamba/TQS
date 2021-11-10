package _1527889.TQS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class TaulerTests {
    // Test del constructor, mira que las medidas sean las correctas
    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
    void TestCreaTauler(int n, int m){
        Tauler t = new Tauler(n, m);

        assertEquals(n, t.getN());
        assertEquals(m, t.getM());
    }

    @Test
    void TestGetSetRand(){
        Tauler t = new Tauler();
        RandomMock mock = new RandomMock();
        t.setRand(mock);
        assertSame(mock, t.getRand());
    }

    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
    void TestGetMatrix(int n, int m){
        Tauler t = new Tauler(n,m);
        assertEquals(n, t.getN());
        assertEquals(m, t.getM());
        assertNull(t.getMatrix()); // El constructor al inici no genera la matriu. no tindria sentit generar-la perque volem que es generi quan es cridi a generateBombs
    }

    //En este testearemos la generacion de una matriz nxm con 1 i 0 distribuidos aleatoriamente.
    // Aquí la idea és hacer un mock de la libreria random. Para "forzar" a que el aleatorio genere una matriz
    // que nosotros queramos. Luego habra que hacer un assert entre la matriz que se genera i la que nos deberia dar (que es lo que hayamos puesto en el mock)
    @ParameterizedTest
    @MethodSource(value = "_1527889.TQS.ParamProvider#matriusSimples")
    void TestGenerateBombs(boolean[][] mat){
		RandomMock randomMockRandom =new RandomMock();
        randomMockRandom.setReturnMatrix(mat);
		Tauler tauler=new Tauler(mat.length, mat[0].length);
		tauler.setRand(randomMockRandom);
        tauler.generateBombs();
        assertEquals(mat.length, tauler.getN());
        assertEquals(mat[0].length, tauler.getM());
		assertEquals(mat, tauler.getMatrix());
    }

}
