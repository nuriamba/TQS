package _1527889.TQS;

import org.javatuples.Pair;

import java.util.List;

//La utilitzarem per fingir certs inputs del usuari per a poder fer bons testos.
public class ModelMock implements IModel{
    private String dif = null;
    private List<Pair<Integer,Integer>> targetInputs;
    private List<Integer> targetActions;

    public void setTargetDificultat(String s){
        //no comprovem si el string es vàlid o no pk no es introduit per l'usuari, com és el mock, és introduit pel programador
        dif = s;
    }

    public void setListOfNextCasella(List<Pair<Integer,Integer>> l){
        targetInputs = l;
    }

    public void setListOfNextActions(List<Integer> l){
        targetActions = l;
    }

    @Override
    public String demanarDificultat() {
        return dif;
    }

    @Override
    public int demanarAccio() {
        int r = targetActions.get(0);
        targetActions.remove(0);
        return r;
    }

    @Override
    public Pair<Integer, Integer> demanarCasella() {
        Pair<Integer, Integer> r = targetInputs.get(0);
        targetInputs.remove(0);
        return r;
    }
}
