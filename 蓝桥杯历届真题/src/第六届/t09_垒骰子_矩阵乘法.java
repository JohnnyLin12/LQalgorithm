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

public class t09_垒骰子_矩阵乘法 {
	static int [] op=new int[7];
	static int n,m;
	private static final long mod=1000000000+7;
	static void init() {
		op[1]=4;
		op[2]=5;
		op[3]=6;
		op[4]=1;
		op[5]=2;
		op[6]=3;
	}

	public static void main(String[] args) {
		init();
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();
		m=reader.nextInt();
		long conflict[][]=new long[6][6];
		for(int i=0;i<6;i++) {
			for (int j = 0; j < 6; j++) {
				conflict[i][j]=1;
				}
			}
		//建立冲突矩阵
		for(int i=0;i<m;i++) {
			int x=reader.nextInt();
			int y=reader.nextInt();
			conflict[ op[x]-1 ][y-1]=0;
			conflict[ op[y]-1 ][x-1]=0;
		}
		//求冲突矩阵的n-1次方
		long [][] mPow_n_1=mPow(conflict,n-1);
		//累加mPow_n_1矩阵
		long ans=0;
		for(int i=0;i<6;i++) {
			for (int j = 0; j < 6; j++) {
				ans= ( ans+mPow_n_1[i][j] )%mod;
			}
		}
		System.out.println(ans*quick_Pow(4,n)%mod);
}
	//求i的n次方快速幂
	private static long quick_Pow(long i, int n) {
		long ret=1;
		while(n!=0) {
			if( (n&1)==1) {
				ret=(ret*i)%mod;
			}
			i=(i*i)%mod;
			n>>=1;
		}
		return ret;
	}
	
	/*
	 * 矩阵的快速幂
	 */
	private static long[][] mPow(long[][] conflict, int n) {
		long [][] ans=new long[6][6];
		
		//单位矩阵：对角线为1 其余皆为0
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(i==j) {
					ans[i][j]=1;
				}else {
					ans[i][j]=0;
				}
				
			}
			
		}
		while(n!=0) {
			if((n&1)==1) {//该位上为1 ans矩阵与conflict矩阵相乘
				ans=mMul(ans,conflict);
			}
			conflict=mMul(conflict,conflict);
			//n右移一位 除以2
			n>>=1;
		}
		return ans;
		
	}
	//矩阵乘法
	private static long[][] mMul(long[][] a, long[][] b) {
		long [][] ans=new long[6][6];
		for(int i=0;i<6;i++) {
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 6; k++) {
					ans[i][j]=( ans[i][j]+a[i][k]*b[k][j] )%mod;
				}
			}
		}
		return ans;
	}

}
