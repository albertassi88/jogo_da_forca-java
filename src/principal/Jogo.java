package principal;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Jogo da Forca! Tente descobrir a palavra, você tem apenas 6 chances.");
		System.out.println();
		System.out.print("Jogador 1 - Digite uma palavra: ");
		String palavra = sc.nextLine();
		while (palavra.matches("[0-9]*|\\s*")) {
			System.out.println("Palavra inválida! digite só letras.");
			palavra = sc.nextLine();
		}

		String vetor[] = new String[palavra.length()];
		int acertou = 0;
		int errou = 1;
		while ((acertou != palavra.length()) & (errou != 7)) {
			System.out.print("Jogador 2 - Tente descobrir a palavra! digite uma letra: ");
			String letra = sc.nextLine();
			while ((letra.length() > 1) | (letra.matches("[0-9]*|\\s*"))) {
				System.out.println("Letra inválida! digite só uma letra.");
				letra = sc.nextLine();
			}

			System.out.println("");
			int retorno = 0;
			if (palavra.contains(letra)) {
				retorno = palavra.indexOf(letra);
				vetor[retorno] = letra;
				acertou++;
				System.out.println("Parabéns! você acertou a letra.");
			} else {
				System.out.println("Essa letra não esta na palavra!" + " você errou " + errou + " vez(es).");
				errou++;
			}

			for (int x = 0; x < palavra.length(); x++) {
				if (vetor[x] == null) {
					vetor[x] = ".";
				}
				System.out.println(vetor[x]);
			}
		}
		if (acertou == palavra.length()) {
			System.out.println("Parabéns! Você acertou a palavra.");
		} else {
			System.out.println("Jogador 2 - Você Perdeu!");
		}
		sc.close();
	}
}
