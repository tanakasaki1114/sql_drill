package FantanPackage;

import TrumpPackage.CardObject;
import TrumpPackage.TableObject;
/**
 * クラス名:FantanTable
 * 概要:7並べのテーブルを表す
 * @author 田中 沙樹
 * 作成日:2026.06.15
 */
public class FantanTable implements TableObject{
	//カードを並べるテーブルを表す2次元配列
	private CardObject[][]tableArray = new CardObject[CardObject.SUIT_NUMBER][CardObject.CARD_NUMBER];
	/**
	 * 関数名:putCard
	 * メソッドの説明:カードを置く
	 * 作成日:2026.06.15
	 */
	//オーバーライド
	@Override
	public void putCard(CardObject[] cardNumber) {
		//要素を決定
		int cardNumber1 = cardNumber[0].getNumber();
		//要素を決定
		int suitNumber = cardNumber[0].getSuit();
		//テーブルにカードを置く
		tableArray[suitNumber - 1][cardNumber1 - 1] = cardNumber[0];
	}
	/**
	 * 関数名:getCards
	 * メソッドの説明:カードを見る
	 * @return テーブルに置かれたカードを表す配列
	 * 作成日:2026.06.15
	 */
	@Override
	public CardObject[][] getCards() {
		//テーブルを返す
		return tableArray;
	}
	/**
	 * 関数名:toString
	 * メソッドの説明:カードの文字列を返却
	 * @return カードの文字列
	 * 作成日:2026.06.15
	 */
	public String toString() {
		//文字列を生成するための変数を作成
		StringBuffer tableString = new StringBuffer(200);
		//繰り返す
		for(int suitNumber = 0; suitNumber < CardObject.SUIT_NUMBER; suitNumber++) {
			//繰り返す
			for(int cardNumber = 0; suitNumber < CardObject.CARD_NUMBER; cardNumber++) {
				//もし配列に値があったら
				if(tableArray[suitNumber][cardNumber] != null) {
					//最後に配列の値を付け加える
					tableString.append(tableArray[suitNumber][cardNumber]);
					//なかった場合
				}else {
					//「..」を表示
					tableString.append("..");
				}
				//空欄を表示
				tableString.append(" ");
			}
			//改行
			tableString.append("\n");
		}
		//文字列を返却
		return tableString.toString();
	}
}