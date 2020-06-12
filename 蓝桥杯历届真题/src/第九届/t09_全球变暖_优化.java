/*

标题：全球变暖

你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：

.......
.##....
.##....
....##.
..####.
...###.
.......

其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。  

由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。

具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。  

例如上图中的海域未来会变成如下样子：

.......
.......
.......
.......
....#..
.......
.......

请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。  

【输入格式】
第一行包含一个整数N。  (1 <= N <= 1000)  
以下N行N列代表一张海域照片。  

照片保证第1行、第1列、第N行、第N列的像素都是海洋。  

【输出格式】
一个整数表示答案。

【输入样例】
7 
.......
.##....
.##....
....##.
..####.
...###.
.......  

【输出样例】
1  



资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
 */
/*
还是前面的思想 先dfs算出所有的岛屿数量用res记录 再统计不会被淹没的岛屿数目ans
二者之差即为被淹没的岛屿数
所不同的是 判断不会被淹没的判断方法发生了改变 
具体是：
在某一个岛屿的搜索过程中 用全局flag标记作为该岛屿是否会不会被淹没的标志
如果存在某一块陆地相邻像素都是陆地的岛屿 那么则该岛屿不会被淹没
但是要继续遍历完该岛屿的全部陆地 使布尔数组vis对应位置标记为true
从而避免了误判




这里的flag要设置为全局变量 否则永远没有得到修改
检测是用的是局部的值false
		boolean flag=false;
		dfs(i,j,map,flag);
		
		if(flag) {
			ans++;
		}

然而着并不能通过全部数据 最后一组数据当数据量为1000*1000时 栈溢出了
这是因为递归允许调用的最大层数为10000  在这个数据里显然超过了
 因此递归搜索解决是不可能获得全部分数的
 容我看看网上题解
 */
package 第九届;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月30日 下午5:32:40
*/
public class t09_全球变暖_优化 {
	static int N;
	static char map[][];
	static char mapbefore[][];
	static 	boolean flag=false;
	static boolean vis[][];
	//上左下右
	static int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};
	
	//判断连通块数目
	static void dfs(int x,int y,char[][] a) {
		//dfs出口当所有陆地都被标记了
		if(check(x,y)) {//找到一块陆地四周都是陆地的则将标记f设为true
			//但还不能直接return 要将该岛屿遍历遍历vis对应位置标为true
			flag=true;
		}
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(!vis[nx][ny]&&nx>=0&&nx<N&&ny>=0&&ny<N&&a[nx][ny]=='#') {
				//注意不用回溯再标记为false
				vis[nx][ny]=true;
				dfs(nx,ny,a);
			}
		}
	}
	
	//判断连通块数目
	static void dfs_islandNum(int x,int y,char[][] a) {
		//dfs出口为全部像素都是'.'时
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N&&a[nx][ny]=='#') {
				a[nx][ny]='.';
				dfs_islandNum(nx,ny,a);
			}
		}
	}
	//判断某一块陆地相邻像素是否都是陆地
	private static boolean check(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N) {
				if(map[nx][ny]=='.') {//相邻像素是海洋 会被淹没 
					return false;
				}
			}
		}
		return true;
	}
	static  void show(char [][]a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	static  void show2(boolean [][]a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(String.format("%5s ", a[i][j]));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		//测试样例
		System.setIn(new FileInputStream(new File("src/data/in7.txt") ) );
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		//mapbefore=new char[N][N];
		map=new char[N][N];
		vis=new boolean[N][N];
		mapbefore=new char[N][N];
		for (int i = 0; i < N; i++) {
			String s=reader.next();
			for (int j = 0; j < N; j++) {
				map[i][j]=s.charAt(j);
				mapbefore[i][j]=map[i][j];
			}
		}
		
		int res=0;
		//统计先前海域的连通块数目即所有的岛屿
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(mapbefore[i][j]=='#') {
					dfs_islandNum(i,j,mapbefore);
					res++;
				}
			}
		}
		//System.out.println(res);
		int ans=0;
		//统计未来海域的连通块数目即未被淹没的岛屿
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='#'&&!vis[i][j]) {
					dfs(i,j,map);
					if(flag) {
						ans++;
					}
					//将标记重新标回false 这一步很关键
					flag=false;
				}
			}
		}
		//show2(vis);
		//System.out.println(ans);
		System.out.println(res-ans);
		
		
	}

}
