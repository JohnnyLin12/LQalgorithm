/*
 
标题：复数幂

设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。
答案写成 "实部±虚部i" 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。(2+3i)^2 写成: -5+12i，
(2+3i)^5 的写成: 122-597i


注意：需要提交的是一个很庞大的复数，不要填写任何多余内容。
4043220979119144065		-7374402350132176768i
 */
package 第九届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月28日 下午8:55:11
*/
public class t03_复数幂 {
	//定义复数运算
	public static void main(String[] args) {
		long a=2;
		long b=3;
		long c=2;
		long d=3;
		long first=0;
		long second=0;
//		for(int i=1;i<=1;i++) {
//			first=a*c-b*d;
//			second=2*a*d;
//			a=c=first;
//			b=d=second;
//		}
		//123456 *123455个
		for(int i=1;i<=123455;i++) {
			long t=a*c-b*d;//4
			long k=b*c+a*d;
			c=t;
			d=k;
		}
		System.out.println(c+"		"+d);
		//System.out.println(first+"		"+second);
		
		
		
		
		
		
		
		
		
	}
}
