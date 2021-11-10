package _1527889.TQS;

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
