package _1527889.TQS;

import org.javatuples.Pair;

import java.util.List;

//La utilitzarem per fingir certs inputs del usuari per a poder fer bons testos.
public class ModelMock implements IModel{
    String dif = null;
    List<Pair<Integer,Integer>> targetInputs;

    public void setTargetDificultat(String s){
        //no comprovem si el string es vàlid o no pk no es introduit per l'usuari, com és el mock, és introduit pel programador
        dif = s;
    }

    @Override
    public String demanarDificultat() {
        return dif;
    }

    @Override
    public int demanarAccio() {
        return 0;
    }

    @Override
    public Pair<Integer, Integer> demanarCasella() {
        return null;
    }
}
