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
        System.out.println("Quantidade de livros: ");
        int qtdLivros = Integer.parseInt(scanner.nextLine());

        if (numVendas < MAX_VENDAS) {
            Venda venda = new Venda(cliente);
            vendas[numVendas++] = venda;

            for (int i = 0; i < qtdLivros; i++) {
                System.out.println("Tipo de livro (Impresso/Eletrônico): ");
                String tipo = scanner.nextLine();
                if (tipo.equalsIgnoreCase("Impresso")) {
                    listarLivrosImpressos();
                    System.out.println("Escolha o índice do livro impresso: ");
                    int indice = Integer.parseInt(scanner.nextLine());
                    if (indice >= 0 && indice < numImpressos) {
                        Impresso livro = impressos[indice];
                        if (livro.getEstoque() > 0) {
                            livro.atualizarEstoque();
                            venda.addLivro(livro, 1);
                        } else {
                            System.out.println("Livro fora de estoque.");
                        }
                    } else {
                        System.out.println("Indice inválido.");
                    }
                } else if (tipo.equalsIgnoreCase("Eletronico")) {
                    listarLivrosEletronicos();
                    System.out.println("Escolha o índice do livro eletronico: ");
                    int indice = Integer.parseInt(scanner.nextLine());
                    if (indice >= 0 && indice < numEletronicos) {
                        Eletronico livro = eletronicos[indice];
                        venda.addLivro(livro, 1);
                    } else {
                        System.out.println("Indice inválido");
                    }
                }
            }
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Capacidade máxima de vendas atingida.");
        }
    }


    public void listarLivros() {
        System.out.println("Livros impressos: ");
        for (int i = 0; i < numImpressos; i++) {
            System.out.println(impressos[i + 1].toString());
        }

        System.out.println("Livros eletrônicos: ");
        for (int i = 0; i < numEletronicos; i++) {
            System.out.println(eletronicos[i + 1].toString());
        }
    }

    public void listarVendas() {
        for (int i = 0; i < numVendas; i++) {
            System.out.println("Venda " + (i + 1) + ": ");
            vendas[i].listarLivros();
        }
    }

    public void listarLivrosImpressos() {
        System.out.println("Livros impressos: ");
        for (int i = 0; i < numImpressos; i++) {
            System.out.println(impressos[i].toString());
        }
    }

    public void listarLivrosEletronicos() {
        System.out.println("Livros eletrônicos: ");
        for (int i = 0; i < numEletronicos; i++) {
            System.out.println(eletronicos[i].toString());
        }
    }

    public static void main(String[] args) {
        LivrariaVirtual livraria = new LivrariaVirtual();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("Livraria Virtual");
            System.out.println("Menu");
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