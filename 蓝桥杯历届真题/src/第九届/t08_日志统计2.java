/*

标题：日志统计

小明维护着一个程序员论坛。现在他收集了一份"点赞"日志，日志共有N行。其中每一行的格式是：

ts id  

表示在ts时刻编号id的帖子收到一个"赞"。  

现在小明想统计有哪些帖子曾经是"热帖"。如果一个帖子曾在任意一个长度为D的时间段内收到不少于K个赞，小明就认为这个帖子曾是"热帖"。  

具体来说，如果存在某个时刻T满足该帖在[T, T+D)这段时间内(注意是左闭右开区间)收到不少于K个赞，该帖就曾是"热帖"。  [1,12) 

给定日志，请你帮助小明统计出所有曾是"热帖"的帖子编号。  

【输入格式】
第一行包含三个整数N、D和K。  
以下N行每行一条日志，包含两个整数ts和id。  

对于50%的数据，1 <= K <= N <= 1000  
对于100%的数据，1 <= K <= N <= 100000 0 <= ts <= 100000 0 <= id <= 100000  

【输出格式】
按从小到大的顺序输出热帖id。每个id一行。  

【输入样例】
7 10 2  
0 1  
0 10    
10 10  
10 1  
9 1
100 3  
100 3  

【输出样例】
1  
3  

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
 */
/*
先将相同id的帖子 及其收到赞的时间保存下来
要用到一对多结构
id	ts
1	0	9	10	
3	100	100
10	0	10
然后枚举每一个可能的时间点T  统计[T,T+D)时间内的赞数是否超过K
01背包：总价值要达到价值V 承重量不超过W
	赞数要达到K	时间间隔不超过D			

注意点 ：
1、要求从小到大的顺序输出热帖id
 */
package 第九届;

import java.util.Arrays;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月30日 下午2:48:40
* 类说明
*/
public class t08_日志统计2 {
	//record类存放每条记录对应的时间和id
	//record实现comparable接口 以实现每条记录的排序
	public static class record implements Comparable<record>{
		int id,ts;
		record(int id,int ts){
			this.id=id;
			this.ts=ts;
		}
		//重写compareTo方法 先按id比较 相同id则按ts比
		@Override
		public int compareTo(record o) {
			if(this.id==o.id)
				return this.ts-o.ts;
			else
				return this.id-o.id;
		}
		
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int N=reader.nextInt();
		int D=reader.nextInt();
		int K=reader.nextInt();
		//声明一个存放每一条点赞记录的数组
		record blog[]=new record[N];
		boolean flag[]=new boolean[100000];
		for(int i=0;i<N;i++) {
			int ts=reader.nextInt();
			int id=reader.nextInt();
			//每一个blog[i]对应存放一条记录
			blog[i]=new record(id,ts);
		}
		Arrays.sort(blog);
		/*
		 * 排完序之后
		 	1 0
			1 9
			1 10
			3 100
			3 100
			10 0
			10 10
		 */
//		for(int i=0;i<N;i++) {
//			System.out.println(blog[i].id+" "+blog[i].ts);
//			
//		}
		for(int i=0;i+K-1<N;i++) {
			int id = blog[i].id;
			int next=i+K-1;
			
			//最低要求（至少）：相距K-1的那条仍然是相同id 且时间间隔在D范围内
			if(!flag[id]&&blog[ next].id==id&& (blog[next].ts-blog[i].ts)<D) {
				flag[id]=true;
				System.out.println(id);
			}
		}

	}
	

}
