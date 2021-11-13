package _1527889.TQS;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
public class ModelTests {
    //Tests que comprovam que els mock funciona adequadament

    //Caixa negra, particions equivalents: dificultat acceptada, dificultat no valida.
    @ParameterizedTest
    @ValueSource(strings = {"facil","dificil","mitja"})
    void TestSetGetDificultyCasBase(String d){
        ModelMock mm = new ModelMock();
        Queue<String> l= new LinkedList<>();
        l.add(d);
        mm.setTargetDificultat(l);
        assertEquals(mm.demanarDificultat(),d);
    }

    //Test caixa blanca, condition coverage
    @Test
    void TestSetGetDificultyConditionCoverage(){
        ModelMock mm = new ModelMock();
        Queue<String> l= new LinkedList<>();
        mm.setTargetDificultat(l);
        l.add("qwerwe");
        l.add("facil");
        assertEquals(mm.demanarDificultat(), "facil");

        l.add("facil");
        assertEquals(mm.demanarDificultat(), "facil");

        l.add("dificil");
        assertEquals(mm.demanarDificultat(), "dificil");

        l.add("mitja");
        assertEquals(mm.demanarDificultat(), "mitja");
    }

    @Test
    void TestSetGetDemanarCasella(){
        ModelMock mm = new ModelMock();
        Queue<Pair<Integer, Integer>> l = new LinkedList<>();

        mm.setListOfNextCasella(l);
        l.add(new Pair<Integer,Integer>(10,10));
        mm.demanarDimensionsTaulell();
        l.add(new Pair<Integer,Integer>(1,1));
        l.add(new Pair<Integer,Integer>(2,1));
        l.add(new Pair<Integer,Integer>(1,2));
        l.add(new Pair<Integer,Integer>(3,3));
        l.add(new Pair<Integer,Integer>(3,4));
        l.add(new Pair<Integer,Integer>(4,3));
        l.add(new Pair<Integer,Integer>(5,3));

        mm.setListOfNextCasella(new LinkedList<>(l));

        for(Pair<Integer,Integer> p : l){
            Pair<Integer,Integer> r = mm.demanarCasella();
            assertEquals(p.getValue0(),r.getValue0());
            assertEquals(p.getValue1(),r.getValue1());
        }
    }

    @Test
    void TestSetGetDemanarCasellaNoValida(){
        ModelMock mm = new ModelMock();
        Queue<Pair<Integer, Integer>> l = new LinkedList<>();

        mm.setListOfNextCasella(l);
        l.add(new Pair<Integer,Integer>(10,10));
        mm.demanarDimensionsTaulell();

        l.add(new Pair<Integer,Integer>(1,1));
        l.add(new Pair<Integer,Integer>(2,1));
        l.add(new Pair<Integer,Integer>(1,2));
        l.add(new Pair<Integer,Integer>(3,3));
        l.add(new Pair<Integer,Integer>(3,4));
        l.add(new Pair<Integer,Integer>(4,3));
        l.add(new Pair<Integer,Integer>(5,3));

        mm.setListOfNextCasella(new LinkedList<>(l));

        for(Pair<Integer,Integer> p : l){
            Pair<Integer,Integer> r = mm.demanarCasella();
            assertEquals(p.getValue0(),r.getValue0());
            assertEquals(p.getValue1(),r.getValue1());
        }
    }


    @Test
    void TestSetGetDemanarAccio(){
        ModelMock mm = new ModelMock();
        Queue<Integer> l = new LinkedList<>();
        l.add(ModelMock.OBRIR);
        l.add(ModelMock.OBRIR);
        l.add(ModelMock.OBRIR);
        l.add(ModelMock.MARCAR);
        l.add(ModelMock.MARCAR);
        l.add(ModelMock.OBRIR);
        l.add(ModelMock.SORTIR);

        mm.setListOfNextActions(new LinkedList<>(l));

        for(Integer p : l){
            Integer r = mm.demanarAccio();
            assertEquals(r,p);
        }
    }

    @Test
    void TestSetGetDemanarAccioNoValida(){
        ModelMock mm = new ModelMock();
        Queue<Integer> l = new LinkedList<>();
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(ModelMock.MARCAR);
        l.add(7);
        l.add(6);
        l.add(ModelMock.OBRIR);
        l.add(7);
        l.add(ModelMock.SORTIR);

        Queue<Integer> expected = new LinkedList<>();
        expected.add(ModelMock.MARCAR);
        expected.add(ModelMock.OBRIR);
        expected.add(ModelMock.SORTIR);

        mm.setListOfNextActions(new LinkedList<>(l));

        for(Integer p : expected){
            Integer r = mm.demanarAccio();
            assertEquals(r,p);
        }
    }
}
