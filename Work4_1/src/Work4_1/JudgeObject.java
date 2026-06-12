package Work4_1;
/**
 * クラス名:JudgeObject
 * 概要:ジャンケンの審判を表す
 * @author 田中 沙樹
 * 作成日:2026.06.11
 */
public class JudgeObject {
	/**
	 * 関数名:startJanken
	 * メソッドの説明:ジャンケンを開始
	 * @param playerOne 判定対象プレイヤー1
	 * @param playerTwo 判定対象プレイヤー2
	 * 作成日:2026.06.11
	 */
	public void startJanken(PlayerObject playerOne,PlayerObject playerTwo){
		//「ジャンケン開始」の案内
		System.out.println("【ジャンケン開始】\n");
		//3回まで繰り返す
		for(int countNumber = 0; countNumber < 3;countNumber++) {
			//何回戦目かを案内
			System.out.println("【"+(countNumber + 1)+"回戦目】");
			//プレイヤーの手を見てどちらが勝ちか判断する
			PlayerObject winnerMan = judgeJanken(playerOne,playerTwo);
			//もし、NULLでなかったら
			if(winnerMan != null) {
				//勝者を表氏
				System.out.println("\n" + winnerMan.getName() + "が勝ちました！\n");
				//勝ったプレイヤーに結果を伝える
				winnerMan.notifyResult(true);
				//引き分けの場合
			}else {
				//引き分けであることを表示
				System.out.println("\n引き分けです！\n");
			}
		}
		//「ジャンケン終了」を案内
		System.out.println("【ジャンケン終了】\n");
		//最終的な勝者を判定する
		PlayerObject fianlWinner = judgeFinalWinner(playerOne,playerTwo);
		//結果の表示
		System.out.print(playerOne.getWinCount()+ "対" + playerTwo.getWinCount() + "で");
		//NULLでなければ
		if(finalWinner != null) {
			//勝者の表示
			System.out.println(finalWinner.getName() + "の勝ちです！\n");
			//引き分けの場合
		}else {
			//引き分けであることを表示
			System.out.println("引き分けです！");
		}
	}
	/**
	 * 関数名:judgeJanken
	 * メソッドの説明:勝者の判定
	 * @param playerOne 判定対象プレイヤー1
	 * @param playerTwo 判定対象プレイヤー2
	 * @return 勝者
	 * 作成日:2026.06.11
	 */
	private PlayerObject judgeJanken(PlayerObject player1, PlayerObject player2) {
		//変数の宣言
		PlayerObject winnerMan = null; 
		//プレイヤー1の手を出す
		int player1hand = player1.showHand();
		//プレイヤー2の手を出す
		int player2hand = player2.showHand();
		//プレイヤー1の手を表示
		printHand(player1hand);
		//「vs.」と表示
		System.out.print("vs.");
		//プレイヤー2の手を表示
		printHand(player2hand);
		//改行
		System.out.print("\n");
		// player1 が勝ったら
		if((player1hand == PlayerObject.HAND_STONE && player2hand == PlayerObject.HAND_SCISSORS) ||
				(player1hand == PlayerObject.HAND_SCISSORS && player2hand == PlayerObject.HAND_PAPER)||
				(player1hand == PlayerObject.HAND_PAPER && player2hand == PlayerObject.HAND_STONE)) {
			//勝者をプレイヤー1にする
			winnerMan = player1;

			// player2 が勝ったら
		} else if((player1hand == PlayerObject.HAND_STONE && player2hand == PlayerObject.HAND_PAPER) ||
				(player1hand == PlayerObject.HAND_SCISSORS && player2hand == PlayerObject.HAND_STONE)||
				(player1hand == PlayerObject.HAND_PAPER && player2hand == PlayerObject.HAND_SCISSORS)) {
			//勝者をプレイヤー2にする
			winnerMan = player2;
		}
		//勝者を返す
		return winnerMan;
	}
	/**
	 * 関数名:judgeFinalWinner
	 * メソッドの説明:最終的な勝者の判定
	 * @param playerOne 判定対象プレイヤー1
	 * @param playerTwo 判定対象プレイヤー2
	 * @return 勝者
	 * 作成日:2026.06.11
	 */
	private PlayerObject judgeFinalWinner(PlayerObject player1,PlayerObject player2) {
		//変数を宣言
		PlayerObject winnerMan = null;
		//プレイヤー1から勝ち数を聞く
		int player1Wincount = player1.getWinCount();
		//プレイヤー2から勝ち数を聞く
		int player2Wincount = player2.getWinCount();
		//プレイヤー1のほうが勝ち数が大きい場合
		if(player1Wincount > player2Wincount) {
			//勝者をプレイヤー1にする
			winnerMan = player1;
			//プレイヤー2のほうが勝ち数が大きい場合
		}else if(player1Wincount < player2Wincount) {
			//勝者をプレイヤー2にする
			winnerMan = player2;
		}
		//勝者を返す
		return winnerMan;
	}
	/**
	 * 関数名:printHand
	 * メソッドの説明:ジャンケンの手を表示する
	 * @param handNumber ジャンケンの手
	 * 作成日:2026.06.11
	 */
	private void printHand(int handNumber) {
		//手の数字を入れる
		switch(handNumber) {
		//0.0以上1.0未満の場合
		case PlayerObject.HAND_STONE:
			//「グー」を表示
			System.out.print("グー");
			//抜ける
			break;
			//1.0以上2.0未満の場合
		case PlayerObject.HAND_SCISSORS:
			//「チョキ」を表示
			System.out.print("チョキ");
			//抜ける
			break;
			//2.0以上3.0未満の場合
		case PlayerObject.HAND_PAPER:
			//「パー」を表示
			System.out.print("パー");
			//抜ける
			break;	
			//nullの場合
		default :
			//抜ける
			break;
		}
	}
}