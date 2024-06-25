package VirtualBookstoreProject;

import java.util.Scanner;

public class LivrariaVirtual {
    private static final int MAX_IMPRESSOS = 10;
    private static final int MAX_ELETRONICOS = 20;
    private static final int MAX_VENDAS = 50;

    private Impresso[] impressos;
    private Eletronico[] eletronicos;
    private Venda[] vendas;

    private int numImpressos;
    private int numEletronicos;
    private int numVendas;

    public LivrariaVirtual() {
        impressos = new Impresso[MAX_IMPRESSOS];
        eletronicos = new Eletronico[MAX_ELETRONICOS];
        vendas = new Venda[MAX_VENDAS];
        numImpressos = 0;
        numEletronicos = 0;
        numVendas = 0;
    }

    public void cadastrarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de livro (1 - Impresso, 2 - Eletrônico): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.println("Digite a editora do livro: ");
        String editora = scanner.nextLine();

        System.out.println("Digite o preço do livro: ");
        float preco = scanner.nextFloat();

        if (tipo == 1) {
            if (numImpressos < MAX_IMPRESSOS) {
                System.out.println("Digite o valor do frete do livro: ");
                float frete = scanner.nextFloat();
                System.out.println("Digite o estoque do livro: ");
                int estoque = scanner.nextInt();

                impressos[numImpressos++] = new Impresso(titulo, autor, editora, preco, frete, estoque);
                System.out.println("Livro impresso cadastrado com sucesso!");
            } else {
                System.out.println("Não há espaço para cadastrar mais livros impressos.");
            }
        } else if (tipo == 2) {
            if (numEletronicos < MAX_ELETRONICOS) {
                System.out.println("Digite o tamanho do livro(em KB): ");
                int tamanho = scanner.nextInt();

                eletronicos[numEletronicos++] = new Eletronico(titulo, autor, editora, preco, tamanho);
                System.out.println("Livro eletrônico cadastrado com sucesso!");
            } else {
                System.out.println("Não há espaço para cadastrar mais livros eletrônicos.");
            }
        } else {
            System.out.println("Tipo de livro inválido.");
        }
    }

    public void realizarVenda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String cliente = scanner.nextLine();

        System.out.println("Digite a quantidade de livros que deseja comprar: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Venda venda = new Venda(cliente);


        for (int i = 0; i < MAX_VENDAS; i++) {
            System.out.println("Digite o tipo de Livro (1 - Impresso; 2 - Eletrônico): ");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            if (tipo == 1) {
                System.out.println("Digite o título do livro impresso: ");
                String titulo = scanner.nextLine();
                Impresso impresso = null;
                for (int j = 0; j < numImpressos; j++) {
                    if (impressos[j].getTituloDoLivro().equals(titulo)) {
                        impresso = impressos[j];
                        break;
                    }
                }
                if (impresso != null) {
                    venda.addLivro(impresso);
                    finalizarVenda(venda);
                } else {
                    System.out.println("Livro impresso não encontrado.");
                }
            } else if (tipo == 2) {
                System.out.println("Digite o título do livro eletrônico: ");
                String titulo = scanner.nextLine();
                Eletronico eletronico = null;
                for (int j = 0; j < numEletronicos; j++) {
                    if (eletronicos[j].getTituloDoLivro().equals(titulo)) {
                        eletronico = eletronicos[j];
                        break;
                    }
                }
                if (eletronico != null) {
                    venda.addLivro(eletronico);
                    finalizarVenda(venda);

                } else {
                    System.out.println("Livro eletrônico não encontrado.");
                }
            } else {
                if (tipo != 1 && tipo != 2)
                    System.out.println("Tipo de livro inválido.");
            }
        }
    }

    public void finalizarVenda(Venda venda) {
        if (numVendas < MAX_VENDAS) {
            vendas[numVendas++] = venda;
            System.out.println("Venda realizada com sucesso!");

        } else {
            System.out.println("Não há espaço para cadastrar mais vendas.");
        }
    }

    public void listarLivros() {
        System.out.println("Livros impressos: ");
        for (int i = 0; i < numImpressos; i++) {
            System.out.println(impressos[i].toString());
        }

        System.out.println("Livros eletrônicos: ");
        for (int i = 0; i < numEletronicos; i++) {
            System.out.println(eletronicos[i].toString());
        }
    }

    public void listarVendas() {
        for (int i = 0; i < numVendas; i++) {
            System.out.println("Venda " + (i + 1) + ": ");
            vendas[i].listarLivros();
        }
    }

    public static void main(String[] args) {
        LivrariaVirtual livraria = new LivrariaVirtual();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Realizar venda");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Listar vendas");
            System.out.println("5 - Sair");
            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    livraria.cadastrarLivro();
                    break;
                case 2:
                    livraria.realizarVenda();
                    break;
                case 3:
                    livraria.listarLivros();
                    break;
                case 4:
                    livraria.listarVendas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }
}