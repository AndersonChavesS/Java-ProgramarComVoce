package ExerciciosOrientacaoAObjetos.ExercicioProgramaBanco;


public class ContaCorrente {
    private String numero;
    private String tipo;
    private Cliente primeiroTitular;
    private Cliente segundoTitular;
    private double saldo;
    private double limiteTotal;

    public ContaCorrente(String numero, String tipo, double saldo, Cliente primeiroTitular, double limiteTotal) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
        this.primeiroTitular = primeiroTitular;
        this.limiteTotal = limiteTotal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getPrimeiroTitular() {
        return primeiroTitular;
    }

    public void setPrimeiroTitular(Cliente primeiroTitular) {
        this.primeiroTitular = primeiroTitular;
    }

    public Cliente getSegundoTitular() {
        return segundoTitular;
    }

    public void setSegundoTitular(Cliente segundoTitular) {
        this.segundoTitular = segundoTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteTotal() {
        return limiteTotal;
    }

    public void setLimiteTotal(double limiteTotal) {
        this.limiteTotal = limiteTotal;
    }

    public void credito(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void debito(double valor) {
        if (valor > 0 && this.saldo + this.limiteTotal >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public void resumo() {
        System.out.println("Número da conta corrente: " + this.getNumero());
        System.out.println("Primeiro Titular: " + this.primeiroTitular.getNome());
        if (this.tipo.equals("Conta conjunta") && this.segundoTitular != null) {
            System.out.println("Segundo Titular: " + this.segundoTitular.getNome());
        }
        System.out.println("Saldo atual: R$ " + this.getSaldo());
        System.out.println("Limite atual: R$ " + (this.getLimiteTotal() + this.getSaldo()));
        System.out.println("Limite total: R$ " + this.getLimiteTotal());
        System.out.println("Está devedor: " + (this.estaDevedor() ? "Procure seu gerente" : ""));
    }

    public boolean estaDevedor() {
        return this.getSaldo() < 0;
    }
}

