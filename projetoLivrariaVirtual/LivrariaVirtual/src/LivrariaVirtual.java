import java.sql.*;
import java.util.Scanner;

public class LivrariaVirtual {
    private static final int MAX_IMPRESSOS = 10;
    private static final int MAX_ELETRONICOS = 20;
    private static final int MAX_VENDAS = 50;

    private Impresso[] impressos = new Impresso[MAX_IMPRESSOS];
    private Eletronico[] eletronicos = new Eletronico[MAX_ELETRONICOS];
    private Venda[] vendas = new Venda[MAX_VENDAS];

    private int numImpressos = 0;
    private int numEletronicos = 0;
    private int numVendas = 0;

    private Connection connection;

    public LivrariaVirtual() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/livraria",
                    "postgres", "postgres");
            criarTabelas();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void criarTabelas() {
        try (Statement stmt = connection.createStatement()) {
            String createLivroTable = "CREATE TABLE IF NOT EXISTS livro (" +
                    "id SERIAL PRIMARY KEY, " +
                    "titulo VARCHAR(255), " +
                    "autores VARCHAR(255), " +
                    "editora VARCHAR(255), " +
                    "preco DOUBLE PRECISION, " +
                    "tipo VARCHAR(50))";

            String createImpressoTable = "CREATE TABLE IF NOT EXISTS impresso (" +
                    "livro_id INTEGER PRIMARY KEY REFERENCES livro(id), " +
                    "frete DOUBLE PRECISION, " +
                    "estoque INTEGER)";

            String createEletronicoTable = "CREATE TABLE IF NOT EXISTS eletronico (" +
                    "livro_id INTEGER PRIMARY KEY REFERENCES livro(id), " +
                    "tamanho INTEGER)";

            String createVendaTable = "CREATE TABLE IF NOT EXISTS venda (" +
                    "id SERIAL PRIMARY KEY, " +
                    "cliente VARCHAR(255), " +
                    "valor DOUBLE PRECISION, " +
                    "livros TEXT)";

            stmt.execute(createLivroTable);
            stmt.execute(createImpressoTable);
            stmt.execute(createEletronicoTable);
            stmt.execute(createVendaTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipo de livro (Impresso/Eletronico): ");
        String tipo = scanner.nextLine();

        System.out.println("Título: ");
        String titulo = scanner.nextLine();
        System.out.println("Autores: ");
        String autores = scanner.nextLine();
        System.out.println("Editora: ");
        String editora = scanner.nextLine();
        System.out.println("Preço: ");
        double preco = scanner.nextDouble();

        if (tipo.equalsIgnoreCase("Impresso")) {
            System.out.println("Frete: ");
            double frete = scanner.nextDouble();
            System.out.println("Estoque: ");
            int estoque = scanner.nextInt();
            Impresso impresso = new Impresso(titulo, autores, editora, preco, frete, estoque);
            impressos[numImpressos++] = impresso;
            cadastrarLivroNoBanco(impresso, "Impresso");
        } else if (tipo.equalsIgnoreCase("Eletronico")) {
            System.out.println("Tamanho (KB): ");
            int tamanho = scanner.nextInt();
            Eletronico eletronico = new Eletronico(titulo, autores, editora, preco, tamanho);
            eletronicos[numEletronicos++] = eletronico;
            cadastrarLivroNoBanco(eletronico, "Eletronico");
        }
    }

    private void cadastrarLivroNoBanco(Livro livro, String tipo) {
        try {
            String query = "INSERT INTO livro (titulo, autores, editora, preco, tipo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutores());
            pstmt.setString(3, livro.getEditora());
            pstmt.setDouble(4, livro.getPreco());
            pstmt.setString(5, tipo);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int livroId = rs.getInt(1);
                if (tipo.equals("Impresso")) {
                    Impresso impresso = (Impresso) livro;
                    query = "INSERT INTO impresso (livro_id, frete, estoque) VALUES (?, ?, ?)";
                    pstmt = connection.prepareStatement(query);
                    pstmt.setInt(1, livroId);
                    pstmt.setDouble(2, impresso.getFrete());
                    pstmt.setInt(3, impresso.getEstoque());
                    pstmt.executeUpdate();
                } else if (tipo.equals("Eletronico")) {
                    Eletronico eletronico = (Eletronico) livro;
                    query = "INSERT INTO eletronico (livro_id, tamanho) VALUES (?, ?)";
                    pstmt = connection.prepareStatement(query);
                    pstmt.setInt(1, livroId);
                    pstmt.setInt(2, eletronico.getTamanho());
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void realizarVenda() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do cliente: ");
        String cliente = scanner.nextLine();

        Venda venda = new Venda(cliente);

        System.out.println("Quantidade de livros: ");
        int qtdLivros = scanner.nextInt();

        for (int i = 0; i < qtdLivros; i++) {
            System.out.println("Tipo de livro (Impresso/Eletronico): ");
            String tipo = scanner.next();
            scanner.nextLine();

            if (tipo.equalsIgnoreCase("Impresso")) {
                listarLivrosImpressos();
                System.out.println("Escolha o índice do livro: ");
                int index = scanner.nextInt();
                venda.addLivro(impressos[index]);
                impressos[index].atualizarEstoque();
            } else if (tipo.equalsIgnoreCase("Eletronico")) {
                listarLivrosEletronicos();
                System.out.println("Escolha o índice do livro: ");
                int index = scanner.nextInt();
                venda.addLivro(eletronicos[index]);
            }
        }

        vendas[numVendas++] = venda;
        salvarVendaNoBanco(venda);
    }

    private void salvarVendaNoBanco(Venda venda) {
        try {
            String query = "INSERT INTO venda (cliente, valor, livros) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, venda.getCliente());
            pstmt.setDouble(2, venda.getValor());

            StringBuilder livros = new StringBuilder();
            for (Livro livro : venda.getLivros()) {
                livros.append(livro.getTitulo()).append(", ");
            }
            pstmt.setString(3, livros.toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarLivrosImpressos() {
        for (int i = 0; i < numImpressos; i++) {
            System.out.println(i + ": " + impressos[i]);
        }
    }

    public void listarLivrosEletronicos() {
        for (int i = 0; i < numEletronicos; i++) {
            System.out.println(i + ": " + eletronicos[i]);
        }
    }

    public void listarLivros() {
        listarLivrosImpressos();
        listarLivrosEletronicos();
    }

    public void listarVendas() {
        for (int i = 0; i < numVendas; i++) {
            System.out.println(vendas[i]);
        }
    }

    public static void main(String[] args) {
        LivrariaVirtual livraria = new LivrariaVirtual();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Realizar uma venda");
            System.out.println("3. Listar livros");
            System.out.println("4. Listar vendas");
            System.out.println("5. Sair do programa");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

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
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}

