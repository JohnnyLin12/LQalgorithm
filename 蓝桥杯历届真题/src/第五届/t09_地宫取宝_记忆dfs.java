/*

  X 国王有一个地宫宝库。是 n x m 个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。

    地宫的入口在左上角，出口在右下角。

    小明被带到地宫的入口，国王要求他只能向右或向下行走。

    走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。

    当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。

    请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。

【数据格式】

    输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)

    接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12)代表这个格子上的宝物的价值

    要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007 取模的结果。

例如，输入：
2 2 2
1 2
2 1
程序应该输出：
2

再例如，输入：
2 3 2
1 2 3
2 1 5
程序应该输出：
14

输入：
2 2 2
1 2
2 2
程序应该输出：
4

思路：记忆型dfs+mod运算
价值的取值是从零开始的 意味着0也是可取的
因此记忆型数组的值要全部初始化为-1 
但是还存在一个问题  就是一开始max传-1进去 数组下标会越界
因而要将max这个维度开大一个 也就是-1位置对应0
 */
package 第五届;

import java.util.Scanner;

public class t09_地宫取宝_记忆dfs  {
	static int [][] map;
	static int n,m,k;
	static long [][][][] memo=new long [51][51][14][13];
	static final long mod=1000000007;
	public static long dfs(int x,int y,int max,int cnt) {
		if(x>=n||y>=m||cnt>k)
			return 0;
		//计算前先查询
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


		if(cur>max) {//大于才可能选
			ans+=dfs(x+1,y,cur,cnt+1);
			ans+=dfs(x,y+1,cur,cnt+1);
		}//不论大于不大都不选
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
			//初始化记忆数组
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

