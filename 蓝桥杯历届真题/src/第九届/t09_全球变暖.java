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
很明显的一道迷宫类搜索题
岛屿被淹没的条件是所有陆地都被淹没 反过来 能剩下的就是有某一块陆地相邻像素都是陆地的岛屿
那么我们先就去搜索有多少个连通块 即多少个岛屿用res记录
然后模拟淹没过程 注意这里淹没判断的时候使用的是未被淹没前的海域地图map 淹没覆盖的是mapAfter
最后再去搜索淹没之后的海域mapAfter有多少个连通块（即剩下的岛屿） 用ans记录
res-ans即为淹没的岛屿个数

但是在过样例四时会发现有误判：
淹没前岛屿数为1
....................
...###..............
...###..............
....#####...........
....######..........
....######..........
....########........
......######........
........####........
........####........
........####........
....................

淹没后岛屿数为2实际上应该为1的
....................
....................
....#...............
.....#..............
.....####...........
.....####...........
......####..........
........###.........
.........##.........
.........##.........
....................




 */
package 第九届;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月30日 下午4:17:14
*/
public class t09_全球变暖 {
	static int N;
	static char map[][];
	static char mapAfter[][];
	static char mapbefore[][] ;
	//上左下右
	static int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};
	
	//判断连通块数目
	static void dfs(int x,int y,char[][] a) {
		
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N&&a[nx][ny]=='#') {
				a[nx][ny]='.';
				dfs(nx,ny,a);
			}
		}
	}
	//判断某一块陆地相邻像素是否都是陆地
	private static void check(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N) {
				if(map[nx][ny]=='.') {//相邻像素是海洋 会被淹没 
					mapAfter[x][y]='.';
					break;
				}
			}
		}
	}
	static void show(char [][]a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		//测试样例
		System.setIn(new FileInputStream(new File("src/data/in4.txt") ) );
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		mapbefore=new char[N][N];
		map=new char[N][N];
		mapAfter=new char[N][N];
		for (int i = 0; i < N; i++) {
			String s=reader.next();
			for (int j = 0; j < N; j++) {
				map[i][j]=s.charAt(j);
				mapbefore[i][j]=map[i][j];
				mapAfter[i][j]=map[i][j];
			}
		}
		int res=0;
		//统计先前海域的连通块数目即所有的岛屿
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(mapbefore[i][j]=='#') {
					dfs(i,j,mapbefore);
					res++;
				}
			}
		}
		System.out.println(res);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='#') {//是陆地则扫描周遭像素
					check(i,j);
				}
			}
		}
		show(mapAfter);
		int ans=0;
		//统计未来海域的连通块数目即未被淹没的岛屿
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(mapAfter[i][j]=='#') {
					dfs(i,j,mapAfter);
					ans++;
				}
			}
		}
		System.out.println(ans);
		System.out.println(res-ans);
		
		
	}

}
