package _1527889.TQS;

import org.javatuples.Pair;

import java.util.Objects;
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
        int in1 = -1;
        int in2 = -1;

        try {
            in1 = s.nextInt();
        }
        catch(Exception e) {
            s.nextLine();
        }
        try {
            in2 = s.nextInt();
        }
        catch(Exception e) {
            s.nextLine();
        }
        Pair<Integer, Integer> input = new Pair<>(in1, in2);
        int _n = input.getValue0();
        int _m = input.getValue1();
        boolean valid = _n >= 0 && _m >= 0 ;

        while (!valid){
            System.out.println("Nombres no vàlids, torna-ho a intentar siusplau");
            try {
                in1 = s.nextInt();
            }
            catch(Exception e) {
                s.nextLine();
            }
            try {
                in2 = s.nextInt();
            }
            catch(Exception e) {
                s.nextLine();
            }
            input = new Pair<>(in1, in2);
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
        System.out.println("Quina dificultat desitjes facil, mitja o dificil");
        String d = s.nextLine();
        d = s.nextLine();
        boolean valid = Objects.equals(d, "facil") || Objects.equals(d, "mitja") || Objects.equals(d, "dificil");
        while (!valid){
            System.out.println("Dificultat no vàlida, torna a introduir una dificultat sisplau");
            d = s.nextLine();
            valid = Objects.equals(d, "facil") || Objects.equals(d, "mitja") || Objects.equals(d, "dificil");

        }
        return d;
    }

    @Override
    public int demanarAccio() {
        System.out.println("Què vols fer? obrir (0), marcar (1) o sortir (2)");
        int input = -1;
        try {
             input = s.nextInt();
        }
        catch(Exception e) {
            s.nextLine();
        }

        boolean valid = input == Model.MARCAR || input == Model.OBRIR || input == Model.SORTIR;

        while (!valid){
            System.out.println("L'acció introduida no és vàlida, torna-hi si us plau.");
            try {
                input = s.nextInt();
            }
            catch(Exception e) {
                s.nextLine();
            }
            valid = input == Model.MARCAR || input == Model.OBRIR || input == Model.SORTIR;
        }

        return input;
    }

    @Override
    public Pair<Integer, Integer> demanarCasella() {
        System.out.println("Coordenades de la casella a la que aplicar l'acció");
        int in1 = -1;
        int in2 = -1;

        try {
            in1 = s.nextInt();
        }
        catch(Exception e) {
            s.nextLine();
        }
        try {
            in2 = s.nextInt();
        }
        catch(Exception e) {
            s.nextLine();
        }

        Pair<Integer, Integer> input = new Pair<>(in1, in2);
        int _n = input.getValue0();
        int _m = input.getValue1();
        boolean valid = _n >= 0 && _n < n && _m >= 0 && _m < m;

        while (!valid){
            System.out.println("Coordenades no vàlides, torna-ho a provar");
            try {
                in1 = s.nextInt();
            }
            catch(Exception e) {
                s.nextLine();
            }
            try {
                in2 = s.nextInt();
            }
            catch(Exception e) {
                s.nextLine();
            }
            input = new Pair<>(in1, in2);
            _n = input.getValue0();
            _m = input.getValue1();
            valid = _n >= 0 && _n < n && _m >= 0 && _m < m;
        }
        return input;
    }
}
