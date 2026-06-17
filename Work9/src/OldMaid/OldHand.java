package OldMaid;

import java.util.ArrayList;

import TrumpPackage.CardObject;
import TrumpPackage.HandObject;
/**
 * クラス名:OldHand
 * 概要:ババ抜きの手持ち
 * @author 田中 沙樹
 * 作成日:2026.06.16
 */
public class OldHand extends HandObject{
	//手札にあるカードを保持するリスト
	protected ArrayList handList = new ArrayList();
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
}