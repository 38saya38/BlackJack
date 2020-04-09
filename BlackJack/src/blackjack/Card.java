package blackjack;

class Card {
  private static final String[] RANKS = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
  private static final String[] SUITS = {"クラブ","ダイヤ","ハート","スペード"};

  private int cardNumber; //1-52
  /**
   * @param cardNumber 1-52
   */
  Card(int cardNumber) {
    this.cardNumber = cardNumber;
  }
  /**
   * 得点計算用
   * @return 1-10
   */
  int getPoint() {
    return Math.min(getRankIndex() + 1, 10);
  }
  /**
   * @return 0-12
   */
  private int getRankIndex() {
    return (cardNumber - 1) % 13;
  }
  /**
   * @return 0-3
   */
  private int getSuitIndex() {
    return (cardNumber - 1) / 13;
  }

  public String toString() {
    return SUITS[getSuitIndex()] + "の" + RANKS[getRankIndex()];
  }
}