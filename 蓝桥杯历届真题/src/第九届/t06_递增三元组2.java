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
1 3 1
3 2 5
4 2 6

3
1 1 3
2 3 5
2 4 6
 */
/*
 *�������Ǵ�A��B��C���������зֱ�ѡ��һ����a��b��c
 *ʹ��a<b<c
 
������A��B��C�ǽ����ź���� ʹ��O(n)��˫ָ�뷨

 ���ȱȽ�B[p]��C[k]
���k<N&&B[p]>=C[k] k����ֱ����һ������B[p]��λ��

 Ȼ��k����  b[p]��¼N-k��C�����д���B[p]�ĸ���  
 ǰ׺�������¼��ֹ��B[p]ʱ  C�����д���B[p]�ĸ����ۼӺ� 
s[p]=(p==0?0:s[p-1])+b[p] 

Ȼ��p����
 �ظ��������� ֱ��p��k>=N��


 
 
 �Ƚ�A[i]��B[j]Ҳ�����Ƶ�
���ȱȽ�A[i]��B[j]
���j<N&&A[i]>=B[j] j����ֱ����һ������A[i]��λ��
 Ȼ��j���� ans+=s[N-1]-(j==0?0:s[j-1]) �õ�[j,N-1)����C����Bd���ܸ���

Ȼ��p����
�ظ��������� ֱ��i��j>=N



 */
package �ھŽ�;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��5��29�� ����8:55:23


*/

public class t06_������Ԫ��2 {
//	static void show(int a[]) {
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i]+" ");
//		}
//		System.out.println();
//	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(new File("src/data/in8.txt") ) );
		Scanner reader=new Scanner(System.in);
		int N=reader.nextInt();
		int A[]=new int[N];
		int B[]=new int[N];
		int C[]=new int[N];
		
		int b[]=new int[N];//��¼C�����д���B[i]�ĸ���
		long s[]=new long[N];//��¼ǰ׺��(�ۼӺ�) �������ͷ�Χ ��long�洢
		
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
		
		
		int p=0;
		int k=0;
		while(p<N) {
			while(k<N&&C[k]<=B[p]) {
				k++;
			}
			b[p]=N-k;
			s[p]=(p==0?0:s[p-1])+b[p];
			p++;
		}
		
		long ans=0;
		int i=0;
		int j=0;
		while(i<N) {
			while(j<N&&B[j]<=A[i]) {
				j++;
			}
			ans+=s[N-1]-(j==0?0:s[j-1]);
			i++;
		}
		System.out.println(ans);
		

	}

}
