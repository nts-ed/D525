package Model;

public class QsLogic {
	public void create(Qs qs,int numsCount,int min,int max) {
		int[] nums=new int[numsCount];
		for(int i=0;i<numsCount;i++) {
			nums[i]=(int)(Math.random()*(max-min+1))+min;
		}

		int result=nums[0];
		for(int i=1;i<nums.length;i++) {
			result*=nums[i];
		}
		qs.setCorrectAns(result);
		String qString="";
		for(int i=0;i<nums.length;i++) {
			qString+=nums[i]+(i==nums.length-1? "=":"~");
		}
		qs.setqString(qString);
	}
	public void result(Qs qs,String userAns) {
		qs.setUserAns(userAns);
		int ans=Integer.parseInt(userAns);
		qs.setCorrect(qs.getCorrectAns()==ans);
	}
}