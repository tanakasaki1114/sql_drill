package OldMaid;
import TrumpPackage.CardObject;
import TrumpPackage.HandObject;
import TrumpPackage.MasterObject;
/**
 * クラス名:OldMaid
 * 概要:ババ抜き
 * @author 田中 沙樹
 * 作成日:2026.06.16
 */
public class OldMaid {
	/**
	 * 関数名:main
	 * メソッドの説明:メイン処理を行う
	 * 作成日:2026.06.16
	 */
	public static void main(String args[]) {
		//進行役の生成
		MasterObject masterObject = new MasterObject();
		//テーブルの生成
		OldTable tableObject = new OldTable();
		//ルールの生成
		OldRules relesObject = new OldRules();
		//村田プレイヤーの生成
		OldPlayer murataObject = new OldPlayer("村田",tableObject,masterObject,relesObject);
		//山田プレイヤーの生成
		OldPlayer yamadaObject = new OldPlayer("山田",tableObject,masterObject,relesObject);
		//斎藤プレイヤーの生成
		OldPlayer saitouObject = new OldPlayer("斎藤",tableObject,masterObject,relesObject);
		//村田プレイヤーの登録
		MasterObject.registerPlayer(murataObject);
		//山田プレイヤーの登録
		MasterObject.registerPlayer(yamadaObject);
		//斎藤プレイヤーの登録
		MasterObject.registerPlayer(saitouObject);
		//トランプの生成
		HandObject trumpObject = createTrump();
		//ゲームの準備をする
		masterObject.prepareGame(trumpObject);
		//ゲームを開始する
		masterObject.startGame();
	}
	/**
	 * 関数名:HandObject
	 * メソッドの説明:52枚のトランプを生成
	 * @return trumpObject トランプを格納したDeal
	 * 作成日:2026.06.16
	 */
	private static HandObject createTrump() {
		//各ソート52枚のカードを生成
		HandObject trumpObject = new HandObject();
		//繰り返す
		for(int cardNumber = 1;cardNumber <= CardObject.CARD_NUMBER;cardNumber++) {
			//カードを生成し、追加する
			trumpObject.addCard(new CardObject(CardObject.SUIT_CLUB,cardNumber));
			//カードを生成し、追加する
			trumpObject.addCard(new CardObject(CardObject.SUIT_DIAMOND,cardNumber));
			//カードを生成し、追加する
			trumpObject.addCard(new CardObject(CardObject.SUIT_HEART,cardNumber));
			//カードを生成し、追加する
			trumpObject.addCard(new CardObject(CardObject.SUIT_SPADE,cardNumber));
		}
		//カードの返却
		return trumpObject;
	}
}