package bootcampDioSantander.javaNumericos;

import java.io.IOException;
import java.util.Scanner;

/*
Precisamos saber quanto uma determinada empresa deve pagar para seus colaboradores, porém temos apenas
a quantidade de horas trabalhadas e o valor hora. Escreva um programa que leia o número de um
colaborador, seu número de horas trabalhadas, o valor que recebe por hora e calcula o salário desse
colaborador. Em seguida, apresente o número e o salário do colaborador, com duas casas decimais.
 */

public class SalarioFuncionario {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Integer numColaborador = sc.nextInt();

        Integer horasTrabalhadas = sc.nextInt();

        Double valorPorhora = sc.nextDouble();

        Double salario = (double)horasTrabalhadas * valorPorhora;

        System.out.println("NUMBER = " + numColaborador);
        System.out.printf("SALARY = U$ %.2f ", salario);
    }
}
