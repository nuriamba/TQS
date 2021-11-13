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
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                assert(mat[i][j]==res[i][j]);
            }
        }
    }

    //Test de caixa negra que mostra que si fem un set de una vista que no correspon en mides al taulell, el metode no fa res.
    @Test
    void TestSetVistaMalament(){
        char t = Tauler.TANCAT;
        char o = Tauler.CASELLA_OBERTA;
        char[][] mat ={{o,'2',t},{o,'4',o},{t,'6',t}, {t,'8',o},{t,o,'7'},{o,t,o}};
        Tauler tau = new Tauler(2,3);
        char[][] previ = tau.getVista();
        tau.setVista(mat);
        assertEquals(previ,tau.getVista());

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
    //En aquest test farem un cas complex en el que la funció recursiva passi per tots els casos possibles. Run coverage tant de open com de open rec
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
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                assert(expected[i][j]==res[i][j]);
            }
        }

        boolean[][] mat2 = { {false, false, false},{false, false, false},{false, false, false}};

        randomMockRandom.setReturnMatrix(mat2);
        Tauler tauler2=new Tauler(mat2.length, mat2[0].length);
        tauler2.setDificulty("facil");
        tauler2.setRand(randomMockRandom);
        tauler2.generateBombs();

        tauler2.obre_rec(1,1);
        char[][] expected2 = {{o, o, o}, {o,o,o}, {o,o,o}};

        res= tauler2.getVista();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                assert(expected2[i][j]==res[i][j]);
            }
        }

        boolean[][] mat3 = { {false, false, false},{false, true, false},{false, false, false}};

        randomMockRandom.setReturnMatrix(mat3);
        Tauler tauler3=new Tauler(mat3.length, mat3[0].length);
        tauler3.setDificulty("facil");
        tauler3.setRand(randomMockRandom);
        tauler3.generateBombs();

        int r = tauler3.obre_rec(1,1);
        assertEquals(r, Tauler.GAME_OVER);


    }

    @Test
    void TestCasellaMarcada(){
        boolean[][] mat = { {true, false, false, false},
                {true, false, false, false},
                {true, false, false, false}};
        RandomMock randomMockRandom =new RandomMock();
        randomMockRandom.setReturnMatrix(mat);
        Tauler tauler=new Tauler(mat.length, mat[0].length);
        tauler.setDificulty("facil");
        tauler.setRand(randomMockRandom);
        tauler.generateBombs();

        tauler.setCasellaMarcada(2,0);
        tauler.setCasellaMarcada(1,0);
        tauler.setCasellaMarcada(1,2);
        char p = Tauler.CASELLA_MARCADA;
        char t = Tauler.TANCAT;
        char[][] expected = {   {t, t, t, t},
                {p, t, p, t},
                {p, t, t, t}};

        char[][] res= tauler.getVista();
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                assert(expected[i][j]==res[i][j]);
            }
        }

        tauler.obre_rec(1,2);
        char o = Tauler.CASELLA_OBERTA;

        char[][] expected2 = {   {t, '2', o, o},
                {p, '3', o, o},
                {p, '2', o, o}};

        char[][] res2= tauler.getVista();
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                assert(expected2[i][j]==res2[i][j]);
            }
        }

    }
}
