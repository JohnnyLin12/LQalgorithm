/*

���⣺ȫ���ů

����һ��ĳ����NxN���ص���Ƭ��"."��ʾ����"#"��ʾ½�أ�������ʾ��

.......
.##....
.##....
....##.
..####.
...###.
.......

����"��������"�ĸ�����������һ���һƬ½�����һ�����졣������ͼ����2�����졣  

����ȫ���ů�����˺�����������ѧ��Ԥ��δ����ʮ�꣬�����Եһ�����صķ�Χ�ᱻ��ˮ��û��

������˵���һ��½�������뺣������(���������ĸ������������к���)�����ͻᱻ��û��  

������ͼ�еĺ���δ�������������ӣ�

.......
.......
.......
.......
....#..
.......
.......

������㣺���տ�ѧ�ҵ�Ԥ�⣬��Ƭ���ж��ٵ���ᱻ��ȫ��û��  

�������ʽ��
��һ�а���һ������N��  (1 <= N <= 1000)  
����N��N�д���һ�ź�����Ƭ��  

��Ƭ��֤��1�С���1�С���N�С���N�е����ض��Ǻ���  

�������ʽ��
һ��������ʾ�𰸡�

������������
7 
.......
.##....
.##....
....##.
..####.
...###.
.......  

�����������
1  



��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
 */
/*
����ǰ���˼�� ��dfs������еĵ���������res��¼ ��ͳ�Ʋ��ᱻ��û�ĵ�����Ŀans
����֮�Ϊ����û�ĵ�����
����ͬ���� �жϲ��ᱻ��û���жϷ��������˸ı� 
�����ǣ�
��ĳһ����������������� ��ȫ��flag�����Ϊ�õ����Ƿ�᲻�ᱻ��û�ı�־
�������ĳһ��½���������ض���½�صĵ��� ��ô��õ��첻�ᱻ��û
����Ҫ����������õ����ȫ��½�� ʹ��������vis��Ӧλ�ñ��Ϊtrue
�Ӷ�����������




�����flagҪ����Ϊȫ�ֱ��� ������Զû�еõ��޸�
������õ��Ǿֲ���ֵfalse
		boolean flag=false;
		dfs(i,j,map,flag);
		
		if(flag) {
			ans++;
		}

Ȼ���Ų�����ͨ��ȫ������ ���һ�����ݵ�������Ϊ1000*1000ʱ ջ�����
������Ϊ�ݹ�������õ�������Ϊ10000  �������������Ȼ������
 ��˵ݹ���������ǲ����ܻ��ȫ��������
 ���ҿ����������
 */
package �ھŽ�;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��5��30�� ����5:32:40
*/
public class t09_ȫ���ů_�Ż� {
	static int N;
	static char map[][];
	static char mapbefore[][];
	static 	boolean flag=false;
	static boolean vis[][];
	//��������
	static int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};
	
	//�ж���ͨ����Ŀ
	static void dfs(int x,int y,char[][] a) {
		//dfs���ڵ�����½�ض��������
		if(check(x,y)) {//�ҵ�һ��½�����ܶ���½�ص��򽫱��f��Ϊtrue
			//��������ֱ��return Ҫ���õ����������vis��Ӧλ�ñ�Ϊtrue
			flag=true;
		}
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(!vis[nx][ny]&&nx>=0&&nx<N&&ny>=0&&ny<N&&a[nx][ny]=='#') {
				//ע�ⲻ�û����ٱ��Ϊfalse
				vis[nx][ny]=true;
				dfs(nx,ny,a);
			}
		}
	}
	
	//�ж���ͨ����Ŀ
	static void dfs_islandNum(int x,int y,char[][] a) {
		//dfs����Ϊȫ�����ض���'.'ʱ
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N&&a[nx][ny]=='#') {
				a[nx][ny]='.';
				dfs_islandNum(nx,ny,a);
			}
		}
	}
	//�ж�ĳһ��½�����������Ƿ���½��
	private static boolean check(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N) {
				if(map[nx][ny]=='.') {//���������Ǻ��� �ᱻ��û 
					return false;
				}
			}
		}
		return true;
	}
	static  void show(char [][]a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	static  void show2(boolean [][]a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(String.format("%5s ", a[i][j]));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		//��������
		System.setIn(new FileInputStream(new File("src/data/in7.txt") ) );
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		//mapbefore=new char[N][N];
		map=new char[N][N];
		vis=new boolean[N][N];
		mapbefore=new char[N][N];
		for (int i = 0; i < N; i++) {
			String s=reader.next();
			for (int j = 0; j < N; j++) {
				map[i][j]=s.charAt(j);
				mapbefore[i][j]=map[i][j];
			}
		}
		
		int res=0;
		//ͳ����ǰ�������ͨ����Ŀ�����еĵ���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(mapbefore[i][j]=='#') {
					dfs_islandNum(i,j,mapbefore);
					res++;
				}
			}
		}
		//System.out.println(res);
		int ans=0;
		//ͳ��δ���������ͨ����Ŀ��δ����û�ĵ���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='#'&&!vis[i][j]) {
					dfs(i,j,map);
					if(flag) {
						ans++;
					}
					//��������±��false ��һ���ܹؼ�
					flag=false;
				}
			}
		}
		//show2(vis);
		//System.out.println(ans);
		System.out.println(res-ans);
		
		
	}

}
