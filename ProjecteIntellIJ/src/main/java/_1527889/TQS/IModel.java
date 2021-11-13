package _1527889.TQS;

import org.javatuples.Pair;

public interface IModel {
    public static final int OBRIR = 0;
    public static final int MARCAR = 1;
    public static final int SORTIR = 2;

    String demanarDificultat();
    int demanarAccio();
    Pair<Integer, Integer> demanarCasella();
}
