package src.main.java.oo.models;

//enumeração dos valores das cartas.

public enum Valor {
   A(11), // o Ás pode valer 1 ou 11. Neste caso 11
   DOIS(2),
   TRES(3),
   QUATRO(4),
   CINCO(5),
   SEIS(6),
   SETE(7),
   OITO(8),
   NOVE(9),
   DEZ(10),
   J(10),
   Q(10),
   K(10);

   int valor;

   Valor(int valor) {
      this.valor = valor;

   }

   public String toString() {
      return String.valueOf(valor);
   }

}
