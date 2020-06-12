/*

标题：包子凑数

小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。每种蒸笼都有非常多笼，可以认为是无限笼。

每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。比如一共有3种蒸笼，分别能放3、4和5个包子。当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个的再加2笼4个的）。

当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。而顾客想买7个包子时，大叔就凑不出来了。

小明想知道一共有多少种数目是包子大叔凑不出来的。

输入
----
第一行包含一个整数N。(1 <= N <= 100)
以下N行每行包含一个整数Ai。(1 <= Ai <= 100)  

输出
----
一个整数代表答案。如果凑不出的数目有无限多个，输出INF。

例如，
输入：
2  
4  
5   

程序应该输出：
6  

再例如，
输入：
2  
4  
6    

程序应该输出：
INF

样例解释：
对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。  
对于样例2，所有奇数都凑不出来，所以有无限多个。  



资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
提交程序时，注意选择所期望的语言类型和编译器类型。



 */
/*
这简直就是道数学题
本质是判断 方程a*x+ a1*x1+……+an*xn=c（a为每笼包子个数） 
有无解 无解即为INF 有解输出个数
根据欧几里得定理：
ax+by=c	
1、若a，b互质 则x，y一定有解且有无穷多个解
若要使解x,y>=0，则使得ax+by=c无解（也就是存在c凑不出来）c的范围时a*b-a-b

2、若a、b不互质 则不能保证有解 也就是存在无限多个c凑不出来（有解的充分必要条件是：c%gcd(a,b)==0）


 */
package 第八届;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月24日 下午10:10:39
*/
public class t08_包子凑数 {
	static int n,g;
	static int a[]=new int[101];
	static boolean[] dp=new boolean[10000];
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();
		//注意0 这数目时可以凑得的
		dp[0]=true;
		for (int i = 1; i <= n; i++) {
			a[i]=reader.nextInt();
			
			if(i==1) g=a[i];//初始化最大公约数
			else g=gcd(a[i],g);
			//新增a[i]这个笼子 在原先可以凑得的数目上a[i]这些数目都可以凑到
			for(int j=0;j<10000-a[i];j++) {
				if(dp[j]) dp[j+a[i]]=true;
			}
		}
		if(g!=1) {
			System.out.println("INF");
			System.exit(0);
		}
		int ans=0;
		for(int j=0;j<10000;j++) {
			if(!dp[j]) {
				ans++;
			}
		}
		System.out.println(ans);

	}
	/**
	 * @param a
	 * @param b
	 * @return
	 * gcd(4,6)==2
	 * gcd(3,4)==1
	 */
	private static int gcd(int a, int b) {
		//辗转相除
		if(b==0)return a;
		return gcd(b,a%b);
	}

}
