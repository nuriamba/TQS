package _1527889.TQS;

import org.javatuples.Quartet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class PractiquesApplicationTests {
	// Ideas:
	// Test de un tauler que es una fila
	// Test raco dels tauler

	// Test que recibe una matriz NxM (tablero) i que dado una casilla devuelve el numero de bombas de alrededor.
	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersSimples")
	void TestBombasAlrededorSimple(Quartet<Tauler, Integer, Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assertEquals(q.getValue3(), r);
	}

	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersEsquinas")
	void TestBombasAlrededorEsquinas(Quartet<Tauler, Integer, Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assertEquals(q.getValue3(), r);
	}

	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersEstrechos")
	void TestBombasAlrededorEstrechos(Quartet<Tauler, Integer, Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assertEquals(q.getValue3(), r);
	}

	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersParedes")
	void TestBombasAlrededorParedes(Quartet<Tauler, Integer, Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assertEquals(q.getValue3(), r);
	}

}
