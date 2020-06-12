/*

���⣺ ���ɿ���

    ��ͯ��������KλС���ѵ�С�������͡�С���ó�����ص��ɿ����д�С�����ǡ�
    С��һ����N���ɿ��������е�i����Hi x Wi�ķ�����ɵĳ����Ρ�

    Ϊ�˹�ƽ�����С����Ҫ���� N ���ɿ������г�K���ɿ����ָ�С�����ǡ��г����ɿ�����Ҫ���㣺

    1. ��״�������Σ��߳�������  
    2. ��С��ͬ  

����һ��6x5���ɿ��������г�6��2x2���ɿ�������2��3x3���ɿ�����

��ȻС�����Ƕ�ϣ���õ����ɿ��������ܴ����ܰ�С����������ı߳��Ƕ���ô��

����
��һ�а�����������N��K��(1 <= N, K <= 100000)  
����N��ÿ�а�����������Hi��Wi��(1 <= Hi, Wi <= 100000) 
���뱣֤ÿλС���������ܻ��һ��1x1���ɿ�����   

���
����г����������ɿ��������ܵı߳���

�������룺
2 10  
6 5  
5 6  

���������
2

��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��

 */
/*
ʵ�����Ǵ�N�����������г�K����Сһ���ġ����߳���������
ľͰЧӦ ���е����߳�����������N������������̵ı�

��ʲô���洢�����εĳ��Ϳ�
����һά����
�õ�oj��ȥ�� ��ʱ��ֻ����75�� 

����Ҫע�����ݹ�ģ ��long�洢��� int �����������ݿ��ܻᳬ



 */
package �ڰ˽�;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��5��25�� ����10:20:16
*/
public class t09_���ɿ��� {
	static int N,K;
	private static int[] width;
	private static int[] length;
	public static void main(String[] args) {
		while(true) {
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		K=reader.nextInt();
		width=new int[N];
		length=new int[N];
		long area=0;
		for (int i = 0; i < N; i++) {
			int a=reader.nextInt();
			int b=reader.nextInt();
			width[i]=Math.min(a, b);
			length[i]=Math.max(a, b);
			area+=a*b;//60
		}
		int sideLen=(int) Math.sqrt((area*1.0/K));	//	60.0/10=6
		
		int ans =1;
		int rows =0;
		int cols =0;
		//ö�ٱ߳� ʡʱ��ķ����� �ӱ߳���Ŀ�ʼö�� �������Եľ��Ǿ����ܵ����
		for(int a=sideLen;a>=1;a--) {
			//ö��ÿһ���ɿ���
			long total=0;
			for(int i=0;i<N;i++) {
				rows=width[i]/a;
				cols=length[i]/a;
				total+=rows*cols;
			}
			if(total>=K) {
				ans=a;
				System.out.println(ans);
				System.exit(0);
			}
		}
		
		}
	}

}
