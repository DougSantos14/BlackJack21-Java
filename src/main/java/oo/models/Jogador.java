package src.main.java.oo.models;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.main.java.oo.exceptions.ExcecaoDeEntradaInvalida;

public class Jogador {
    private Mao mao;
    private String nome;
    Scanner scan = new Scanner(System.in);

    public Jogador(String nome) {
        this.mao = new Mao();
        this.nome = nome;

    }

    public Mao getMao() {
        return this.mao;
    }

    public String getNome() {
        return this.nome;
    }

    // Decidir se o jogador vai pedir outra carta ou manter as que tem
    public void Escolher(Baralho baralho, Baralho descarte) {
        int opcao = 0;
        boolean lerNumero = true;

        while (lerNumero) {
            try {
                System.out.println("Aperte (1) para Pedir cartas ou (2) para Manter.");
                opcao = scan.nextInt();

                switch (opcao) {
                    case 1:
                        this.Pedir(baralho, descarte);
                        if (this.getMao().calcularValor() > 20) {
                            return;
                        } else {
                            this.Escolher(baralho, descarte);
                        }
                        break;
                    case 2:
                        System.out.println(this.getNome() + " mantém suas cartas.");
                        System.out.println("");
                        break;
                    default:
                        throw new ExcecaoDeEntradaInvalida("Erro. Entrada inválida, digite um número (1 ou 2)..");
                }
                lerNumero = false;
            } catch (ExcecaoDeEntradaInvalida e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro. Entrada inválida, digite um número (1 ou 2).");
                scan.next();
            }
        }
    }

    public boolean fezBlackJack() {
        if (this.getMao().calcularValor() == 21) {
            return true;
        } else {
            return false;
        }

    }

    public void mostrarMao() {

        System.out.println("\nAs cartas na mão de " + this.nome + " são: ");
        System.out.println(
                this.mao + "O valor total que " + this.nome + " possui  é: " + this.mao.calcularValor() + "\n");
        System.out.println("");

    }

    public void Pedir(Baralho baralho, Baralho descarte) {
        if (!baralho.temCartas()) {
            baralho.reporBaralhoUsandoDescartes(descarte);
        }
        this.mao.pegarCartaDoBaralho(baralho);
        System.out.println(this.nome + " pediu uma carta.");
        System.out.println("");
        this.mostrarMao();
    }

    public String toString() {
        return this.nome;
    }

    public void fecharScanner() {
        scan.close();
    }

}
