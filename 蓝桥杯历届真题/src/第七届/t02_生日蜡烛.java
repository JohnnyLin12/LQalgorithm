/*

��������

ĳ����ĳ�꿪ʼÿ�궼�ٰ�һ������party������ÿ�ζ�Ҫ��Ϩ��������ͬ����������

��������������һ����Ϩ��236������

���ʣ����Ӷ����꿪ʼ������party�ģ�

����д����ʼ������party����������
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�


26


(26+33)*8/2=59*4=236
 */
package ���߽�;
/**
* @author JohnnyLin
* @version Creation Time��2020��5��10�� ����1:55:53
*/
public class t02_�������� {

	public static void main(String[] args) {
		//boolean flag = false;
		for(int begin=1;begin<150;begin++) {
			for(int now=begin+1;now<150;now++) {
				if((begin+now)*(now-begin+1)/2==236) {
					System.out.println(begin+" "+now);
//					flag=true;
					break;
				}
			}
//			if(flag) {
//				break;
//			}
		}
	}

}
