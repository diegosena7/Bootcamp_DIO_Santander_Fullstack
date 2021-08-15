package bootcampDioSantander.javaBasico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Fazer a soma de 2 valores informados via conseole
 */
public class Desafio1_JavaBasico {
	public static void main(String[] args) throws IOException {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int a = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    int total = a + b; 
	    
	    System.out.println("X = " + total);
	  }
}
