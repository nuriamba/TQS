package _1527889.TQS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class PractiquesApplicationTests {

	// Ideas:
	// Test de un tauler que es una fila
	// Test raco dels tauler


	// Test del constructor, mira que las medidas sean las correctas
	@ParameterizedTest
	@ValueSource (ints = {n,m})
	void creaTauler(int[] dim){
		Tauler t = new Tauler(n, m);

		assertEquals(n, t.getN());
		assertEquals(m, t.getM());
	}

	// Test que recibe una matriz NxM (tablero) i que dado una casilla devuelve el numero de bombas de alrededor.
	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersSimples")
	void bombasAlrededor(Tauler tauler) {

	}

}
