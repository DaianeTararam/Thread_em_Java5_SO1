package view;

import controller.ThreadPing;

public class Main {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadPing("UOL: ", "www.uol.com.br"));
		Thread t2 = new Thread(new ThreadPing("TERRA: ", "www.terra.com.br"));
		Thread t3 = new Thread(new ThreadPing("GOOGLE: ", "www.google.com.br"));
		
		t1.start();
		t2.start();
		t3.start();
	
		
		
		

	}

}
