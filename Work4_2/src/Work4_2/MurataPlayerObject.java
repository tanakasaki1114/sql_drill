package Work4_2;
/**
 * クラス名:MurataPlayerObject
 * 概要:ジャンケンプレイヤーを表す
 * @author 田中 沙樹
 * 作成日:2026.06.10
 */
public class MurataPlayerObject extends PlayerObject{
	/**
	 * コンストラクタ名:MurataPlayerObject
	 * コンストラクタの説明:プレイヤーの名前を初期化
	 * @param プレイヤーの名前
	 * 作成日:2026.06.11
	 */
	public MurataPlayerObject(String playerName) {
		//スーパークラスのコンストラクタを呼び出す
		super(playerName);
	}
	/**
	 * 関数名:showHand
	 * メソッドの説明:必ずグーを出す
	 * @return グー
	 * 作成日:2026.06.10
	 */
	public int showHand() {
		//グーを返す
		return HAND_STONE;
	}
}