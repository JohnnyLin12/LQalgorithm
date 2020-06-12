/*

生日蜡烛

某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。

现在算起来，他一共吹熄了236根蜡烛。

请问，他从多少岁开始过生日party的？

请填写他开始过生日party的年龄数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。


26


(26+33)*8/2=59*4=236
 */
package 第七届;
/**
* @author JohnnyLin
* @version Creation Time：2020年5月10日 下午1:55:53
*/
public class t02_生日蜡烛 {

	public static void main(String[] args) {
		//boolean flag = false;
		for(int begin=1;begin<150;begin++) {
			for(int now=begin+1;now<150;now++) {
				if((begin+now)*(now-begin+1)/2==236) {
					System.out.println(begin+" "+now);
//					flag=true;
					break;
				}
			}
//			if(flag) {
//				break;
//			}
		}
	}

}
