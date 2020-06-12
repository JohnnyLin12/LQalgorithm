/*题目描述
垒骰子
赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。
经过长期观察，atm 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！
我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。
假设有 m 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。 atm想计算一下有多少种不同的可能的垒骰子方式。
两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。
由于方案数可能过多，请输出模 10^9 + 7 的结果。

不要小看了 atm 的骰子数量哦～

「输入格式」
第一行两个整数 n m
n表示骰子数目
接下来 m 行，每行两个整数 a b ，表示 a 和 b 不能紧贴在一起。

「输出格式」
一行一个数，表示答案模 10^9 + 7 的结果。

「样例输入」
2 1
1 2
「样例输出」
544
 */
//这种暴力法只能通过30%的数据
package 第六届;

import java.util.ArrayList;
import java.util.Scanner;

public class t09_垒骰子 {
	static final long mod=1000000000+7;
	static int [][]a;
	static int atm[];
	//骰子对面 1-4  2-5 3-6
	static int duimian[]= {0,4,5,6,1,2,3};
	static int n;
	static long ans;
	static ArrayList []huchi;
	static long mypow(int x,int y) {
		long res=1;
		for(int i=1;i<=y;i++) {
			res*=x;
		}
		return res;
	}
	static void dfs(int r) {
		if(r==n) {
			ans++;
			return;
		}
		for(int i=1;i<=6;i++) {
			if(r>=1) {
				if(!huchi[ atm[r-1] ].contains(i)) {
					atm[r]=i;
					dfs(r+1);
				}
			}
			else {
				atm[r]=i;
				dfs(r+1);				
			}
		}
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		//n个骰子
		n=reader.nextInt();
		//m组互斥对
		int m=reader.nextInt();
		a=new int[m][2];
		atm=new int[n];
		huchi=new ArrayList[7];
		for(int i=1;i<=6;i++) {
			huchi[i]=new ArrayList();
		}
		//1 2 5
		//2 1 4
		//4*4  
		/*用链表记录互斥对数字
		 * 1-4  2-5 3-6
		 */
		for(int i=0;i<m;i++) {
			int x=reader.nextInt();
			int y=reader.nextInt();			
			huchi[x].add(duimian[y]);
			huchi[y].add(duimian[x]);
		}
		dfs(0);
		//因为每个骰子四个面对应四种不同结果，所以还要乘上4^n
		//原题目：两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。
		ans=( mypow(4,n)*ans)%mod;
		System.out.println(ans);
	}
	
}
