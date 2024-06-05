package programarcomvoce.listadeexercicios;

import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor: ");
        double raio = sc.nextDouble();
        double area = Math.PI * Math.pow(raio, 2);

        long areaArrendodada = Math.round(area);

        System.out.println("A área do círculo é: " + areaArrendodada);

        sc.close();
    }
}

//  9 - Escreva uma classe para calcular a área de um círculo, sabendo que a área
//  é A = PI * r2, onde o raio (r) deve ser informado pelo usuário e o resultado terá
//  que ser arredondado.