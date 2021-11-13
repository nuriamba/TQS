package _1527889.TQS;

import org.javatuples.Pair;

import java.util.List;
import java.util.Queue;

//La utilitzarem per fingir certs inputs del usuari per a poder fer bons testos.
public class ModelMock implements IModel{
    private String dif = null;
    private Queue<Pair<Integer,Integer>> targetInputs;
    private Queue<Integer> targetActions;

    public ModelMock(){

    }

    public ModelMock(int n, int m){

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
        return null;
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
