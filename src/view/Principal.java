package view;
import java.util.concurrent.Semaphore;
import controller.Threads;
import controller.Piloto;
public class Principal {
	public static void main(String[] args) {
		int carro = 1;
		Semaphore semPista = new Semaphore(5);
		Semaphore [] semEquipe = new Semaphore[7];
		
		Piloto piloto[] = new Piloto[14];
		for (int i = 0; i < piloto.length; i ++) {
			piloto[i] = new Piloto();
		}
		
		for (int i = 0; i < 7; i ++) {
			semEquipe[i] = new Semaphore(1);
			Thread carro1 = new Threads(carro, i, semPista, semEquipe, piloto);
			carro ++;
			Thread carro2 = new Threads(carro, i, semPista, semEquipe, piloto);
			carro ++;
			carro1.start();
			carro2.start();
		}
	}

}