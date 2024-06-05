package programarcomvoce.listadeexercicios;
import java.util.Scanner;

public class NumMaior {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    if (num1 > num2) {
        System.out.println(num1+ " é o maior");
    }else {
        System.out.println(num2+ " é o maior");
    }


    }
}

           // 2 - Faça um programa que receba 2 valores e retorne o maior entre eles.
