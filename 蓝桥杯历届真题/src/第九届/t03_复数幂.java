/*
 
���⣺������

��iΪ������λ����������������n��(2+3i)^n ��ʵ�����鲿����������
�� (2+3i)^123456 ���ڶ��٣� ��(2+3i)��123456���ݣ�������ֺܴ�Ҫ��ȷ��ʾ��
��д�� "ʵ�����鲿i" ����ʽ��ʵ�����鲿���������������ÿ�ѧ��������ʾ�����м��κεط������ӿո�ʵ��Ϊ��ʱǰ�治�����š�(2+3i)^2 д��: -5+12i��
(2+3i)^5 ��д��: 122-597i


ע�⣺��Ҫ�ύ����һ�����Ӵ�ĸ�������Ҫ��д�κζ������ݡ�
4043220979119144065		-7374402350132176768i
 */
package �ھŽ�;
/**
* @author JohnnyLin
* @version Creation Time��2020��5��28�� ����8:55:11
*/
public class t03_������ {
	//���帴������
	public static void main(String[] args) {
		long a=2;
		long b=3;
		long c=2;
		long d=3;
		long first=0;
		long second=0;
//		for(int i=1;i<=1;i++) {
//			first=a*c-b*d;
//			second=2*a*d;
//			a=c=first;
//			b=d=second;
//		}
		//123456 *123455��
		for(int i=1;i<=123455;i++) {
			long t=a*c-b*d;//4
			long k=b*c+a*d;
			c=t;
			d=k;
		}
		System.out.println(c+"		"+d);
		//System.out.println(first+"		"+second);
		
		
		
		
		
		
		
		
		
	}
}
