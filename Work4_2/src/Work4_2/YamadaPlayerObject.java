package Work4_2;
/**
 * クラス名:YamadaPlayerObject
 * 概要:ジャンケンプレイヤーを表す
 * @author 田中 沙樹
 * 作成日:2026.06.10
 */
public class YamadaPlayerObject extends PlayerObject{
	/**
	 * コンストラクタ名:YamadaPlayerObject
	 * コンストラクタの説明:プレイヤーの名前を初期化
	 * @param プレイヤーの名前
	 * 作成日:2026.06.11
	 */
	public YamadaPlayerObject(String playerName) {
		//スーパークラスのコンストラクタを呼び出す
		super(playerName);
	}
	/**
	 * 関数名:showHand
	 * メソッドの説明:必ずパーを出す
	 * @return パー
	 * 作成日:2026.06.11
	 */
	public int showHand() {
		//パーを返す
		return HAND_PAPER;
	}
}