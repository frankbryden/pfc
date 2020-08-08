package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PFC {
	int scoreJoueur, scoreOrdi, manche;
	final int MANCHE_MAXI = 10;
	List<String> choixValides = Arrays.asList("P", "C", "F");
	Ordi ordi = new Ordi();

	// Autres debaras
	Scanner scanner = new Scanner(System.in);

	enum Resultat {
		JOUEUR_GAGNE, ORDI_GAGNE, TIE, ERROR
	}

	public void play() {
		this.intro();
		for (int i = 0; i<MANCHE_MAXI; i++) {
			this.playRound();
		}
		if (scoreOrdi<scoreJoueur) {
			System.out.println("C'est la fin de notre jeu, et je crois que tu as gagné");
			System.out.println("Bravo tu es plus fort que moi");
			System.out.println("Rejoue avec moi quand tu veux");
		} else if (scoreOrdi>scoreJoueur) {
			System.out.println("C'est la fin de notre jeu, et je crois que j'ai gagné");
			System.out.println("Dommage je crois que je suis plus fort que toi");
			System.out.println("Rejoue avec moi quand tu veux");
		} else {
			System.out.println("C'est le fin de notre jeu, et nos deux scors sont égaux");
			System.out.println("Bravo tu es aussi fort que moi");
			System.out.println("Rejoue avec moi quans tu veux");
		}
		
		if (veutRejouer()) {
			this.reset();
			this.play();
		}
	}

	private void playRound() {
		System.out.println("à ton tour");
		String actionJoueur = scanner.nextLine().toUpperCase();

		if (choixValides.contains(actionJoueur)) {
			String actionOrdi = ordi.getAction();
			System.out.println(actionOrdi);
			Resultat resultat = this.denouement(actionJoueur, actionOrdi);
			System.out.println(resultat);
			switch(resultat) {
			case JOUEUR_GAGNE:
				this.scoreJoueur++;
				break;
			case ORDI_GAGNE:
				this.scoreOrdi++;
				break;
			case TIE:
				break;
			}
		}
		System.out.printf("C'est la fin du tour, ton score est de %d et mon score est de %d\n", scoreJoueur, scoreOrdi);
	}

	private Resultat denouement(String actionJoueur, String actionOrdi) {
		if (actionJoueur.compareToIgnoreCase("P") == 0 && actionOrdi.compareToIgnoreCase("P") == 0) {
			System.out.println("It's a tie");
			return Resultat.TIE;
		}
		if (actionJoueur.compareToIgnoreCase("C") == 0 && actionOrdi.compareToIgnoreCase("C") == 0) {
			System.out.println("It's a tie");
			return Resultat.TIE;
		}
		if (actionJoueur.compareToIgnoreCase("P") == 0 && actionOrdi.compareToIgnoreCase("P") == 0) {
			System.out.println("It's a tie");
			return Resultat.TIE;
		}
		if (actionJoueur.compareToIgnoreCase("P") == 0 && actionOrdi.compareToIgnoreCase("C") == 0) {
			System.out.println("Tu as gagné");
			return Resultat.JOUEUR_GAGNE;
		}
		if (actionJoueur.compareToIgnoreCase("C") == 0 && actionOrdi.compareToIgnoreCase("F") == 0) {
			System.out.println("Tu as gagné");
			return Resultat.JOUEUR_GAGNE;
		}
		if (actionJoueur.compareToIgnoreCase("F") == 0 && actionOrdi.compareToIgnoreCase("P") == 0) {
			System.out.println("Tu as gagné");
			return Resultat.JOUEUR_GAGNE;
		}
		if (actionJoueur.compareToIgnoreCase("P") == 0 && actionOrdi.compareToIgnoreCase("F") == 0) {
			System.out.println("J'ai gagné");
			return Resultat.ORDI_GAGNE;
		}
		if (actionJoueur.compareToIgnoreCase("F") == 0 && actionOrdi.compareToIgnoreCase("C") == 0) {
			System.out.println("J'ai gagné");
			return Resultat.ORDI_GAGNE;
		}
		if (actionJoueur.compareToIgnoreCase("C") == 0 && actionOrdi.compareToIgnoreCase("P") == 0) {
			System.out.println("J'ai gagné");
			return Resultat.ORDI_GAGNE;
		}
		return Resultat.ERROR;
	}
	

	private void intro() {
		System.out.println("Joue avec moi");
		System.out.println("On jouera un total de 10 manches");
		System.out.println("Que le meilleur gagne!");		
	}
	
	private boolean veutRejouer() {
		System.out.println("Veux tu rejouer ? (N/o)");
		String reponse = scanner.nextLine();
		if (reponse.compareToIgnoreCase("O") == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private void reset() {
		this.scoreJoueur = 0;
		this.scoreOrdi = 0;
				
	}

}
