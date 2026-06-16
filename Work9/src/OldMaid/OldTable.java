package OldMaid;

import java.util.ArrayList;

import TrumpPackage.CardObject;
import TrumpPackage.TableObject;
/**
 * クラス名:OldTable
 * 概要:ババ抜きのテーブル役を表す
 * @author 田中 沙樹
 * 作成日:2026.06.15
 */
public class OldTable implements TableObject{
	//手札にあるカードを保持するためのリスト
	private static ArrayList disposedCards = new ArrayList();
	/**
	 * 関数名:putCard
	 * メソッドの説明:カードを捨てる
	 * @param cardObject 捨てるカードの配列
	 * 作成日:2026.06.15
	 */
	@Override
	public void putCard(CardObject[] cardNumber) {
		//繰り返す
		for(int indexNumber = 0;indexNumber < cardNumber.length;indexNumber++) {
			//捨てられたカードの表示
			System.out.print(cardNumber[indexNumber] + " ");
		}
		//捨てたことを案内
		System.out.println("を捨てました。");
		//捨てられたカードはリストに追加して保持
		disposedCards.add(cardNumber);
	}
	/**
	 * 関数名:getCards
	 * メソッドの説明:カードを見る
	 * 作成日:2026.06.15
	 */
	@Override
	public CardObject[][] getCards() {
		//見ない
		return null;
	}
}