/*

方格填数

如下的10个格子
   +--+--+--+
   |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |
+--+--+--+

（如果显示有问题，也可以参看【图1.jpg】）

填入0~9的数字。同一数字不能重复填。要求：连续的两个数字不能相邻。
（左右、上下、对角都算相邻）

一共有多少种可能的填数方案？

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
/*
这题和经典的N皇后问题 、数字九宫格这两个题目比较像
不过这里首先要把map[0][0]和map[2][3]位置筛掉 
 就是用 不能与(0-9)相差为1的数字先填上(如-2等等)
才不会造成左右、上下、对角相邻位置为相邻数字的影响 

可能用到知识点：
1、常见的dfs迷宫类的套路了：
	0-9数字 不能重复使用 -------vis标记数组
	
	先按y方向逐个填数字dfs(x,y+1)  
	当y==4（注意边界 边界为超出时的临界）时 换行 dfs(x+1,0)
	这里判断该方格填的数i是否合法的方法时：八个方向逐个检验
	
	dfs出口为 x,y坐标为2,3

注意：
1、要注意一定要先将map初始化为-3 消除干扰
否则会发现答案只有1579少了一种
 */
package 第七届;


/**
* @author JohnnyLin
* @version Creation Time：2020年5月10日 下午3:00:13
*/
public class t06_方格填数 {
	static int map[][]=new int[3][4];
	static int ans;
	//上 左上 ……逆时针方向
	static int dir[][]=new int[][]{{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	//标记0-9数字是否用过
	private static boolean[] vis=new boolean[10];
	
	/**
	 * @param x
	 * @param y
	 * 当前准备在（x，y）这个方格填数
	 */
	static void dfs(int x,int y) {
		//System.out.println(x+" "+y);
//		if(x<0||x>=3||y<0||y>=4)//错误 因为是逐格填的能到这里说明是在10个格子内
//			return;
		if(x==2&&y==3) {
			show(map);
			ans++;
			return;
		}
		if(y==4) {
			dfs(x+1,0);
			return;
		}
		//往每一个格子填数 且不能重复 因此要使用标记
		for(int i=0;i<=9;i++) {
			if(!vis[i]&&check(x,y,i)) {
				vis[i]=true;
				map[x][y]=i;
				dfs(x,y+1);
				vis[i]=false;
				map[x][y]=-3;
				
			}
		}
	}

	private static void show(int[][] map2) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if((i==0&&j==0)||(i==2&&j==3))
					continue;
				System.out.print(map2[i][j]+" ");
			}
		}
		System.out.println();
		
	}
	//从该位置出发 八个方向扫描 检查是否为相邻数字
	private static boolean check(int x, int y, int k) {
		for(int i=0;i<8;i++) {
			int dx=x+dir[i][0];
			int dy=y+dir[i][1];
			if(in(dx,dy)) {
				if(Math.abs(map[dx][dy]-k)==1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean in(int x, int y) {
		
		return x>=0&&x<3&&y>=0&&y<4;
	}

	public static void main(String[] args) {
		//因为数字是在0-9之间的 数组默认初始值为0 会与1形成相邻 因而要消除干扰 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j]=-3;
			}
			
		}
		show(map);
		dfs(0,1);
		System.out.println(ans);
		
		
	}

}
