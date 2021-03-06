package _1527889.TQS;


import com.sun.tools.javac.Main;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	@ParameterizedTest
	@CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
	void TestIniciacioControladorModel(int n, int m) {
		ModelMock mm = new ModelMock();
		Queue<Pair<Integer,Integer>> q = new LinkedList<>();
		q.add(new Pair<>(n,m));
		mm.setListOfNextCasella(q);
		Pair<Integer, Integer> d = mm.demanarDimensionsTaulell();
		Tauler t = new Tauler(d.getValue0(), d.getValue1());

		assertEquals(t.getN(), n);
		assertEquals(t.getM(), m);
		assertEquals(mm.getN(), n);
		assertEquals(mm.getM(), m);
	}
	//White box, condition coverage.
	@ParameterizedTest
	@CsvSource(value = {"8,8","16,16","16,30","1,3","100,100","400,400"})
	void TestIniciacioControladorModelNoValid(int n, int m) {
		ModelMock mm = new ModelMock();
		Queue<Pair<Integer,Integer>> q = new LinkedList<>();

		q.add(new Pair<>(3,-2));
		q.add(new Pair<>(-3,-2));
		q.add(new Pair<>(-3, 2));
		q.add(new Pair<>(0, 2));
		q.add(new Pair<>(-3, 0));
		q.add(new Pair<>(0,0));//Valor frontera
		q.add(new Pair<>(n,m));

		mm.setListOfNextCasella(q);
		Pair<Integer, Integer> d = mm.demanarDimensionsTaulell();
		Tauler t = new Tauler(d.getValue0(), d.getValue1());

		assertEquals(t.getN(), n);
		assertEquals(t.getM(), m);
		assertEquals(mm.getN(), n);
		assertEquals(mm.getM(), m);
	}

	@ParameterizedTest
	@CsvSource(value = {"8,8","16,16","16,30","2,3","100,100","400,400"})
	void TestIniciacioControladorModelCasellas(int n, int m) {
		ModelMock mm = new ModelMock();

		Queue<Pair<Integer,Integer>> dimensions = new LinkedList<>();
		dimensions.add(new Pair<>(n,m));
		mm.setListOfNextCasella(dimensions);
		Pair<Integer, Integer> d = mm.demanarDimensionsTaulell();
		Tauler t = new Tauler(d.getValue0(), d.getValue1());

		Queue<Pair<Integer,Integer>> q = new LinkedList<>();
		q.add(new Pair<>(3,-2));
		q.add(new Pair<>(-3,-2));
		q.add(new Pair<>(1, 2));
		q.add(new Pair<>(-3, 2));
		q.add(new Pair<>(0, 2));
		q.add(new Pair<>(-3, 0));
		q.add(new Pair<>(n,m));//Valor frontera
		q.add(new Pair<>(0,0));//Valor frontera
		mm.setListOfNextCasella(q);

		Queue<Pair<Integer,Integer>> expected = new LinkedList<>();
		expected.add(new Pair<>(1, 2));;
		expected.add(new Pair<>(0,2));
		expected.add(new Pair<>(0,0));

		for(Pair<Integer,Integer> p : expected){
			Pair<Integer,Integer> r = mm.demanarCasella();
			assertEquals(p.getValue0(),r.getValue0());
			assertEquals(p.getValue1(),r.getValue1());
		}
	}

	@Test
	void TestPartidaGameOver() {
		ModelMock mm = new ModelMock();
		Queue<Pair<Integer, Integer>> dimensions = new LinkedList<>();
		IVista v = new VistaMock();
		dimensions.add(new Pair<>(3, -2));
		dimensions.add(new Pair<>(0, 0));
		dimensions.add(new Pair<>(8, 8));
		mm.setListOfNextCasella(dimensions);
		Pair<Integer, Integer> d = mm.demanarDimensionsTaulell();
		Tauler ta = new Tauler(d.getValue0(), d.getValue1());
		ta.setDificulty("facil");
		RandomMock rm = new RandomMock();

		Queue<Pair<Integer, Integer>> casellas = new LinkedList<>();
		Queue<Integer> accions = new LinkedList<>();
		mm.setListOfNextCasella(casellas);
		mm.setListOfNextActions(accions);

		boolean b = true;
		boolean f = false;
		char t = Tauler.TANCAT;
		char o = Tauler.CASELLA_OBERTA;
		char p = Tauler.CASELLA_MARCADA;
		boolean[][] mat = {{f, f, f, f, b, f, b, f},
				{f, f, f, f, f, f, f, f},
				{f, f, f, f, f, b, f, f},
				{f, f, b, f, f, f, f, f},
				{f, b, f, b, f, f, f, b},
				{f, b, f, b, f, f, f, f},
				{f, f, f, f, f, b, b, b},
				{b, f, f, b, f, b, f, b},};

		rm.setReturnMatrix(mat);
		ta.setRand(rm);
		ta.generateBombs();

		casellas.add(new Pair<>(0, 0));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(3, 2));
		accions.add(Model.MARCAR);

		casellas.add(new Pair<>(3, 3));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(3, 4));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(2, 4));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(1, 4));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(0, 4));
		accions.add(Model.MARCAR);

		casellas.add(new Pair<>(0, 5));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(4, 0));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(4, 1));
		accions.add(Model.MARCAR);

		casellas.add(new Pair<>(4, 2));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(5, 1));
		accions.add(Model.MARCAR);

		casellas.add(new Pair<>(5, 0));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(6, 0));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(6, 1));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(7, 0));
		accions.add(Model.OBRIR);

		char[][] vista2 = {{o, o, o, '1', p, '2', t, t},
				{o, o, o, '1', '2', t, t, t},
				{o, '1', '1', '1', '1', t, t, t},
				{'1', '2', p, '2', '2', t, t, t},
				{'2', p, '5', t, t, t, t, t},
				{'2', p, t, t, t, t, t, t},
				{'2', '2', t, t, t, t, t, t},
				{t, t, t, t, t, t, t, t},
		};
		int ret = PractiquesApplication.mainT(ta,mm,v);
		assertEquals(ret, Tauler.GAME_OVER);
		assertMatrixEqual(ta.getVista(), vista2);

	}

	@Test
	void TestPartidaGuanyada(){
		char o = Tauler.CASELLA_OBERTA;
		char p = Tauler.CASELLA_MARCADA;
		boolean[][] mat = { {true, false, false, false},
				{true, false, false, false},
				{true, false, false, false}};



		ModelMock mm = new ModelMock();
		Queue<Pair<Integer, Integer>> dimensions = new LinkedList<>();
		IVista v = new VistaMock();
		dimensions.add(new Pair<>(3, -2));
		dimensions.add(new Pair<>(0, 0));
		dimensions.add(new Pair<>(3, 4));
		mm.setListOfNextCasella(dimensions);
		Pair<Integer, Integer> d = mm.demanarDimensionsTaulell();
		Tauler ta = new Tauler(d.getValue0(), d.getValue1());
		ta.setDificulty("facil");
		RandomMock rm = new RandomMock();

		Queue<Pair<Integer, Integer>> casellas = new LinkedList<>();
		Queue<Integer> accions = new LinkedList<>();
		mm.setListOfNextCasella(casellas);
		mm.setListOfNextActions(accions);

		rm.setReturnMatrix(mat);
		ta.setRand(rm);
		ta.generateBombs();

		char[][] vista_guanyadora = {
				{p,'2',o,o},
				{p,'3',o,o},
				{p,'2',o,o},
		};

		casellas.add(new Pair<>(1, 3));
		accions.add(Model.OBRIR);

		casellas.add(new Pair<>(0, 0));
		accions.add(Model.MARCAR);

		casellas.add(new Pair<>(1, 0));
		accions.add(Model.MARCAR);

		casellas.add(new Pair<>(2, 0));
		accions.add(Model.MARCAR);
		v.print(ta);
		//accions.add(Model.SORTIR);
		int ret = PractiquesApplication.mainT(ta,mm,v);
		assertEquals(ret, Tauler.SUCCESS);
		assertMatrixEqual(ta.getVista(), vista_guanyadora);

	}
	void assertMatrixEqual(char[][] m1, char[][] m2){
		//Copiada d'internet. Assumim que no cal testejar-la
		int n = m1.length;
		int m = m1[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				assert(m1[i][j]==m2[i][j]);
			}
		}
	}

}
