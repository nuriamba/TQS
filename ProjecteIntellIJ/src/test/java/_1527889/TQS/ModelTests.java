package _1527889.TQS;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
public class ModelTests {

    //Tests que comprovam que els mock funciona adequadament

    @ParameterizedTest
    @ValueSource(strings = {"facil","mitja","dificil"})
    void TestSetGetTargetDificultyMock(String t){
        ModelMock mm = new ModelMock();
        mm.setTargetDificultat(t);
        assertEquals(t, mm.demanarDificultat());
    }

    @Test
    void TestSetGetDemanarCasella(){
        ModelMock mm = new ModelMock();
        Queue<Pair<Integer, Integer>> l = new LinkedList<>();
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
}
