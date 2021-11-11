package _1527889.TQS;

public class Vista implements IVista{
    Tauler bombas;
    public static final int CASELLA_OBERTA = 0;
    public static final int GAME_OVER = -1;
    public static final int SUCCESS = 1;
    char[][] tauler;
    @Override
    public void print() {

    }

    @Override
    public void getCasella(int i, int j) {

    }

    @Override
    public void setCasella(int i, int j, char v) {

    }

    @Override
    public int obre(int i, int j) {
        /*PSEUDOCODI
        * Si (i,j) és casella tancada
        *   n = Tauler.open(i,j)
        *   Si n == 0
        *       setCasella(i,j, '0')
        *       this.obre(i+-1, j+-1)
        *   Si n == -1
        *       return CODI_GAME_OVER
        *   Sino
        *       setCasella(i,j, n)
        * Sino
        *   return CODI_CASELLA_OCUPADA
        * */
        return 0;
    }

}
