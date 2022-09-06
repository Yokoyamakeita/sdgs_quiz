package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.QuizInfoEntity;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //①リクエスト(Getメソッド)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//②転送処理(フォワード)
		ServletContext con = request.getServletContext();
		RequestDispatcher rd = con.getRequestDispatcher("/top.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//データベースからクイズ問題を取得
		try {
			//JCBDドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			//データベースへの接続
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_c_itpj?useSSL=false", "root","password");
			
			//横山使用
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false", "root","");
			
			//ステートメントの作成
			Statement stmt = con.createStatement();
			//SQL文の実行（参照系）
			ResultSet res  = stmt.executeQuery("select * from quiz_info");
			
			//コレクションクラス(ArrayList)を初期化し、変数quizListへ代入
			ArrayList<QuizInfoEntity> quizList = new ArrayList<>();
			
			//ResultSetの操作
			while(res.next()){
				//QuizInfoEntityをインスタンス化
				QuizInfoEntity quizInfoObj = new QuizInfoEntity();
				//DBから取得したquestion_idデータをQuizInfoEntityオブジェクトのquestion_idへ代入
				quizInfoObj.setQuestion_id(res.getInt("id"));
				//DBから取得したquestionデータをQuizInfoEntityオブジェクトのquestionへ代入
				quizInfoObj.setQuestion(res.getString("questions"));
				//DBから取得したansデータをQuizInfoEntityオブジェクトのansへ代入
				quizInfoObj.setAns(res.getBoolean("ans"));
				//DBから取得したexplanationデータをQuizInfoEntityオブジェクトのexplanationへ代入
				quizInfoObj.setExplanation(res.getString("explanation"));
				
				//QuizInfoEntityオブジェクトをクイズリスト(quizList)の要素へ追加
				quizList.add(quizInfoObj);
			}
			//データベースへの接続開放（クローズ処理）
			con.close();
			stmt.close();
			res.close();
			
			//セッションスコープへquizListを保存
			//セッションスコープの準備
			HttpSession session = request.getSession();
			//セッションスコープの有効期間(300秒)の設定
			session.setMaxInactiveInterval(300);
			//セッションスコープへオブジェクト(quizList)を保存
			session.setAttribute("quizlist", quizList);
			//問題出題回数
			session.setAttribute("currentcount", 0);
			//問題出題上限(0以上)
			//session.setAttribute("maxcount", 9);
			session.setAttribute("maxcount", 10);
			//正解数
			session.setAttribute("anscount", 0);

			

			
			
			//転送処理(フォワード)
			//問題画面へ表示
			ServletContext s = request.getServletContext();
			RequestDispatcher rd = s.getRequestDispatcher("/quiz.jsp");
			
		
			

			rd.forward(request, response);

		}catch(Exception e){
			//例外処理
			e.getStackTrace();
		}
	}

}
