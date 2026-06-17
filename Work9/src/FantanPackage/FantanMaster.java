package FantanPackage;

import TrumpPackage.MasterObject;
/**
 * クラス名:FantanMaster
 * 概要:7並べの進行役を表す
 * @author 田中 沙樹
 * 作成日:2026.06.15
 */
public class FantanMaster extends MasterObject{
	//パスできる制限回数
	public static final int PASS_LIMIT = 3;
	/**
	 * 関数名:passObject
	 * メソッドの説明:パスを宣言する
	 * @param playerObject パスするプレイヤーの名前
	 * 作成日:2026.06.15
	 */
	public void passObject(FantanPlayer playerObject) {
		//パスを宣言したことを案内
		System.out.println(playerObject + "さんは" + playerObject.getPass() + "回目のパスをしました！");
		//パスの制限回数を超えたら
		if(playerObject.getPass() > PASS_LIMIT) {
			//負けであることを案内
			System.out.println(playerObject + "さんは負けです。");
			//プレイヤーを削除
			deregisterPlayer(playerObject);
		}
	}
}