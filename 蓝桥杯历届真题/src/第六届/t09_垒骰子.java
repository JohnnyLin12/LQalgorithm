/*��Ŀ����
������
��ʥatm�����������������ӣ����ǰ�����һ��������һ���ϱߣ���������ŤŤ��Ҫ�ݳɷ����塣
�������ڹ۲죬atm �������ȶ����ӵİ��أ���Щ���ֵ������Żụ���ų⣡
���������淶һ�����ӣ�1 �Ķ����� 4��2 �Ķ����� 5��3 �Ķ����� 6��
������ m �黥������ÿ���е����������ֵ��������һ�����ӾͲ����ȶ����������� atm�����һ���ж����ֲ�ͬ�Ŀ��ܵ������ӷ�ʽ��
���������ӷ�ʽ��ͬ�����ҽ��������ַ�ʽ�ж�Ӧ�߶ȵ����ӵĶ�Ӧ���ֵĳ�����ͬ��
���ڷ��������ܹ��࣬�����ģ 10^9 + 7 �Ľ����

��ҪС���� atm ����������Ŷ��

�������ʽ��
��һ���������� n m
n��ʾ������Ŀ
������ m �У�ÿ���������� a b ����ʾ a �� b ���ܽ�����һ��

�������ʽ��
һ��һ��������ʾ��ģ 10^9 + 7 �Ľ����

���������롹
2 1
1 2
�����������
544
 */
//���ֱ�����ֻ��ͨ��30%������
package ������;

import java.util.ArrayList;
import java.util.Scanner;

public class t09_������ {
	static final long mod=1000000000+7;
	static int [][]a;
	static int atm[];
	//���Ӷ��� 1-4  2-5 3-6
	static int duimian[]= {0,4,5,6,1,2,3};
	static int n;
	static long ans;
	static ArrayList []huchi;
	static long mypow(int x,int y) {
		long res=1;
		for(int i=1;i<=y;i++) {
			res*=x;
		}
		return res;
	}
	static void dfs(int r) {
		if(r==n) {
			ans++;
			return;
		}
		for(int i=1;i<=6;i++) {
			if(r>=1) {
				if(!huchi[ atm[r-1] ].contains(i)) {
					atm[r]=i;
					dfs(r+1);
				}
			}
			else {
				atm[r]=i;
				dfs(r+1);				
			}
		}
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		//n������
		n=reader.nextInt();
		//m�黥���
		int m=reader.nextInt();
		a=new int[m][2];
		atm=new int[n];
		huchi=new ArrayList[7];
		for(int i=1;i<=6;i++) {
			huchi[i]=new ArrayList();
		}
		//1 2 5
		//2 1 4
		//4*4  
		/*�������¼���������
		 * 1-4  2-5 3-6
		 */
		for(int i=0;i<m;i++) {
			int x=reader.nextInt();
			int y=reader.nextInt();			
			huchi[x].add(duimian[y]);
			huchi[y].add(duimian[x]);
		}
		dfs(0);
		//��Ϊÿ�������ĸ����Ӧ���ֲ�ͬ��������Ի�Ҫ����4^n
		//ԭ��Ŀ�����������ӷ�ʽ��ͬ�����ҽ��������ַ�ʽ�ж�Ӧ�߶ȵ����ӵĶ�Ӧ���ֵĳ�����ͬ��
		ans=( mypow(4,n)*ans)%mod;
		System.out.println(ans);
	}
	
}
