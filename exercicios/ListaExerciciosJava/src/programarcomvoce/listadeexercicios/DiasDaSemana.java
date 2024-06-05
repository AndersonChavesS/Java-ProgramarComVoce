package programarcomvoce.listadeexercicios;

import java.util.Scanner;

public class DiasDaSemana {
    public static void main(String[] args) {
        String[] diasDaSemana = {
                "Segunda-feira",
                "terça-feira",
                "quarta-feira",
                "quinta-feira",
                "sexta-feira",
                "Sabado",
                "Domingo",
        };
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número de 1 a 7 correspondendo ao dia da semana:" +
                "\n 1 para: 'segunda-feira', 2 para: 'terça-feira', ..., 7 para: 'Domingo'");
        int numero = sc.nextInt();

        if (numero >= 1 && numero <= 7) {
            System.out.println("O dia da semana é: " + diasDaSemana[numero-1]);
        }else{
            System.out.println("Número inválido! Por favor insira um número de 1 a 7.");
        }
        sc.close();
    }
}
/*
 5. Faça um programa que solicite ao usuário um número de 1 a 7, e imprima na
    tela o dia da semana correspondente. Suponha que Segunda corresponde a 1 ,
    Terça corresponde a 2, e assim por diante. Utilizando Array.
*/