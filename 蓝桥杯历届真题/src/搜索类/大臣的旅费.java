/*
�������ݣ�
5
1 2 2
1 3 1
2 4 5
2 5 4
�𰸣�135
 * 
 */
package ������;

import java.util.Scanner;

public class �󳼵��÷� {
	static int ans=Integer.MIN_VALUE;
	static int n;
	static int [][]mp;
	static boolean [][] vis;
	//��ʾ��ǰ��u����  ��ǰ�Ѿ��ߵ�·��Ϊsum
	static void dfs(int u,int sum) {
		if(sum>ans) {//�õ���u�������·����
			ans=sum;
		}
		for(int v=1;v<=n;v++) {//ö�ٴ�u������һ�����ܵ���ĳ���
			if(mp[u][v]!=0&&!vis[u][v]) {
				vis[u][v]=true;
				vis[v][u]=true;
				dfs(v,sum+mp[u][v]);
				vis[u][v]=false;
				vis[v][u]=false;
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();//n������
		mp=new int[n+1][n+1];//n-�����ٹ�·
		vis=new boolean[n+1][n+1];
		for(int i=1;i<n;i++) {
			int p=reader.nextInt();
			int q=reader.nextInt();
			int d=reader.nextInt();
			mp[p][q]=d;
			mp[q][p]=d;
		}

		for(int i=1;i<=n;i++) {
			dfs(i,0);
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(mp[i][j]);
			}
			System.out.println();
		}
		//1  9
		//11 19
		System.out.println((11+10+ans)*ans/2);
		
	}

}
