/**
* @author JohnnyLin
* @version Creation Time：2020年5月19日 下午8:51:13
* 类说明
*/
/*

压缩变换

小明最近在研究压缩算法。
他知道，压缩的时候如果能够使得数值很小，就能通过熵编码得到较高的压缩比。
然而，要使数值很小是一个挑战。

最近，小明需要压缩一些正整数的序列，这些序列的特点是，后面出现的数字很大可能是刚出现过不久的数字。对于这种特殊的序列，小明准备对序列做一个变换来减小数字的值。

变换的过程如下：
从左到右枚举序列，每枚举到一个数字，如果这个数字没有出现过，刚将数字变换成它的相反数，如果数字出现过，则看它在原序列中最后的一次出现后面（且在当前数前面）出现了几种数字，用这个种类数替换原来的数字。

比如，序列(a1, a2, a3, a4, a5)=(1, 2, 2, 1, 2)在变换过程为：
a1: 1未出现过，所以a1变为-1；
a2: 2未出现过，所以a2变为-2；
a3: 2出现过，最后一次为原序列的a2，在a2后、a3前有0种数字，所以a3变为0；
a4: 1出现过，最后一次为原序列的a1，在a1后、a4前有1种数字，所以a4变为1；
a5: 2出现过，最后一次为原序列的a3，在a3后、a5前有1种数字，所以a5变为1。
现在，给出原序列，请问，按这种变换规则变换后的序列是什么。

输入格式：
输入第一行包含一个整数n，表示序列的长度。
第二行包含n个正整数，表示输入序列。

输出格式：
输出一行，包含n个数，表示变换后的序列。

例如，输入：
5
1 2 2 1 2

程序应该输出：
-1 -2 0 1 1

再例如，输入：
12
1 1 2 3 2 3 1 2 2 2 3 1

程序应该输出：
-1 0 -2 -3 1 1 2 2 0 0 2 2

数据规模与约定
对于30%的数据，n<=1000；
对于50%的数据，n<=30000；
对于100%的数据，1 <=n<=100000，1<=ai<=10^9


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 3000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。


 */
/*
这道题的优化在于统计最后一次出现到本次出现这段区间的数字种类
网上解法如下 时间复杂度为n*log(n)
可以使用区间树来统计两个位置之间的个数 即求区间和
使用区间树查询某一段区间的和 由于使用的是二分法 查询时间复杂度为log(n)
 */
package 第七届;
import java.util.HashMap;
import java.util.Scanner;


/**
* @author JohnnyLin
* @version Creation Time：2020年5月19日 下午5:44:37
*/
public class t10_压缩变换_优化 {
	static HashMap <Integer,Integer> lastIndexOf =new HashMap<>();
	static int[] a;//记录原始数据
	static int [] ans;//记录答案
	//01序列 某一个位置p上的数字为1表示 a[p]这个数字最后出现的位置是p a[p]曾经出现过的位置都是0
	//求得的区段和即为该区段所有数字的种类数
	static int[] b;
	private static SegTree root;
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		//初始化
		a=new int[n];
		ans =new int[n];
		b =new int[n];
		//构建区间树
		root = buildSegTree(0, n-1);
		for(int i=0;i<n;i++) {
			int num=reader.nextInt();
			a[i]=num;
			//该数上一次出现的位置
			Integer preIndex=lastIndexOf.get(num);
			//第一次出现则 存该数的相反数
			if(preIndex==null) {
				ans[i]=-num;
				b[i]=1;
				update(root,i,1);
			}else {
			//统计最后一次出现到本次出现这段区间的数字种类
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
	/*构建区间树*/
	/**
	 * @param l 左区间
	 * @param r	右区间
	 * @return 区间树
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
	 * @param i  增量
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
		int l,r;//区间范围
		int sum; //区间和
		SegTree lson;//左子树
		SegTree rson;//右子树
		public SegTree(int l,int r) {
			this.l=l;
			this.r=r;
		}
		
	}

}
