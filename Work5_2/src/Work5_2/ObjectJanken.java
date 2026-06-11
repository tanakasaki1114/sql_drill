package Work5_2;
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
		PlayerObject msMurata = new PlayerObject("村田さん");
		TacticsObject msMurataTactics = new CyclicTactics();
		msMurata.setTactics(msMurataTactics);
		//山田さんのインスタンスの生成
		PlayerObject msYamada = new PlayerObject("山田さん");
		TacticsObject msYamadaTactics = new CyclicTactics();
		msYamada.setTactics(msMurataTactics);
		//ジャンケンを開始する
		msSaito.startJanken(msMurata,msYamada);
	}
}