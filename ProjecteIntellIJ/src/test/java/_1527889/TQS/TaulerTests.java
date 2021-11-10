package _1527889.TQS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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

    //En este testearemos la generacion de una matriz nxm con 1 i 0 distribuidos aleatoriamente.
    // Aquí la idea és hacer un mock de la libreria random. Para "forzar" a que el aleatorio genere una matriz
    // que nosotros queramos. Luego habra que hacer un assert entre la matriz que se genera i la que nos deberia dar (que es lo que hayamos puesto en el mock)
    @Test
    void TestMatriz(){
		/*
		RandomMock randomMockRandom =new RandomMock();

		Tauler tauler=new Tauler();
		tauler.setRand(randomMockRandom);

		boolean[][] mat1 = {{true,false,true,false,true,false,true,false},{true,false,true,false,true,false,true,false}, {true,false,true,false,true,false,true,false}, {true,false,true,false,true,false,true,false}};

		assertEquals(mat1, tauler.getMatrix());
		*/
    }

}