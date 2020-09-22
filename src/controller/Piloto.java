package controller;
public class Piloto implements Comparable<Piloto>{
	private String equipe;
	private int carroNum;
	private double tempo;
	
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public int getCarro() {
		return carroNum;
	}
	public void setCarro(int carroNum) {
		this.carroNum = carroNum;
	}
	public double getTempo() {
		return tempo;
	}
	public void setTempo(double tempo2) {
		this.tempo = tempo2;
	}
	
	public int compareTo(Piloto comparaPiloto) {
		double comparaTempo = comparaPiloto.getTempo();
		if (comparaTempo < this.tempo) {
			return -1;
		}
		else {
			if (comparaTempo > this.tempo) {
				return 1;
			}
			else {
				return 0;
			}
		}	
	}
}