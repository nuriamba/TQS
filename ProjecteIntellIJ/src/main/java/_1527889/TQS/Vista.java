package _1527889.TQS;

public class Vista implements IVista{
    @Override
    public void print(Tauler t) {
        char[][] tau = t.getVista();
        for(int i = 0; i < t.getN(); i++){
            for(int j = 0; j < t.getM(); j++){
                System.out.print(tau[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
