package programarcomvoce.listadeexercicios;

public class DivisaoMultiplos3 {
    public static void main(String[] args) {
        System.out.println("Divisão por 2 dos múltiplos de 3 (int):");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                int resultadoInt = i / 2;
                System.out.println("i = " + i + ", i/2 = " + resultadoInt);
            }
        }

        System.out.println("\nDivisão por 2 dos múltiplos de 3 (double): ");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                double resultadoDouble = i / 2;
                System.out.println("i = " + i + ", i/2 = " + resultadoDouble);
            }
        }
    }
}

// 7 - Imprima o resultado da divisão por 2 de todos os múltiplos de 3, entre 1 e
// 100, usando os tipos de dados int e double .