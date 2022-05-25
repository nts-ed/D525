package Model;

import java.io.Serializable;

public class Stat implements Serializable{
	private int correct;
	private int wrong;
	public Stat() {
		correct=0;
		wrong=0;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public int getWrong() {
		return wrong;
	}
	public void setWrong(int wrong) {
		this.wrong = wrong;
	}

}