package programarcomvoce.listadeexercicios;

import java.util.Scanner;

public class ComparadorDePalavras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a primeira palavra:");
        String palavra1 = sc.nextLine();
        System.out.println("Digite a segunda palavra:");
        String palavra2 = sc.nextLine();

        if (palavra1.compareTo(palavra2) < 0) {
            System.out.println("ordem alfabética: " + palavra1 + " e " + palavra2);
        } else {
            System.out.println("ordem alfabética: " + palavra1 + " e " + palavra2);
        }

        if (palavra1.length() < palavra2.length()) {
            System.out.println("A palavra com mais caracteres é: " + palavra2);
        } else if (palavra1.length() == palavra2.length()) {
            System.out.println("A palavras contém a mesma quantidade de caracteres");
        } else {
            System.out.println("A palavra com mais caracteres é: " + palavra1);
        }
        sc.close();
    }
}

//  11. Escreva um programa que tenha duas palavras como entrada, e a saída
//  imprima as palavras em ordem alfabética (utilize o método compareTo da
//  classe String). Informe também, qual das palavras tem o maior número de
//  caracteres.