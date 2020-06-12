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
一开始觉得是动态规划 但写不出dp数组
想不出来-------

网上解法：多分支dfs
有些类似爬楼梯方案数 可选楼梯数是{n1,n2,n3}
但是取球博弈这里存在对手 是交互式选球  你取球面临地总球数是我上一轮选剩下地 
我下轮取球面临地总球数是你这轮取完剩下的 因此dfs传参时参数要互换

结算规则：

if:在分支出来地三个局面中存在一个局面对手输  那么我赢了
else if :在对手不输的基础上存在一个局面是平局		那么逼平
else: 我输了
 
 */
package 第七届;

import java.util.Arrays;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月14日 上午9:57:48

*/
public class t09_取球博弈dfs {
	static int num[];
	private static char dfs(int n, int me, int you) {
		//结算规则
		if(n<num[0]) {
			if((me&1)==1&&(you&1)==0)//你赢 奇数 偶数
				return '+';
			else if((me&1)==0&&(you&1)==1)//你输 偶数 奇数
				return '-';
			else	//平 奇数 奇数 偶数 偶数
				return '0';
		}
		boolean flag=false;
		for(int i=0;i<3;i++) {
			if(n>=num[i]) {
				//交换身份进行选球
				char c=dfs(n-num[i],you,me+num[i]);
				//判定输赢规则 c得到是对手输赢情况
				if(c=='-')//对手输则我赢
					return '+';
				if(c=='0')
					flag=true;
			}
		}
		//对手不输那么对手可能赢或者平
		if(flag)//双方都平
			return '0';
		else//不平则我输了
			return '-';
	}

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		num=new int[3];
		for(int i=0;i<3;i++) {
			num[i]=reader.nextInt();
		}
		Arrays.sort(num);
		//game数组存放每局球数
		int game[]=new int[5];
		for(int i=0;i<5;i++) {
			game[i]=reader.nextInt();
			System.out.print(dfs( game[i],0,0 )+" ");
		}
		System.out.println();
		

	}


}
