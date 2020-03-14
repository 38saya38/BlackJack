package blackjack;

import java.util.Collections;
import java.util.List;

public class Deck {

	static int deckCount; //山札の進行状況を記録する変数deckCountを定義

	// 山札（deck）に値を入れ、シャッフルするメソッド
	public void shuffleDeck(List<Integer> deck) {
		// リストに1-52の連番を代入
		for (int i = 1; i <= 52; i++) {
			deck.add(i);
		}
		// 山札をシャッフル
		Collections.shuffle(deck);
	}

	//現在の合計ポイントを計算するメソッド
	public static int sumPoint(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum = sum + toPoint(toNumber(list.get(i)));
		}
		return sum;
	}

	//山札の数をカードの数に置き換えるメソッド
	private static int toNumber(int cardNumber) {
		int number = cardNumber % 13;
		if (number == 0) {
			number = 13;
		}

		return number;
	}

	//山札の通し番号を得点計算用のポイントに変換するメソッド J/Q/Kは10とする
	public static int toPoint(int num) {
		if (num == 11 || num == 12 || num == 13) {
			num = 10;
		}
		return num;

	}

	//山札の数を（スート）の（ランク）の文字列に置き換えるメソッド
	public static String toDescription(int cardNumber) {

		String rank = toRank(toNumber(cardNumber));
		String suit = toSuit(cardNumber);

		return suit + "の" + rank;

	}

	//カード番号をランクに変換するメソッド（A,J,Q,Kなど）
	private static String toRank(int number) {
		switch (number) {
		case 1:
			return "A";

		case 11:
			return "J";

		case 12:
			return "Q";

		case 13:
			return "K";

		default:
			String str = String.valueOf(number);
			return str;
		}

	}

	//山札の数をスートに置き換えるメソッド
	private static String toSuit(int cardNumber) {
		switch ((cardNumber - 1) / 13) {
		case 0:
			return "クラブ";

		case 1:
			return "ダイヤ";

		case 2:
			return "ハート";

		case 3:
			return "スペード";

		default:
			return "例外です";
		}
	}

	//手札がバーストしているか判定するメソッド
	public static boolean isBusted(int point) {
		if (point <= 21) {
			return false;
		} else {
			return true;
		}
	}

}
