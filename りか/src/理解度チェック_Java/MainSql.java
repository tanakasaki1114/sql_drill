package 理解度チェック_Java;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * クラス名:MainSql
 * 概要:JavaとSQL連携し、登録・修正・削除・検索を行う
 * @author 田中 沙樹
 * 作成日:2026.06.10
 */
public class MainSql {
	//キーボードに入力された値を読み込むための変数を作る
	private static final Scanner standardInput = new Scanner(System.in);
	/**
	 * クラス名:main
	 * 概要:mainを処理
	 * @author 田中 沙樹
	 * 作成日:2026.06.10
	 */
	public static void main(String[] args) {
		// マネージャの宣言
		MariaDBManager managerObject = null;
		//処理を行う
		try {
			// DB操作を行うマネージャを作成する
			managerObject = CreataMariaDBManager();
			// Select 実行
			selectQuerySample(managerObject);
			//区切りをつける
			System.out.println("--------------------");
			//「実行したいものを選んでください。」という案内
			System.out.println("実行したいものを選んでください。\n1：登録 2:修正 3；削除 4：検索");
			//実行項目を選ぶ
			String actKey = standardInput.next();
			//もし、1の登録を選ぶ
			if(actKey.equals("1")) {
				// Insert 実行
				insertQuerySample(managerObject);
				// Select 実行
				selectQuerySample(managerObject);
				//区切りをつける
				System.out.println("--------------------");
				//もし、2の修正を選ぶ
			}else if(actKey.equals("2")) {
				// Update 実行
				updateQuerySample(managerObject);
				// Select 実行
				selectQuerySample(managerObject);
				//区切りをつける
				System.out.println("--------------------");
				//もし3の削除を選ぶ
			}else if(actKey.equals("3")) {
				// Delete 実行
				deleteQuerySample(managerObject);
				// Select 実行
				selectQuerySample(managerObject);
				//区切りをつける
				System.out.println("--------------------");
				//もし4の検索を選ぶ
			}else if(actKey.equals("4")) {
				//「検索メニュー」の案内
				System.out.println("--- 検索メニュー ---");
				//検索メニューの注意事項を表記
				System.out.println("※検索したい項目だけ入力。指定しない場合は「なし」と入力してください。");
				//区切り
				System.out.println("--------------------");
				//ディーラーキーを入力
				System.out.print("1. ディーラーキー : ");
				//検索したいディーラーキーを入力
				String dealerKey = standardInput.next();
				//メーカーキーを入力
				System.out.print("2. メーカーキー : ");
				//検索したいメーカーキーを入力
				String makerId = standardInput.next();
				//タイプコードを入力
				System.out.print("3. タイプコード : ");
				//検索したいタイプコードを入力
				String typeId = standardInput.next();
				//車種コードを入力
				System.out.print("4. 車種コード : ");
				//検索したい車種コードを入力
				String carId = standardInput.next();
				//中古販売額で検索するかどうか決める
				System.out.print("5. 中古販売額で検索しますか？(Yes/No) : ");
				//「Yes」か「No」を入力
				String priceChoice = standardInput.next();
				//変数を初期化
				int searchMin = 0;
				//変数を初期化
				int searchMax = 0;
				//変数を宣言
				String searchKey = "";
				// ディーラーの指定があったら
				if (!dealerKey.equals("なし")) {
					//実行
					searchKey += "dealer_key LIKE '%" + dealerKey + "%'";
				}
				// メーカーの指定があったら
				if (!makerId.equals("なし")) {
					//条件があったら
					if (!searchKey.equals("")) { 
						//つなぐ
						searchKey += " AND "; 
					} 
					//実行
					searchKey += "maker_id LIKE '%" + makerId + "%'";
				}
				// タイプの指定があったら
				if (!typeId.equals("なし")) {
					//条件があったら
					if (!searchKey.equals("")) {
						//つなぐ
						searchKey += " AND "; 
					}
					//実行
					searchKey += "type_id LIKE '%" + typeId + "%'";
				}
				// 車種の指定があったら
				if (!carId.equals("なし")) {
					//条件があったら
					if (!searchKey.equals("")) {
						//つなぐ
						searchKey += " AND "; 
					}
					//実行
					searchKey += "car_id LIKE '%" + carId + "%'";
				}
				//もしYesなら
				if (priceChoice.equalsIgnoreCase("Yes")) {
					//「下限額」の案内
					System.out.print("下限額：");
					//下限額を入力
					searchMin = standardInput.nextInt();
					//「上限額」の案内
					System.out.print("上限額：");
					//上限額を入力
					searchMax = standardInput.nextInt();
					//条件があったら
					if (!searchKey.equals("")) {
						//つなぐ
						searchKey += " AND "; 
					}
					//実行
					searchKey += "used_price BETWEEN " + searchMin + " AND " + searchMax;
				}
				// 完成した条件で検索を実行する
				selectQuerySample(managerObject, searchKey);
			}
		}// SQL実行時エラーを補足
	}catch (SQLException e) {
		// エラーメッセージを表示
		System.err.println("エラーが発生したため処理を終了します");
		// 例外情報を出力する
		e.printStackTrace();
		// エラー有無にかかわらず処理を実行
	} finally {
		// コネクションをクローズする
		managerObject.closeConnection();
	}

}
/**
 * 関数名:selectQuerySample
 * メソッドの説明:全て列挙するSQL文の作成
 * @param managerObject マネージャ
 * @throws SQLException
 * 作成日:2026.06.10
 */
private static void selectQuerySample(MariaDBManager managerObject) throws SQLException {
	// クエリ(SQL文)を作成する
	String sqlQuery = "select * from reception ";
	// SQLを実行する
	ResultSet resultSet = managerObject.executeQuery(sqlQuery);
	// 実行結果を表示する
	showResultset(resultSet);
}
/**
 * 関数名:selectQuerySample
 * メソッドの説明:条件をつけて全て列挙するSQL文の作成
 * @param managerObject マネージャ
 * @param condition 条件
 * @throws SQLException
 * 作成日:2026.06.10
 */
private static void selectQuerySample(MariaDBManager managerObject, String conditionObject) throws SQLException {
	// クエリ(SQL文)を作成する
	String sqlQuery = "select * from reception ";
	// 検索条件が指定されている場合
	if (conditionObject != null && conditionObject != "") {
		// 検索条件を追加する(?の部分は後で設定する)
		sqlQuery = sqlQuery + " WHERE " + conditionObject;
	}
	// 条件付きStatementの宣言
	PreparedStatement statement = managerObject.getConnection().prepareStatement(sqlQuery);
	// SQLを実行する
	ResultSet resultSet = managerObject.executeQueryWithPreparedStatement(statement);
	// 実行結果を表示する
	showResultset(resultSet);
}
/**
 * 関数名:showResultset
 * メソッドの説明:DB内の情報の取得
 * @param resultSet クエリの実行結果
 * 作成日:2026.06.10
 */
private static void showResultset(ResultSet resultSet) throws SQLException {
	// 結果の表示
	while (resultSet.next()) {
		// 都道府県コード列取得
		String receptionKey = resultSet.getString("reception_key");
		// 都道府県コード列取得
		String prefCode = resultSet.getString("pref_code");
		// ディーラーキー列取得
		String dealerKey = resultSet.getString("dealer_key");
		// メーカーキー列取得
		String makerId = resultSet.getString("maker_id");
		// タイプコード列取得
		String typeId = resultSet.getString("type_id");
		// 車種コード列取得
		String  carId= resultSet.getString("car_id");
		// 中古車販売額列取得
		String usedPrice = resultSet.getString("used_price");
		//ユーザーID列取得
		String userId = resultSet.getString("user_id");
		// 取得した情報を出力
		System.out.println(receptionKey + "," + prefCode + "," + dealerKey + "," + makerId + "," + typeId + "," + carId + "," + usedPrice + "," + userId);
	}
}
/**
 * INSERT 実行
 * @param manager
 * @throws SQLException
 * 作成日:2026.06.10 
 */
private static void insertQuerySample(MariaDBManager managerObject) throws SQLException {
	//「受付番号：」と表示
	System.out.print("受付番号：");
	//受付番号の入力
	String receptionKey = standardInput.next();
	//「都道府県コード：」と表示
	System.out.print("都道府県コード：");
	//都道府県コードの入力
	String prefCode = standardInput.next();
	//「ディーラーキー：」と表示
	System.out.print("ディーラーキー：");
	//ディーラーキーを入力
	String dealerKey = standardInput.next();
	//「メーカーキー：」と表示
	System.out.print("メーカーキー：");
	//メーカーキーを入力
	String makerId = standardInput.next();
	//「タイプコード：」と表示
	System.out.print("タイプコード：");
	//タイプコードを入力
	String typeId = standardInput.next();
	//「車種コード：」と表示
	System.out.print("車種コード：");
	//車種コードを入力
	String carId = standardInput.next();
	//「中古販売額：」と表示
	System.out.print("中古販売額：");
	//中古販売額を入力
	int usedPrice = standardInput.nextInt();
	//「元所有者コード」と表示
	System.out.print("元所有者コード：");
	//元所有者コードを入力
	String userId = standardInput.next();
	// クエリ(SQL文)を作成する
	String sqlQuery = "INSERT INTO reception (reception_key, pref_code, dealer_key, maker_id, type_id, car_id, used_price, user_id) "
			+ "VALUES (" + receptionKey + "," + prefCode + "," + dealerKey + "," + makerId + "," + typeId + "," + carId + "," + usedPrice + "," + userId + ")";
	// SQL文を実行する
	managerObject.executeUpdateQuery(sqlQuery);


}
/**
 * UPDATE 実行
 * @param manager
 * @throws SQLException 
 * 作成日:2026.06.10
 */
private static void updateQuerySample(MariaDBManager managerObject) throws SQLException {
	//「修正したい受付番号：」と表示
	System.out.print("修正したい受付番号：");
	//修正したい受付番号を入力
	String receptionKey = standardInput.next();
	//「修正後のメーカーキー：」と表示
	System.out.print("修正後のメーカーキー：");
	//修正後のメーカーキーを入力
	String makerId = standardInput.next();
	//「修正後のタイプコード」と表示
	System.out.print("修正後のタイプコード：");
	//修正後のタイプコードを入力
	String typeId = standardInput.next();
	//「修正後の車種コード：」と表示
	System.out.print("修正後の車種コード：");
	//修正後の車種コードを入力
	String carId = standardInput.next();
	//「修正後の中古販売額：」と表示
	System.out.print("修正後の中古販売額：");
	//修正後の中古販売額を入力
	int usedPrice = standardInput.nextInt();
	// クエリ(SQL文)を作成する
	String sqlQuery = "UPDATE reception SET maker_id = " + makerId + "," + "type_id = " + typeId + "," + "car_id = " + carId + "," + "used_price =  "+ usedPrice + 
			" WHERE reception_key = " + receptionKey;
	// SQL文を実行する
	managerObject.executeUpdateQuery(sqlQuery);

}
/**
 * DELETE 実行
 * @param manager
 * @throws SQLException
 * 作成日:2026.06.10 
 */
private static void deleteQuerySample(MariaDBManager managerObject) throws SQLException {
	//「削除したい受付番号：」と表示
	System.out.print("削除したい受付番号：");
	//削除したい受付番号を入力
	String receptionKey = standardInput.next();
	// クエリ(SQL文)を作成する
	String sqlQuery = "DELETE FROM reception WHERE reception_key = " + receptionKey;
	// SQL文を実行する
	managerObject.executeUpdateQuery(sqlQuery);
}
/**
 * DBアクセスを行うオブジェクトを作成する
 * @return DBManager
 * @throws SQLException
 * 作成日:2026.06.10
 */
private static MariaDBManager CreataMariaDBManager() throws SQLException {
	//SQLのURLの挿入
	String jdbcUrl = "jdbc:mariadb://localhost:3306/workbook";
	//SQLのログインネーム
	String userName = "root";
	//SQLのログインパスワード
	String passWord = "";
	//SQLにログイン
	return new MariaDBManager(jdbcUrl, userName, passWord);
}
}