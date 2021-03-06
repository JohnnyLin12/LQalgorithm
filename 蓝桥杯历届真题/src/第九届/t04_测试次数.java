/*

标题：测试次数

x星球的居民脾气不太好，但好在他们生气的时候唯一的异常举动是：摔手机。
各大厂商也就纷纷推出各种耐摔型手机。x星球的质监局规定了手机必须经过耐摔测试，
并且评定出一个耐摔指数来，之后才允许上市流通。
x星球有很多高耸入云的高塔，刚好可以用来做耐摔测试。
塔的每一层高度都是一样的，与地球上稍有不同的是，他们的第一层不是地面，而是相当于我们的2楼。
如果手机从第7层扔下去没摔坏，但第8层摔坏了，则手机耐摔指数=7。
特别地，如果手机从第1层扔下去就坏了，则耐摔指数=0。
如果到了塔的最高层第n层扔没摔坏，则耐摔指数=n
为了减少测试次数，从每个厂家抽样3部手机参加测试。
某次测试的塔高为1000层，如果我们总是采用最佳策略，
在最坏的运气下最多需要测试多少次才能确定手机的耐摔指数呢？

请填写这个最多测试次数。

注意：需要填写的是一个整数，不要填写任何多余内容。

 */
/*
用到知识点：
二分查找
答案：10
 */
package 第九届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月28日 下午10:15:57
*/
public class t04_测试次数 {

	public static void main(String[] args) {
		int low=1;
		int high=1000;
		int cnt=0;
		
		//最坏的运气下手机的耐摔指数为1000 1875/2=937 1937/2=968 484 492 496 
		int n=1000;//500 750 875 937 968 984 992 996
		while(low<=high) {
			int mid=(low+high)>>1;
			if(mid<=n) {
				low=mid+1;
				cnt++;
			}else {
				high=mid-1;
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
