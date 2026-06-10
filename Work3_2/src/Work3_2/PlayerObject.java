package Work3_2;
/**
 * クラス名:PlayerObject
 * 概要:ジャンケンプレイヤーを表す
 * @author 田中 沙樹
 * 作成日:2026.06.10
 */
public class PlayerObject {
	//ジャンケンの手を表す定数
	//グー
	final int HAND_STONE = 0;
	//チョキ
	final int HAND_SCISSORS = 1;
	//パー
	final int HAND_PAPER = 2;
	//-------------------------
	//プレイヤークラスの属性
	//-------------------------
	/** プレイヤーの名前 */
	private String playerName;
	/** プレイヤーの勝った回数 */
	private int winCount = 0;
	//-------------------------
	//プレイヤークラスの操作
	//-------------------------
	/**
	 * 関数名:showHand
	 * メソッドの説明:ジャンケンの手を出す
	 * @return ジャンケンの手
	 * 作成日:2026.06.10
	 */
	public int showHand() {
		//プレイヤーの手の変数を宣言
		int playerHand = 0;
		//0以上3未満の小数として乱数を得る
		double randomNumber = Math.random() * 3;
		//randomNumberが0.0以上1.0未満の場合、
		if(randomNumber < 1) {
			//グー
			playerHand = HAND_STONE;
			//randomNumberが1.0以上2.0未満の場合、
		}else if(randomNumber < 2) {
			//チョキ
			playerHand = HAND_SCISSORS;
			//randomNumberが2.0以上3.0未満の場合、
		}else if(randomNumber < 3) {
			//パー
			playerHand = HAND_PAPER;
		}
		//手の数字を返す
		return playerHand;
	}
	/**
	 * 関数名:notifyResult
	 * メソッドの説明:ジャンケンの手を出す
	 * @param trueが勝ち、falseが負け
	 * 作成日:2026.06.10
	 */
	public void notifyResult(boolean resultNumber) {
		//もし勝ったら
		if(resultNumber == true) {
			//名前を表示し、勝ちと表示
			System.out.println(playerName + "の勝ちです!");
			//カウントする
			winCount++;
		}
	}
	/**
	 * 関数名:getWinCount
	 * メソッドの説明:勝った回数を答える
	 * @return 勝った回数
	 * 作成日:2026.06.10
	 */
	public int getWinCount() {
		//勝った回数を返却
		return winCount;
	}
}