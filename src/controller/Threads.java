package controller;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
public class Threads extends Thread {
	private int equipe;
	private String nomeEquipe;
	private Semaphore semPista;
	private Semaphore semEquipe[];
	private double tempo;
	private int carroNum;
	private Piloto piloto[];
	private static int cont;
	Semaphore semaforoPs = new Semaphore(1);
	private double maior;
	
	public Threads(int carroNum, int equipe, Semaphore semPista, Semaphore semEquipe[], Piloto piloto[]) {
		this.equipe = equipe;
		this.semPista = semPista;
		this.semEquipe = semEquipe;
		this.carroNum = carroNum;
		this.piloto = piloto;
	}
	
	public void run() {
		switch(equipe) {
		case 0: nomeEquipe = "Mercedes-AMG";
		break;
		
		case 1: nomeEquipe = "RBR Red Bull Racing";
		break;
		
		case 2: nomeEquipe = "McLaren";
		break;
		
		case 3: nomeEquipe = "Racing Point";
		break;
		
		case 4: nomeEquipe = "Renault DP";
		break;
		
		case 5: nomeEquipe = "Scuderia Ferrari";
		break;
		
		case 6: nomeEquipe = "AlphaTauri Honda";
		break;
		}
		
		try {
			semEquipe[equipe].acquire();
			semPista.acquire();
			corridaPista();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semPista.release();
			semEquipe[equipe].release();
		}
		
		try {
			semaforoPs.acquire();
			mostraGrid();
		}catch (InterruptedException e){
			e.printStackTrace();
		} finally {
			semaforoPs.release();
		}	
	}
	
	private void corridaPista() {
		for (int i = 0; i < 3; i ++) {
			tempo = (Math.random() * 1) + 1;
			try{
				sleep((long) (tempo + 1000));
			}catch (Exception e) {
				e.printStackTrace();
			}
			if (tempo > maior) {
				this.maior = tempo;
			}
			System.out.println("O piloto com carro n." + carroNum + " da equipe " + nomeEquipe + " completou sua " + (i + 1) +"° volta em " + tempo + " minuto." );
		}
		piloto[carroNum - 1].setCarro(carroNum);
		piloto[carroNum - 1].setEquipe(nomeEquipe);
		piloto[carroNum - 1].setTempo(maior);
	}
				
	private void mostraGrid() {
		cont ++;
		if (cont == 14) {
			Arrays.sort(piloto);
			System.out.println("\nGrid de Largada");
			for (int i = 0; i < 14; i ++) {
				System.out.println((i + 1) + "° lugar o piloto carro n. " + piloto [13 - i].getCarro() + " | Equipe: " + piloto[13 - i].getEquipe() + " | Tempo da melhor volta: " +
						piloto[13 - i].getTempo() + " minuto.");
			}
		}
	}	
}