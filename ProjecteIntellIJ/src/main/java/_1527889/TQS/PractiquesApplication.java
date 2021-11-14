package _1527889.TQS;

import org.javatuples.Pair;

import java.io.IOException;

public class PractiquesApplication {
	//Copia una referencia a un objeto externo de tipo Random
	private IRandom rand;


	public static void main(String[] args) throws InterruptedException, IOException {
		//pseudo codigo
		/*
		* Iniciamos objetos modelo i objeto vista
		* Con el modelo pedimos que nos digan dificultad y dimensiones del tablero
		* Iniciamos el objeto Tablero con los datos recogidos
		* A la vista le decimos tmb que se inicie (tablero tapado totalmente)
		* Modelo pide input de que casilla abrir
		* Tablero abre la casilla. Si el retorno és 0, abrimos las casillas contiguas. Si el retorno és -1 acabamos el juego.
		* Le damos al objeto vista la lista de casillas que tiene que actualizar
		*
		* */
		System.out.println("-----NORMES-----");
		System.out.println("- El joc acaba quan tens totes les bombes marcades, i la reta de caselles obertes");
		System.out.println("- Si obres una casella amb una bomba, perds");
		System.out.println("- Cada línea s'entén com un input, els inputs separals amb un enter.");
		System.out.println("- Molta sort!");
		System.out.println("----------------");
		Model m = new Model();
		Vista v = new Vista();
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

}
