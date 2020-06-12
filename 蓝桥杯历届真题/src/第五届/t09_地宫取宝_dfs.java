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

思路：带条件dfs+mod运算
这里的dfs与以往的不太一样 加了一点条件 我叫他做带条件的dfs：这里是规定只能向下或向右 因此不必担心走回头路的问题
不用vis数组标记 

这题有个地方还比较坑 就是拿起那个格子的宝贝的前提是：那个格子中的宝贝价值比小明手中任意宝贝价值都大
因此要用一个变量来维护手中的宝贝最大值 另外还注意的一点是：价值的取值是从零开始的 意味着0也是可取的
再需要注意的一点是：一开始我少考虑到出口时 只拿到了k-1件宝贝 所以第二个样例怎么算都是5

这样拿到官网上去跑 也只能的一半的分
 */
package 第五届;

import java.util.Scanner;

public class t09_地宫取宝_dfs  {
	static int [][] map;
	static int ans=0;
	static int n,m,k;
	public static void dfs(int x,int y,int max,int cnt) {
		//System.out.println(x+" "+y+" "+cnt);
		if(x>=n||y>=m||cnt>k)
			return;
		int cur=map[x][y];
		if(x==n-1&&y==m-1) {
			if(cnt==k) {
				ans=(ans+1)%1000000007;
			}
			if(cnt==k-1&&cur>max) {
				ans=(ans+1)%1000000007;
			}
			return;
		}
	

		if(cur>max) {//大于才可能选
			dfs(x+1,y,cur,cnt+1);
			dfs(x,y+1,cur,cnt+1);
		}//不论大于不大都不选
		dfs(x+1,y,max,cnt);
		dfs(x,y+1,max,cnt);

	
		
	}

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		
			n=reader.nextInt();
			m=reader.nextInt();
			k=reader.nextInt();
			map=new int[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j]=reader.nextInt();
				}
			}
			dfs(0,0,-1,0);
			System.out.println(ans);
			
		
	}

}

