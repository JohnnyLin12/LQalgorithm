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
�����Ե�һ���Թ���������
���챻��û������������½�ض�����û ������ ��ʣ�µľ�����ĳһ��½���������ض���½�صĵ���
��ô�����Ⱦ�ȥ�����ж��ٸ���ͨ�� �����ٸ�������res��¼
Ȼ��ģ����û���� ע��������û�жϵ�ʱ��ʹ�õ���δ����ûǰ�ĺ����ͼmap ��û���ǵ���mapAfter
�����ȥ������û֮��ĺ���mapAfter�ж��ٸ���ͨ�飨��ʣ�µĵ��죩 ��ans��¼
res-ans��Ϊ��û�ĵ������

�����ڹ�������ʱ�ᷢ�������У�
��ûǰ������Ϊ1
....................
...###..............
...###..............
....#####...........
....######..........
....######..........
....########........
......######........
........####........
........####........
........####........
....................

��û������Ϊ2ʵ����Ӧ��Ϊ1��
....................
....................
....#...............
.....#..............
.....####...........
.....####...........
......####..........
........###.........
.........##.........
.........##.........
....................




 */
package �ھŽ�;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��5��30�� ����4:17:14
*/
public class t09_ȫ���ů {
	static int N;
	static char map[][];
	static char mapAfter[][];
	static char mapbefore[][] ;
	//��������
	static int dir[][]={{-1,0},{0,-1},{1,0},{0,1}};
	
	//�ж���ͨ����Ŀ
	static void dfs(int x,int y,char[][] a) {
		
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N&&a[nx][ny]=='#') {
				a[nx][ny]='.';
				dfs(nx,ny,a);
			}
		}
	}
	//�ж�ĳһ��½�����������Ƿ���½��
	private static void check(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(nx>=0&&nx<N&&ny>=0&&ny<N) {
				if(map[nx][ny]=='.') {//���������Ǻ��� �ᱻ��û 
					mapAfter[x][y]='.';
					break;
				}
			}
		}
	}
	static void show(char [][]a) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		//��������
		System.setIn(new FileInputStream(new File("src/data/in4.txt") ) );
		Scanner reader=new Scanner(System.in);
		N=reader.nextInt();
		mapbefore=new char[N][N];
		map=new char[N][N];
		mapAfter=new char[N][N];
		for (int i = 0; i < N; i++) {
			String s=reader.next();
			for (int j = 0; j < N; j++) {
				map[i][j]=s.charAt(j);
				mapbefore[i][j]=map[i][j];
				mapAfter[i][j]=map[i][j];
			}
		}
		int res=0;
		//ͳ����ǰ�������ͨ����Ŀ�����еĵ���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(mapbefore[i][j]=='#') {
					dfs(i,j,mapbefore);
					res++;
				}
			}
		}
		System.out.println(res);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='#') {//��½����ɨ����������
					check(i,j);
				}
			}
		}
		show(mapAfter);
		int ans=0;
		//ͳ��δ���������ͨ����Ŀ��δ����û�ĵ���
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(mapAfter[i][j]=='#') {
					dfs(i,j,mapAfter);
					ans++;
				}
			}
		}
		System.out.println(ans);
		System.out.println(res-ans);
		
		
	}

}
