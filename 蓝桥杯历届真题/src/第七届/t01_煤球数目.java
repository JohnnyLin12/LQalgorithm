/*

煤球数目

有一堆煤球，堆成三角棱锥形。具体：
第一层放1个，
第二层3个（排列成三角形），
第三层6个（排列成三角形），
第四层10个（排列成三角形），
....
如果一共有100层，共有多少个煤球？

请填表示煤球总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

 */
/*
思路
n:		1 2 3 4 5 6 7 8 9 10
f(n)	1 3 6 10 15 21 28 36 45 55

f(1)=1
f(2)=f(1)+2
f(3)=f(2)+3
……
递推式：
f(n)=f(n-1)+n

 */
package 第七届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月10日 下午1:32:03
*/
public class t01_煤球数目 {

	public static void main(String[] args) {
		int a[]=new int[101];
		a[1]=1;
		int sum=a[1];
		for(int i=2;i<a.length;i++) {
			a[i]=a[i-1]+i;
			sum+=a[i];
		}
		//System.out.println(a[100]);
		System.out.println(sum);

	}

}
