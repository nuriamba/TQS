package _1527889.TQS;

import org.javatuples.Pair;

//La utilitzarem per fingir certs inputs del usuari per a poder fer bons testos.
public class ModelMock implements IModel{
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
