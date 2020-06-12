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


时间问题：
在竞赛中，一般百算机一秒能运行5 x 10^8次汁算，
一般 O(n)的算度法数据范围n < 10^8。
O(n *logn)的算法专数属据范围n <= 10^6。
O(n*sqrt(n) )的算法数据范围n < 10^5。
O(n^2)的算法数据范围n<5000。
O(n^3)的算法数据范围n <300。
O(2^n)的算法数据范围n < 25。
O(n!)的算法数据范围n < 11。 

这题的本质是从给定长度的序列中 统计连续序列（注意是连续的 也就是子串）的和
满足条件的区间之和为K的倍数
算法时间复杂度得优化成n*log(n)级别的才能通过所有样例
可以优化的地方在

可能用到的知识点：
1、区间求和 :用到高中数列求和的知识
f(i)表示到i位置（包括i）的累加和
则f(j)-f(i)(j>=i)表示区间[i+1,j]的累加和

注意几个问题：
1、 10^8的数据规模 n^2复杂度的话肯定是超时的了最多可以通过规模小于10^3的数据

 */
package 第八届;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月25日 下午4:44:06
*/
public class t10_k倍区间 {

	private static int N,K;
	static int[] a;
	static int[] dp;

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		K=reader.nextInt();
		a=new int[N+1];
		//dp数组存放累加和 dp[i]表示[1,i]的累加和
		dp=new int[N+1];
		for (int i = 1; i <= N; i++) {
			a[i]=reader.nextInt();
			dp[i]=a[i]+dp[i-1];
		}
		int ans=0;
		//dp[j]-dp[i] 表示[i+1,j]这一区间的和
		for (int i = 0; i <= N; i++) {
			for(int j=i+1;j<=N;j++) {
				if((dp[j]-dp[i])%K==0) {
					ans++;
				}
			}
		}
		System.out.println(ans);

	}

}
