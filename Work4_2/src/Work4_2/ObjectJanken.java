package Work4_2;
/**
 * クラス名:ObjectJanken
 * 概要:オブジェクト指向によるジャンケンプログラム
 * @author 田中 沙樹
 * 作成日:2026.06.11
 */
public class ObjectJanken {
	/**
	 * 関数名:main
	 * メソッドの説明:メインの処理
	 * 作成日:2026.06.11
	 */
	public static void main(String[] args) {
		//審判のインスタンスの生成
		JudgeObject msSaito = new JudgeObject();
		//村田さんのインスタンスの生成
		PlayerObject msMurata = new MurataPlayerObject("村田さん");
		//山田さんのインスタンスの生成
		PlayerObject msYamada = new YamadaPlayerObject("山田さん");
		//ジャンケンを開始する
		msSaito.startJanken(msMurata,msYamada);
	}
}