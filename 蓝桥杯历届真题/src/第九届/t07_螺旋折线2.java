/*
 ����һ����ѧ�� ���ҵ����ɲ��ܽ�
 ��y=-x���������� ����Ϊ��ͼ��������
 �����Ͻ����� ÿһ�����صõ��߶γ��ȷֱ�Ϊ 4 8 12����
 Ϊ����a1=4 ����d=4�ĵȲ�����
 Ҫ����ÿһ���������dis �����������½ǵ�Ϊ���յ�
 ����step����λ�Ʋ������ɵõ�
 
 ���½ǵ㳤��Ϊs(n)=(a(1)+a(n))*n/2=a(1)+(n*(n-1)d)/2
 */
package �ھŽ�;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��6��4�� ����1:41:18
*/
public class t07_��������2 {

	public static void main(String[] args) {
		Scanner reader=new Scanner (System.in);
		//0 1
		int X=reader.nextInt();
		int Y=reader.nextInt();
		long dis=1;
		long n=0,ans=0;
		//����һ
		if(Y>0&&Math.abs(X)<=Y) {
			//�ڼ���
			n=Y;
			//�����½ǲ��յ�Ĳ��
			dis=Y-X+2*Y;
		}else if(X>0&&Math.abs(Y)<=X) {	//�����
			n=X;
			dis=Y+X;
		}else if(Y<=0&&X>=Y-1&&X<=-Y) {//������
			n=-Y;
			dis=-(-Y-X);
		}else if(X<0&&Y>=X+1&&Y<=-X) {	//������
			n=-X-1;
			dis=-(Y-X-1-2*X-1);
		}
		System.out.println(sum(1L,2*n,1)*2-dis);
	}
	static long sum(long a,long  n,int d) {
		return (a+a+(n-1)*d)*n/2;
	}

}
