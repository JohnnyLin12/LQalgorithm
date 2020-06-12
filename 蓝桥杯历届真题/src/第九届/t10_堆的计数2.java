/*
 
标题：堆的计数

我们知道包含N个元素的堆可以看成是一棵包含N个节点的完全二叉树。  
每个节点有一个权值。对于小根堆来说，父节点的权值一定小于其子节点的权值。  

假设N个节点的权值分别是1~N，你能求出一共有多少种不同的小根堆吗？  

例如对于N=4有如下3种：

    1
   / \
  2   3
 /
4

    1
   / \
  3   2
 /
4

    1
   / \
  2   4
 /
3

由于数量可能超过整型范围，你只需要输出结果除以1000000009的余数。  


【输入格式】
一个整数N。  
对于40%的数据，1 <= N <= 1000  
对于70%的数据，1 <= N <= 10000  
对于100%的数据，1 <= N <= 100000

【输出格式】
一个整数表示答案。  

【输入样例】
4  

【输出样例】
3


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。

 */
/*
 *利用小根堆性质  递归算法解决
 在1~N范围 小根堆的根是1~N范围的最小值1
 为左子树选根 假设有l种 为右子树选根 假设有r种 
 以1为根派生出左右子树 再在剩下N-1个数字中选择没有被选过的
 且大于根的数字作为新子树的根 这是一个递归建立小根堆的过程
 
 实质上为左右子树选根的过程就相当于给左子树划分集合的过程 
假设为左子树选定lsize个结点 则右结点数也确定下来了 
总的选根方案数为 :N-1选lisze的组合数  即C(N-1,lisze)
则总的堆的个数为：d(1)=C(N-1,lsize)*d(l)*d(r)
其中d(i)表示以编号为i的结点为根的堆的方案数

1、确定N-1和l、r
目标式子的递推式：
d(x)=C(size(x)-1,size(2*x))*d(2*x)*d(2*x+1)
其中size(i)表示根节点是编号为i的结点的树的结点总数目
例如N=5时
d(1)=C(4,3)*d(2)*d(3)
d(2)=C(2,1)*d(4)*d(5)
叶子节点的堆的方案数为1
d(3)=C(1,1)=1
d(4)=d(5)=1
所以总的方案数：d(1)=4*2=8

2、求组合数C(N,lsize)
c(N,lsize)=N!/(N-lsize)!/ lsize!
对阶乘进行预处理
在求阶乘过程已经对上式子求余过
对于组合数最终仍需要求余
除法求余要根据费马小定理转化为模的逆元 这里就不展开讲了
举个例子
a/b %mod模的除法没有分配律 不等于a%mod /b%mod
而是等于a*(b关于模的逆元)
而b关于模的逆元为 a^(mod-2)
求幂过程使用快速幂
所以c(N,lsize)=N!* quicikPow( (N-lsize)!,mod-2 ) * quickPow(lsize!,mod-2)
lsize






 
 
 */
package 第九届;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年6月1日 下午9:54:08
*/
public class t10_堆的计数2 {
	static final int mod= 1000000009;
	static int N;
	static int[]size;//记录每个结点的size 	size[i]表示根节点是编号为i的结点的树的总结点数
	static long[] a;//记录1~N的阶乘 	a[i]表示i!
	static long[] inv;//记录1~N阶乘的逆元 	inv[i]表示i的逆元
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		N = reader.nextInt();
		size=new int[N+1];
		a=new long[N+1];
		inv=new long[N+1];
		initSize();
		initA();
		System.out.println(dp());
	}
	private static void initSize() {
//		for(int i=N;i>=1;i--) {
//			if(2*i+1<=N) {
//				size[i]=size[2*i]+size[2*i+1]+1;
//			}else if(2*i<=N) {
//				size[i]=size[2*i+1]+1;
//			}else {
//				size[i]=1;
//			}
//		}
		//可简写成如下
		for(int i=N;i>=1;i--) {//
			size[i] = 1 + (2*i<=N?size[2*i]:0)+(2*i+1<=N?size[2*i+1]:0);//size[i]<=n所以不用取余
			}
	}
	private static void initA() {
		a[0]=1;
		inv[0]=1;//千万注意要初始化 
		for(int i=1;i<=N;i++) {
			//求阶乘过程可能超过int 因此要先取余
			a[i]=a[i-1]*i%mod;
			//求i阶乘的逆元
			inv[i]=quickPow(a[i],mod-2);
		}
		//show2(a)
	}
	private static long dp() {
		//dp[i]表示编号为i的小根堆种数
		long [] d=new long[N+1];
		for(int x=N;x>=1;x--) {
			if(2*x+1<=N)
				d[x]=C(size[x]-1,size[2*x])*d[2*x]%mod*d[2*x+1]%mod;
			else if(2*x<=N)
				d[x]=C(size[x]-1,size[2*x])*d[2*x]%mod;
			else 
				d[x]=1;
				
		}
		return d[1];
	}
	//计算组合数
	static long C(int N,int lsize) {
		//c(n,lsize)=N!* quicikPow( (N-lsize)!,mod-2 ) * quickPow(lsize!,mod-2)
		return a[N]*inv[ lsize ]%mod*inv[ N-lsize ]%mod;
	}
	
	/**
	 * @param a
	 * @param y
	 * @return 
	 * 快速求解x的y次方
	 */
	private static long quickPow(long a, int n) {
		if(a==0)
			return 0;
		long ans=1;
		long x=a;
		while(n>0) {
			if((n&1)==1)
				ans=ans*x%mod;
			n>>=1;
			x=x*x%mod;
		}
		return ans;
	}
	private static void show(long[] d) {
		for(int i=N;i>=1;i--) {
			System.out.print(d[i]+" ");
		}
		System.out.println();
	}
	private static void show2(int[] d) {
		for(int i=N;i>=1;i--) {
			System.out.print(d[i]+" ");
		}
		System.out.println();
		
	}



}
