/*
饮料换购

乐羊羊饮料厂正在举办一次促销优惠活动。乐羊羊C型饮料，凭3个瓶盖可以再换一瓶C型饮料，并且可以一直循环下去，但不允许赊账。

请你计算一下，如果小明不浪费瓶盖，尽量地参加活动，那么，对于他初始买入的n瓶饮料，最后他一共能得到多少瓶饮料。

输入：一个整数n，表示开始购买的饮料数量（0<n<10000）
输出：一个整数，表示实际得到的饮料数

例如：
用户输入：
100
程序应该输出：
149

用户输入：
101
程序应该输出：
151


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
 */
package 第六届;

import java.util.Scanner;

public class t08_饮料换购 {
	static  int ans;
	//
	static void dfs(int n,int sum) {
		//但最后一次换购要注意
		if(n<3) {
			System.out.println(ans+sum);
			System.exit(0);
		}
		//3个瓶盖可以再换一瓶 等价为每两瓶换得一瓶
		dfs(n-2,sum+1);
	}

	public static void main(String[] args) {
		//原先有n瓶饮料 兑换得到的饮料数
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		ans=n;
		dfs(n,0);
	}

}
