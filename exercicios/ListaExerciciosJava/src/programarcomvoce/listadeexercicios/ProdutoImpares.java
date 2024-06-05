package programarcomvoce.listadeexercicios;

public class ProdutoImpares {
    public static void main(String[] args) {
        int produtoInt = 1;
        for (int i = 15; i <= 30; i++) {
            if (i % 2 != 0) {
                produtoInt *= i;
            }
        }
        System.out.println("Produto dos números ímpares(int): " + produtoInt);

        float produtoFloat = 1.0F;
        for (int i = 15; i <= 30; i++) {
            if (i % 2 != 0) {
                produtoFloat *= i;
            }
        }
        System.out.println("Produto dos números ímpares(float): " + produtoFloat);
    }
}
//  6 - Imprima produto dos números de ímpares de 15 a 30, usando os tipos de
//  dados int e float.