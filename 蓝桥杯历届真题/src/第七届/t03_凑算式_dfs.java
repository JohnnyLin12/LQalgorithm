/*

����ʽ

     B      DEF
A + --- + ------- = 10
     C      GHI
     
�������ʾ�����⣬���Բμ���ͼ1.jpg����
	 
	 
�����ʽ��A~I����1~9�����֣���ͬ����ĸ����ͬ�����֡�

���磺
6+8/3+952/714 ����һ�ֽⷨ��
5+3/1+972/486 ����һ�ֽⷨ��

�����ʽһ���ж����ֽⷨ��

ע�⣺���ύӦ���Ǹ���������Ҫ��д�κζ�������ݻ�˵�������֡�
 */
/*
 * 
�õ�֪ʶ�㣺
1������dfs��·��
	dfs(int index,int cnt)
	ÿ������ֻ�ܳ���һ�� ʹ��vis�����ʾ
	dfs���ڣ�9�����ֶ�ѡ�����ٴλ����� ������ʽ ans++

ע�⣺
1��System.out.println(6.0+8.0/3.0+952.0/714.0);���Ϊ10
������ֳ��� ��֤���� Ҫʹ��double����
�𰸣�252
 */
package ���߽�;
/**
* @author JohnnyLin
* @version Creation Time��2020��5��10�� ����2:05:13
*/
public class t03_����ʽ_dfs {
	static int ans=0;
	static double a[]=new double[10];
	static boolean vis[]=new boolean[10];
	/**
	 * @param index ��ǰΪa��indexλ��ѡ����
	 * @param cnt ��ǰѡ��cnt����
	 */
	static void dfs(int index,int cnt) {
		//9������ѡ����
		if(cnt==9) {
			if(a[1]+a[2]/a[3]+ (a[4]*a[5]*a[6])/(a[7]*a[8]*a[9])==10.0) {
				System.out.println(a[1]+" "+a[2]/a[3]+" "+ (a[4]*a[5]*a[6])/(a[7]*a[8]*a[9]));
				ans++;
				return;
			}
		}
		for(int i=1;i<=9;i++) {
			//��ǰa��indexλ��ѡ��i
			if(!vis[i]) {
				a[index]=(double)i;
				vis[i]=true;
				dfs(index+1,cnt+1);
				a[index]=0.0;
				vis[i]=false;
			}
		}
	}


	public static void main(String[] args) {

		dfs(1,0);
		System.out.println(ans);
		
	}

}
