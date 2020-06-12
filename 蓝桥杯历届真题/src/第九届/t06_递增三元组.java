/*

���⣺������Ԫ��

����������������
A = [A1, A2, ... AN], 
B = [B1, B2, ... BN], 
C = [C1, C2, ... CN]��
����ͳ���ж��ٸ���Ԫ��(i, j, k) ���㣺

1. 1 <= i, j, k <= N  
2. Ai < Bj < Ck  

�������ʽ��
��һ�а���һ������N��
�ڶ��а���N������A1, A2, ... AN��
�����а���N������B1, B2, ... BN��
�����а���N������C1, C2, ... CN��

����30%�����ݣ�1 <= N <= 100  
����60%�����ݣ�1 <= N <= 1000 
����100%�����ݣ�1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000 

�������ʽ��
һ��������ʾ��

������������
3
1 1 1
2 2 2
3 3 3

�����������
27 


��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��

3
1 2 1
3 2 5
1 3 1
2

 */
/*
 *���Ǵ�A��B��C���������зֱ�ѡ��һ����a��b��c
 *ʹ��a<b<c
 */
package �ھŽ�;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��6��3�� ����7:30:20


*/

public class t06_������Ԫ�� {
	static void show(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(new File("src/data/in4.txt") ) );
		Scanner reader=new Scanner(System.in);
		int N=reader.nextInt();
		int A[]=new int[N];
		int B[]=new int[N];
		int C[]=new int[N];
		
		int a[]=new int[N];//��¼B�����е�һ������A[i]���±�
		int b[]=new int[N];//��¼C�����д���B[i]�ĸ���
		
		for (int j = 0; j < N; j++) {
			A[j]=reader.nextInt();
		}
		for (int j = 0; j < N; j++) {
			B[j]=reader.nextInt();
		}
		for (int j = 0; j < N; j++) {
			C[j]=reader.nextInt();
		}
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		show(A);
		show(B);
		show(C);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(A[i]<B[j]) {
					//����B�����е�һ������A[i]���±�
					// A���±���B���±�ӳ���ϵ
					a[i]=j;
					break;
				}
			}
		}
		show(a);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(B[i]<C[j]) {
					//����C�������B[i]�ĸ���  B���±���C����ӳ���ϵ
					b[i]=N-j;
					break;
				}
			}
		}
		show(b);
		int ans=0;
		for (int i = 0; i < N; i++) {
			//A����ѡ��һ����A[i] ��ô����������ֵĸ���������a[i]���ҵ�
			//ͬʱҲ����֪���������B�е�λ��ΪN-a[i] �Ӷ����C�д���������ֵĸ���b[ N-a[i] ]
			for(int j=a[i];j<N;j++) {
				ans+= b[j];
			}
			System.out.println(ans);
		}
		
		//System.out.println(ans);

	}
	/*
10
6 0 9 2 4 6 2 3 4 4
6 4 8 7 6 9 0 7 8 0
1 5 2 9 6 6 0 6 8 3

	 */

}
