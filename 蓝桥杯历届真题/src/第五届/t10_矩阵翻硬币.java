/*
问题描述
小明先把硬币摆成了一个 n 行 m 列的矩阵。
随后，小明对每一个硬币分别进行一次 Q 操作。
对第x行第y列的硬币进行 Q 操作的定义：将所有第 i*x 行，第 j*y 列的硬币进行翻转。
其中i和j为任意使操作可行的正整数，行号和列号都是从1开始。
当小明对所有硬币都进行了一次 Q 操作后，他发现了一个奇迹——所有硬币均为正面朝上。
小明想知道最开始有多少枚硬币是反面朝上的。于是，他向他的好朋友小M寻求帮助。
聪明的小M告诉小明，只需要对所有硬币再进行一次Q操作，即可恢复到最开始的状态。
然而小明很懒，不愿意照做。于是小明希望你给出他更好的方法。帮他计算出答案。

输入格式
　　输入数据包含一行，两个正整数 n m，含义见题目描述。
输出格式
　　输出一个正整数，表示最开始有多少枚硬币是反面朝上的。
样例输入
2 3
样例输出
1
数据规模和约定
　　对于10%的数据，n、m <= 10^3；
　　对于20%的数据，n、m <= 10^7；
　　对于40%的数据，n、m <= 10^15；
　　对于100%的数据，n、m <= 10^1000（10的1000次方）。

gg 不会 看了题解 基本是道数学题 
思路是：
通过硬币被翻的次数来确定是正面朝上还是反面朝上 
如果一枚硬币总共被翻了奇数次最终正面 那么原来状态肯定是反面朝上
对于一枚硬币 需要同时考虑行x和列y 也就是说它会被翻： 行x的被翻的次数（假设为a）乘以列y被翻的次数（假设为b）
因此a、b需均为奇数  而完全平方数有奇数个约数 也就是说 x、y均为完全平方数（完全平方数就是n^2，n为自然数，也就是0，2，4，9……）
因此问题转化为求完全平方数

 */
package 第五届;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class t10_矩阵翻硬币 {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String n=reader.next();
		String m=reader.next();
		System.out.println(sqrt(n).multiply(sqrt(m)));
	}
	private static BigInteger sqrt(String s) {
		//被开方数的位数
		int length=s.length();
		
		//被开方数 约数的位数
		int len=0;
		
		if((length&1)==0)
			len=length/2;
		else
			len=length/2+1;
		
		char[] sArr=new char[len];
		Arrays.fill(sArr, '0');
		BigInteger target = new BigInteger(s);
		//逐位试填
		for(int i=0;i<len;i++) {
			for(char a='1';a<='9';a++) {
				sArr[i]=a;
				BigInteger bigInteger = new BigInteger(String.valueOf(sArr)).pow(2);
				if(bigInteger.compareTo(target)==1) {//试探的平方数更大 则回退一位
					sArr[i]-=1;
					break;
				}
			}
		}
		return new BigInteger(String.valueOf(sArr));
	}

}
