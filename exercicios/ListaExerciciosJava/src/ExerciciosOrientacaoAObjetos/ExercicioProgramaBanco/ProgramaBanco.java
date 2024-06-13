package ExerciciosOrientacaoAObjetos.ExercicioProgramaBanco;

public class ProgramaBanco {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("12345678900", "João Silva", "Rua A, 123", "1980");
        Cliente cliente2 = new Cliente("98765432100", "Maria Souza", "Rua B, 456", "1985");

        ContaCorrente conta1 = new ContaCorrente("001", "Conta conjunta", 1000.0, cliente1, 500.0);
        conta1.setSegundoTitular(cliente2);

        conta1.resumo();

        conta1.credito(5000.0);
        conta1.resumo();

        conta1.debito(200.0);
        conta1.resumo();

        conta1.debito(1500.0);
        conta1.resumo();
    }
}

