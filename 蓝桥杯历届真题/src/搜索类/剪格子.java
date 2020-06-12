package ËÑË÷Àà;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ¼ô¸ñ×Ó {
	static class Node {
		int res,x,y,step;
		Node(int _x,int _y,int _res,int _step){
			x=_x;
			y=_y;
			res=_res;
			step=_step;
		}
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int m=reader.nextInt();
		int n=reader.nextInt();
		int [][]mp=new int[n][m];
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				mp[i][j]=reader.nextInt();
				sum+=mp[i][j];
			}
		}
		sum=sum>>1;
		System.out.println(sum);
		int [][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
		boolean [][]vis= new boolean[n][m];
		int ans=0;
		Queue<Node> q=new LinkedList<>();
		Node first=new Node(0,0,mp[0][0],1);
		q.offer(first);
		while(!q.isEmpty()) {
			Node now=q.peek();
			q.poll();
			int u=now.x;
			int v=now.y;
			//vis[u][v]=true;
			if(now.res==sum) {
				System.out.println(now.step);
				System.exit(0);
			}
			for(int i=0;i<4;i++) {
				int nx=u+dir[i][0];
				int ny=v+dir[i][1];
				if(nx>=0&&nx<n&&ny>=0&&ny<m) {
					q.offer(new Node(nx,ny,now.res+mp[nx][ny],now.step+1));
				}
			}
			//ans++;
		}
		System.out.println(-1);
	}

}
