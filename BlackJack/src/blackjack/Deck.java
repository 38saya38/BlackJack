package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
  private List<Card> cardList = new ArrayList<>(52);  //山札

  Deck() {
    for(int i=1; i<=52; i++) cardList.add(new Card(i));
    Collections.shuffle(cardList);
  }
  /**
   * 最初の一枚を取り出し, リストから削除
   * @return カード
   */
  Card pop() {
    return cardList.remove(0);
  }

  // シャッフルしたカードを表示
  void printAll() {
    for(Card i : cardList) {
      System.out.println(i);
    }
  }
}