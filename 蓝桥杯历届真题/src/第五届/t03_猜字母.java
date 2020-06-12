/*题目描述：
 * 
 * 标题：猜字母

    把abcd...s共19个字母组成的序列重复拼接106次，得到长度为2014的串。

    接下来删除第1个字母（即开头的字母a），以及第3个，第5个等所有奇数位置的字母。

    得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。

答案是一个小写字母，请通过浏览器提交答案。不要填写任何多余的内容。
 *答案：q 
 */
package 第五届;

public class t03_猜字母 {

	public static void main(String[] args) {
		String s= "abcdefghijklmnopqrs";
		String news="";
		for(int i=1;i<=106;i++) {
			news+=s;
		}
		char[] c=news.toCharArray();
		int length=c.length;
		while(length>1) {
			int k=0;
			//在原数组上进行覆盖
			for(int i=0;i<length;i++) {
				if(i%2==1) {//下标为奇数  覆盖前面的偶数下标（原序列中要删除的数）
					c[k++]=c[i];
				}else {
					length--;//没遇到一个偶数下标长度就减1
				}
			}
		}
		System.out.println(c[0]);
		

	}

}
