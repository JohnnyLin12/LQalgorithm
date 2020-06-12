/*题意描述
生命之树

在X森林里，上帝创建了生命之树。

他给每棵树的每个节点（叶子也称为一个节点）上，都标了一个整数，代表这个点的和谐值。
上帝要在这棵树内选出一个非空节点集S，使得对于S中的任意两个点a,b，
都存在一个点列 {a, v1, v2, ..., vk, b} 
使得这个点列中的每个点都是S里面的元素，且序列中相邻两个点间有一条边相连。
在这个前提下，上帝要使得S中的点所对应的整数的和尽量大。
这个最大的和就是上帝给生命之树的评分。
经过atm的努力，他已经知道了上帝给每棵树上每个节点上的整数。
但是由于 atm 不擅长计算，他不知道怎样有效的求评分。他需要你为他写一个程序来计算一棵树的分数。

「输入格式」
第一行一个整数 n 表示这棵树有 n 个节点。
第二行 n 个整数，依次表示每个节点的评分。
接下来 n-1 行，每行 2 个整数 u, v，表示存在一条 u 到 v 的边。由于这是一棵树，所以是不存在环的。

「输出格式」
输出一行一个数，表示上帝给这棵树的分数。

「样例输入」
5
1 -2 -3 4 5
4 2
3 1
1 2
2 5

「样例输出」
8

「数据范围」
对于 30% 的数据，n <= 10
对于 100% 的数据，0 < n <= 10^5, 每个节点的评分的绝对值不超过 10^6 。

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 3000ms
 */
package 第六届;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class t010_生命树 {
	static List<Integer> [] g;
	static int n;
	static int[] weight;
	static int ans=Integer.MIN_VALUE;
	//无根树转有根树 求最大权值和
	static void dfs(int root,int father) {
		//System.out.println(root);
		//遍历与root相邻的结点
		for(int i=0;i<g[root].size();i++) {
			Integer son = g[root].get(i);
			//相邻结点为父节点
			if(son==father) continue;
			dfs(son,root);
			if(weight[son]>0) {//子树对权值由正向贡献作用则加上
				weight[root]+=weight[son];
			}
		}
		if(ans<weight[root])
			ans=weight[root];
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		//结点个数
		 n=reader.nextInt();
		
		 //存放对象的列表
		g=new LinkedList[n+1];
		//存储和谐值
		weight=new int[n+1];
		int x=0,y=0;
		for(int i=1;i<=n;i++) {
			weight[i]=reader.nextInt();
			//声明n个对象
			g[i]=new LinkedList<Integer>();
		}
		for(int i=1;i<n;i++) {
			x=reader.nextInt();
			y=reader.nextInt();
			g[x].add(y);
			g[y].add(x);
		}
		dfs(1,0);
		System.out.println(ans);
	}

}
