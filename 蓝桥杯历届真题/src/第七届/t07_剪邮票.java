/*
����Ʊ

�硾ͼ1.jpg��, ��12������һ���12��Ф����Ʊ��
������Ҫ���м���5������Ҫ����������ŵġ�
����������һ���ǲ���������
���磬��ͼ2.jpg������ͼ3.jpg���У��ۺ�ɫ��ʾ���־��Ǻϸ�ļ�ȡ��

������㣬һ���ж����ֲ�ͬ�ļ�ȡ������

����д��ʾ������Ŀ��������
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�

 */
/*
����һ��ʼ����Զ�ά�����ÿһ������в���Ϊ5��dfs ����ϸ����������ͼ�����ֲ���
dfs�ѳ�����5������Ȼ����ͨ�� ����״ֻ����L���� ��Ϊdfs��һ·�ߵ���  һ�β���������·���߲�����T����������״
���������ѵ�����̫���� ˼ά��Щ����  ���ú��� ����dfs��bfs�ⷽ����

��������������� �ŷ�������ԭ�����ԣ����ظ�ȫ����+dfs����ͨ������

 * 
 */
package ���߽�;
/**
* @author JohnnyLin
* @version Creation Time��2020��5��10�� ����3:25:53
*/

public class t07_����Ʊ {
	private static int ans;
	private static int[] a= {0,0,0,0,0,0,0,1,1,1,1,1};
	private static boolean[] vis=new boolean[12];

	static void permutation(int cnt,int []path) {
		if(cnt==12) {
			if(check(path)) {
				ans++;
			}
			return;
		}
		//���ظ���ȫ����
		for(int i=0;i<12;i++) {
			if(i>0&&a[i]==a[i-1]&&!vis[i-1])
				continue;
			
			if(!vis[i]) {
				vis[i]=true;
				path[cnt]=a[i];
				permutation(cnt+1, path);
				vis[i]=false;
			}
		}
	}
	static void dfs(int x,int y,int [][]map) {
		if(x<0||x>=3||y<0||y>=4||map[x][y]!=1) 
			return;
		//��λ����Ϊ0
		map[x][y]=0;
		dfs(x-1,y,map);
		dfs(x,y-1,map);
		dfs(x+1,y,map);
		dfs(x,y+1,map);
		
	}
	private static boolean check(int[] path) {
		int map[][]=new int[3][4];
		//���Ѿ���Ǻõ�һά����ת��Ϊ��Ӧ�Ķ�ά����
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <4; j++) {
				if(path[i*4+j]==1)
					map[i][j]=1;
			}
		}
		int cnt=0;//ͳ����ͨ��ĸ��� ����������2 2 1��֮��
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <4; j++) {
				if(map[i][j]==1) {
					dfs(i,j,map);
					cnt++;
				}
			}
		}
		
		return cnt==1;
	}

	public static void main(String[] args) {
		int path[]=new int[12];
		permutation(0, path);
		System.out.println(ans);
		
	}

}
