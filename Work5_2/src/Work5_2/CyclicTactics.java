package Work5_2;
/**
 * クラス名:CyclicTactics
 * 概要:ジャンケンの戦略を表す
 * @author 田中 沙樹
 * 作成日:2026.06.11
 */
public class CyclicTactics implements TacticsObject{
	//前回出した手を覚えておくための変数
	int lastTime = -1;
	/**
	 * 関数名:readTactics
	 * メソッドの説明:グー・チョキ・パーを交互に出す
	 * @return ジャンケンの手
	 * 作成日:2026.06.11
	 */
	public int readTactics() {
		//出す手を決める
		int handNumber = (lastTime + 1) % 3;
		//もし0なら
		if(handNumber == 0) {
			//グーを出す
			lastTime = PlayerObject.HAND_STONE;
			//もし1なら
		}else if(handNumber == 1) {
			//チョキを出す
			lastTime = PlayerObject.HAND_SCISSORS;
			//もし2なら
		}else if(handNumber == 2) {
			//パーを出す
			lastTime = PlayerObject.HAND_PAPER;
		}
		//出す手を返却
		return lastTime;
	}
}