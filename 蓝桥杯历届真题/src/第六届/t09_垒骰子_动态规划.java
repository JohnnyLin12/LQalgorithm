/*

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
package 第六届;

import java.util.Scanner;

public class t09_垒骰子_动态规划 {
	static final int mod=1000000000+7;
	
	static long mypow(int x,int y) {
		long res=1;
		for(int i=1;i<=y;i++) {
			res*=x;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		//n个骰子
		int n=reader.nextInt();

		int m=reader.nextInt();
		//对立面
		int [] op=new int[] {0,4,5,6,1,2,3};

		//m组互斥对
		boolean [][] confilct=new boolean[7][7];
		for(int i=0;i<m;i++) {
			int x=reader.nextInt();
			int y=reader.nextInt();
			confilct[x][y]=true;
			confilct[y][x]=true;
		}
		//dp[i][j] 表示第i层 该层朝上数字为j时的可行方案数
		//由图中的递推式可知本层方案数目只与上一层有关 故可以用两行的动态数组保存方案数
		int [][] dp=new int[2][7];
		for(int i=1;i<=6;i++) {
			dp[0][i]=1;
		}
		//迭代的层数	
		for(int i=1;i<n;i++) {
			//面朝上的数字
			for(int j=1;j<=6;j++) {
				for(int x=1;x<=6;x++) {
					if(confilct[j][ op[x] ]) continue;
					dp[ i%2 ][j]=(dp[ i%2 ][j]+dp[(i-1)%2 ][x]);
				}
			}
		}
		long ans=0;
		for(int i=1;i<=6;i++) {
			ans+=dp[(n-1)%2][i];
		}
		ans=mypow(4,n)*ans%mod;
		System.out.println(ans);
		
	}
	
}
