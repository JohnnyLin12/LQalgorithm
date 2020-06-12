/*

��������

���µ�10������
   +--+--+--+
   |  |  |  |
+--+--+--+--+
|  |  |  |  |
+--+--+--+--+
|  |  |  |
+--+--+--+

�������ʾ�����⣬Ҳ���Բο���ͼ1.jpg����

����0~9�����֡�ͬһ���ֲ����ظ��Ҫ���������������ֲ������ڡ�
�����ҡ����¡��ԽǶ������ڣ�

һ���ж����ֿ��ܵ�����������

����д��ʾ������Ŀ��������
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�
 */
/*
����;����N�ʺ����� �����־Ź�����������Ŀ�Ƚ���
������������Ҫ��map[0][0]��map[2][3]λ��ɸ�� 
 ������ ������(0-9)���Ϊ1������������(��-2�ȵ�)
�Ų���������ҡ����¡��Խ�����λ��Ϊ�������ֵ�Ӱ�� 

�����õ�֪ʶ�㣺
1��������dfs�Թ������·�ˣ�
	0-9���� �����ظ�ʹ�� -------vis�������
	
	�Ȱ�y�������������dfs(x,y+1)  
	��y==4��ע��߽� �߽�Ϊ����ʱ���ٽ磩ʱ ���� dfs(x+1,0)
	�����жϸ÷��������i�Ƿ�Ϸ��ķ���ʱ���˸������������
	
	dfs����Ϊ x,y����Ϊ2,3

ע�⣺
1��Ҫע��һ��Ҫ�Ƚ�map��ʼ��Ϊ-3 ��������
����ᷢ�ִ�ֻ��1579����һ��
 */
package ���߽�;


/**
* @author JohnnyLin
* @version Creation Time��2020��5��10�� ����3:00:13
*/
public class t06_�������� {
	static int map[][]=new int[3][4];
	static int ans;
	//�� ���� ������ʱ�뷽��
	static int dir[][]=new int[][]{{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	//���0-9�����Ƿ��ù�
	private static boolean[] vis=new boolean[10];
	
	/**
	 * @param x
	 * @param y
	 * ��ǰ׼���ڣ�x��y�������������
	 */
	static void dfs(int x,int y) {
		//System.out.println(x+" "+y);
//		if(x<0||x>=3||y<0||y>=4)//���� ��Ϊ���������ܵ�����˵������10��������
//			return;
		if(x==2&&y==3) {
			show(map);
			ans++;
			return;
		}
		if(y==4) {
			dfs(x+1,0);
			return;
		}
		//��ÿһ���������� �Ҳ����ظ� ���Ҫʹ�ñ��
		for(int i=0;i<=9;i++) {
			if(!vis[i]&&check(x,y,i)) {
				vis[i]=true;
				map[x][y]=i;
				dfs(x,y+1);
				vis[i]=false;
				map[x][y]=-3;
				
			}
		}
	}

	private static void show(int[][] map2) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if((i==0&&j==0)||(i==2&&j==3))
					continue;
				System.out.print(map2[i][j]+" ");
			}
		}
		System.out.println();
		
	}
	//�Ӹ�λ�ó��� �˸�����ɨ�� ����Ƿ�Ϊ��������
	private static boolean check(int x, int y, int k) {
		for(int i=0;i<8;i++) {
			int dx=x+dir[i][0];
			int dy=y+dir[i][1];
			if(in(dx,dy)) {
				if(Math.abs(map[dx][dy]-k)==1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean in(int x, int y) {
		
		return x>=0&&x<3&&y>=0&&y<4;
	}

	public static void main(String[] args) {
		//��Ϊ��������0-9֮��� ����Ĭ�ϳ�ʼֵΪ0 ����1�γ����� ���Ҫ�������� 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j]=-3;
			}
			
		}
		show(map);
		dfs(0,1);
		System.out.println(ans);
		
		
	}

}
