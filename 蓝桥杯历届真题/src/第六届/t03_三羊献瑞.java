/*��Ŀ����
��������

�۲�����ļӷ���ʽ��

      �� �� �� ��
  +   �� �� �� ��
-------------------
   �� �� �� �� ��

(����ж������⣬���Բο���ͼ1.jpg��)

���У���ͬ�ĺ��ִ�����ͬ�����֣���ͬ�ĺ��ִ���ͬ�����֡�

������д�����������������4λ���֣���Ψһ������Ҫ��д�κζ������ݡ�

 */
package ������;

public class t03_�������� {

	public static void main(String[] args) {
	//		d c e f
	//		1 a b c
	//    1 a e c g
		//1 a  
		for(int a=0;a<=9;a++) {
			if(a==1)continue;
			for(int b=0;b<=9;b++) {
				if(b==1)continue;
				for(int c=0;c<=9;c++) {
					if(c==1)continue;
					for(int d=2;d<=9;d++) {
						if(d==1)continue;
						for(int e=0;e<=9;e++) {
							if(e==1)continue;
							for(int f=0;f<=9;f++) {
								if(f==1)continue;
								for(int g=0;g<=9;g++) {
									if(g==1)continue;
									if(a!=b&&a!=c&&a!=d&&a!=e&&a!=f&&a!=g
											&&b!=c&&b!=d&&b!=e&&b!=f&&b!=g&&
											c!=d&&c!=e&&c!=f&&c!=g&&
											d!=e&&d!=f&&d!=g&&
											e!=f&&e!=g
											&&f!=g
											) {
										int x=1000+a*100+b*10+c;
										int y=d*1000+c*100+e*10+f;
										int z=10000+a*1000+e*100+c*10+g;
										if(x+y==z) {
											//System.out.println("1"+a+" "+b+" "+c);
											System.out.println(x+" "+y+" "+z);
											}
										}
									}
							}
						}
					}
				}
			}
		}
	}

}
