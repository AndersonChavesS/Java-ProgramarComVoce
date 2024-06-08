package programarcomvoce.listadeexercicios;
import java.util.Scanner;

public class ConversaoMilhaKm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma distância em milhas: ");
        double milhas = sc.nextDouble();
        double quilometros = milhas * 1.609;

        System.out.printf("A distância convertida para quilometros é: %.2fkm",  quilometros);
    }
}
/*
    4 - Pretende-se escrever um programa que leia do teclado uma distância
    expressa em milhas, converte-a para quilometros e apresenta o resultado
    no console.(fórmula de conversão: 1 milha = 1.609km).
*/