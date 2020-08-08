package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PFC {
    int scoreJoueur, scoreOrdi, manche;
    final int MANCHE_MAXI = 10;
    List<String> choixValides = Arrays.asList("P", "C", "F");
    Ordi ordi = new Ordi();

    //Autres debaras
    Scanner scanner = new Scanner(System.in);

    enum Resultat {
        JOUEUR_GAGNE,
        ORDI_GAGNE,
        TIE
    }




    public void play(){
        this.intro();
        this.playRound();

    }

    private void playRound(){
        System.out.println("a ton tour");
        String actionJoueur = scanner.nextLine();

        if (choixValides.contains(actionJoueur)){
            String actionOrdi = ordi.getAction();
        }
    }

    private Resultat denouement(String actionJoueur, String actionOrdi)

    private void intro(){
        System.out.println("Joue avec moi");
        System.out.println("On jouera un total de 10 manches");
        System.out.println("Que le meilleur gagne!");
    }


}
