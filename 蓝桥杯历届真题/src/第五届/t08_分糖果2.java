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

public class t08_���ǹ�2 {
	static boolean check(int [] arra) {
		for (int i = 0; i < arra.length-1; i++) {
			if(arra[i]!=arra[i+1]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		int [] dp=new int[n];
		for (int i = 0; i < n; i++) {
			dp[i]=reader.nextInt();
		}
		int ans=0;
		while(true) {
			int t=dp[0];
			for(int i=0;i<n-1;i++) {
				dp[i]-=dp[i]/2;
				dp[i]+=dp[i+1]/2;
				if((dp[i]&1)==1) {
					ans++;
					dp[i]++;
				}
			}
			dp[n-1]-=dp[n-1]/2;
			dp[n-1]+=t/2;
			if((dp[n-1]&1)==1) {
				dp[n-1]++;
				ans++;
			}
			if(check(dp)) {
				System.out.println(ans);
				break;
			}
				
		}
	}

}
