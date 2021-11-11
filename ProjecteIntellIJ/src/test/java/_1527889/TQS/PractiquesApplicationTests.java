package _1527889.TQS;


import org.javatuples.Quartet;
import org.javatuples.Triplet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class PractiquesApplicationTests {
	// Ideas:
	// Test de un tauler que es una fila
	// Test raco dels tauler

	// Test que recibe una matriz NxM (tablero) i que dado una casilla devuelve el numero de bombas de alrededor.
	// Farem 3 testos corresponents a les particions equivalents del: Cas base, cantonades, parets
	// Test caixa negra , partició equivalent: Cas base
	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersSimples")
	void TestBombasAlrededorSimple(Quartet<Tauler, Integer, Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assertEquals(q.getValue3(), r);
	}
	// Test caixa negra, partició equivalent: Cantonades
	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersEsquinas")
	void TestBombasAlrededorEsquinas(Quartet<Tauler, Integer, Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assertEquals(q.getValue3(), r);
	}

	// Test caixa negra, partició equivalent: parets
	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersParedes")
	void TestBombasAlrededorParedes(Quartet<Tauler, Integer, Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assertEquals(q.getValue3(), r);
	}

	// Test caixa negra, cas especial taulers de una sola fila o columna
	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersEstrechos")
	void TestBombasAlrededorEstrechos(Quartet<Tauler, Integer, Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assertEquals(q.getValue3(), r);
	}

	// Test caixa negra, cas especial tauler 1x1
	@Test
	void TestBombasAlrededor1x1() {

		boolean[][] mat = {{false}};

		Tauler t = new Tauler(1,1);
		RandomMock mock = new RandomMock();
		mock.setReturnMatrix(mat);
		t.setRand(mock);
		t.generateBombs();

		int r = t.open(0,0);
		assertEquals(0, r);
	}


	// Test PairWise. Obrir totes les combinacions de variables d'entrada
	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#obrirPairWise")
	void TestBombasAlrededorParedes(Triplet<Tauler,Integer, Integer> q) {
		Tauler t = q.getValue0();
		int r = t.open(q.getValue1(),q.getValue2());
		assert(r>= -1 && r < 9);
	}

}
