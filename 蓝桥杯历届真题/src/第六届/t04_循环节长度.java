/*

ѭ���ڳ���

������������������ʱ�����ѭ��С������ѭ�����ֳ�Ϊ��ѭ���ڡ�
���磬11/13=6=>0.846153 846153.....  ��ѭ����Ϊ[846153] ����6λ�� 
 */
package ������;

import java.util.Vector;

public class t04_ѭ���ڳ��� {

	public static int f(int n, int m)
	{
		n = n % m;	
		Vector v = new Vector();
		//for()
		for(;;)
		{
			v.add(n);
			n *= 10;
			n = n % m;
			if(n==0) return 0;
			//˵���ҵ��ظ���
			if(v.indexOf(n)>=0)  return v.size() ;  //���
		}
	}
	public static void main(String[] args) {
		System.out.println(f(11,13));
	}

}
