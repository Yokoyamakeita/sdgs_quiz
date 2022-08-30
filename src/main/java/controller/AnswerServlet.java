package controller;

import java.io.IOException;
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
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//文字コードをUTF-8へ変換
		request.setCharacterEncoding("UTF-8");
		
		//requestオブジェクトのgetParameterメソッドへ引数「btn」を指定し、
		//ボタンの表示項目（YES or NO）を取得し、変数ansButtonへ格納
		String ansButton = request.getParameter("btn");
		
		//正解をセッションスコープから取得
		HttpSession session = request.getSession();
		ArrayList<QuizInfoEntity> quizList = (ArrayList<QuizInfoEntity>)session.getAttribute("quizlist");
		int currentCount = (int)session.getAttribute("currentcount");
		QuizInfoEntity qe = quizList.get(currentCount);
		boolean answer = qe.isAns();
		
		//正解数を取得
		int anscount = (int) session.getAttribute("anscount");		
		
		//正解有無を確認
		if(ansButton.equals("YES") && answer || ansButton.equals("NO") && !answer){
			//正解の場合
			//正解数に1を足す
			anscount += 1;
			//セッションスコープへ格納する
			session.setAttribute("anscount", anscount);
			session.setAttribute("anstitle", "正解です");
			
		}else {
			//セッションスコープへ格納する
			session.setAttribute("anstitle", "不正解です");
		}
		
		//転送処理(フォワード)
		//解説画面へ表示
		ServletContext s = request.getServletContext();
		RequestDispatcher rd = s.getRequestDispatcher("/answer.jsp");
		rd.forward(request, response);
	
	}

}
