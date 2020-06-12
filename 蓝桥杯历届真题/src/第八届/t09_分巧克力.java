/*

标题： 分巧克力

    儿童节那天有K位小朋友到小明家做客。小明拿出了珍藏的巧克力招待小朋友们。
    小明一共有N块巧克力，其中第i块是Hi x Wi的方格组成的长方形。

    为了公平起见，小明需要从这 N 块巧克力中切出K块巧克力分给小朋友们。切出的巧克力需要满足：

    1. 形状是正方形，边长是整数  
    2. 大小相同  

例如一块6x5的巧克力可以切出6块2x2的巧克力或者2块3x3的巧克力。

当然小朋友们都希望得到的巧克力尽可能大，你能帮小明计算出最大的边长是多少么？

输入
第一行包含两个整数N和K。(1 <= N, K <= 100000)  
以下N行每行包含两个整数Hi和Wi。(1 <= Hi, Wi <= 100000) 
输入保证每位小朋友至少能获得一块1x1的巧克力。   

输出
输出切出的正方形巧克力最大可能的边长。

样例输入：
2 10  
6 5  
5 6  

样例输出：
2

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。

 */
/*
实质上是从N个长方形中切出K个大小一样的、最大边长的正方形
木桶效应 能切的最大边长受限制与于N个长方形中最短的边

用什么来存储长方形的长和宽？
两个一维数组
拿到oj上去跑 超时了只得了75分 

这里要注意数据规模 用long存储面积 int 后面两个数据可能会超



 */
package 第八届;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月25日 上午10:20:16
*/
public class t09_分巧克力 {
	static int N,K;
	private static int[] width;
	private static int[] length;
	public static void main(String[] args) {
		while(true) {
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		K=reader.nextInt();
		width=new int[N];
		length=new int[N];
		long area=0;
		for (int i = 0; i < N; i++) {
			int a=reader.nextInt();
			int b=reader.nextInt();
			width[i]=Math.min(a, b);
			length[i]=Math.max(a, b);
			area+=a*b;//60
		}
		int sideLen=(int) Math.sqrt((area*1.0/K));	//	60.0/10=6
		
		int ans =1;
		int rows =0;
		int cols =0;
		//枚举边长 省时间的方法是 从边长大的开始枚举 遇到可以的就是尽可能的最大
		for(int a=sideLen;a>=1;a--) {
			//枚举每一块巧克力
			long total=0;
			for(int i=0;i<N;i++) {
				rows=width[i]/a;
				cols=length[i]/a;
				total+=rows*cols;
			}
			if(total>=K) {
				ans=a;
				System.out.println(ans);
				System.exit(0);
			}
		}
		
		}
	}

}
