package _1527889.TQS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    // Test del constructor, mira que el constructor crei bé la matriu de vista
    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
    void TestCreaTaulerVista(int n, int m){
        Tauler t = new Tauler(n, m);
        char[][] r = t.getVista();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                assertEquals(r[i][j], Tauler.TANCAT);
            }
        }
    }

    //Caixa negra
    @Test
    void TestGetSetRand(){
        Tauler t = new Tauler(1,1);
        RandomMock mock = new RandomMock();
        t.setRand(mock);
        assertSame(mock, t.getRand());
    }

    //Caixa negra, particions equivalents: dificultat acceptada, dificultat no valida.
    @ParameterizedTest
    @ValueSource(strings = {"facil","dificil","mitja"})
    void TestSetGetDificultyCasBase(String d){
        Tauler t = new Tauler(3,3);
        t.setDificulty(d);
        assertEquals(t.getDificulty(),d);
    }
    @Test
    void TestSetGetDificultyCasNoVaild(){
        Tauler t = new Tauler(3,3);
        t.setDificulty("qwerwe");
        assertNull(t.getDificulty());
    }

    //Caixa negra
    @ParameterizedTest
    @CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
    void TestGetMatrix(int n, int m){
        Tauler t = new Tauler(n,m);
        assertEquals(n, t.getN());
        assertEquals(m, t.getM());
        assertNull(t.getMatrix()); // El constructor al inici no genera la matriu. no tindria sentit generar-la perque volem que es generi quan es cridi a generateBombs
    }
    @ParameterizedTest
    @MethodSource(value = "_1527889.TQS.ParamProvider#matriusVista")
    void TestSetVista(char[][] mat){
        Tauler t = new Tauler(mat.length,mat[0].length);
        t.setVista(mat);
        char[][] res= t.getVista();
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                assert(mat[i][j]==res[i][j]);
            }
        }
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
        tauler.setDificulty("facil");
		tauler.setRand(randomMockRandom);
        tauler.generateBombs();
        assertEquals(mat.length, tauler.getN());
        assertEquals(mat[0].length, tauler.getM());
		assertEquals(mat, tauler.getMatrix());
    }

    //Cas base
    @Test
    void TestRecursiveOpenSimple(){
        boolean[][] mat = { {true, false, false, false},
                            {true, false, false, false},
                            {true, false, false, false}};
        RandomMock randomMockRandom =new RandomMock();
        randomMockRandom.setReturnMatrix(mat);
        Tauler tauler=new Tauler(mat.length, mat[0].length);
        tauler.setDificulty("facil");
        tauler.setRand(randomMockRandom);
        tauler.generateBombs();

        tauler.obre_rec(1,2);
        char o = Tauler.CASELLA_OBERTA;
        char t = Tauler.TANCAT;
        char[][] expected = {   {t, '2', o, o},
                                {t, '3', o, o},
                                {t, '2', o, o}};
        char[][] res= tauler.getVista();
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                assert(expected[i][j]==res[i][j]);
            }
        }

    }

    //Parets
    @Test
    void TestRecursiveOpenComplex(){
        boolean[][] mat = { {true, false, false, false},
                {true, false, false, false},
                {true, false, false, false}};
        RandomMock randomMockRandom =new RandomMock();
        randomMockRandom.setReturnMatrix(mat);
        Tauler tauler=new Tauler(mat.length, mat[0].length);
        tauler.setDificulty("facil");
        tauler.setRand(randomMockRandom);
        tauler.generateBombs();

        tauler.obre_rec(0,2);
        char o = Tauler.CASELLA_OBERTA;
        char t = Tauler.TANCAT;
        char[][] expected = {   {t, '2', o, o},
                {t, '3', o, o},
                {t, '2', o, o}};

        char[][] res= tauler.getVista();
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                assert(expected[i][j]==res[i][j]);
            }
        }
    }

    //CaixaBlanca
    //En aquest test farem un cas complex en el que la funció recursiva passi per tots els casos possibles, sense contar el cas game over
    @Test
    void TestRecursiveOpenCaixaBlanca(){
        boolean[][] mat = { {true, false, false, false,false},
                {true, false, true, true,true},
                {true, true, false, false,false},
                {true, true, false, false,false},
                {true, false, false, false,false},};
        RandomMock randomMockRandom =new RandomMock();
        randomMockRandom.setReturnMatrix(mat);
        Tauler tauler=new Tauler(mat.length, mat[0].length);
        tauler.setDificulty("facil");
        tauler.setRand(randomMockRandom);
        tauler.generateBombs();

        tauler.obre_rec(3,3);
        char o = Tauler.CASELLA_OBERTA;
        char t = Tauler.TANCAT;
        char[][] expected = {   {t, t, t, t,t},
                                {t, t, t, t,t},
                                {t, t, '4', '3', '2'},
                                {t, t, '2', o, o},
                                {t, t, '1', o, o}};

        char[][] res= tauler.getVista();
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                assert(expected[i][j]==res[i][j]);
            }
        }
    }


}
