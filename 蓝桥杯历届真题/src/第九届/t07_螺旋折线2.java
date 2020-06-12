/*
 这是一道数学题 得找到规律才能解
 以y=-x将螺旋折线 划分为如图两个区域
 在右上角区域 每一个所截得的线段长度分别为 4 8 12……
 为首项a1=4 公差d=4的等差数列
 要计算每一个给定点的dis 即可以以右下角点为参照点
 进行step步的位移操作即可得到
 
 右下角点长度为s(n)=(a(1)+a(n))*n/2=a(1)+(n*(n-1)d)/2
 */
package 第九届;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年6月4日 下午1:41:18
*/
public class t07_螺旋折线2 {

	public static void main(String[] args) {
		Scanner reader=new Scanner (System.in);
		//0 1
		int X=reader.nextInt();
		int Y=reader.nextInt();
		long dis=1;
		long n=0,ans=0;
		//区域一
		if(Y>0&&Math.abs(X)<=Y) {
			//第几项
			n=Y;
			//跟右下角参照点的差距
			dis=Y-X+2*Y;
		}else if(X>0&&Math.abs(Y)<=X) {	//区域二
			n=X;
			dis=Y+X;
		}else if(Y<=0&&X>=Y-1&&X<=-Y) {//区域三
			n=-Y;
			dis=-(-Y-X);
		}else if(X<0&&Y>=X+1&&Y<=-X) {	//区域四
			n=-X-1;
			dis=-(Y-X-1-2*X-1);
		}
		System.out.println(sum(1L,2*n,1)*2-dis);
	}
	static long sum(long a,long  n,int d) {
		return (a+a+(n-1)*d)*n/2;
	}

}
