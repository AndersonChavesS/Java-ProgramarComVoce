package programarcomvoce.listadeexercicios;

import java.util.Scanner;

public class ContadorDeCaracteres {
    private String texto;
    private int vogais;
    private int espacos;
    private int consoantes;

    public ContadorDeCaracteres(String texto) {
        this.texto = texto.toLowerCase();
        this.vogais = 0;
        this.espacos = 0;
        this.consoantes = 0;
        contadorCaracteres();
    }

    private void contadorCaracteres() {
        for (char c : texto.toCharArray()) {
            if (isVogal(c)) {
                vogais++;
            } else if (c == ' ') {
                espacos++;
            } else if (isConsoante(c)) {
                consoantes++;
            }
        }
    }

    private boolean isVogal(char c) {
        return "aáàâãeéêiíoóôõuú".indexOf(c) != -1;
    }

    private boolean isConsoante(char c) {
        return "bcçdfghjklmnpqrstvwxyz".indexOf(c) != -1;
    }

    public int getVogais() {
        return vogais;
    }

    public int getEspacos() {
        return espacos;
    }

    public int getConsoantes() {
        return consoantes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma frase:");
        String texto = sc.nextLine();
        ContadorDeCaracteres contador = new ContadorDeCaracteres(texto);

        System.out.println("Vogais: " + contador.getVogais());
        System.out.println("Espaços: " + contador.getEspacos());
        System.out.println("Consoantes: " + contador.getConsoantes());
    }
}

// 10. Escreva uma classe que conte a quantidade de vogais, espaços em
// brancos e consoantes de uma cadeia de caracteres.