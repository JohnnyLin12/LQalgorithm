/*

标题：螺旋折线

如图p1.pgn所示的螺旋折线经过平面上所有整点恰好一次。  
对于整点(X, Y)，我们定义它到原点的距离dis(X, Y)是从原点到(X, Y)的螺旋折线段的长度。  

例如dis(0, 1)=3, dis(-2, -1)=9  

给出整点坐标(X, Y)，你能计算出dis(X, Y)吗？

【输入格式】
X和Y 

对于40%的数据，-1000 <= X, Y <= 1000  
对于70%的数据，-100000 <= X， Y <= 100000  
对于100%的数据, -1000000000 <= X, Y <= 1000000000  

【输出格式】
输出dis(X, Y)  


【输入样例】
0 1

【输出样例】
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
 
比较笨的方法是模拟曲线 挨个求
x-1,y	x,y+1	x+2,y	x,y-2	
左（1） 上（1） 右（2） 下（2）
左（3） 上（3） 右（4） 下（4）  

n^2复杂度 1000ms（1s）内能通过的数据大概是5000 也就是能通过40%的数据

需要注意的是最大规模为10^9 整型可表示最大10^10
宁多勿少
 */
package 第九届;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time：2020年5月29日 上午10:59:39
*/
public class t07_螺旋折线 {
	private static long X;
	private static long Y;
	public static void main(String[] args) {
		Scanner reader=new Scanner (System.in);
		//0 1
		X=reader.nextInt();
		Y=reader.nextInt();
		long step=1;
		long x=0,y=0,ans=0;
		for(;;) {
			if(x==X&&y==Y) {
				System.out.println(ans);
				System.exit(0);
			}
			if((step&1)==1) {//奇数 左上
				//左 
				long nx=x;
				for(int i=1;i<=step;i++) {
					//更新坐标位置
					nx-=1;
					//更新折线段的长度
					ans+=1;
					if(nx==X&&y==Y) {
						System.out.println(ans);
						System.exit(0);
					}
					//System.out.println("1: "+nx+" "+y+" "+ans);
				}
				x=nx;
				//上
				//更新坐标位置
				
				long ny=y;
				for(int i=1;i<=step;i++) {
					ny+=1;
					//更新折线段的长度
					ans+=1;
					if(x==X&&ny==Y) {
						System.out.println(ans);
						System.exit(0);
					}
					//System.out.println("2: "+x+" "+ny+" "+ans);
				}
				y=ny;
				step++;
			}
			if((step&1)==0) {//偶数 右下
				//右 
				//更新坐标位置
				long nx=x;
				for(int i=1;i<=step;i++) {
					//更新坐标位置
					nx+=1;
					//更新折线段的长度
					ans+=1;
					if(nx==X&&y==Y) {
						System.out.println(ans);
						System.exit(0);
					}
					//System.out.println("3: "+nx+" "+y+" "+ans);
				}
				x=nx;
				
				//下
				long ny=y;
				for(int i=1;i<=step;i++) {
					//更新坐标位置
					ny-=1;
					//更新折线段的长度
					ans+=1;
					if(x==X&&ny==Y) {
						System.out.println(ans);
						System.exit(0);
					}
					//System.out.println("4: "+x+" "+ny+" "+ans);
				}
				y=ny;
				step++;
			}
		}
	}

}
