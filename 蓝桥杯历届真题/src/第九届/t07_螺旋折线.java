/*

���⣺��������

��ͼp1.pgn��ʾ���������߾���ƽ������������ǡ��һ�Ρ�  
��������(X, Y)�����Ƕ�������ԭ��ľ���dis(X, Y)�Ǵ�ԭ�㵽(X, Y)���������߶εĳ��ȡ�  

����dis(0, 1)=3, dis(-2, -1)=9  

������������(X, Y)�����ܼ����dis(X, Y)��

�������ʽ��
X��Y 

����40%�����ݣ�-1000 <= X, Y <= 1000  
����70%�����ݣ�-100000 <= X�� Y <= 100000  
����100%������, -1000000000 <= X, Y <= 1000000000  

�������ʽ��
���dis(X, Y)  


������������
0 1

�����������
3


��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��


 */
/*
 
�Ƚϱ��ķ�����ģ������ ������
x-1,y	x,y+1	x+2,y	x,y-2	
��1�� �ϣ�1�� �ң�2�� �£�2��
��3�� �ϣ�3�� �ң�4�� �£�4��  

n^2���Ӷ� 1000ms��1s������ͨ�������ݴ����5000 Ҳ������ͨ��40%������

��Ҫע���������ģΪ10^9 ���Ϳɱ�ʾ���10^10
��������
 */
package �ھŽ�;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��5��29�� ����10:59:39
*/
public class t07_�������� {
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
			if((step&1)==1) {//���� ����
				//�� 
				long nx=x;
				for(int i=1;i<=step;i++) {
					//��������λ��
					nx-=1;
					//�������߶εĳ���
					ans+=1;
					if(nx==X&&y==Y) {
						System.out.println(ans);
						System.exit(0);
					}
					//System.out.println("1: "+nx+" "+y+" "+ans);
				}
				x=nx;
				//��
				//��������λ��
				
				long ny=y;
				for(int i=1;i<=step;i++) {
					ny+=1;
					//�������߶εĳ���
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
			if((step&1)==0) {//ż�� ����
				//�� 
				//��������λ��
				long nx=x;
				for(int i=1;i<=step;i++) {
					//��������λ��
					nx+=1;
					//�������߶εĳ���
					ans+=1;
					if(nx==X&&y==Y) {
						System.out.println(ans);
						System.exit(0);
					}
					//System.out.println("3: "+nx+" "+y+" "+ans);
				}
				x=nx;
				
				//��
				long ny=y;
				for(int i=1;i<=step;i++) {
					//��������λ��
					ny-=1;
					//�������߶εĳ���
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
