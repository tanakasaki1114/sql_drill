package FantanPackage;

import TrumpPackage.CardObject;
import TrumpPackage.HandObject;
import TrumpPackage.MasterObject;
import TrumpPackage.PlayerObject;
import TrumpPackage.RulesObject;
import TrumpPackage.TableObject;
/**
 * クラス名:FantanPlayer
 * 概要:7並べのプレイヤー役を表す
 * @author 田中 沙樹
 * 作成日:2026.06.15
 */
public class FantanPlayer extends PlayerObject{
	//パスの回数を初期化
	private int passNumber;
	/**
	 * コントラクタ名:FantanPlayer
	 * コントラクタの説明:名前、テーブル、進行役、ルールを初期化
	 * @param nameObject 名前、tableNumber テーブル、masterObject 進行役、rules ルール
	 * 作成日:2026.06.15
	 */
	public FantanPlayer(String nameObject, TableObject tableNumber, FantanMaster masterObject,
			RulesObject rulesObject) {
		//親クラスから呼ぶ
		super(nameObject, tableNumber, masterObject, rulesObject);
	}
	/**
	 * 関数名:playerObject
	 * メソッドの説明:順番を指名する
	 * @param nextPlayerObject 次のプレイヤー
	 * 作成日:2026.06.15
	 */
	//オーバーライド
	@Override
	public void playerObject(PlayerObject nextPlayerObject) {
		//テーブルに出せるカードを探す
		CardObject[] candidateObject = rulesObject.findCandidate(myHand,tableNumber);
		//候補がある場合は
		if(candidateObject != null) {
			//「置きました。」と表示
			System.out.println("置きました。");
			//テーブルに出す
			tableNumber.putCard(candidateObject);
		}
		//手札がなくなったら
		if(myHand.getNumberOfCards() == 0){
			//上がりを宣言する
			MasterObject.declareWin(this);
			//テーブルに出せなかったら
		}else(passNumber > FantanMaster.PASS_LIMIT) {
			//パスの回数を数える
			passNumber++;
			//パスをする
			FantanMaster.passObject(this);
			//パス回数が制限回数以上ならば
			if(passNumber > FantanMaster.PASS_LIMIT) {
				//カードの情報を得る
				int numberOfHand = myHand.getNumberOfCards();
				//繰り返す
				for(int countNumber = 0;countNumber < numberOfHand;countNumber++) {
					//手札を全てテーブルに置く
					tableNumber.putCard(new CardObject[]){
						myHand.pickCard(countNumber0);
					}
				}
			}
		}
	}
	/**
	 * 関数名:receiveCard
	 * メソッドの説明:カードを配る
	 * @param cardObject 受け取ったカード
	 * 作成日:2026.06.15
	 */
	public void receiveCard(CardObject cardObject) {
		//カードの情報を得る
		int receiveCard = cardObject.getNumber();
		//7を定数化
		public static final int FIRST_CARD = 7;
		//もし7なら
		if(receiveCard == FIRST_CARD) {
			//7を置いた案内
			System.out.println("7を置きました。");
			//テーブルにカードを置く
			tableNumber.putCard(new CardObject[] {
					cardObject
			});
			//その他の場合
		}else {
			//手札に加える
			super.receiveCard(cardObject);
		}
	}
	/**
	 * 関数名:getPass
	 * メソッドの説明:パスの回数を数える
	 * 作成日:2026.06.15
	 */
	public int getPass() {
		//パスの回数
		return passNumber;
	}
}