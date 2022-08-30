package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NextQuestionServlet
 */
@WebServlet("/NextQuestionServlet")
public class NextQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字コードをUTF-8へ変換
		request.setCharacterEncoding("UTF-8");
		
		//requestオブジェクトのgetParameterメソッドへ引数「btn」を指定し、
		//ボタンの表示項目（次の問題へ進む or 結果画面へ）を取得し、変数nextButtonへ格納
		String nextButton = request.getParameter("btn");

		//転送処理(フォワード)
		ServletContext s = request.getServletContext();
		RequestDispatcher rd;
		
		if(nextButton.equals("次の問題へ進む")) {
			//次の問題へ進む
			rd = s.getRequestDispatcher("/quiz.jsp");
		}else {
			//結果画面への場合
			rd = s.getRequestDispatcher("/result.jsp");
		}
		
		//処理を転送する
		rd.forward(request, response);

	}

}
