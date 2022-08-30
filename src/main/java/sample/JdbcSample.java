package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSample {

	public static void main(String[] args) {
		
//		問題IDを指定
		int num = 2;
		
		try {
			//DBへ接続
			//①JDBCドライバーをロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//②DBへ接続
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_c_itpj", "root","password");
			
			//③SQL作成
//			[指定された問題を表示]
			PreparedStatement stmt = con.prepareStatement("select * from quiz_info where id = ?");
			
			stmt.setInt(1, num);
			
			ResultSet rs = stmt.executeQuery();
		
			
//			[すべての問題を表示]
//			Statement stmt = con.createStatement();
			
			
//			ResultSet rs = stmt.executeQuery("select * from quiz_info");
			
			
			//④データの取得
			while(rs.next()) {
				int id = rs.getInt("id");
				String questions = rs.getString("questions");
				int ans  = rs.getInt("ans");
				String explanation = rs.getString("explanation");

				System.out.print(id + " ");
				System.out.print(questions + " ");
				System.out.print(ans + " ");
				System.out.println(explanation);

			}

			//⑤DBを終了する
			con.close();
			stmt.close();
			rs.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
