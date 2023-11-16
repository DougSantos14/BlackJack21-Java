package src.main.java.oo.models;

import src.main.java.oo.exceptions.ExcecaoDeEntradaInvalida;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {
    private static Jogo uniqueInstance; // padrão Singleton para Instância única do jogo
    private Baralho baralho;
    private Baralho descarte;
    private Jogador jogador1;
    private Jogador jogador2;
    private int vitoriasJogador1, vitoriasJogador2, empates;
    private Placar placar;
    private Scanner scan = new Scanner(System.in);

    private Jogo() {

        baralho = new Baralho(true);
        descarte = new Baralho();
        vitoriasJogador1 = 0;
        vitoriasJogador2 = 0;
        empates = 0;
        baralho.Embaralhar();

        System.out.println("........................................");
        System.out.println("|     Bem vindos ao BlackJack(21)      |");
        System.out.println("| Jogador(a) Nº1, digite seu nickname: |");
        System.out.println("|......................................|\n");
        String nomeJogador1 = scan.nextLine();
        while (nomeJogador1.trim().isEmpty()) {
            System.out.println("Nome em branco. Digite algo: \n");
            nomeJogador1 = scan.nextLine();
        }
        jogador1 = new Jogador(nomeJogador1);

        System.out.println("........................................");
        System.out.println("|                                      |");
        System.out.println("| Jogador(a) Nº2, digite seu nickname: |");
        System.out.println("|......................................|\n");
        String nomeJogador2 = scan.nextLine();
        while (nomeJogador2.trim().isEmpty()) {
            System.out.println("Nome em branco. Digite algo: \n");
            nomeJogador2 = scan.nextLine();
        }

        jogador2 = new Jogador(nomeJogador2);

        placar = new Placar(nomeJogador1, nomeJogador2);

        iniciarRodada();

    }

    public static Jogo getInstance() { // Singleton

        if (uniqueInstance == null) {
            uniqueInstance = new Jogo();
        }
        return uniqueInstance;

    }

    public void iniciarRodada() {

        if (vitoriasJogador1 > 0 || vitoriasJogador2 > 0 || empates > 0) {
            jogador1.getMao().devolverCartasProBaralho(descarte);
            jogador2.getMao().devolverCartasProBaralho(descarte);

        }

        if (baralho.cartasRestantes() < 4) {
            baralho.reporBaralhoUsandoDescartes(descarte);
        }

        jogador1.getMao().pegarCartaDoBaralho(baralho);
        jogador1.getMao().pegarCartaDoBaralho(baralho);

        jogador2.getMao().pegarCartaDoBaralho(baralho);
        jogador2.getMao().pegarCartaDoBaralho(baralho);

        System.out.println("................................................");
        System.out.println("|              Cartas Sorteadas!!!             |");
        jogador1.mostrarMao();
        jogador2.mostrarMao();

        if (jogador1.fezBlackJack()) {

            if (jogador2.fezBlackJack()) {
                System.out.println("Ambos fizeram BlackJack(21). Empate!");
                empates++;
                reiniciarRodada();
            } else {
                System.out.println("O Jogador(a) " + jogador1.getNome() + " venceu! Fazendo BlackJack!");
                vitoriasJogador1++;
                reiniciarRodada();
            }
        }
        if (jogador2.fezBlackJack()) {
            System.out.println("O Jogador(a) " + jogador2.getNome() + " venceu fazendo BlackJack!");
            vitoriasJogador2++;
            reiniciarRodada();
        }
        System.out.println("..........Vez do jogador(a) " + jogador1.getNome() + "..........");
        jogador1.Decidir(baralho, descarte);

        if (jogador1.getMao().calcularValor() > 21) {
            System.out.println(jogador1.getNome() + " ultrapassou 21. Vitoria de " + jogador2.getNome() + ".");
            vitoriasJogador2++;

            reiniciarRodada();

        }
        System.out.println("..........Vez do jogador(a) " + jogador2.getNome() + "..........");
        jogador2.mostrarMao();
        jogador2.Decidir(baralho, descarte);

        if (jogador2.getMao().calcularValor() > 21) {
            System.out.println(jogador2.getNome() + "ultrapassou 21. Vitoria de " + jogador1.getNome() + ".");

        } else if (jogador1.getMao().calcularValor() > jogador2.getMao().calcularValor()) {
            System.out.println("Jogador(a) " + jogador1.getNome() + " venceu a rodada.");
            vitoriasJogador1++;
        } else if (jogador2.getMao().calcularValor() > jogador1.getMao().calcularValor()) {
            System.out.println("Jogador(a) " + jogador2.getNome() + " venceu a rodada.");
            vitoriasJogador2++;

        } else {
            System.out.println("Empate.");
            empates++;
        }
        reiniciarRodada();
    }

    public void reiniciarRodada() {
        int escolha = 0;
        boolean lerNumero = true;

        while (lerNumero) {
            try {
                System.out.println("\nVoce deseja reiniciar o BlackJack? Aperte (1) caso sim ou (2) caso não.");
                escolha = scan.nextInt();
                scan.nextLine();

                if (escolha != 1 && escolha != 2) {
                    throw new ExcecaoDeEntradaInvalida("Erro. Entrada inválida, digite um número (1 ou 2).");
                }
                lerNumero = false;
            } catch (ExcecaoDeEntradaInvalida e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Erro. Entrada inválida, digite um número (1 ou 2).");
                scan.next();
            }
        }

        if (escolha == 1) {
            System.out.println("........................................");
            System.out.println("|                                      |");
            System.out.println("| Reiniciando o jogo, se prepare:      |");
            System.out.println("|......................................|\n");
            iniciarRodada();
        } else {
            System.out.println("........................................");
            System.out.println("|                                      |");
            System.out.println("|          Fechando o jogo :(          |");
            System.out.println("|......................................|\n");
            placar.exibirResultado(vitoriasJogador1, vitoriasJogador2, empates);
            scan.close();

            System.exit(0);
        }

    }

}
