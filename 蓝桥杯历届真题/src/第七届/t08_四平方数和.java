/*

��ƽ����

��ƽ���Ͷ����ֳ�Ϊ�������ն���
ÿ�������������Ա�ʾΪ����4����������ƽ���͡�
�����0������ȥ�������ÿ��Ա�ʾΪ4������ƽ���͡�

���磺
5 = 0^2 + 0^2 + 1^2 + 2^2
7 = 1^2 + 1^2 + 1^2 + 2^2
��^���ű�ʾ�˷�����˼��

����һ�������������������ܴ��ڶ���ƽ���͵ı�ʾ����
Ҫ�����4��������
0 <= a <= b <= c <= d
�������еĿ��ܱ�ʾ���� a,b,c,d Ϊ���������������У���������һ����ʾ��


��������Ϊһ��������N (N<5000000)
Ҫ�����4���Ǹ�����������С���������м��ÿո�ֿ�

���磬���룺
5
�����Ӧ�������
0 0 1 2

�����磬���룺
12
�����Ӧ�������
0 2 2 2

�����磬���룺
773535
�����Ӧ�������
1 1 267 838

��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 3000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��

 */
package ���߽�;
/**
* @author JohnnyLin
* @version Creation Time��2020��5��10�� ����4:49:03
*/


import java.util.Scanner;

public class t08_��ƽ������ {
	static int n,root;
	static int a[] =new int [4];
	static int ans;
	/**
	 * @param index ��ǰ����a[index]���Ԫ��
	 * @param k ��ǰ��ѡ������k
	 * @param sum ��ǰ��ѡ����������ƽ����
	 */
	static void dfs(int index,int k,int sum) {
		
		if(sum>n) {
			return;
		}
		if(index==4) {
			if(sum==n) {
				System.out.println(a[0]+" "+a[1]+" "+a[2]+" "+a[3]);
				System.exit(0);
			}
			return;
		}
		//��0��sqrt(n)ѡһ����
		for(int i=k;i<=root;i++) {
			a[index]=i;
			dfs(index+1,i,sum+i*i);
			a[index]=0;
		}
	}
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
			n=reader.nextInt();
			root=(int) Math.sqrt((double)n);
			dfs(0,0,0);
		
	}

}
