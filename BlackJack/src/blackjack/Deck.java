package blackjack;

import java.util.Collections;
import java.util.List;

public class Deck {
	
	
	// 山札（deck）に値を入れ、シャッフルするメソッド
	public void shuffleDeck(List<Integer> deck) {
		// リストに1-52の連番を代入
		for (int i = 1; i <= 52; i++) {
			deck.add(i);
		}
		// 山札をシャッフル
		Collections.shuffle(deck);
	}
}
