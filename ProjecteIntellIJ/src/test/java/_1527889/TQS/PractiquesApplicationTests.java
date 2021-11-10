package _1527889.TQS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
	@CsvSource(value = {"1,0","8,8","16,16","16,30"})
	void TestCreaTauler(int n, int m){
		Tauler t = new Tauler(n, m);

		assertEquals(n, t.getN());
		assertEquals(m, t.getM());
	}

	//En este testearemos la generacion de una matriz nxm con 1 i 0 distribuidos aleatoriamente.
	// Aquí la idea és hacer un mock de la libreria random. Para "forzar" a que el aleatorio genere una matriz
	// que nosotros queramos. Luego habra que hacer un assert entre la matriz que se genera i la que nos deberia dar (que es lo que hayamos puesto en el mock)
	@Test
	void TestMatriz(){
		Mock mockRandom=new Mock();

		Tauler tauler=new Tauler();

		mockRandom.MockMatrizRandom(8,8, {{true,false,true},{true,false,true}});

		PractiquesApplication pa= new PractiquesApplication();
		pa.setRand(mockRandom);

		pa.InicializaMatriz(8,8,{{true,false,true,false,true,false,true,false},{true,false,true,false,true,false,true,false}, {true,false,true,false,true,false,true,false}, {true,false,true,false,true,false,true,false}});
		assertEquals({{true,false,true,false,true,false,true,false},{true,false,true,false,true,false,true,false}, {true,false,true,false,true,false,true,false}, {true,false,true,false,true,false,true,false}}, getTauler());
	}


	@Test
	void TestGenerateBombs() {

	}

	// Este test sera sencillito. Habra que generar una matriz con la funcion mencionada anteriormente, i assignar-la a un objeto Tauler. Luego hacer assert de que se haya asignado bien
	@Test
	void TestSetBombs(){

	}

	// Test que recibe una matriz NxM (tablero) i que dado una casilla devuelve el numero de bombas de alrededor.
	@ParameterizedTest
	@MethodSource(value = "_1527889.TQS.ParamProvider#taulersSimples")
	void bombasAlrededor(Tauler tauler) {

	}

}
