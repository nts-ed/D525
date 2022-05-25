package Model;

import java.io.Serializable;

public class Qs implements Serializable{

	private int correctAns;
	private String userAns;
	private boolean isCorrect;
	private String qString;

	public String getqString() {
		return qString;
	}
	public void setqString(String qString) {
		this.qString = qString;
	}
	public int getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(int correctAns) {
		this.correctAns = correctAns;
	}
	public String getUserAns() {
		return userAns;
	}
	public void setUserAns(String userAns) {
		this.userAns = userAns;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}