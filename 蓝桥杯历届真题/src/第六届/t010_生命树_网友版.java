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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class t010_生命树_网友版 {
	static int[] nodeValue;//存放各个点的和谐值
	static List<Integer>[] point;//存放各个点的包含的邻接边
	static int[] value;//存放以某个点为根节点情况下的最大和谐值和
	static int ans=0;//记录最大结果
	static void dfs(int son,int father) {
		value[son]=nodeValue[son];//以son为根节点，一开始时其最大和谐值为它本身
		for(int i=0;i<point[son].size();i++) {//枚举与son相连的结点
			int next=point[son].get(i);
			//当枚举的下一个结点是son先前经过的点father 跳过 防止绕圈
			if(next==father)continue;//如果都continue掉说明这个点是叶子结点
			dfs(next,son);
			//回溯（子节点平行状态都走完没得走了或者说状态没得转移了才会回溯）得到父节点与子节点和
			if(value[next]>0)//子节点的和谐值
				value[son]+=value[next];
			ans=Math.max(ans, value[son]);
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		//测试样例
		System.setIn(new FileInputStream(new File("src/data/in2.txt") ) );
		
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		nodeValue=new int [n+1];
		value=new int[n+1];
		point=new LinkedList[n+1];
		for(int i=1;i<=n;i++) {
			nodeValue[i]=reader.nextInt();
			point[i]=new LinkedList();
		}
		for(int i=1;i<n;i++) {
			int x=reader.nextInt();
			int y=reader.nextInt();
			point[x].add(y);
			point[y].add(x);
		}
		dfs(1,-1);//从0号结点开始搜索 假设它的父节点为-1可以为其他的无关量
		System.err.println(ans);
	}

}
