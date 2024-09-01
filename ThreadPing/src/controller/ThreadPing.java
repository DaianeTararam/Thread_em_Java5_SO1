package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreadPing implements Runnable{
	
	private String servidor;
	private String nome;
	
	public ThreadPing(String nome, String servidor) {
		this.servidor = servidor;
		this.nome = nome;
	}
	private String os() {
		return System.getProperty("os.name");
	}

	@Override
	public void run() {
		ping();
	}
	
	private void ping() {
		String so = os();
		Process processo;		
		double tempoTotal = 0;
		int contador = 0;
		
		try {
			if(so.contains("Linux")) {
				processo = Runtime.getRuntime().exec("ping -4 -c 10 " + servidor);
				BufferedReader leitura = new BufferedReader(new InputStreamReader(processo.getInputStream()));
				String linha;
				while((linha = leitura.readLine()) != null ) {
					System.out.println(nome + linha);
					if (linha.contains("time=")) {
						String[] partes = linha.split("time=");
						String tempoStr = partes[1].split(" ")[0];
						double tempo = Double.parseDouble(tempoStr);
						tempoTotal += tempo;
						contador++;			
					}
				}
				leitura.close();
			}else {
				System.out.println("Sistema Operacional não suportado!");
			}
			double media = (tempoTotal / contador);
			System.out.println("Tempo médio: " + media + "ms");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
