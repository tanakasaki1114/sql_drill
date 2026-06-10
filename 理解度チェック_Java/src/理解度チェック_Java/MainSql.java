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
	/**
	 * クラス名:main
	 * 概要:mainを処理
	 * @author 田中 沙樹
	 * 作成日:2026.06.10
	 */
	public static void main(String[] args) {
		//キーボードに入力された値を読み込むための変数を作る
		Scanner standardInput = new Scanner(System.in);
		// マネージャの宣言
		MariaDBManager manager = null;
		//処理を行う
		try {
			// DB操作を行うマネージャを作成する
			manager = CreataMariaDBManager();
			// Select 実行
			selectQuerySample(manager);
			//区切りをつける
			System.out.println("--------------------");
			//「実行したいものを選んでください。」という案内
			System.out.println("実行したいものを選んでください。\n1：登録 2:修正 3；削除 4：検索");
			//実行項目を選ぶ
			String actKey = standardInput.next();
			//もし、1の登録を選ぶ
			if(actKey.equals("1")) {
				// Insert 実行
				insertQuerySample(manager);
				// Select 実行
				selectQuerySample(manager);
				//区切りをつける
				System.out.println("--------------------");
				//もし、2の修正を選ぶ
			}else if(actKey.equals("2")) {
				// Update 実行
				updateQuerySample(manager);
				// Select 実行
				selectQuerySample(manager);
				//区切りをつける
				System.out.println("--------------------");
				//もし3の削除を選ぶ
			}else if(actKey.equals("3")) {
				// Delete 実行
				deleteQuerySample(manager);
				// Select 実行
				selectQuerySample(manager);
				//区切りをつける
				System.out.println("--------------------");
				//もし4の検索を選ぶ
			}else if(actKey.equals("4")) {
				//「検索メニュー」の案内
				System.out.println("--- 検索メニュー ---");
				//「1: ディーラーキーで検索」を表示
				System.out.println("1: ディーラーキーで検索");
				//「2: メーカーコードで検索」を表示
				System.out.println("2: メーカーコードで検索");
				//「3: タイプコードで検索」を表示
				System.out.println("3: タイプコードで検索");
				//「4：車種コードで検索」を表示
				System.out.println("4：車種コードで検索");
				//「5: 中古販売額で検索」を表示
				System.out.println("5: 中古販売額で検索");
				//「番号を選んでください（1〜5）：」という案内
				System.out.print("メニュー番号を選んでください（1〜5）： ");
				//検索メニューを選ぶ
				String menuKey = standardInput.next();
				//もし1のディーラーキーを選ぶ
				if (menuKey.equals("1")) {
					//「検索するディーラーキー：」という案内
					System.out.print("検索するディーラーキー：");
					// ディーラーキーの検索
					String searchKey = "dealer_key = " + standardInput.next();
					// Select 実行
					selectQuerySample(manager, searchKey);
				} else if (menuKey.equals("2")) {
					//「検索するメーカーキー：」という案内
					System.out.print("検索するメーカーキー：");
					// メーカーコードの検索
					String searchKey = "maker_id = " + standardInput.next();
					// Select 実行
					selectQuerySample(manager, searchKey);
				}else if (menuKey.equals("3")) {
					//「検索するタイプコード：」という案内
					System.out.print("検索するタイプコード：");
					// タイプコードの検索
					String searchKey = "type_id = " + standardInput.next();
					// Select 実行
					selectQuerySample(manager, searchKey);
				}else if (menuKey.equals("4")) {
					//「検索する車種コード：」という案内
					System.out.print("検索する車種コード：");
					// // 車種コードの検索
					String searchKey = "car_id = " + standardInput.next() ;
					// Select （条件あり）実行
					selectQuerySample(manager, searchKey);
				}else if (menuKey.equals("5")) {
					// 「下限額」の案内
					System.out.print("下限額：");
					//下限額の入力
					String searchMin = standardInput.next();
					// 「上限額」の案内
					System.out.print("上限額：");
					//上限額の入力
					String searchMax = standardInput.next();
					// Select （条件あり）実行
					selectQuerySample(manager, searchMin,searchMax);
				}
				//区切りをつける
				System.out.println("--------------------");
			}// SQL実行時エラーを補足
		}catch (SQLException e) {
			// エラーメッセージを表示
			System.err.println("エラーが発生したため処理を終了します");
			// 例外情報を出力する
			e.printStackTrace();
			// エラー有無にかかわらず処理を実行
		} finally {
			// コネクションをクローズする
			manager.closeConnection();
		}

	}
	/**
	 * SELECT 実行
	 * @param manager
	 * @throws SQLException 
	 * 作成日:2026.06.10
	 */
	private static void selectQuerySample(MariaDBManager manager) throws SQLException {
		// クエリ(SQL文)を作成する
		String sqlQuery = "select * from reception ";
		// SQLを実行する
		ResultSet resultSet = manager.executeQuery(sqlQuery);
		// 実行結果を表示する
		showResultset(resultSet);
	}
	/**
	 * SELECT 実行(条件あり)
	 * @param manager
	 * @param condition
	 * @throws SQLException
	 * 作成日:2026.06.10
	 */
	private static void selectQuerySample(MariaDBManager manager, String condition) throws SQLException {
		// クエリ(SQL文)を作成する
		String sqlQuery = "select * from reception ";
		// 検索条件が指定されている場合
		if (condition != null && condition != "") {
			// 検索条件を追加する(?の部分は後で設定する)
			sqlQuery = sqlQuery + " WHERE " + condition;
		}
		// 条件付きStatementの宣言
		PreparedStatement statement = manager.getConnection().prepareStatement(sqlQuery);
		// 検索条件が指定されている場合はStatementに条件を追加する
		if (condition != null && condition != "") {
			// 検索条件を設定する
			statement.setString(1, condition);
		}
		// SQLを実行する
		ResultSet resultSet = manager.executeQueryWithPreparedStatement(statement);
		// 実行結果を表示する
		showResultset(resultSet);
	}
	/**
	 * SELECT 実行(条件あり)
	 * @param manager
	 * @param condition
	 * @throws SQLException
	 * 作成日:2026.06.10
	 */
	private static void selectQuerySample(MariaDBManager manager, String minPrice, String maxPrice) throws SQLException {
		// クエリ(SQL文)を作成する
		String sqlQuery = "select * from reception ";
		// 検索条件が指定されている場合
		if (minPrice != null && minPrice != "" && maxPrice != null && maxPrice != "") {
			// 検索条件を追加する(?の部分は後で設定する)
			sqlQuery = sqlQuery + " WHERE used_price BETWEEN " + minPrice + " AND " + maxPrice + ";";
		}
		// 条件付きStatementの宣言
		PreparedStatement statement = manager.getConnection().prepareStatement(sqlQuery);
		// SQLを実行する
		ResultSet resultSet = manager.executeQueryWithPreparedStatement(statement);
		// 実行結果を表示する
		showResultset(resultSet);
	}
	private static void showResultset(ResultSet resultSet) throws SQLException {
		// 結果の表示
		while (resultSet.next()) {
			// 都道府県コード列取得
			String reception_key = resultSet.getString("reception_key");
			// 都道府県コード列取得
			String pref_code = resultSet.getString("pref_code");
			// ディーラーキー列取得
			String dealer_key = resultSet.getString("dealer_key");
			// メーカーキー列取得
			String maker_id = resultSet.getString("maker_id");
			// タイプコード列取得
			String type_id = resultSet.getString("type_id");
			// 車種コード列取得
			String  car_id= resultSet.getString("car_id");
			// 中古車販売額列取得
			String used_price = resultSet.getString("used_price");
			//ユーザーID列取得
			String user_id = resultSet.getString("user_id");
			// 取得した情報を出力
			System.out.println(reception_key + "," + pref_code + "," + dealer_key + "," + maker_id + "," + type_id + "," + car_id + "," + used_price + "," + user_id);
		}
	}
	/**
	 * INSERT 実行
	 * @param manager
	 * @throws SQLException
	 * 作成日:2026.06.10 
	 */
	private static void insertQuerySample(MariaDBManager manager) throws SQLException {
		//キーボードに入力された値を読み込むための変数を作る
		Scanner standardInput = new Scanner(System.in);
		//「受付番号：」と表示
		System.out.print("受付番号：");
		//受付番号の入力
		String reception_key = standardInput.next();
		//「都道府県コード：」と表示
		System.out.print("都道府県コード：");
		//都道府県コードの入力
		String pref_code = standardInput.next();
		//「ディーラーキー：」と表示
		System.out.print("ディーラーキー：");
		//ディーラーキーを入力
		String dealer_key = standardInput.next();
		//「メーカーキー：」と表示
		System.out.print("メーカーキー：");
		//メーカーキーを入力
		String maker_id = standardInput.next();
		//「タイプコード：」と表示
		System.out.print("タイプコード：");
		//タイプコードを入力
		String type_id = standardInput.next();
		//「車種コード：」と表示
		System.out.print("車種コード：");
		//車種コードを入力
		String car_id = standardInput.next();
		//「中古販売額：」と表示
		System.out.print("中古販売額：");
		//中古販売額を入力
		String used_price = standardInput.next();
		//「元所有者コード」と表示
		System.out.print("元所有者コード：");
		//元所有者コードを入力
		String user_id = standardInput.next();
		// クエリ(SQL文)を作成する
		String sqlQuery = "INSERT INTO reception (reception_key, pref_code, dealer_key, maker_id, type_id, car_id, used_price, user_id) "
				+ "VALUES (" + reception_key + "," + pref_code + "," + dealer_key + "," + maker_id + "," + type_id + "," + car_id + "," + used_price + "," + user_id + ")";
		// SQL文を実行する
		manager.executeUpdateQuery(sqlQuery);


	}
	/**
	 * UPDATE 実行
	 * @param manager
	 * @throws SQLException 
	 * 作成日:2026.06.10
	 */
	private static void updateQuerySample(MariaDBManager manager) throws SQLException {
		//キーボードに入力された値を読み込むための変数を作る
		Scanner standardInput = new Scanner(System.in);
		//「修正したい受付番号：」と表示
		System.out.print("修正したい受付番号：");
		//修正したい受付番号を入力
		String reception_key = standardInput.next();
		//「修正後のメーカーキー：」と表示
		System.out.print("修正後のメーカーキー：");
		//修正後のメーカーキーを入力
		String maker_id = standardInput.next();
		//「修正後のタイプコード」と表示
		System.out.print("修正後のタイプコード：");
		//修正後のタイプコードを入力
		String type_id = standardInput.next();
		//「修正後の車種コード：」と表示
		System.out.print("修正後の車種コード：");
		//修正後の車種コードを入力
		String car_id = standardInput.next();
		//「修正後の中古販売額：」と表示
		System.out.print("修正後の中古販売額：");
		//修正後の中古販売額を入力
		String used_price = standardInput.next();
		// クエリ(SQL文)を作成する
		String sqlQuery = "UPDATE reception SET maker_id = " + maker_id + "," + "type_id = " + type_id + "," + "car_id = " + car_id + "," + "used_price =  "+ used_price + 
				" WHERE reception_key = " + reception_key;
		// SQL文を実行する
		manager.executeUpdateQuery(sqlQuery);

	}
	/**
	 * DELETE 実行
	 * @param manager
	 * @throws SQLException
	 * 作成日:2026.06.10 
	 */
	private static void deleteQuerySample(MariaDBManager manager) throws SQLException {
		//キーボードに入力された値を読み込むための変数を作る
		Scanner standardInput = new Scanner(System.in);
		//「削除したい受付番号：」と表示
		System.out.print("削除したい受付番号：");
		//削除したい受付番号を入力
		String reception_key = standardInput.next();
		// クエリ(SQL文)を作成する
		String sqlQuery = "DELETE FROM reception WHERE reception_key = " + reception_key;
		// SQL文を実行する
		manager.executeUpdateQuery(sqlQuery);
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
		String username = "root";
		//SQLのログインパスワード
		String password = "";
		//SQLにログイン
		return new MariaDBManager(jdbcUrl, username, password);
	}
}