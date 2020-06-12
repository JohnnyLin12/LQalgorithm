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

public class t08_分糖果 {
	static boolean check(int [] arra) {
		for (int i = 0; i < arra.length-1; i++) {
			if(arra[i]!=arra[i+1]) {
				return false;
			}
		}
		return true;
	}
	static void show(int dp[]) {
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		int cnt=0;
		int dp[] =new int[n];
		for (int i = 0; i < n; i++) {
			dp[i]=reader.nextInt();
		}
		do{
			for (int i = 0; i < dp.length; i++) {
				int k=dp[(i+1)%n]; ///2+(dp[(i+1)%n]&1); 
				int tmp=k/2+k&1;
				dp[i]+=k-tmp;// 
				dp[(i+1)%n]=tmp;
			}
			show(dp);
			if(check(dp)) {
				break;
			}
			for (int i = 0; i < dp.length; i++) {
				if((dp[i]&1)==1) {
					dp[i]++;
					cnt++;
				}
			}
			
			
		}while(true);
		System.out.println(cnt);
		
	}

}
