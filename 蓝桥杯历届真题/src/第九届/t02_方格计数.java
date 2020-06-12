/*
 标题：方格计数

如图p1.png所示，在二维平面上有无数个1x1的小方格。


我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
你能计算出这个圆里有多少个完整的小方格吗？ 

注意：需要提交的是一个整数，不要填写任何多余内容。
 */
/*
 由于圆是对称的 所以只需要统计正半轴的方格数再乘以4即可得到总数
 方格能在圆内实际上就是 方格右上方点到圆心距离小于等于半径
 答案：3137548
 */
package 第九届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月28日 下午8:30:11
* 类说明
*/
public class t02_方格计数 {

	public static void main(String[] args) {
		int r=1000;
		int ans=0;
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= r; j++) {
				if(i*i+j*j<=r*r)
					ans++;
			}
		}
		System.out.println(ans*4);

	}

}
