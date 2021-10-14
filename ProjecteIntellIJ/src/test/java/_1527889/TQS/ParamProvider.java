package _1527889.TQS;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
public class ParamProvider {
    static List<Tauler> taulersSimples(){
        Tauler t1 = new Tauler();
        Tauler t2 = new Tauler();
        Tauler t3 = new Tauler();
        return Arrays.asList(t1,t2,t3);
    }
}
