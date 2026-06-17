package OldMaid;

import TrumpPackage.CardObject;
import TrumpPackage.HandObject;
import TrumpPackage.MasterObject;
import TrumpPackage.PlayerObject;
/**
 * クラス名:OldPlayer
 * 概要:ババ抜きのプレイヤー
 * @author 田中 沙樹
 * 作成日:2026.06.16
 */
public class OldPlayer extends PlayerObject{
	/**
	 * コントラクタ名:PlayerObject
	 * コントラクタの説明:名前、テーブル、進行役、ルールを初期化
	 * @param nameObject 名前、tableNumber テーブル、masterObject 進行役、rulesObject ルール
	 * 作成日:2026.06.15
	 */
	public OldPlayer(String nameObject, OldTable tableNumber, MasterObject masterObject, OldRules rulesObject) {
		//親クラスから呼ぶ
		super(nameObject, tableNumber, masterObject, rulesObject);
	}
	/**
	 * 関数名:playerObject
	 * メソッドの説明:順番を指名する
	 * @param 次のプレイヤー
	 * 作成日:2026.06.16
	 */
	@Override
	public void playerObject(PlayerObject nextPlayerObject) {
		//次のプレイヤーに手札を出してもらう
		HandObject nextHand = nextPlayerObject.showHand();
		//相手の手札からカードを一枚引く
		CardObject pickedCard = nextHand.pickCard();
		//引いた結果を表示
		System.out.println(this + "：" + nextPlayerObject + "さんから" + pickedCard + "を引きました。");
		//引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(pickedCard);
		//手札がゼロになったかどうか調べる
		if(myHand.getNumberOfCards() == 0) {
			//進行役に上がりを宣言する
			masterObject.declareWin(this);
			//そのほかの場合
		}else {
			//現在の手札の表示
			System.out.println(this + "：残りの手札は" + myHand + "です。");
		}	
	}
	/**
	 * 関数名:dealCard
	 * メソッドの説明:カードを自分の手札に加え、同じカードの数があったら捨てる
	 * @param カード
	 * 作成日:2026.06.16
	 */
	private void dealCard(CardObject cardObject) {
		//カードを追加する
		myHand.addCard(cardObject);
		//今加えたカードと同じカードを探す
		CardObject[] sameCards = myHand.findSameNumberCard();
		//同じカードの組み合わせが存在した場合
		if(sameCards != null) {
			//表示
			System.out.print(this + "：");
			//テーブルへカードを捨てる
			tableNumber.disposeCard(sameCards);
		}
	}
	/**
	 * 関数名:showHand
	 * メソッドの説明:手札を見せる
	 * @return 自分の手札
	 * 作成日:2026.06.16
	 */
	public HandObject showHand() {
		//もしこの時点で手札が残り一枚なら
		if(myHand.getNumberOfCards() == 1) {
			//上がりとなる
			masterObject.declareWin(this);
		}
		//シャッフルする
		myHand.shuffleCard();
		//自分の手札を見せる
		return myHand;
	}
	/**
	 * 関数名:receiveCard
	 * メソッドの説明:カードを受け取る
	 * @param 受け取ったカード
	 * 作成日:2026.06.16
	 */
	public void receiveCard(CardObject cardObject) {
		//引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(cardObject);
	}
}