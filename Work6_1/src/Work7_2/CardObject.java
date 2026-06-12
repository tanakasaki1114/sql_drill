package Work7_2;
/**
 * クラス名:CardObject
 * 概要:トランプのカードを表す
 * @author 田中 沙樹
 * 作成日:2026.06.12
 */
public class CardObject {
	//ジョーカーを表す定数
	public static final int JOCKER_CARD = 0;
	//スペードを表す定数
	public static final int SUIT_SPADE = 1;
	//ダイヤを表す定数
	public static final int SUIT_DIAMOND = 2;
	//クラブを表す定数
	public static final int SUIT_CLUB = 3;
	//ハートを表す定数
	public static final int SUIT_HEART = 4;
	//カードの示すソート
	private int suitNumber = 0;
	//カードの示す数
	private int cardNumber = 0;
	/**
	 * コンストラクタ名:CardObject
	 * コンストラクタの説明:ソートと数を初期化
	 * @param suitNumber スート
	 * @param cardNumber 数
	 * 作成日:2026.06.12
	 */
	public CardObject(int suitNumber,int cardNumber) {
		//スートを初期化
		this.suitNumber = suitNumber;
		//数を初期化
		this.cardNumber = cardNumber;
	}
	/**
	 * 関数名:getNumber
	 * メソッドの説明:数字を見る
	 * @return 数
	 * 作成日:2026.06.12
	 */
	public int getNumber() {
		//数を返す
		return cardNumber;
	}
	/**
	 * 関数名:toString
	 * メソッドの説明:カードを文字列で表現
	 * @return カードの文字表現
	 * 作成日:2026.06.12
	 */
	public String toString() {
		//文字列を結合するための変数を作る
		StringBuffer string = new StringBuffer();
		//カードの数が0より大きいとき
		if(cardNumber > 0) {
			//ソートを見る
			switch(suitNumber) {
			//スペードのとき
			case SUIT_SPADE:
				//Sを後ろにつける
				string.append("S");
				//抜ける
				break;
				//ダイヤのとき
			case SUIT_DIAMOND:
				//Dを後ろにつける
				string.append("D");
				//抜ける
				break;
				//クラブのとき
			case SUIT_CLUB:
				//Cを後ろにつける
				string.append("C");
				//抜ける
				break;
				//ハートのとき
			case SUIT_HEART:
				//Hを後ろにつける
				string.append("H");
				//抜ける
				break;
				//ジョーカーのとき
			default:
				//抜ける
				break;
			}
			//カードの数を見る
			switch(cardNumber) {
			//1のとき
			case 1:
				//Aを後ろにつける
				string.append("A");
				//抜ける
				break;
				//10のとき
			case 10:
				//Tを後ろにつける
				string.append("T");
				//抜ける
				break;
				//11のとき
			case 11:
				//Jを後ろにつける
				string.append("J");
				//抜ける
				break;
				//12のとき
			case 12:
				//Qを後ろにつける
				string.append("Q");
				//抜ける
				break;
				//13のとき
			case 13:
				//Kを後ろにつける
				string.append("K");
				//抜ける
				break;
				//1～9のとき
			default:
				//抜ける
				break;
			}
		}
		//その他の場合
		else {
			//JKを後ろにつける
			string.append("JK");
		}
		//文字列を返す
		return string.toString();
	}
}