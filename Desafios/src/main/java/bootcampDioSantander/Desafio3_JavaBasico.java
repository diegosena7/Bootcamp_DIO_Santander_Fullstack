package bootcampDioSantander;

import java.util.Scanner;

/*
 * Crie um programa que leia 6 valores. Voc� poder� receber valores negativos e/ou positivos como entrada,
 * devendo desconsiderar os valores nulos. Em seguida, apresente a quantidade de valores positivos digitados.
 */
public class Desafio3_JavaBasico {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int total = 0;

		double valor;

		for(int i = 0; i < 6; i ++){
			valor = sc.nextDouble();
			if (valor > 0){
				total = total + 1;
			}
		}
		System.out.println(total + " valores positivos");
		sc.close();
	}
}
