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

public class t09_������_����˷� {
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
		//������ͻ����
		for(int i=0;i<m;i++) {
			int x=reader.nextInt();
			int y=reader.nextInt();
			conflict[ op[x]-1 ][y-1]=0;
			conflict[ op[y]-1 ][x-1]=0;
		}
		//���ͻ�����n-1�η�
		long [][] mPow_n_1=mPow(conflict,n-1);
		//�ۼ�mPow_n_1����
		long ans=0;
		for(int i=0;i<6;i++) {
			for (int j = 0; j < 6; j++) {
				ans= ( ans+mPow_n_1[i][j] )%mod;
			}
		}
		System.out.println(ans*quick_Pow(4,n)%mod);
}
	//��i��n�η�������
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
	 * ����Ŀ�����
	 */
	private static long[][] mPow(long[][] conflict, int n) {
		long [][] ans=new long[6][6];
		
		//��λ���󣺶Խ���Ϊ1 �����Ϊ0
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
			if((n&1)==1) {//��λ��Ϊ1 ans������conflict�������
				ans=mMul(ans,conflict);
			}
			conflict=mMul(conflict,conflict);
			//n����һλ ����2
			n>>=1;
		}
		return ans;
		
	}
	//����˷�
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
