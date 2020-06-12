/*

凑算式

     B      DEF
A + --- + ------- = 10
     C      GHI
     
（如果显示有问题，可以参见【图1.jpg】）
	 
	 
这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。

比如：
6+8/3+952/714 就是一种解法，
5+3/1+972/486 是另一种解法。

这个算式一共有多少种解法？

注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
 */
/*
 * 
用到知识点：
1、常规dfs套路：
	dfs(int index,int cnt)
	每个数字只能出现一次 使用vis数组表示
	dfs出口：9个数字都选完了再次基础上 满足算式 ans++

注意：
1、System.out.println(6.0+8.0/3.0+952.0/714.0);结果为10
这里出现除法 保证精度 要使用double类型
答案：252
 */
package 第七届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月10日 下午2:05:13
*/
public class t03_凑算式_dfs {
	static int ans=0;
	static double a[]=new double[10];
	static boolean vis[]=new boolean[10];
	/**
	 * @param index 当前为a的index位置选数字
	 * @param cnt 当前选了cnt个数
	 */
	static void dfs(int index,int cnt) {
		//9个数都选好了
		if(cnt==9) {
			if(a[1]+a[2]/a[3]+ (a[4]*a[5]*a[6])/(a[7]*a[8]*a[9])==10.0) {
				System.out.println(a[1]+" "+a[2]/a[3]+" "+ (a[4]*a[5]*a[6])/(a[7]*a[8]*a[9]));
				ans++;
				return;
			}
		}
		for(int i=1;i<=9;i++) {
			//当前a的index位置选了i
			if(!vis[i]) {
				a[index]=(double)i;
				vis[i]=true;
				dfs(index+1,cnt+1);
				a[index]=0.0;
				vis[i]=false;
			}
		}
	}


	public static void main(String[] args) {

		dfs(1,0);
		System.out.println(ans);
		
	}

}
