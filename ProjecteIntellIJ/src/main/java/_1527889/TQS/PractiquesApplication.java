package _1527889.TQS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PractiquesApplication {
//--------SERVICE

	//Copia una referencia a un objeto externo de tipo Random
	private Random rand;
	public void setRand(Random r){
		this.rand=r;
	}
	public void InicializaMatriz(int n,int m,boolean [][] matr){
		boolean[][] tauler= this.rand.MatrizRandom(n,m,matr);
		this.rand.Actualitzar(tauler);
	}

	public static void main(String[] args) {
		SpringApplication.run(PractiquesApplication.class, args);
	}

}
