package programarcomvoce.listadeexercicios;

import java.util.Scanner;

public class NumeroPrimo {
    public boolean numPrimo(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero inteiro: ");
        int number = sc.nextInt();

        NumeroPrimo np = new NumeroPrimo();

        System.out.println("Números primos menores que " + number + ":");
        for (int i = 2; i < number; i++) {
            if (np.numPrimo(i)) {
                System.out.print(i + " ");
            }
        }

    }
}

      /*
      * 3 - Crie uma classe e na funçao main() implemente um programa que lê um
      * número inteiro do teclado e imprime todos os números primos menores que
      * ele (divisíveis por 1 ou por ele mesmo).
      * */

