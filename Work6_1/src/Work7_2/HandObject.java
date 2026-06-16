package Work7_2;

import java.util.ArrayList;
/**
 * クラス名:HandObject
 * 概要:手札を表す
 * @author 田中 沙樹
 * 作成日:2026.06.12
 */
public class HandObject {
	//手札にあるカードを保持するリスト
	protected ArrayList handList = new ArrayList();
	/**
	 * 関数名:addCard
	 * メソッドの説明:カードを加える
	 * @param 加えるカード
	 * 作成日:2026.06.12
	 */
	public void addCard(CardObject cardList) {
		//カードをリストの最後に追加する
		handList.add(cardList);
	}
	/**
	 * 関数名:pickCard
	 * メソッドの説明:カードを引く
	 * @return 引いたカード
	 * 作成日:2026.06.12
	 */
	public CardObject pickCard() {
		//先頭のカードを引く
		CardObject pickedCard = (CardObject)handList.remove(0);
		//引いたカードを返却
		return pickedCard;
	}
	/**
	 * 関数名:shuffleCard
	 * メソッドの説明:カードをシャッフルする
	 * 作成日:2026.06.12
	 */
	public void shuffleCard() {
		//カードの枚数を数える
		int handNumber = handList.size();
		//カードを抜き出す位置
		int posNumber = 0;
		//繰り返す
		for(int countNumber = 0; countNumber < handNumber * 2; countNumber++) {
			//ランダムに抜く
			posNumber = (int) (Math.random() * handNumber);
			//ランダムな位置からカードを1枚抜く
			CardObject pickedCard = (CardObject)handList.remove(posNumber);
			//抜き取ったカードを最後に加える
			handList.add(pickedCard);
		}
	}
	/**
	 * 関数名:getNumberOfCards
	 * メソッドの説明:枚数を数える
	 * @return 手札にあるカードの枚数
	 * 作成日:2026.06.12
	 */
	public int  getNumberOfCards() {
		//手札にあるカードの枚数を返す
		return handList.size();
	}
	/**
	 * 関数名:findSameNumberCard
	 * メソッドの説明:同じ数のカードを探す。カードがない場合、nullを返す
	 * @return 同じ数のカード
	 * 作成日:2026.06.12
	 */
	public CardObject[]findSameNumberCard(){
		//カードの枚数を数える
		int numberOfCards = handList.size();
		//配列の宣言
		CardObject[] sameCards = null;
		//手持ちがある場合、
		if(numberOfCards > 0) {
			//最後に追加されたカードを取得する
			int lastIndex = numberOfCards - 1;
			//手持ちの手札を見る
			CardObject lastAddedCard = (CardObject) handList.get(lastIndex);
			//最後に追加されたカードの数字を取得
			int lastAddedCardNumber = lastAddedCard.getNumber();
			//繰り返す
			for(int indexNumber = 0;indexNumber < lastIndex; indexNumber++) {
				//手持ちの手札を見る
				CardObject cardNumber = (CardObject)handList.get(indexNumber);
				//もし最後に追加されたカードと手元のカードを同じなら
				if(cardNumber.getNumber() == lastAddedCardNumber) {
					//配列を宣言
					sameCards = new CardObject[2];
					//見つかった組み合わせを格納
					sameCards[0] = (CardObject)handList.remove(lastIndex);
					//見つかった組み合わせを格納
					sameCards[1] = (CardObject)handList.remove(indexNumber);
					//抜ける
					break;
				}				
			}
		}
		//同じ数のカードを返却
		return sameCards;
	}
	/**
	 * 関数名:toString
	 * メソッドの説明:カードを文字列で表現
	 * @return カードの文字表現
	 * 作成日:2026.06.12
	 */
	public String toString() {
		//文字列を結合するための変数を作る
		StringBuffer stringWord = new StringBuffer();
		//手持ちの数を数える
		int sizeNumber = handList.size();
		//手持ちがある場合、
		if(sizeNumber > 0) {
			//繰り返す
			for(int indexNumber = 0; indexNumber < sizeNumber; indexNumber++) {
				//カードの数を見る
				CardObject cardNumber = (CardObject) handList.get(indexNumber);
				//カードの数を追加
				stringWord.append(cardNumber);
				//空白を追加
				stringWord.append(" ");
			}
		}
		//文字列を表現
		return String.toString();
	}
}