package _1527889.TQS;

import org.javatuples.Pair;

import java.io.IOException;

public class PractiquesApplication {
	//Copia una referencia a un objeto externo de tipo Random
	private IRandom rand;


	public static void main(String[] args) {
		//pseudo codigo
		/*
		* Iniciamos objetos modelo i objeto vista
		* Con el modelo pedimos que nos digan dificultad y dimensiones del tablero
		* Iniciamos el objeto Tablero con los datos recogidos
		* En bucle
		* 	Modelo pide accion Abrir, Salir, Marcar
		* 	Si es salir, acabamos ejecucion
		* 	Modelo pide la casilla a la que aplicar la accion
		* 	Si accion -> abrir
		* 		Tablero abre la casilla. Si el retorno és 0, abrimos las casillas contiguas. Si el retorno és -1 acabamos ejecucion.
		* 	Si accion -> marcar
		* 		Marcamos la casilla como Marcada (bomba localizada)
		* 	Printeamos el estado del teclado
		*fin Bucle
		* */
		System.out.println("-----NORMES-----");
		System.out.println("- El joc acaba quan tens totes les bombes marcades, i la reta de caselles obertes");
		System.out.println("- Si obres una casella amb una bomba, perds");
		System.out.println("- Cada línea s'entén com un input, els inputs separals amb un enter.");
		System.out.println("- Molta sort!");
		System.out.println("----------------");
		Model m = new Model();
		IVista v = new Vista();
		Pair<Integer,Integer> dim = m.demanarDimensionsTaulell();
		Tauler t = new Tauler(dim.getValue0(), dim.getValue1());
		t.setRand(new Random());
		t.setDificulty(m.demanarDificultat());
		t.generateBombs();
		v.print(t);
		Integer accio = m.demanarAccio();
		int code = Tauler.SUCCESS;
		while (!accio.equals(Model.SORTIR)){
			if(accio.equals(Model.OBRIR)){
				Pair<Integer,Integer> c = m.demanarCasella();
				code = t.obre_rec(c.getValue0(), c.getValue1());
				if(code == Tauler.CASELLA_JA_OBERTA)
					System.out.println("Aquesta casella ja esta oberta");
			}
			if(accio.equals(Model.MARCAR)){
				Pair<Integer,Integer> c = m.demanarCasella();
				t.setCasellaMarcada(c.getValue0(), c.getValue1());
			}

			if(code != Tauler.GAME_OVER){
				v.print(t);
				if(t.hemGuanyat()){
					System.out.println("Has Guanyat!!");
					accio = Model.SORTIR;
				}else{
					accio = m.demanarAccio();
				}
			}
			else{
				System.out.println("BOOOOOOOOOOOOOOOOOM!");
				accio=Model.SORTIR;
			}
		}
		System.out.println("Arreveure");
	}

	public static Integer mainT(Tauler t, IModel m, IVista v){
		v.print(t);
		Integer accio = m.demanarAccio();
		Integer code = Tauler.SUCCESS;
		while (!accio.equals(Model.SORTIR)) {
			if (accio.equals(Model.OBRIR)) {
				Pair<Integer, Integer> c = m.demanarCasella();
				code = t.obre_rec(c.getValue0(), c.getValue1());
				if (code == Tauler.CASELLA_JA_OBERTA) {//casella oberta}
				}
			}
			if (accio.equals(Model.MARCAR)) {
				Pair<Integer, Integer> ca = m.demanarCasella();
				t.setCasellaMarcada(ca.getValue0(), ca.getValue1());
			}

			if (code != Tauler.GAME_OVER) {
				if(t.hemGuanyat()){
					//Hem guanyat
					return Tauler.SUCCESS;
				}else{
					v.print(t);
					accio = m.demanarAccio();
				}
			} else {
				//game over
				return Tauler.GAME_OVER;
			}

		}
		return Model.SORTIR;
	}

}
