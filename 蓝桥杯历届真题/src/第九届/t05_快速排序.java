/*

���⣺��������

���´�����Դ�����a[]���ҳ���kС��Ԫ�ء�  


��ʹ�������ƿ��������еķ����㷨������ʱ�临�Ӷ���O(N)�ġ�


����ϸ�Ķ�����Դ�룬��д���߲���ȱʧ�����ݡ�

import java.util.Random;
public class Main{
	public static int quickSelect(int a[], int l, int r, int k) {
		Random rand = new Random();
		int p = rand.nextInt(r - l + 1) + l;
		int x = a[p];
		int tmp = a[p]; a[p] = a[r]; a[r] = tmp;
		int i = l, j = r;
		while(i < j) {
                	while(i < j && a[i] < x) i++;
                	if(i < j) {
                        	a[j] = a[i];
                        	j--;
                	}
                	while(i < j && a[j] > x) j--;
                	if(i < j) {
                        	a[i] = a[j];
                        	i++;
                	}
        	}
        	a[i] = x;
        	p = i;
        	if(i - l + 1 == k) return a[i];
        	if(i - l + 1 < k) return quickSelect( _________________________________ ); //���
        	else return quickSelect(a, l, i - 1, k);	
	}
	public static void main(String args[]) {
		int [] a = {1, 4, 2, 8, 5, 7};
		System.out.println(quickSelect(a, 0, 5, 4));
	}
}

ע�⣺ֻ�ύ���߲���ȱ�ٵĴ��룬��Ҫ��д�κ��Ѿ����ڵĴ������š�


 */
package �ھŽ�;
/**
* @author JohnnyLin
* @version Creation Time��2020��5��28�� ����10:26:17
*/
import java.util.Random;
public class t05_��������{
	/**
		1, 4, 2, 8, 5, 7
		quickSelect(a, 0, 5, 4)
	 * @param a ����������
	 * @param l	�������±�
	 * @param r	�������±�
	 * @param k	
	 * @return
	 */
	public static int quickSelect(int a[], int l, int r, int k) {
		//������ָ��
		Random rand = new Random();
		int p = rand.nextInt(r - l + 1) + l;//	3 3 3 5
		//System.out.println(p);
		int x = a[p];
		//����a[p]ѡ��Ԫ����������Ԫ��a[r]
		int tmp = a[p]; a[p] = a[r]; a[r] = tmp;
		int i = l, j = r;
		while(i < j) {
                	while(i < j && a[i] < x) i++;
                	if(i < j) {
                        	a[j] = a[i];
                        	j--;
                	}
                	while(i < j && a[j] > x) j--;
                	if(i < j) {
                        	a[i] = a[j];
                        	i++;
                	}
        	}
        	a[i] = x;
        	//mid
        	p = i;
        	if(i - l + 1 == k) return a[i];
        	//ʵ���������ұ� a, p+1, r, k-(i-l+1)
        	//8 6
        	//3 5
        	//l=4 r=8
        	// 2=k-(r-l)=6-(8-4)
        	//����k���ڸ���������� ע����������ǲ�����С ���ƽ�ĳ��Ԫ�ص�
        	if(i - l + 1 < k) return quickSelect( a,  i+1,r, k-(i-l+1)); //���
        	else return quickSelect(a, l, i - 1, k);	
	}
	public static void main(String args[]) {
//		int [] a = {1, 4, 2, 8, 5, 7};
//		System.out.println(quickSelect(a, 0, 5, 4));
		int [] a = {1, 4, 2, 8, 5, 7, 0};//0 1 2 4 5 7 8 
		System.out.println(quickSelect(a, 0, 6, 1));
		
		int [] b = {1, 4, 2, 8, 5, 7, 0};//0 1 2 4 5 7 8 
		System.out.println(quickSelect(b, 0, 6, 3));
		
		int [] c = {1, 4, 2, 8, 5, 7, 0};//0 1 2 4 5 7 8 
		System.out.println(quickSelect(c, 0, 6, 6));
	}
}




