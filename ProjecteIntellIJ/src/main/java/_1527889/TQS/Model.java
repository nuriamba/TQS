package _1527889.TQS;

import org.javatuples.Pair;

import java.util.Scanner;

//Aquesta classe no rep tests ja que té els mateixos mètodes que ModelMock però
// canviant el queue.poll() per un Scanner.nextInt(), cosa que no fa que requereixi un nou test.
public class Model implements IModel{
    private int n;
    private int m;
    private static final Scanner s = new Scanner(System.in);
    @Override
    public Pair<Integer, Integer> demanarDimensionsTaulell() {
        System.out.println("Introdueix les dimensions del taulell (2 números)");
        Pair<Integer, Integer> input = new Pair<>(s.nextInt(),s.nextInt());
        int _n = input.getValue0();
        int _m = input.getValue1();
        boolean valid = _n >= 0 && _m >= 0 ;

        while (!valid){
            System.out.println("Nombres no vàlids, torna-ho a intentar siusplau");
            input = new Pair<>(s.nextInt(),s.nextInt());
            _n = input.getValue0();
            _m = input.getValue1();
            valid = _n > 0 && _m > 0 ;
        }
        n = _n;
        m = _m;
        return input;
    }

    @Override
    public String demanarDificultat() {
        return s.nextLine();
    }

    @Override
    public int demanarAccio() {
        int input = s.nextInt();
        boolean valid = false;
        if(input == Model.MARCAR || input == Model.OBRIR || input == Model.SORTIR)
            valid = true;

        while (!valid){
            input = s.nextInt();
            if(input == Model.MARCAR || input == Model.OBRIR || input == Model.SORTIR)
                valid = true;
        }

        return input;
    }

    @Override
    public Pair<Integer, Integer> demanarCasella() {
        System.out.println("Coordenades de la casella a la que aplicar l'acció");
        Pair<Integer, Integer> input = new Pair<>(s.nextInt(), s.nextInt());
        int _n = input.getValue0();
        int _m = input.getValue1();
        boolean valid = _n >= 0 && _n < n && _m >= 0 && _m < m;

        while (!valid){
            System.out.println("Coordenades no vàlides, torna-ho a provar");
            input =  new Pair<>(s.nextInt(), s.nextInt());
            _n = input.getValue0();
            _m = input.getValue1();
            valid = _n >= 0 && _n < n && _m >= 0 && _m < m;
        }
        return input;
    }
}
