/*
剪邮票

如【图1.jpg】, 有12张连在一起的12生肖的邮票。
现在你要从中剪下5张来，要求必须是连着的。
（仅仅连接一个角不算相连）
比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。

请你计算，一共有多少种不同的剪取方法。

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

 */
/*
这题一开始是想对二维数组的每一个点进行步长为5的dfs 但仔细分析给出的图例发现不行
dfs搜出来的5个块虽然是联通的 但形状只能是L类型 因为dfs是一路走到黑  一次不能走两条路是走不出像T字形这种形状
可能是深搜的题做太多了 思维有些定势  觉得很像 总往dfs、bfs这方面想

后来网上搜了题解 才发现这题原来可以：不重复全排列+dfs判连通块来做

 * 
 */
package 第七届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月10日 下午3:25:53
*/

public class t07_剪邮票 {
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
		//不重复的全排列
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
		//该位置置为0
		map[x][y]=0;
		dfs(x-1,y,map);
		dfs(x,y-1,map);
		dfs(x+1,y,map);
		dfs(x,y+1,map);
		
	}
	private static boolean check(int[] path) {
		int map[][]=new int[3][4];
		//将已经标记好的一维数组转化为对应的二维数组
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <4; j++) {
				if(path[i*4+j]==1)
					map[i][j]=1;
			}
		}
		int cnt=0;//统计连通块的个数 比如三个（2 2 1）之类
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
