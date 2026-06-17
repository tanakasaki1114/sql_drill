package FantanPackage;

import TrumpPackage.CardObject;
import TrumpPackage.HandObject;
import TrumpPackage.RulesObject;
import TrumpPackage.TableObject;
/**
 * クラス名:FantanRule
 * 概要:7並べのルールを表す
 * @author 田中 沙樹
 * 作成日:2026.06.15
 */
public class FantanRule implements RulesObject{
	/**
	 * 関数名:findCandidate
	 * メソッドの説明:テーブルに置けるカードを探す
	 * @param handNumber 手札、tableNumber テーブル
	 * @return 見つかったカードの組み合わせ。見つからなかった場合は、NULLを返す
	 * 作成日:2026.06.15
	 */
	//オーバーライド
	@Override
	public CardObject[] findCandidate(HandObject handNumber, TableObject tableNumber) {
		//テーブルに置けるカードの候補
		CardObject[] candidateCard = null;
		//手札にあるカードの情報をとる
		int numberOfHand = handNumber.getNumberOfCads();
		//繰り返す
		for(int positionNumber = 0;positionNumber < numberOfHand; positionNumber++) {
			//カードの情報をとる
			CardObject lookingCard = handNumber.lookCard(positionNumber);
			//手札のカードの数字をの情報をとる
			int cardNumber = lookingCard.getNumber();
			//手札のカードのスートの情報をとる
			int suitNumber = lookingCard.getSuit();
			//1を定数化
			public static final int ONE_CARD = 1;
			//左の数が、1のときは13、1以外のときは1を引く
			int leftNumber = (cardNumber != ONE_CARD) ? cardNumber - ONE_CARD : CardObject.CARD_NUMBER;
			//右の数が、1のときは13、1以外のときは1を引く
			int rightNumber = (cardNumber != CARD_NUMBER) ? cardNumber + 1 : ONE_CARD;
			//指定したカードがあれば
			if((true == isThereCard(tableNumber,suitNumber,leftNumber)) || (true == isThereCard(tableNumber,suitNumber,rightNumber))) {
				//置くためのカードの準備
				candidateCard = new CardObject[1];
				//手札からカードを引く
				candidateCard[0] = handNumber.pickCard(positionNumber);
				//抜ける
				break;
			}
		}
		//見つかったカードの組み合わせを返却
		return candidateCard;
	}
	/**
	 * 関数名:isThereCard
	 * メソッドの説明:テーブルにカードが置かれているか調べる
	 * @param handNumber 手札、tableNumber テーブル、cardNumber カードの数
	 * @return カードが置かれている場合はtrue、置かれていない場合はfalse
	 * 作成日:2026.06.15
	 */
	private boolean isThereCard(TableObject tableNumber,int suitNumber,int cardNumber) {
		//テーブル上のカードの情報をとる
		CardObject[][] cardsNumber = tableNumber.getCards();
		//テーブル上にあれば
		if(cardsNumber[suitNumber - 1][cardNumber - 1] != null) {
			//trueを返す
			return true;
			//テーブル上になければ
		}else {
			//falseを返す
			return false;
		}
	}
}