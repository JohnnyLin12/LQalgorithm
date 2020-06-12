package ������;

import java.util.ArrayList;
import java.util.Scanner;

public class �󳼵��÷�_���Ѱ� {
	public static int n;
	static int Max=Integer.MIN_VALUE;
	//����������������
	static int point;
	//���нṹ��
	//������̬���� ArrayList<edge> map1=new ArrayList<>();����A�������� ������Integer
	//���飺A [] map2=new A();
	//�������һ����൱�ڣ�������һ������map2���������Ԫ����A���͵� ��A���͵�������edge���
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
		//������������ ��һ�������������·������㣬�ڶ��������߳��·��
		dfs(1,vis,0);
		vis=new boolean[n+1];
		dfs(point,vis,0);
		int res=(11+10+Max)*Max/2;
		System.out.println(res);
	}
	private static void dfs(int start,boolean[] vis,int dis ) {
		vis[start]=true;
		//ö�ٴ�start���� ���Ե������һ������
		for(int i=0;i<map[start].size();i++) {
			edge temp=map[start].get(i);
			if(!vis[temp.Q]) {//�����������еĸ��ٹ�·û�з��ʹ� �����
				dis+=temp.D;
				if(dis>Max) {//������·�ľ������max ����max
					Max=dis;
					point=temp.Q;//���Ҵ洢�ó���
				}
				dfs(temp.Q,vis,dis);//���Ÿõ���������
				//��Ҫ�ָ�״̬ ��Ϊ�ڸ�������·�ߵ���֮�������һ������·������
				dis-= temp.D;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		n=reader.nextInt();
		
		//��n������ ÿ�����ж����Լ���map
		map=new ArrayList[n+1];
		for(int i=1;i<=n;i++) 
			//��ÿ�����е�map��ʵ����Ϊ�洢edge(����·)���������
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
	
