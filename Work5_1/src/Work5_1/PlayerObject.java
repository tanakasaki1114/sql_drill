package Work5_1;
/**
 * クラス名:PlayerObject
 * 概要:ジャンケンプレイヤーを表す
 * @author 田中 沙樹
 * 作成日:2026.06.10
 */
public class PlayerObject {
	//ジャンケンの手を表す定数
	//グー
	final static int HAND_STONE = 0;
	//チョキ
	final static int HAND_SCISSORS = 1;
	//パー
	final static int HAND_PAPER = 2;
	//-------------------------
	//プレイヤークラスの属性
	//-------------------------
	/** プレイヤーの名前 */
	private String playerName;
	/** プレイヤーの勝った回数 */
	private int winCount = 0;
	//与えられた戦略
	private TacticsObject tacticsfight;
	//-------------------------
	//プレイヤークラスの操作
	//-------------------------
	/**
	 * コンストラクタ名:PlayerObject
	 * コンストラクタの説明:プレイヤーの名前を初期化
	 * @param プレイヤーの名前
	 * 作成日:2026.06.10
	 */
	public PlayerObject(String playerName) {
		//名前を初期化
		this.playerName = playerName;
	}
	/**
	 * 関数名:showHand
	 * メソッドの説明:ジャンケンの手を出す
	 * @return ジャンケンの手
	 * 作成日:2026.06.10
	 */
	public int showHand() {
		//与えられた戦力を読んでジャンケンの手を決める
		int playerHand = tacticsfight.readTactics();
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
			//カウントする
			winCount++;
		}
	}
	/**
	 * 関数名:getName
	 * メソッドの説明:プレイヤーの名前を答える
	 * @return プレイヤーの名前
	 * 作成日:2026.06.10
	 */
	public String getName() {
		//プレイヤーの名前を返却
		return playerName;
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
	/**
	 * 関数名:setTactics
	 * メソッドの説明:プレイヤーに戦略を渡す
	 * @param 戦略
	 * 作成日:2026.06.11
	 */
	public void setTactics(TacticsObject tacticsWord) {
		//戦略を読む
		tacticsfight = tacticsWord;
	}
}