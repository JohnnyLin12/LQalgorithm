/*

标题：快速排序

以下代码可以从数组a[]中找出第k小的元素。  


它使用了类似快速排序中的分治算法，期望时间复杂度是O(N)的。


请仔细阅读分析源码，填写划线部分缺失的内容。

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
        	if(i - l + 1 < k) return quickSelect( _________________________________ ); //填空
        	else return quickSelect(a, l, i - 1, k);	
	}
	public static void main(String args[]) {
		int [] a = {1, 4, 2, 8, 5, 7};
		System.out.println(quickSelect(a, 0, 5, 4));
	}
}

注意：只提交划线部分缺少的代码，不要抄写任何已经存在的代码或符号。


 */
package 第九届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月28日 下午10:26:17
*/
import java.util.Random;
public class t05_快速排序{
	/**
		1, 4, 2, 8, 5, 7
		quickSelect(a, 0, 5, 4)
	 * @param a 待排序数组
	 * @param l	左区间下标
	 * @param r	右区间下标
	 * @param k	
	 * @return
	 */
	public static int quickSelect(int a[], int l, int r, int k) {
		//随机获得指针
		Random rand = new Random();
		int p = rand.nextInt(r - l + 1) + l;//	3 3 3 5
		//System.out.println(p);
		int x = a[p];
		//交换a[p]选定元素与右区间元素a[r]
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
        	//实际名次在右边 a, p+1, r, k-(i-l+1)
        	//8 6
        	//3 5
        	//l=4 r=8
        	// 2=k-(r-l)=6-(8-4)
        	//排名k是在该区间的排名 注意这个区间是不断缩小 最后逼近某个元素的
        	if(i - l + 1 < k) return quickSelect( a,  i+1,r, k-(i-l+1)); //填空
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




