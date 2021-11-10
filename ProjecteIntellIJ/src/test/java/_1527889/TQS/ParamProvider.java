package _1527889.TQS;

import org.javatuples.Quartet;
import java.util.Arrays;
import java.util.List;

public class ParamProvider {
    static List<Quartet<Tauler, Integer, Integer, Integer>> taulersSimples(){
        // Este ParamProvider crea varios tableros, de una dimension concreta pero sencillita i le genera las bombas
        RandomMock mock = new RandomMock();
        // Tauler 1
        Tauler t1 = new Tauler();
        t1.setRand(mock);
        boolean[][] mat1 = {{true,true,true},
                            {true,false,true},
                            {true,true,true}};
        mock.setReturnMatrix(mat1);
        t1.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q1 = new Quartet<Tauler, Integer, Integer, Integer>(t1, 1,1, 8);


        // Tauler 2
        Tauler t2 = new Tauler();
        t2.setRand(mock);
        boolean[][] mat2 = {{false,true,false,false},
                            {true,false,true,false},
                            {false,true,false,false},
                            {true,true,true,true}};
        mock.setReturnMatrix(mat2);
        t2.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q2 = new Quartet<Tauler, Integer, Integer, Integer>(t2, 1,1, 4);

        // Tauler 3
        Tauler t3 = new Tauler();
        t3.setRand(mock);
        boolean[][] mat3 = {{false,false,false,false},
                            {false,false,false,false},
                            {false,false,false,true},
                            {false,false,true,false}};
        mock.setReturnMatrix(mat3);
        t3.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q3 = new Quartet<Tauler, Integer, Integer, Integer>(t3, 2,2, 2);

        // Tauler 4
        Tauler t4 = new Tauler();
        t4.setRand(mock);
        boolean[][] mat4 = {{false,false,false,false},
                            {false,false,false,false},
                            {false,false,true,true},
                            {false,false,true,false}};
        mock.setReturnMatrix(mat4);
        t4.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q4 = new Quartet<Tauler, Integer, Integer, Integer>(t3, 2,2, -1);

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
        Tauler t1 = new Tauler();
        t1.setRand(mock);
        boolean[][] mat1 = {{false,false,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat1);
        t1.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q1 = new Quartet<Tauler, Integer, Integer, Integer>(t1, 0,0, 2);


        // Tauler 2 esquina inferior derecha
        Tauler t2 = new Tauler();
        t2.setRand(mock);
        boolean[][] mat2 = {{false,true,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat2);
        t2.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q2 = new Quartet<Tauler, Integer, Integer, Integer>(t2, 2,2, 3);

        // Tauler 3 esquina inferior izquierda
        Tauler t3 = new Tauler();
        t3.setRand(mock);
        boolean[][] mat3 = {{false,true,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat3);
        t3.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q3 = new Quartet<Tauler, Integer, Integer, Integer>(t3, 2,0, 3);

        // Tauler 4 esquina superior derecha
        Tauler t4 = new Tauler();
        t4.setRand(mock);
        boolean[][] mat4 = {{false,true,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat4);
        t4.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q4 = new Quartet<Tauler, Integer, Integer, Integer>(t4, 0,2, 3);

        // Tauler 5 esquina superior derecha + boom
        Tauler t5 = new Tauler();
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
        Tauler t1 = new Tauler();
        t1.setRand(mock);
        boolean[][] mat1 = {{false,false,true,false,false,true,false,true,false,false,false,false,false,false,false,}};
        mock.setReturnMatrix(mat1);
        t1.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q1 = new Quartet<Tauler, Integer, Integer, Integer>(t1, 0,6, 2);


        // Tauler 2 columna
        Tauler t2 = new Tauler();
        t2.setRand(mock);
        boolean[][] mat2 = {{false},{false},{true},{false},{true},{true},{true},{true},{true}};
        mock.setReturnMatrix(mat2);
        t2.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q2 = new Quartet<Tauler, Integer, Integer, Integer>(t2, 3,0, 2);

        // Tauler 3 columna + boom
        Tauler t3 = new Tauler();
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
        Tauler t1 = new Tauler();
        t1.setRand(mock);
        boolean[][] mat1 = {{false,false,false},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat1);
        t1.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q1 = new Quartet<Tauler, Integer, Integer, Integer>(t1, 0,1, 3);


        // Tauler 2 pared inferior
        Tauler t2 = new Tauler();
        t2.setRand(mock);
        boolean[][] mat2 = {{false,true,false},
                {true,true,true},
                {false,false,false}};
        mock.setReturnMatrix(mat2);
        t2.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q2 = new Quartet<Tauler, Integer, Integer, Integer>(t2, 2,1, 3);

        // Tauler 3 pared izquierda
        Tauler t3 = new Tauler();
        t3.setRand(mock);
        boolean[][] mat3 = {{false,false,false},
                {false,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat3);
        t3.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q3 = new Quartet<Tauler, Integer, Integer, Integer>(t3, 1,0, 2);

        // Tauler 4 pared derecha
        Tauler t4 = new Tauler();
        t4.setRand(mock);
        boolean[][] mat4 = {{false,true,true},
                {true,true,false},
                {false,true,false}};
        mock.setReturnMatrix(mat4);
        t4.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q4 = new Quartet<Tauler, Integer, Integer, Integer>(t4, 1,2, 4);

        // Tauler 5 pared derecha + boom
        Tauler t5 = new Tauler();
        t5.setRand(mock);
        boolean[][] mat5 = {{false,true,true},
                {true,true,true},
                {false,true,false}};
        mock.setReturnMatrix(mat5);
        t5.generateBombs();
        Quartet<Tauler, Integer, Integer, Integer> q5 = new Quartet<Tauler, Integer, Integer, Integer>(t5, 1,2, -1);

        return Arrays.asList(q1,q2,q3,q4,q5);
    }
}
