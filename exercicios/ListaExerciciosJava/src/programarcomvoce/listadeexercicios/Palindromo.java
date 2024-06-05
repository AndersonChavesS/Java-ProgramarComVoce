package programarcomvoce.listadeexercicios;

import java.util.Scanner;

public class Palindromo {
    public static boolean isPalindromo(String palavra) {
        String palavraLimpa = palavra.replaceAll("\\s+", "").toLowerCase();

        int inicio = 0;
        int fim = palavraLimpa.length() - 1;
        while (inicio < fim) {
            if (palavraLimpa.charAt(inicio) != palavraLimpa.charAt(fim)) {
                return false;
            }
            inicio++;
            fim--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");
        String palavra = sc.nextLine();

        if (isPalindromo(palavra)) {
            System.out.println(palavra + " é um palindromo");
        } else {
            System.out.println(palavra + " não é um palindromo");
        }
        sc.close();
    }
}
// 8 - Criar uma classe Java que receba uma palavra (String) retorne uma mensagem caso
// a palavra fornecida seja uma palavra que pode ser lida da esquerda pra direita ou da
// direita pra esquerda obtendo-se a mesma palavra. Ex.: Ana, arara, osso, etc.
