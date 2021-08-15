package bootcampDioSantander.javaBasico;

import java.util.Scanner;

/*
 * Leia um valor inteiro X. Em seguida apresente os 6 valores �mpares consecutivos a partir de X, um valor por linha
 * inclusive o X se for o caso.
 */

public class Desafio2_JavaBasico {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int cont = 0;

        while (cont <  6) {
        	if (x  %  2 == 1) {
        		System.out.println(   x   );
        		cont  ++;
        	}
    		x++;
        }
        sc.close();
    }
}
