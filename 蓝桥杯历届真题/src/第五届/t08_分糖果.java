/*

���⣺���ǹ�



��n��С����Χ����һȦ����ʦ��ÿ��С���������ż�����ǹ���Ȼ������������Ϸ��

ÿ��С���Ѷ����Լ����ǹ���һ������ֱߵĺ��ӡ�

һ�ַ��Ǻ�ӵ���������ǵĺ�������ʦ����1���ǹ����Ӷ����ż����

�������������Ϸ��ֱ������С���ѵ��ǹ�������ͬΪֹ��

���������Ԥ������֪�ĳ�ʼ�ǹ������£���ʦһ����Ҫ�������ٸ��ǹ���

����ʽҪ��

    �������ȶ���һ������N(2<N<100)����ʾС���ѵ�������
    ������һ���ÿո�ֿ���N��ż����ÿ��ż��������1000����С��2��
    Ҫ��������һ����������ʾ��ʦ��Ҫ�������ǹ�����

���磺����
3
2 2 4
����Ӧ�������
4

������˾��ñ���ʵ�ڲ��Ͻ� û��˵С����ʱ˳ʱ����Ȧ��������ʱ�� �Ұ�˳ʱ�����������
�������ϵ��������ʱ�� ����һ��ı�ʾҲû��˵��� ��С��������������ʱ����ô�� �����Ĭ�ϴ�����  
 */
package �����;

import java.util.Scanner;

public class t08_���ǹ� {
	static boolean check(int [] arra) {
		for (int i = 0; i < arra.length-1; i++) {
			if(arra[i]!=arra[i+1]) {
				return false;
			}
		}
		return true;
	}
	static void show(int dp[]) {
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		int cnt=0;
		int dp[] =new int[n];
		for (int i = 0; i < n; i++) {
			dp[i]=reader.nextInt();
		}
		do{
			for (int i = 0; i < dp.length; i++) {
				int k=dp[(i+1)%n]; ///2+(dp[(i+1)%n]&1); 
				int tmp=k/2+k&1;
				dp[i]+=k-tmp;// 
				dp[(i+1)%n]=tmp;
			}
			show(dp);
			if(check(dp)) {
				break;
			}
			for (int i = 0; i < dp.length; i++) {
				if((dp[i]&1)==1) {
					dp[i]++;
					cnt++;
				}
			}
			
			
		}while(true);
		System.out.println(cnt);
		
	}

}
