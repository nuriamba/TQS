package _1527889.TQS;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
public class ParamProvider {
    static List<Tauler> taulersSimples(){
        // Este ParamProvider crea varios tableros, de una dimension concreta pero sencillita i le genera las bombas
        Tauler t1 = new Tauler();
        t1.generateBombs();
        Tauler t2 = new Tauler();
        t2.generateBombs();
        Tauler t3 = new Tauler();
        t3.generateBombs();
        return Arrays.asList(t1,t2,t3);
    }
}
