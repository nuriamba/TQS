package _1527889.TQS;

import org.javatuples.Pair;

public interface IModel {
    public static final Integer OBRIR = 0;
    public static final Integer MARCAR = 1;
    public static final Integer SORTIR = 2;

    String demanarDificultat();
    int demanarAccio();
    Pair<Integer, Integer> demanarCasella();
}
