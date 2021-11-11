package _1527889.TQS;

public class VistaMock implements IVista{
    Tauler bombas;
    public static final int CASELLA_OBERTA = 0;
    public static final int GAME_OVER = -1;
    public static final int SUCCESS = 1;
    char[][] tauler;
    VistaMock(Tauler t){

    }

    @Override
    public void print() {
        //nothing
    }

    @Override
    public void getCasella(int i, int j) {

    }

    @Override
    public void setCasella(int i, int j, char v) {

    }

    @Override
    public int obre(int i, int j) {
        return 0;
    }


}
