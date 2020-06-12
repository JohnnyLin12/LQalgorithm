package 第八届;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class t04_魔方状态
{
 
	/**
	 * 
	 * 标题：魔方状态
	 * 
	 * 二阶魔方就是只有2层的魔方，只由8个小块组成。 如图p1.png所示。
	 * 
	 * 小明很淘气，他只喜欢3种颜色，所有把家里的二阶魔方重新涂了颜色，如下：
	 * 
	 * 前面：橙色 右面：绿色 上面：黄色 左面：绿色 下面：橙色 后面：黄色
	 * 
	 * 请你计算一下，这样的魔方被打乱后，一共有多少种不同的状态。
	 * 
	 * 如果两个状态经过魔方的整体旋转后，各个面的颜色都一致，则认为是同一状态。
	 * 
	 * 请提交表示状态数的整数，不要填写任何多余内容或说明文字。
	 * 
	 * @param args
	 */
	//全排列问题
	//通过分析，此魔方一共八块 分别是 黄橙绿四块  橙橙绿两块  黄黄绿两块
	//即此题变成11112233的全排列问题
	//但是11112233与33221111相同
	static int count;
	static List<String> list=new ArrayList<>();
	public static void main(String[] args)
	{
		String string="11112233";
		f(string.toCharArray(),0);
		System.out.println(count);
	}
 
	private static void f(char[] charArray, int i)
	{
		if (i==8)
		{
			String string=new String(charArray);
			String string2=reverse(string);
			if (list.contains(string)||list.contains(string2))
			{
				return;
			}
			count++;
			System.out.println(string);
			list.add(string);
		}
		
		for (int j = i; j < charArray.length; j++)
		{
			char old=charArray[i];
			charArray[i]=charArray[j];
			charArray[j]=old;
			
			f(charArray, i+1);
			
			old=charArray[i];
			charArray[i]=charArray[j];
			charArray[j]=old;
		}
	}
	private static String reverse(String string)
	{
		String string2="";
		for (int i = 0; i < string.length(); i++)
		{
			string2=string.charAt(i)+string2;
		}
		return string2;
	}                                                                                                                                                                                                                                                                                                               
}
//229878