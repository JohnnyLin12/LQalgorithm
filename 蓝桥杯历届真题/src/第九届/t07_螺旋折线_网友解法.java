/*
例如dis(0, 1)=3, dis(-2, -1)=9  
 */
package 第九届;
/**
* @author JohnnyLin
* @version Creation Time：2020年6月4日 上午11:39:39
*/
import java.util.Scanner;

public class t07_螺旋折线_网友解法 {
    static int x, y;
    static int df = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();

        if (x > 0 && y >= 0) {
            int dx = Math.max(x, y);
            int dy = dx;
            df = (dx + dy) * (dx + dy);
            if (x < dx) {
                df -= (dx - x);
            }
            if (y < dy) {
                df += (dy - y);
            }
        } else if (x >= 0 && y < 0) {
            int dx = Math.max(Math.abs(x), Math.abs(y));
            int dy = -dx;
            df = (dx + Math.abs(dy)) * (dx + Math.abs(dy) + 1);
            if (x < dx) {
                df += (dx - x);
            }
            if (y > dy) {
                df -= (y - dy);
            }
        } else if (x < 0 && y <= 0) {// -2 -1
            int dx = -Math.max(Math.abs(x), Math.abs(y));//-2
            int dy = dx + 1;//-1
            df = (Math.abs(dx) + Math.abs(dy)) * (Math.abs(dx) + Math.abs(dy));//(2+1)^2=9
            if (x > dx) {
                df -= (x - dx);
            }
            if (y > dy) {
                df += (y - dy);
            }
        } else  if (x <= 0 && y > 0) {
            int dx = -Math.max(Math.abs(x), Math.abs(y));
            int dy = -dx;
            df = (Math.abs(dx) + Math.abs(dy)) * (Math.abs(dx) + Math.abs(dy) - 1);
            if (x > dx) {
                df += (x - dx);
            }
            if (y < dy) {
                df -= (y - dy);
            }
        }
        System.out.println(df);
    }
}
