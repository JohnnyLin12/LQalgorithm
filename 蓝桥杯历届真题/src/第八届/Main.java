package 第八届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月25日 下午9:39:22
* 类说明
*/
public class Main {

	public static void main(String[] args) {
		//int []x= {0,1,2,3,4,5,6,7,9,10};
		int dp[]=new int[11];
		for (int i = 1; i <=10; i++) {
			/*
			 * dp[i]=(x+dp[i-1]);
			 * int index=(int) (dp[i]%K);
			 *与下面等效 
			 */ 
			//1 0 0 1 0 0 1 0 0 1 
			dp[i]=(i+dp[i-1])%2;
			int index=(int) dp[i];
			//1 0 0 1 0 0 1 0 0 1 
//			dp[i]=(i+dp[i-1]);//1 1 0 0 1 1 0 0 1 1 
//			int index=(int) (dp[i]%2);
			System.out.print(index+" ");
		}

	}

}
