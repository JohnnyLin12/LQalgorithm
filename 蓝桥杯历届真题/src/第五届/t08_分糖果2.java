/*

标题：分糖果



有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：

每个小朋友都把自己的糖果分一半给左手边的孩子。

一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。

反复进行这个游戏，直到所有小朋友的糖果数都相同为止。

你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。

【格式要求】

    程序首先读入一个整数N(2<N<100)，表示小朋友的人数。
    接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）
    要求程序输出一个整数，表示老师需要补发的糖果数。

例如：输入
3
2 2 4
程序应该输出：
4

这题个人觉得表述实在不严谨 没有说小朋友时顺时针绕圈坐还是逆时针 我按顺时针来结果不对
看了网上的题解是逆时针 对于一半的表示也没有说清楚 当小朋友有奇数颗糖时该怎么分 这里就默认处理了  
 */
package 第五届;

import java.util.Scanner;

public class t08_分糖果2 {
	static boolean check(int [] arra) {
		for (int i = 0; i < arra.length-1; i++) {
			if(arra[i]!=arra[i+1]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		int [] dp=new int[n];
		for (int i = 0; i < n; i++) {
			dp[i]=reader.nextInt();
		}
		int ans=0;
		while(true) {
			int t=dp[0];
			for(int i=0;i<n-1;i++) {
				dp[i]-=dp[i]/2;
				dp[i]+=dp[i+1]/2;
				if((dp[i]&1)==1) {
					ans++;
					dp[i]++;
				}
			}
			dp[n-1]-=dp[n-1]/2;
			dp[n-1]+=t/2;
			if((dp[n-1]&1)==1) {
				dp[n-1]++;
				ans++;
			}
			if(check(dp)) {
				System.out.println(ans);
				break;
			}
				
		}
	}

}
