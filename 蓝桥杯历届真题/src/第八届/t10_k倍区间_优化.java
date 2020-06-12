/*

标题： k倍区间

给定一个长度为N的数列，A1, A2, ... AN，如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <= j)之和是K的倍数，我们就称这个区间[i, j]是K倍区间。  

你能求出数列中总共有多少个K倍区间吗？  

输入
-----
第一行包含两个整数N和K。(1 <= N, K <= 100000)  
以下N行每行包含一个整数Ai。(1 <= Ai <= 100000)  

输出
-----
输出一个整数，代表K倍区间的数目。  


例如，
输入：
5 2
1  
2  
3  
4  
5  

程序应该输出：
6

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
 */
/*
换个思路 对每个累加和mod上K 得到的是
相同余数（同余）的区间差值是k的倍数
例如
k=2

原数		1 	2 	3 	4 	5
累加和	1	3	6	10	15
%K余数	1	1	0	0	1
余数都为0的有：	f(4) f(3) 		1
余数都为1的有：	f(1) f(2) f(5)	
转化为求组合问题 从同余的累加和中取两个作为区间端点作差

从相同余数

模运算与四则运算类似
(a + b) % g = (a % g + b % g) % g 
(a - b) % g = (a % g - b % g) % g 
(a * b) % g = (a % g * b % g) % g 
a ^ b % g = ((a % g)^b) % g 

结合律：
((a+b) % g + c) % g = (a + (b+c) % g) % g 

分配律：
((a +b)% g * c) % g = ((a * c) % g + (b * c) % g) % g 
 */
package 第八届;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月25日 下午5:29:08
*/
public class t10_k倍区间_优化 {

	private static int N,K;
	//dp数组存放累加和
	static long[] dp;
	//cnt统计相同余数的个数
	static int[] cnt;
	static int p;

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		K=reader.nextInt();
		//dp数组存放累加和 	dp[i]表示[1,i]的累加和
		dp=new long[N+1];
		cnt=new int[N+1];
		
		cnt[0]=1;
		for (int i = 1; i <= N; i++) {
			int x=reader.nextInt();
			dp[i]=(x+dp[i-1]);
			int index=(int) (dp[i]%K);
			cnt[ index ]++;
			
		}
		//ans不能开成int型 因为当k=1，N=10000时cnt[i]*(cnt[i]-1)超过了整型范围  
		long ans=0;
		//modK后的 范围在0~k-1
		for (int i = 0; i <K; i++) {
			//先转为long型  后面乘除都遵照这个long型来转
			ans+=(long)cnt[i]*(cnt[i]-1)/2;
		}
		System.out.println(ans);

	}
}
