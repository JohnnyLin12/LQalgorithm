/*

取球博弈

两个人玩取球的游戏。
一共有N个球，每人轮流取球，每次可取集合{n1,n2,n3}中的任何一个数目。
如果无法继续取球，则游戏结束。
此时，持有奇数个球的一方获胜。
如果两人都是奇数，则为平局。

假设双方都采用最聪明的取法，
第一个取球的人一定能赢吗？
试编程解决这个问题。

输入格式：
第一行3个正整数n1 n2 n3，空格分开，表示每次可取的数目 (0<n1,n2,n3<100)
第二行5个正整数x1 x2 ... x5，空格分开，表示5局的初始球数(0<xi<1000)

输出格式：
一行5个字符，空格分开。分别表示每局先取球的人能否获胜。
能获胜则输出+，
次之，如有办法逼平对手，输出0，
无论如何都会输，则输出-

例如，输入：
1 2 3
1 2 3 4 5

程序应该输出：
+ 0 + 0 -

再例如，输入：
1 4 5
10 11 12 13 15

程序应该输出：
0 - 0 + +

再例如，输入：
2 3 5
7 8 9 10 11

程序应该输出：
+ 0 0 0 0


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 3000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。

 */
/*
双方的取球可选范围是一样的{n1,n2,n3}
双方都采用最聪明的取法，就是说每个人都尽可能地选择使得自己的总数量为奇数
 实质上就是 
 奇数=奇数+偶数
 
 偶数=偶数+偶数
 偶数=奇数+奇数
 
 */
package 第七届;

import java.util.Arrays;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月14日 上午9:57:48

*/
public class t09_取球博弈 {

	private static void dfs(int i, int[] num) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int []num=new int[3];
		for(int i=0;i<3;i++) {
			num[i]=reader.nextInt();
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		//game数组存放每句球数
		int game[]=new int[5];
		for(int i=0;i<5;i++) {
			game[i]=reader.nextInt();
		}
		for(int i=0;i<5;i++) {
			dfs( game[i],num );
		}
		

	}


}
