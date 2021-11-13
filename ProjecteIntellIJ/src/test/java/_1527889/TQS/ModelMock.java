package _1527889.TQS;

import org.javatuples.Pair;

import java.util.List;
import java.util.Queue;

//La utilitzarem per fingir certs inputs del usuari per a poder fer bons testos.
public class ModelMock implements IModel{
    private String dif = null;
    private Queue<Pair<Integer,Integer>> targetInputs;
    private Queue<Integer> targetActions;
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

    public void setTargetDificultat(String s){
        //no comprovem si el string es vàlid o no pk no es introduit per l'usuari, com és el mock, és introduit pel programador
        dif = s;
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
        return dif;
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
        return targetInputs.poll();
    }
}
