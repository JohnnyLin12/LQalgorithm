/*

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
package ������;

import java.util.Scanner;

public class t09_������_��̬�滮 {
	static final int mod=1000000000+7;
	
	static long mypow(int x,int y) {
		long res=1;
		for(int i=1;i<=y;i++) {
			res*=x;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		//n������
		int n=reader.nextInt();

		int m=reader.nextInt();
		//������
		int [] op=new int[] {0,4,5,6,1,2,3};

		//m�黥���
		boolean [][] confilct=new boolean[7][7];
		for(int i=0;i<m;i++) {
			int x=reader.nextInt();
			int y=reader.nextInt();
			confilct[x][y]=true;
			confilct[y][x]=true;
		}
		//dp[i][j] ��ʾ��i�� �ò㳯������Ϊjʱ�Ŀ��з�����
		//��ͼ�еĵ���ʽ��֪���㷽����Ŀֻ����һ���й� �ʿ��������еĶ�̬���鱣�淽����
		int [][] dp=new int[2][7];
		for(int i=1;i<=6;i++) {
			dp[0][i]=1;
		}
		//�����Ĳ���	
		for(int i=1;i<n;i++) {
			//�泯�ϵ�����
			for(int j=1;j<=6;j++) {
				for(int x=1;x<=6;x++) {
					if(confilct[j][ op[x] ]) continue;
					dp[ i%2 ][j]=(dp[ i%2 ][j]+dp[(i-1)%2 ][x]);
				}
			}
		}
		long ans=0;
		for(int i=1;i<=6;i++) {
			ans+=dp[(n-1)%2][i];
		}
		ans=mypow(4,n)*ans%mod;
		System.out.println(ans);
		
	}
	
}
