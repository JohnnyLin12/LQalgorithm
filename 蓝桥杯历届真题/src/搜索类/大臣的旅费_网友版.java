package 搜索类;

import java.util.ArrayList;
import java.util.Scanner;

public class 大臣的旅费_网友版 {
	public static int n;
	static int Max=Integer.MIN_VALUE;
	//代表最长距离的起点城市
	static int point;
	//城市结构体
	//声明动态数组 ArrayList<edge> map1=new ArrayList<>();看成A数据类型 类似于Integer
	//数组：A [] map2=new A();
	//两句合在一起就相当于：声明了一个数组map2里面的数据元素是A类型的 而A类型的数据是edge类的
	static ArrayList<edge>[] map;
	static class edge{
		public int P,Q,D;
		public edge(int p,int q,int d) {
			P=p;
			Q=q;
			D=d;
		}
	}
	private static void getResult() {
		boolean [] vis=new boolean[n+1];
		//进行两遍深搜 第一遍深搜搜索出最长路径的起点，第二次深搜走出最长路径
		dfs(1,vis,0);
		vis=new boolean[n+1];
		dfs(point,vis,0);
		int res=(11+10+Max)*Max/2;
		System.out.println(res);
	}
	private static void dfs(int start,boolean[] vis,int dis ) {
		vis[start]=true;
		//枚举从start出发 可以到达的下一个城市
		for(int i=0;i<map[start].size();i++) {
			edge temp=map[start].get(i);
			if(!vis[temp.Q]) {//若这两个城市的高速公路没有访问过 则访问
				dis+=temp.D;
				if(dis>Max) {//若这条路的距离大于max 更新max
					Max=dis;
					point=temp.Q;//并且存储该城市
				}
				dfs(temp.Q,vis,dis);//沿着该点往下搜索
				//需要恢复状态 因为在该条高速路走到黑之后进行下一条高速路的深搜
				dis-= temp.D;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();
		
		//由n个城市 每个城市都有自己的map
		map=new ArrayList[n+1];
		for(int i=1;i<=n;i++) 
			//将每个城市的map都实例化为存储edge(高速路)对象的链表
			map[i]=new ArrayList<edge>();
		for(int j=1;j<n;j++) {
			int p=reader.nextInt();
			int q=reader.nextInt();
			int d=reader.nextInt();
			map[p].add(new edge(p,q,d));
			map[q].add(new edge(q,p,d));
			}
			reader.close();
			getResult();
		
	}
}
	
