package _1527889.TQS;

import org.javatuples.Pair;

import java.util.List;
import java.util.Queue;

//La utilitzarem per fingir certs inputs del usuari per a poder fer bons testos.
public class ModelMock implements IModel{
    private String dif = null;
    private Queue<Pair<Integer,Integer>> targetInputs;
    private Queue<Integer> targetActions;

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
    public String demanarDificultat() {
        return dif;
    }

    @Override
    public int demanarAccio() {
        return targetActions.poll();
    }

    @Override
    public Pair<Integer, Integer> demanarCasella() {
        return targetInputs.poll();
    }
}
