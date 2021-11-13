package _1527889.TQS;

import org.javatuples.Pair;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

//La utilitzarem per fingir certs inputs del usuari per a poder fer bons testos.
public class ModelMock implements IModel{
    private Queue<Pair<Integer,Integer>> targetInputs;
    private Queue<Integer> targetActions;
    private Queue<String> dificultats;
    private int n;
    private int m;

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public ModelMock(){

    }

    public void setTargetDificultat(Queue<String> s){
        dificultats = s;
    }

    public void setListOfNextCasella(Queue<Pair<Integer,Integer>> l){
        targetInputs = l;
    }

    public void setListOfNextActions(Queue<Integer> l){
        targetActions = l;
    }

    @Override
    public Pair<Integer, Integer> demanarDimensionsTaulell() {
        Pair<Integer, Integer> input = targetInputs.poll();
        int _n = input.getValue0();
        int _m = input.getValue1();
        boolean valid = _n >= 0 && _m >= 0 ;

        while (!valid){
            input = targetInputs.poll();
            _n = input.getValue0();
            _m = input.getValue1();
            valid = _n > 0 && _m > 0 ;
        }
        n = _n;
        m = _m;
        return input;
    }

    @Override
    public String demanarDificultat() {
        String d = dificultats.poll();
        boolean valid = Objects.equals(d, "facil") || Objects.equals(d, "mitja") || Objects.equals(d, "dificil");
        while (!valid){
            d = dificultats.poll();
            valid = Objects.equals(d, "facil") || Objects.equals(d, "mitja") || Objects.equals(d, "dificil");

        }
        return d;
    }

    @Override
    public int demanarAccio() {
        int input = targetActions.poll();
        boolean valid = false;
        if(input == Model.MARCAR || input == Model.OBRIR || input == Model.SORTIR)
            valid = true;

        while (!valid){
            input = targetActions.poll();
            if(input == Model.MARCAR || input == Model.OBRIR || input == Model.SORTIR)
                valid = true;
        }

        return input;
    }

    @Override
    public Pair<Integer, Integer> demanarCasella() {
        Pair<Integer, Integer> input = targetInputs.poll();
        int _n = input.getValue0();
        int _m = input.getValue1();
        boolean valid = _n >= 0 && _n < n && _m >= 0 && _m < m;

        while (!valid){
            input = targetInputs.poll();
            _n = input.getValue0();
            _m = input.getValue1();
            valid = _n >= 0 && _n < n && _m >= 0 && _m < m;
        }
        return input;
    }
}
