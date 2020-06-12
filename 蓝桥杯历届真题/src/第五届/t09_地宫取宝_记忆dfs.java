/*

  X ������һ���ع����⡣�� n x m �����ӵľ���ÿ�����ӷ�һ��������ÿ���������ż�ֵ��ǩ��

    �ع�����������Ͻǣ����������½ǡ�

    С���������ع�����ڣ�����Ҫ����ֻ�����һ��������ߡ�

    �߹�ĳ������ʱ������Ǹ������еı�����ֵ��С���������ⱦ����ֵ����С���Ϳ�������������Ȼ��Ҳ���Բ��ã���

    ��С���ߵ�����ʱ����������еı���ǡ����k��������Щ�����Ϳ����͸�С����

    �����С����һ�㣬�ڸ����ľ����£����ж����ֲ�ͬ���ж������ܻ����k��������

�����ݸ�ʽ��

    ����һ��3���������ÿո�ֿ���n m k (1<=n,m<=50, 1<=k<=12)

    �������� n �����ݣ�ÿ���� m ������ Ci (0<=Ci<=12)������������ϵı���ļ�ֵ

    Ҫ�����һ����������ʾ����ȡk���������ж��������������ֿ��ܴܺ�������� 1000000007 ȡģ�Ľ����

���磬���룺
2 2 2
1 2
2 1
����Ӧ�������
2

�����磬���룺
2 3 2
1 2 3
2 1 5
����Ӧ�������
14

���룺
2 2 2
1 2
2 2
����Ӧ�������
4

˼·��������dfs+mod����
��ֵ��ȡֵ�Ǵ��㿪ʼ�� ��ζ��0Ҳ�ǿ�ȡ��
��˼����������ֵҪȫ����ʼ��Ϊ-1 
���ǻ�����һ������  ����һ��ʼmax��-1��ȥ �����±��Խ��
���Ҫ��max���ά�ȿ���һ�� Ҳ����-1λ�ö�Ӧ0
 */
package �����;

import java.util.Scanner;

public class t09_�ع�ȡ��_����dfs  {
	static int [][] map;
	static int n,m,k;
	static long [][][][] memo=new long [51][51][14][13];
	static final long mod=1000000007;
	public static long dfs(int x,int y,int max,int cnt) {
		if(x>=n||y>=m||cnt>k)
			return 0;
		//����ǰ�Ȳ�ѯ
		if(memo[x][y][max+1][cnt]!=-1) {
			return memo[x][y][max+1][cnt];
		}
		int cur=map[x][y];
		long ans=0;
		if(x==n-1&&y==m-1) {
			if(cnt==k||(cnt==k-1&&cur>max)) {
				ans++;
			}
			return ans%=mod;
		}


		if(cur>max) {//���ڲſ���ѡ
			ans+=dfs(x+1,y,cur,cnt+1);
			ans+=dfs(x,y+1,cur,cnt+1);
		}//���۴��ڲ��󶼲�ѡ
		ans+=dfs(x+1,y,max,cnt);
		ans+=dfs(x,y+1,max,cnt);
		
		memo[x][y][max+1][cnt]=ans%mod;
		return memo[x][y][max+1][cnt];

	
		
	}

	public static void main(String[] args) {
			Scanner reader=new Scanner(System.in);
		while(true) {
			n=reader.nextInt();
			m=reader.nextInt();
			k=reader.nextInt();
			map=new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j]=reader.nextInt();
				}
			}
			//��ʼ����������
			for (int i = 0; i < 51; i++) {
				for (int j = 0; j <51; j++) {
					for (int k = 0; k < 14; k++) {
						for (int p = 0; p < 13; p++) {
							memo[i][j][k][p]=-1;
						}
					}
				}
			}
			System.out.println(dfs(0,0,-1,0));
		}
		
	}

}

