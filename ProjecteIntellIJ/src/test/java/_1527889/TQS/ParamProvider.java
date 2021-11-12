package _1527889.TQS;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ParamProvider {
    static List<Quartet<Tauler, Integer, Integer, Integer>> taulersSimples(){
        // Este ParamProvider crea varios tableros, de una dimension concreta pero sencillita i le genera las bombas
        RandomMock mock = new RandomMock();
        // Tauler 1
        Tauler t1 = new Tauler(3,3);
        t1.setRand(mock);
        boolean[][] mat1 = {{true,true,true},
                            {true,false,true},
                            {true,true,true}};
        mock.setReturnMatrix(mat1);
        t1.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q1 = new Quartet<Tauler, Integer, Integer, Integer>(t1, 1,1, 8);


        // Tauler 2
        Tauler t2 = new Tauler(4,4);
        t2.setRand(mock);
        boolean[][] mat2 = {{false,true,false,false},
                            {true,false,true,false},
                            {false,true,false,false},
                            {true,true,true,true}};
        mock.setReturnMatrix(mat2);
        t2.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q2 = new Quartet<Tauler, Integer, Integer, Integer>(t2, 1,1, 4);

        // Tauler 3
        Tauler t3 = new Tauler(4,4);
        t3.setRand(mock);
        boolean[][] mat3 = {{false,false,false,false},
                            {false,false,false,false},
                            {false,false,false,true},
                            {false,false,true,false}};
        mock.setReturnMatrix(mat3);
        t3.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q3 = new Quartet<Tauler, Integer, Integer, Integer>(t3, 2,2, 2);

        // Tauler 4
        Tauler t4 = new Tauler(4,4);
        t4.setRand(mock);
        boolean[][] mat4 = {{false,false,false,false},
                            {false,false,false,false},
                            {false,false,true,true},
                            {false,false,true,false}};
        mock.setReturnMatrix(mat4);
        t4.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q4 = new Quartet<Tauler, Integer, Integer, Integer>(t4, 2,2, -1);

        return Arrays.asList(q1,q2,q3,q4);
    }
    static List<boolean[][]> matriusSimples(){
        // Este ParamProvider crea varios tableros, de una dimension concreta pero sencillita i le genera las bombas
        boolean[][] t1 = {{true,false,true,false,true,false,true,false},{true,false,true,false,true,false,true,false}, {true,false,true,false,true,false,true,false}, {true,false,true,false,true,false,true,false}};
        boolean[][] t2 = {{false,true,true,false,false,false,true,false},{true,false,true,false,false,false,true,true}};
        boolean[][] t3 = {{true,true,true,true,true,true,true,true},{true,true,true,true,true,true,true,true}};
        boolean[][] t4 = {{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false}};
        boolean[][] t5 = {{false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false},{true,true,true,true,true,true,true,true},{true,true,true,true,true,true,true,true}};
        return Arrays.asList(t1,t2,t3,t4, t5);
    }
    static List<Quartet<Tauler, Integer, Integer, Integer>> taulersEsquinas(){
        // Este ParamProvider crea varios tableros, de una dimension concreta pero sencillita i le genera las bombas
        RandomMock mock = new RandomMock();
        // Tauler 1 esquina superior izquierda
        Tauler t1 = new Tauler(3,3);
        t1.setRand(mock);
        boolean[][] mat1 = {{false,false,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat1);
        t1.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q1 = new Quartet<Tauler, Integer, Integer, Integer>(t1, 0,0, 2);


        // Tauler 2 esquina inferior derecha
        Tauler t2 = new Tauler(3,3);
        t2.setRand(mock);
        boolean[][] mat2 = {{false,true,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat2);
        t2.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q2 = new Quartet<Tauler, Integer, Integer, Integer>(t2, 2,2, 3);

        // Tauler 3 esquina inferior izquierda
        Tauler t3 = new Tauler(3,3);
        t3.setRand(mock);
        boolean[][] mat3 = {{false,true,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat3);
        t3.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q3 = new Quartet<Tauler, Integer, Integer, Integer>(t3, 2,0, 3);

        // Tauler 4 esquina superior derecha
        Tauler t4 = new Tauler(3,3);
        t4.setRand(mock);
        boolean[][] mat4 = {{false,true,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat4);
        t4.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q4 = new Quartet<Tauler, Integer, Integer, Integer>(t4, 0,2, 3);

        // Tauler 5 esquina superior derecha + boom
        Tauler t5 = new Tauler(3,3);
        t5.setRand(mock);
        boolean[][] mat5 = {{false,true,true},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat5);
        t5.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q5 = new Quartet<Tauler, Integer, Integer, Integer>(t5, 0,2, -1);

        return Arrays.asList(q1,q2,q3,q4,q5);
    }
    static List<Quartet<Tauler, Integer, Integer, Integer>> taulersEstrechos(){
        // Este ParamProvider crea varios tableros, de una dimension concreta pero sencillita i le genera las bombas
        RandomMock mock = new RandomMock();
        // Tauler 1 fila
        Tauler t1 = new Tauler(1, 15);
        t1.setRand(mock);
        boolean[][] mat1 = {{false,false,true,false,false,true,false,true,false,false,false,false,false,false,false}};
        mock.setReturnMatrix(mat1);
        t1.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q1 = new Quartet<Tauler, Integer, Integer, Integer>(t1, 0,6, 2);


        // Tauler 2 columna
        Tauler t2 = new Tauler(9,1);
        t2.setRand(mock);
        boolean[][] mat2 = {{false},{false},{true},{false},{true},{true},{true},{true},{true}};
        mock.setReturnMatrix(mat2);
        t2.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q2 = new Quartet<Tauler, Integer, Integer, Integer>(t2, 3,0, 2);

        // Tauler 3 columna + boom
        Tauler t3 = new Tauler(9,1);
        t3.setRand(mock);
        boolean[][] mat3 = {{false},{false},{true},{false},{true},{true},{true},{true},{true}};
        mock.setReturnMatrix(mat3);
        t3.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q3 = new Quartet<Tauler, Integer, Integer, Integer>(t3, 4,0, -1);

        return Arrays.asList(q1,q2,q3);
    }
    static List<Quartet<Tauler, Integer, Integer, Integer>> taulersParedes(){
        // Este ParamProvider crea varios tableros, de una dimension concreta pero sencillita i le genera las bombas
        RandomMock mock = new RandomMock();
        // Tauler 1 pared superior
        Tauler t1 = new Tauler(3,3);
        t1.setRand(mock);
        boolean[][] mat1 = {{false,false,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat1);
        t1.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q1 = new Quartet<Tauler, Integer, Integer, Integer>(t1, 0,1, 3);


        // Tauler 2 pared inferior
        Tauler t2 = new Tauler(3,3);
        t2.setRand(mock);
        boolean[][] mat2 = {{false,true,false},
                {true,true,true},
                {false,false,false}};
        mock.setReturnMatrix(mat2);
        t2.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q2 = new Quartet<Tauler, Integer, Integer, Integer>(t2, 2,1, 3);

        // Tauler 3 pared izquierda
        Tauler t3 = new Tauler(3,3);
        t3.setRand(mock);
        boolean[][] mat3 = {{false,false,false},
                {false,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat3);
        t3.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q3 = new Quartet<Tauler, Integer, Integer, Integer>(t3, 1,0, 2);

        // Tauler 4 pared derecha
        Tauler t4 = new Tauler(3,3);
        t4.setRand(mock);
        boolean[][] mat4 = {{false,true,true},
                {true,true,false},
                {false,true,false}};
        mock.setReturnMatrix(mat4);
        t4.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q4 = new Quartet<Tauler, Integer, Integer, Integer>(t4, 1,2, 4);

        // Tauler 5 pared derecha + boom
        Tauler t5 = new Tauler(3,3);
        t5.setRand(mock);
        boolean[][] mat5 = {{false,true,true},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat5);
        t5.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q5 = new Quartet<Tauler, Integer, Integer, Integer>(t5, 1,2, -1);

        return Arrays.asList(q1,q2,q3,q4,q5);
    }
    static List<Triplet<Integer, Integer, String>> taulerDificultats(){
        Triplet<Integer, Integer, String> t1 = new Triplet<Integer, Integer, String>(8,8,"facil");
        Triplet<Integer, Integer, String> t2 = new Triplet<Integer, Integer, String>(8,8,"mitja");
        Triplet<Integer, Integer, String> t3 = new Triplet<Integer, Integer, String>(16,16,"mitja");
        Triplet<Integer, Integer, String> t4 = new Triplet<Integer, Integer, String>(16,16,"dificil");
        Triplet<Integer, Integer, String> t5 = new Triplet<Integer, Integer, String>(32,32,"dificil");
        return Arrays.asList(t1,t2,t3,t4,t5);
    }
    static List<Pair<boolean[][], String>> taulerDificultatsMock(){

        boolean[][] mat1 = {{true, false, true, false, false, true},
                            {false, true, false, false, false, false},
                            {false, false, false, true, false, false},
                            {false, false, false, false, true, false}};
        Pair<boolean[][], String> t1 = new Pair<boolean[][], String>(mat1, "facil");

        boolean[][] mat2 = {{false, true, false, false, true, false},
                            {false, false, true, false, false, true},
                            {true, false, false, true, false, false},
                            {false, true, false, false, true, false}};
        Pair<boolean[][], String> t2 = new Pair<boolean[][], String>(mat2, "mitja");

        boolean[][] mat3 = {{true, false, false, true, false, false},
                            {false, true, false, false, true, false},
                            {false, false, true, false, false, true},
                            {false, true, false, false, true, false}};
        Pair<boolean[][], String> t3 = new Pair<boolean[][], String>(mat3, "mitja");

        boolean[][] mat4 = {{true, false, true, false, false, true},
                            {false, true, true, false, true, false},
                            {true, false, false, true, true, false},
                            {false, true, false, true, false, true}};
        Pair<boolean[][], String> t4 = new Pair<boolean[][], String>(mat4, "dificil");

        boolean[][] mat5 = {{true, false, false, false, true, true},
                            {false, true, true, true, false, false},
                            {true, false, true, true, false, false},
                            {false, true, false, false, true, true}};
        Pair<boolean[][], String> t5 = new Pair<boolean[][], String>(mat5, "dificil");

        boolean[][] mat6 = {{false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false}};
        Pair<boolean[][], String> t6 = new Pair<boolean[][], String>(mat6, "qwert");

        return Arrays.asList(t1,t2,t3,t4,t5,t6);
    }
    static List<Triplet<Tauler, Integer, Integer>> obrirPairWise(){
        int n = 3;
        int m = 3;
        List<Triplet<Tauler, Integer, Integer>> ret = new LinkedList<Triplet<Tauler, Integer, Integer>>();
        boolean[][] mat1 = {{true, false, true},
                {false, true, false},
                {false, false, false}};
        Tauler t = new Tauler(n,m);
        RandomMock mock = new RandomMock();
        mock.setReturnMatrix(mat1);
        t.setRand(mock);
        t.generateBombs();

        ret.add(new Triplet<Tauler, Integer, Integer>(t, 0, 0));
        ret.add(new Triplet<Tauler, Integer, Integer>(t, 0, 1));
        ret.add(new Triplet<Tauler, Integer, Integer>(t, 0, 2));
        ret.add(new Triplet<Tauler, Integer, Integer>(t, 1, 1));
        ret.add(new Triplet<Tauler, Integer, Integer>(t, 1, 2));
        ret.add(new Triplet<Tauler, Integer, Integer>(t, 2, 2));

        return ret;
    }
    static List<char[][]> matriusVista(){
        char t = Tauler.TANCAT;
        char o = Tauler.CASELLA_OBERTA;
        char[][] t1 ={{o,o,t},{o,o,o},{t,t,t}, {t,o,o},{t,o,t},{o,t,o}};
        char[][] t2 ={{o,'2',t},{o,'4',o},{t,'6',t}, {t,'8',o},{t,o,'7'},{o,t,o}};
        char[][] t3 = {{t,t,t},{t,'8',t},{t,t,t}};
        char[][] t4 = {{t,t,t},{t,t,t},{t,t,t}};
        char[][] t5 = {{o,o,o},{o,o,o},{o,o,o}};
        return Arrays.asList(t1,t2,t3,t4, t5);
    }
}
