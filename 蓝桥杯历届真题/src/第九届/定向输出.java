package 第九届;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
* @author JohnnyLin
* @version Creation Time：2020年6月2日 下午5:32:31
*/
public class 定向输出 {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 *System.out是系统的标准输出流，默认向控制台输出信息
		 *但是可以通过System.setOut()方法将输出输出到文件或其他地方 
		 */
		//文件对像 该文件默认会在项目工程下生成 也可以显示指定位置 如:E:\abc.txt
		File file = new File("abc.txt");
		
		PrintStream p=new PrintStream(file);
		String s="Hello Johnny!";
		p.print(s);
		System.setOut(p);

	}

}
