package blackjack;

import java.util.ArrayList;
import java.util.List;

/*カード枚数は52枚。ジョーカーは含めない。カードの重複が無いように山札を構築する。
プレイヤー、ディーラーの一対一で対戦するものとし、以下の挙動を取る
初期設定として、プレイヤー・ディーラーが交互に1枚ずつ山札からカードを取り手札とする。
プレイヤーからは自分の手札すべてと、ディーラーの1枚めの手札が確認できる。（ディーラーの2枚目移行の手札はわからない）

手札はAが1ポイント、2-10がそれぞれ2-10ポイント、J/Q/Kが10ポイントとして計算される。

プレイヤーは手札を1枚追加するか、しないかを選択できる。
手札を追加した場合、21ポイントを超えるとバーストとなり、ゲームに敗北する。
プレイヤーはバーストするか、好きなタイミングで止めるまで手札にカードを追加できる。
ディーラーは手札の合計ポイントが17以上になるまで山札を引き続ける。
ディーラーの手札が21ポイントを超えた場合、バーストしてプレイヤーの勝利。
ディーラーの手札が18以上21以下になったとき次の段階に移行する。

プレイヤー・ディーラーの手札のポイントを比較して、大きいほうが勝利。

ダブルダウン・スプリット・サレンダーなどの特殊ルールは無し。*/

public class MainGame {

	public static void main(String[] args) {
		System.out.println("ブラックジャックへようこそ！");

		List<Integer> deck = new ArrayList<Integer>();
		Deck deckInstance = new Deck(); //Deckクラスのインスタンスを生成

		deckInstance.shuffleDeck(deck); // インスタンス生成後，インスタンスフィールドを経由してメソッドを呼び出す

		// シャッフルしたカードを表示。デバック用
		//		for(Integer i : deck) {
		//	            System.out.println(i);
		//	        }

		List<Integer> player = new ArrayList<>(); //プレイヤーの手札リストを作成
		List<Integer> dealer = new ArrayList<>(); //ディーラーの手札リストを作成

		//プレイヤー・ディーラーがカードを2枚引く
		player.add(deck.get(0));
		dealer.add(deck.get(1));
		player.add(deck.get(2));
		dealer.add(deck.get(3));

		//プレイヤー・ディーラーの手札のポイントを表示
		System.out.println("貴方の1枚目のカードは"
				+ Deck.toDescription(player.get(0)));
		System.out.println("ディーラーの1枚目のカードは"
				+ Deck.toDescription(dealer.get(0)));
		System.out.println("貴方の2枚目のカードは"
				+ Deck.toDescription(player.get(1)));
		System.out.println("ディーラーの2枚めのカードは秘密です。");



	}

}
