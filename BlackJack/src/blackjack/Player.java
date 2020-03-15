package blackjack;

public class Player extends Deck {

	private static int playerHands; //プレイヤーの手札枚数を記録する変数playerHandsを定義

	public static int getPlayerHands() {
		return playerHands;
	}

	public static void setPlayerHands(int playerHands) {
		Player.playerHands = playerHands;

		for(int i = 0; i <5; i++) {

		}
	}

}
