package HerancaEPolimorfismo_exe02;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cachorro:");
        Cachorro cachorro = new Cachorro();
        cachorro.nome = "Bob";
        System.out.println("Nome: " + cachorro.nome);

        cachorro.tipo = "Beagle";
        System.out.println("Tipo: " + cachorro.tipo);

        cachorro.idade = 2;
        System.out.println("Idade: " + cachorro.idade);

        cachorro.habitat = "terrestre";
        System.out.println("Habitat: " + cachorro.habitat);

        cachorro.quantidadeDePatas = 4;
        System.out.println("Quantidade de patas: " + cachorro.quantidadeDePatas);

        cachorro.altura = 0.25F;
        System.out.println("Altura: " + cachorro.altura);

        cachorro.peso = 12.5F;
        System.out.println("Peso: " + cachorro.peso);

        cachorro.comer(0.5F);
        cachorro.andar();
        cachorro.morverse(30);
        cachorro.dormir(13);

        System.out.println("========================================");

        System.out.println("Gato:");
        Gato gato = new Gato();
        gato.nome = "felix";
        System.out.println("Nome: " + gato.nome);

        gato.tipo = "felino";
        System.out.println("Tipo: " + gato.tipo);

        gato.idade = 1;
        System.out.println("Idade: " + gato.idade);

        gato.habitat = "terrestre";
        System.out.println("Habitat: " + gato.habitat);

        gato.quantidadeDePatas = 4;
        System.out.println("Quantidade de patas: " + gato.quantidadeDePatas);

        gato.altura = 0.20F;
        System.out.println("Altura: " + gato.altura);

        gato.peso = 5.5F;
        System.out.println("Peso: " + gato.peso);

        gato.andar();
        gato.morverse(30);
        gato.comer(0.2F);
        gato.dormir(15);

        System.out.println("========================================");
        System.out.println("Elefante:");
        Elefante elefante = new Elefante();

        elefante.tipo = "Asiático";
        System.out.println("Tipo: " + elefante.tipo);

        elefante.idade = 19;
        System.out.println("Idade: " + elefante.idade);

        elefante.habitat = "terrestre";
        System.out.println("Habitat: " + elefante.habitat);

        elefante.quantidadeDePatas = 4;
        System.out.println("Quantidade de patas: " + elefante.quantidadeDePatas);

        elefante.altura = 3F;
        System.out.println("Altura: " + elefante.altura);

        elefante.peso = 4000F;
        System.out.println("Peso: " + elefante.peso);

        elefante.andar();
        elefante.morverse(300);
        elefante.comer(80);
        elefante.dormir(2);

        System.out.println("========================================");
        System.out.println("Leão:");
        Leao leao = new Leao();

        leao.tipo = "Leão africano";
        System.out.println("Tipo: " + leao.tipo);

        leao.idade = 4;
        System.out.println("Idade: " + leao.idade);

        leao.habitat = "terrestre";
        System.out.println("Habitat: " + leao.habitat);

        leao.quantidadeDePatas = 4;
        System.out.println("Quantidade de patas: " + leao.quantidadeDePatas);

        leao.altura = 1.2F;
        System.out.println("Altura: " + leao.altura);

        leao.peso = 190F;
        System.out.println("Peso: " + leao.peso);

        leao.andar();
        leao.morverse(300);
        leao.comer(7);
        leao.dormir(10);

        System.out.println("========================================");
        System.out.println("Pombo:");
        Pombo pombo = new Pombo();

        pombo.tipo = "ave";
        System.out.println("Tipo: " + pombo.tipo);

        pombo.idade = 1;
        System.out.println("Idade: " + pombo.idade);

        pombo.habitat = "terrestre";
        System.out.println("Habitat: " + pombo.habitat);

        pombo.quantidadeDePatas = 2;
        System.out.println("Quantidade de patas: " + pombo.quantidadeDePatas);

        pombo.envergaduraAsa = 0.65F;
        System.out.println("Envergadura das asas: " + pombo.envergaduraAsa);

        pombo.altura = 0.3F;
        System.out.println("Altura: " + pombo.altura);

        pombo.peso = 0.325F;
        System.out.println("Peso: " + pombo.peso);

        pombo.voar();
        pombo.morverse(1);
        pombo.comer(0.3F);
        pombo.dormir(18);

        System.out.println("========================================");
        System.out.println("Peixe");
        Peixe peixe = new Peixe();

        peixe.tipo = "Sardinha";
        System.out.println("Tipo de peixe: " + peixe.tipo);

        peixe.idade = 2;
        System.out.println("Idade: " + peixe.idade);

        peixe.habitat = "aquatico";
        System.out.println("Habitat: " + peixe.habitat);

        peixe.peso = 0.115F;
        System.out.println("Peso: " + peixe.peso);

        peixe.nadar();
        peixe.morverse(250);
        peixe.comer(.1F);
        peixe.dormir(3);
    }
}
