/*
��������
С���Ȱ�Ӳ�Ұڳ���һ�� n �� m �еľ���
���С����ÿһ��Ӳ�ҷֱ����һ�� Q ������
�Ե�x�е�y�е�Ӳ�ҽ��� Q �����Ķ��壺�����е� i*x �У��� j*y �е�Ӳ�ҽ��з�ת��
����i��jΪ����ʹ�������е����������кź��кŶ��Ǵ�1��ʼ��
��С��������Ӳ�Ҷ�������һ�� Q ��������������һ���漣��������Ӳ�Ҿ�Ϊ���泯�ϡ�
С����֪���ʼ�ж���öӲ���Ƿ��泯�ϵġ����ǣ��������ĺ�����СMѰ�������
������СM����С����ֻ��Ҫ������Ӳ���ٽ���һ��Q���������ɻָ����ʼ��״̬��
Ȼ��С����������Ը������������С��ϣ������������õķ���������������𰸡�

�����ʽ
�����������ݰ���һ�У����������� n m���������Ŀ������
�����ʽ
�������һ������������ʾ�ʼ�ж���öӲ���Ƿ��泯�ϵġ�
��������
2 3
�������
1
���ݹ�ģ��Լ��
��������10%�����ݣ�n��m <= 10^3��
��������20%�����ݣ�n��m <= 10^7��
��������40%�����ݣ�n��m <= 10^15��
��������100%�����ݣ�n��m <= 10^1000��10��1000�η�����

gg ���� ������� �����ǵ���ѧ�� 
˼·�ǣ�
ͨ��Ӳ�ұ����Ĵ�����ȷ�������泯�ϻ��Ƿ��泯�� 
���һöӲ���ܹ��������������������� ��ôԭ��״̬�϶��Ƿ��泯��
����һöӲ�� ��Ҫͬʱ������x����y Ҳ����˵���ᱻ���� ��x�ı����Ĵ���������Ϊa��������y�����Ĵ���������Ϊb��
���a��b���Ϊ����  ����ȫƽ������������Լ�� Ҳ����˵ x��y��Ϊ��ȫƽ��������ȫƽ��������n^2��nΪ��Ȼ����Ҳ����0��2��4��9������
�������ת��Ϊ����ȫƽ����

 */
package �����;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class t10_����Ӳ�� {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String n=reader.next();
		String m=reader.next();
		System.out.println(sqrt(n).multiply(sqrt(m)));
	}
	private static BigInteger sqrt(String s) {
		//����������λ��
		int length=s.length();
		
		//�������� Լ����λ��
		int len=0;
		
		if((length&1)==0)
			len=length/2;
		else
			len=length/2+1;
		
		char[] sArr=new char[len];
		Arrays.fill(sArr, '0');
		BigInteger target = new BigInteger(s);
		//��λ����
		for(int i=0;i<len;i++) {
			for(char a='1';a<='9';a++) {
				sArr[i]=a;
				BigInteger bigInteger = new BigInteger(String.valueOf(sArr)).pow(2);
				if(bigInteger.compareTo(target)==1) {//��̽��ƽ�������� �����һλ
					sArr[i]-=1;
					break;
				}
			}
		}
		return new BigInteger(String.valueOf(sArr));
	}

}
