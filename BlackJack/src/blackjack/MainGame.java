package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

		List<Integer> deck = new ArrayList<Integer>(52);

		Deck.shuffleDeck(deck); // メソッドを呼び出す

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
		System.out.println("貴方の"
				+ Player.getPlayerHands() + "枚目のカードは"
				+ Deck.toDescription(player.get(0)));
		System.out.println("ディーラーの1枚目のカードは"
				+ Deck.toDescription(dealer.get(0)));
		System.out.println("貴方の"
				+ Player.getPlayerHands() + "枚目のカードは"
				+ Deck.toDescription(player.get(1)));
		System.out.println("ディーラーの2枚めのカードは秘密だよ");

		//プレイヤー、ディーラーのポイントを集計
		int playerPoint = Deck.sumPoint(player);
		int dealerPoint = Deck.sumPoint(dealer);

		System.out.println("あなたの現在のポイントは"
				+ playerPoint + "です");

		//プレイヤーがカードを引くフェーズ
		while (true) {
			System.out.println("カードを引きますか？ Yes:y or No:n");
			//キーボードの入力を受け付けて、変数strに代入する

			Scanner scan = new Scanner(System.in);
			String str = scan.next();

			if ("n".equals(str)) {
				break;
			} else if ("y".equals(str)) {
				//手札に山札から1枚加える
				player.add(deck.get(Deck.deckCount));

				//山札と手札を一枚進める
				Deck.deckCount++;
				Player.setPlayerHands(Player.getPlayerHands() + 1);

				System.out.println("あなたの"
						+ Player.getPlayerHands() + "枚目のカードは"
						+ Deck.toDescription(player.get(Player.getPlayerHands() - 1)));
				playerPoint = Deck.sumPoint(player);
				System.out.println("現在の合計は" + playerPoint);
				//プレイヤーのバーストチェック
				if (Deck.isBusted(playerPoint)) {
					System.out.println("残念、バーストしてしまいました。ディーラーの勝ちです。");
					return;
				}
			} else {
				System.out.println("あなたの入力は"
						+ str + "です。y か n を入力してください。");
			}
		}

		//ディーラーが手札を17以上にするまでカードを引くフェーズ
		while (true) {
			//手札が１７以上の場合ブレーク
			if (dealerPoint >= 17) {
				break;
			} else {
				//手札に山札から1枚加える
				dealer.add(deck.get(Deck.deckCount));
				//山札を1枚進める
				Deck.deckCount++;

				//ディーラーの合計ポイントを計算
				dealerPoint = Deck.sumPoint(dealer);
				//ディーラーのバーストチェック
				if (Deck.isBusted(dealerPoint)) {
					System.out.println("ディーラーがバーストしました。あなたの勝ちです！");
					return;

				}
			}
		}

		//ポイントを比較する
		System.out.println("あなたのポイントは" + playerPoint);
		System.out.println("ディーラーのポイントは" + dealerPoint);

		if (playerPoint == dealerPoint) {
			System.out.println("引き分けです。");
		} else if (playerPoint > dealerPoint) {
			System.out.println("勝ちました！");
		} else {
			System.out.println("負けました・・・");
		}

	}

}
