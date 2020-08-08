package com.company;

import java.util.Random;

public class Ordi {
	String[] choix = new String[]{"P", "C", "F"};
	Random random;
	
	public Ordi() {
		this.random = new Random();
	}
   
	public String getAction(){
       return choix[random.nextInt(choix.length)];
            
    }
}
