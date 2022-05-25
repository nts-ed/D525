package Model;

public class StatLogic {
	public void correctPlus(Stat stat) {
		stat.setCorrect(stat.getCorrect()+1);
	}
	public void wrongPlus(Stat stat) {
		stat.setWrong(stat.getWrong()+1);
	}
}
