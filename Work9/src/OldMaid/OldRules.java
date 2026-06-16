package OldMaid;

import TrumpPackage.CardObject;
import TrumpPackage.HandObject;
import TrumpPackage.RulesObject;
import TrumpPackage.TableObject;

public class OldRules implements RulesObject{
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
				//もし同じ値の組み合わせが見つかったら
				if(numberOfHand == lookingCard) {
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
}