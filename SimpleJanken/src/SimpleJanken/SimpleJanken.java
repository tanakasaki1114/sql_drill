package SimpleJanken;

import java.util.Random;
import java.util.Scanner;
/**
 * クラス名:SimpleJanken
 * 概要:オブジェクト指向を使用しないジャンケンのプログラム
 * @author 田中 沙樹
 * 作成日:2026.06.10
 */
public class SimpleJanken {
	/**
	 * 関数名:main
	 * メソッドの説明:メインの処理
	 * 作成日:2026.06.10
	 */
	public static void main(String[] args) {
		//キーボードから入力するための変数を作る
		Scanner standardInput = new Scanner(System.in);
		//乱数を生成するための変数を作る
		Random randomInput = new Random();
		//■■■■■■■■■■■■■■■■■■■
		//①プログラムが開始したことを表示する
		//■■■■■■■■■■■■■■■■■■■
		//プログラム開始メッセージを表示する
		System.out.println("【ジャンケン開始】\n");
		//ジャンケンの手を表す定数
		//グー
		final int HAND_STONE = 0;
		//チョキ
		final int HAND_SCISSORS = 1;
		//パー
		final int HAND_PAPER = 2;
		//乱数を格納するための変数
		double randomNumber = 0;
		//プレイヤー1の勝ち数
		int player1WinCount = 0;
		//プレイヤー2の勝ち数
		int player2WinCount = 0;
		//ジャンケンを3回実施する
		//■■■■■■■■■■■■■■■■■■■
		//⑥勝負した回数を加算する
		//⑦3回勝負が終わったか？
		//■■■■■■■■■■■■■■■■■■■
		//繰り返す
		for(int countNumber = 0; countNumber < 3;countNumber++) {
			//■■■■■■■■■■■■■■■■■■■
			//②プレイヤー1が何を出すのか決める
			//■■■■■■■■■■■■■■■■■■■
			int player1Hand = 0;
			//0以上3未満の小数として乱数を得る
			randomNumber = Math.random() * 3;
			//randomNumberが0.0以上1.0未満の場合、
			if(randomNumber < 1) {
				//グー
				player1Hand = HAND_STONE;
				//プレイヤー1の手を表示
				System.out.print("グー");
			}
			//randomNumberが1.0以上2.0未満の場合、
			else if(randomNumber < 2) {
				//チョキ
				player1Hand = HAND_SCISSORS;
				//プレイヤー1の手を表示
				System.out.print("チョキ");
			}
			//randomNumberが2.0以上3.0未満の場合、
			else if(randomNumber < 3) {
				//パー
				player1Hand = HAND_PAPER;
				//プレイヤー1の手を表示
				System.out.print("パー");
			}
			//■■■■■■■■■■■■■■■■■■■
			//③プレイヤー2が何を出すのか決める
			//■■■■■■■■■■■■■■■■■■■
			int player2Hand = 0;
			//0以上3未満の小数として乱数を得る
			randomNumber = Math.random() * 3;
			//randomNumberが0.0以上1.0未満の場合、
			if(randomNumber < 1) {
				//グー
				player1Hand = HAND_STONE;
				//プレイヤー2の手を表示
				System.out.print("グー");
			}
			//randomNumberが1.0以上2.0未満の場合、
			else if(randomNumber < 2) {
				//チョキ
				player1Hand = HAND_SCISSORS;
				//プレイヤー2の手を表示
				System.out.print("チョキ");
			}
			//randomNumberが2.0以上3.0未満の場合、
			else if(randomNumber < 3) {
				//パー
				player1Hand = HAND_PAPER;
				//プレイヤー2の手を表示
				System.out.print("パー");
			}
			//■■■■■■■■■■■■■■■■■■■■■
			//④どちらかが勝ちか判断し、結果を表示する
			//■■■■■■■■■■■■■■■■■■■■■
			//プレイヤー1が勝つ場合、
			if((player1Hand == HAND_STONE && player2Hand == HAND_SCISSORS)
					||(player1Hand == HAND_SCISSORS && player2Hand == HAND_PAPER)
					||(player1Hand == HAND_PAPER && player2Hand == HAND_STONE)) {
				//■■■■■■■■■■■■■■■■■■■■■
				//⑤プレイヤー1の勝った回数を加算する
				//■■■■■■■■■■■■■■■■■■■■■
				player1WinCount++;
				//ジャンケンの結果を表示する
				System.out.println("\nプレイヤー1が勝ちました！\n");
			}
			//プレイヤー2が勝つ場合、
			else if((player1Hand == HAND_STONE && player2Hand == HAND_PAPER)
					||(player1Hand == HAND_SCISSORS && player2Hand == HAND_STONE)
					||(player1Hand == HAND_PAPER && player2Hand == HAND_SCISSORS)) {
				//■■■■■■■■■■■■■■■■■■■■■
				//⑤プレイヤー2の勝った回数を加算する
				//■■■■■■■■■■■■■■■■■■■■■
				player2WinCount++;
				//ジャンケンの結果を表示する
				System.out.println("\nプレイヤー2が勝ちました！\n");
			}
		}
		//■■■■■■■■■■■■■■■■■■■
		//⑧最終的な勝者を判定し、画面に表示する
		//■■■■■■■■■■■■■■■■■■■
		//ジャンケン終了の案内
		System.out.println("【ジャンケン終了】\n");
		//プレイヤー1の勝ち数が多いとき
		if(player1WinCount > player2WinCount) {
			//プレイヤー1の勝ちを表示する
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー1の勝ちです！\n");
		}//プレイヤー2の勝ち数が多いとき
		else if(player1WinCount < player2WinCount) {
			//プレイヤー2の勝ちを表示する
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー2の勝ちです！\n");
		}//プレイヤー1とプレイヤー2の勝ち数が同じのとき
		else if(player1WinCount == player2WinCount) {
			//引き分けを表示する
			System.out.println(player1WinCount + "対" + player2WinCount + "で引き分けです！\n");
		}
	}
}