/*
���⣺�˿�����


A A 2 2 3 3 4 4�� һ��4���˿��ơ�����������ų�һ�С�
Ҫ������A�м���1���ƣ�����2֮����2���ƣ�����3֮����3���ƣ�����4֮����4���ơ�

����д�����з���Ҫ��������У��ֵ�����С���Ǹ���

���磺22AA3344 �� A2A23344 �ֵ���С����Ȼ�����Ƕ���������Ҫ��Ĵ𰸡�


��ͨ��������ύ�𰸡���A��һ����Ҫ��Сд��ĸa��Ҳ��Ҫ�á�1�����档�ַ���һ����Ҫ���ո�

25314876 ��Ӧ 4A3A2432
51237468 ��Ӧ 2342A3A4
�ֵ�����С����2342A3A4
 */
package �����;

import java.util.Arrays;

public class t07_�˿�����_����ö�� {

	public static void main(String[] args) {
		for(int ia=1;ia<=6;ia++) {
			for(int i2=1;i2<=5;i2++) {
				for(int i3=1;i3<=4;i3++) {
					for(int i4=1;i4<=3;i4++) {
						int i5=ia+2;int i6=(i2+3);
						int i7=(i3+4);int i8=(i4+5);
					
						String s=""+ia+i2+i3+i4+i5+i6+i7+i8;
						//ֻҪ���±겻��� ��ô����һ���Ϸ���
						boolean flag=true;
						if(ia==i2||ia==i3||ia==i4||ia==i6||ia==i7||ia==i8||
								i2==i3||i2==i4||i2==i5||i2==i7||i2==i8||
								i3==i4||i3==i5||i3==i6||i3==i8||
								i4==i5||i4==i6||i4==i7||
								i5==i6||i5==i7||i5==i8||
								i6==i7||i6==i8||
								i7==i8
								
							) {
							flag=false;
							break;
						}
						if(flag) {
							System.out.println(s);
						}
					}
				}
				
			}
		}
		for(int ma = 1 ; ma <= 6 ; ma++){
			for(int m2 = 1 ; m2 <= 5 ; m2++){
				for(int m3 = 1 ; m3 <= 4 ; m3++){
					for(int m4 = 1 ; m4 <= 3 ; m4++){
						String str = "" +ma+m2+m3+m4+(ma+2)+(m2+3)+(m3+4)+(m4+5) ;
						//split("")���±�����ֿ���ΪgetStr��Ԫ��
						String[] getStr = str.split("");
						boolean flag = true ;
						//���±��С��������
						Arrays.sort(getStr);
					
						for (int i = 0; i < getStr.length-1; i++) {
							if(getStr[i].equals(getStr[i+1])){
								flag = false ;
								break ;
							}
						}
						if(flag){
							System.out.println(str);
						}
					}
				}
			}
		}

	}

}
