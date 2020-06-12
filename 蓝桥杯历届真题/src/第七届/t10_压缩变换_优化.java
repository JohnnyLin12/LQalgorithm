/**
* @author JohnnyLin
* @version Creation Time��2020��5��19�� ����8:51:13
* ��˵��
*/
/*

ѹ���任

С��������о�ѹ���㷨��
��֪����ѹ����ʱ������ܹ�ʹ����ֵ��С������ͨ���ر���õ��ϸߵ�ѹ���ȡ�
Ȼ����Ҫʹ��ֵ��С��һ����ս��

�����С����Ҫѹ��һЩ�����������У���Щ���е��ص��ǣ�������ֵ����ֺܴ�����Ǹճ��ֹ����õ����֡�����������������У�С��׼����������һ���任����С���ֵ�ֵ��

�任�Ĺ������£�
������ö�����У�ÿö�ٵ�һ�����֣�����������û�г��ֹ����ս����ֱ任�������෴����������ֳ��ֹ���������ԭ����������һ�γ��ֺ��棨���ڵ�ǰ��ǰ�棩�����˼������֣�������������滻ԭ�������֡�

���磬����(a1, a2, a3, a4, a5)=(1, 2, 2, 1, 2)�ڱ任����Ϊ��
a1: 1δ���ֹ�������a1��Ϊ-1��
a2: 2δ���ֹ�������a2��Ϊ-2��
a3: 2���ֹ������һ��Ϊԭ���е�a2����a2��a3ǰ��0�����֣�����a3��Ϊ0��
a4: 1���ֹ������һ��Ϊԭ���е�a1����a1��a4ǰ��1�����֣�����a4��Ϊ1��
a5: 2���ֹ������һ��Ϊԭ���е�a3����a3��a5ǰ��1�����֣�����a5��Ϊ1��
���ڣ�����ԭ���У����ʣ������ֱ任����任���������ʲô��

�����ʽ��
�����һ�а���һ������n����ʾ���еĳ��ȡ�
�ڶ��а���n������������ʾ�������С�

�����ʽ��
���һ�У�����n��������ʾ�任������С�

���磬���룺
5
1 2 2 1 2

����Ӧ�������
-1 -2 0 1 1

�����磬���룺
12
1 1 2 3 2 3 1 2 2 2 3 1

����Ӧ�������
-1 0 -2 -3 1 1 2 2 0 0 2 2

���ݹ�ģ��Լ��
����30%�����ݣ�n<=1000��
����50%�����ݣ�n<=30000��
����100%�����ݣ�1 <=n<=100000��1<=ai<=10^9


��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 3000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��


 */
/*
�������Ż�����ͳ�����һ�γ��ֵ����γ�������������������
���Ͻⷨ���� ʱ�临�Ӷ�Ϊn*log(n)
����ʹ����������ͳ������λ��֮��ĸ��� ���������
ʹ����������ѯĳһ������ĺ� ����ʹ�õ��Ƕ��ַ� ��ѯʱ�临�Ӷ�Ϊlog(n)
 */
package ���߽�;
import java.util.HashMap;
import java.util.Scanner;


/**
* @author JohnnyLin
* @version Creation Time��2020��5��19�� ����5:44:37
*/
public class t10_ѹ���任_�Ż� {
	static HashMap <Integer,Integer> lastIndexOf =new HashMap<>();
	static int[] a;//��¼ԭʼ����
	static int [] ans;//��¼��
	//01���� ĳһ��λ��p�ϵ�����Ϊ1��ʾ a[p]������������ֵ�λ����p a[p]�������ֹ���λ�ö���0
	//��õ����κͼ�Ϊ�������������ֵ�������
	static int[] b;
	private static SegTree root;
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		//��ʼ��
		a=new int[n];
		ans =new int[n];
		b =new int[n];
		//����������
		root = buildSegTree(0, n-1);
		for(int i=0;i<n;i++) {
			int num=reader.nextInt();
			a[i]=num;
			//������һ�γ��ֵ�λ��
			Integer preIndex=lastIndexOf.get(num);
			//��һ�γ����� ��������෴��
			if(preIndex==null) {
				ans[i]=-num;
				b[i]=1;
				update(root,i,1);
			}else {
			//ͳ�����һ�γ��ֵ����γ�������������������
				ans[i]=query(root,preIndex+1,i-1);
				b[preIndex]=0;
				b[i]=1;
				update(root, preIndex, -1);
				update(root, i, 1);
			}
			lastIndexOf.put(num, i);
		}
		for (int i = 0; i < ans.length; i++) {
			
			System.out.print(ans[i]+" ");
		}
		
	}

	private static int query(SegTree tree, int x, int y) {
		int l=tree.l;
		int r=tree.r;
		if(x<=l&&y>=r) return tree.sum;
		int mid=(l+r)>>1;
		int ans=0;
		if(x<=mid) ans+=query(tree.lson,x,y);
		if(y>mid) ans+=query(tree.rson,x,y);
		return ans;
		
	}
	/*����������*/
	/**
	 * @param l ������
	 * @param r	������
	 * @return ������
	 */
	static SegTree buildSegTree(int l,int r) {
		SegTree segTree=new SegTree(l,r);
		if(l==r) {
			segTree.sum=b[l];
			return segTree;
		}
		int mid=(l+r)>>1;
		SegTree lson=buildSegTree(l,mid);
		SegTree rson=buildSegTree(mid+1,r);
		segTree.lson=lson;
		segTree.rson=rson;
		segTree.sum=lson.sum+rson.sum;
		return segTree;
	}
	/**
	 * @param p
	 * @param i  ����
	 */
	static void update(SegTree tree,int p,int i) {
		if(tree==null) {
			return;
		}
		tree.sum+=i;
		int l=tree.l;
		int r=tree.r;
		int mid=(l+r)>>1;
		if(p<=mid) {
			update(tree.lson,p,i);
		}else {//(p>mid)
			update(tree.rson,p,i);
		}
	}
	static class SegTree{
		int l,r;//���䷶Χ
		int sum; //�����
		SegTree lson;//������
		SegTree rson;//������
		public SegTree(int l,int r) {
			this.l=l;
			this.r=r;
		}
		
	}

}
