/*

���⣺ k������

����һ������ΪN�����У�A1, A2, ... AN���������һ��������������Ai, Ai+1, ... Aj(i <= j)֮����K�ı��������Ǿͳ��������[i, j]��K�����䡣  

��������������ܹ��ж��ٸ�K��������  

����
-----
��һ�а�����������N��K��(1 <= N, K <= 100000)  
����N��ÿ�а���һ������Ai��(1 <= Ai <= 100000)  

���
-----
���һ������������K���������Ŀ��  


���磬
���룺
5 2
1  
2  
3  
4  
5  

����Ӧ�������
6

��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 2000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
 */
/*
����˼· ��ÿ���ۼӺ�mod��K �õ�����
��ͬ������ͬ�ࣩ�������ֵ��k�ı���
����
k=2

ԭ��		1 	2 	3 	4 	5
�ۼӺ�	1	3	6	10	15
%K����	1	1	0	0	1
������Ϊ0���У�	f(4) f(3) 		1
������Ϊ1���У�	f(1) f(2) f(5)	
ת��Ϊ��������� ��ͬ����ۼӺ���ȡ������Ϊ����˵�����

����ͬ����

ģ������������������
(a + b) % g = (a % g + b % g) % g 
(a - b) % g = (a % g - b % g) % g 
(a * b) % g = (a % g * b % g) % g 
a ^ b % g = ((a % g)^b) % g 

����ɣ�
((a+b) % g + c) % g = (a + (b+c) % g) % g 

�����ɣ�
((a +b)% g * c) % g = ((a * c) % g + (b * c) % g) % g 
 */
package �ڰ˽�;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��5��25�� ����5:29:08
*/
public class t10_k������_�Ż� {

	private static int N,K;
	//dp�������ۼӺ�
	static long[] dp;
	//cntͳ����ͬ�����ĸ���
	static int[] cnt;
	static int p;

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		K=reader.nextInt();
		//dp�������ۼӺ� 	dp[i]��ʾ[1,i]���ۼӺ�
		dp=new long[N+1];
		cnt=new int[N+1];
		
		cnt[0]=1;
		for (int i = 1; i <= N; i++) {
			int x=reader.nextInt();
			dp[i]=(x+dp[i-1]);
			int index=(int) (dp[i]%K);
			cnt[ index ]++;
			
		}
		//ans���ܿ���int�� ��Ϊ��k=1��N=10000ʱcnt[i]*(cnt[i]-1)���������ͷ�Χ  
		long ans=0;
		//modK��� ��Χ��0~k-1
		for (int i = 0; i <K; i++) {
			//��תΪlong��  ����˳����������long����ת
			ans+=(long)cnt[i]*(cnt[i]-1)/2;
		}
		System.out.println(ans);

	}
}
