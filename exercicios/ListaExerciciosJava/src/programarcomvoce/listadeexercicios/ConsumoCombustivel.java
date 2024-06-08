package programarcomvoce.listadeexercicios;

import java.util.Scanner;

public class ConsumoCombustivel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int quilometragemTotal = 0;
        int litrosstotal = 0;
        char continuar;

        do {
            System.out.print("Digite os quilometros dirigidos: ");
            int quilometragem = sc.nextInt();

            System.out.println("Digite os litros de gasolina consumidos: ");
            int litros = sc.nextInt();

            double consumo = (double) quilometragem / litros;
            System.out.println("O consumo para este tanque foi de %.2f km/l\n" + consumo);

            quilometragemTotal += quilometragem;
            litrosstotal += litros;

            System.out.println("Deseja inserir dados para outro tanque? s/n: ");
            continuar = sc.next().toLowerCase().charAt(0);

        } while (continuar == 's');

        double consumoMedioTotal = (double) quilometragemTotal / litrosstotal;

        System.out.println("Quilometragem combinada: %d km\n" + quilometragemTotal);
        System.out.println("Total de litros consumidos: %d litros\n" + litrosstotal);
        System.out.println("Consumo médio total: %.2f km/l\n" + consumoMedioTotal);

        sc.close();
    }
}

//  12 - Os motoristas se preocupam com a quilometragem obtida por seus
//  automóveis. Um
//  motorista monitorou vários tanques cheios de gasolina registrando a
//  quilometragem dirigida e a quantidade de combustível em litros utilizados para
//  cada tanque cheio. Desenvolva um aplicativo Java que receba como entrada
//  os quilômetros dirigidos e os litros de gasolina consumidos (ambos com
//  inteiros) para cada tanque cheio. O programa deve calcular e exibir o consumo
//  em quilômetros/litro para cada tanque cheio e imprimir a quilometragem
//  combinada e a soma total de litros de combustível consumidos até esse ponto.
//  Todos os cálculos de média devem produzir resultados de ponto flutuante.
