package model;
/* 
 * クイズ情報管理クラス
 */
public class QuizInfoEntity {
	
	//フィールド
	private  int question_id;	//問題No
	private String question;	//問題
	private boolean ans;		//解答
	private String explanation;	//解答説明

	//コンストラクタ
	public QuizInfoEntity() {
		this.question_id = 0;
		this.question = "";
		this.ans = false;
		this.explanation = "";
	}
	
	//アクセサメソッド
	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isAns() {
		return ans;
	}

	public void setAns(boolean ans) {
		this.ans = ans;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
