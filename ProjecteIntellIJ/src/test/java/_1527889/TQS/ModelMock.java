package _1527889.TQS;

import org.javatuples.Pair;

import java.util.List;

//La utilitzarem per fingir certs inputs del usuari per a poder fer bons testos.
public class ModelMock implements IModel{
    String dif;
    List<Pair<Integer,Integer>> targetInputs;

    public void setTargetDificultat(String s){}

    @Override
    public String demanarDificultat() {
        return null;
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
