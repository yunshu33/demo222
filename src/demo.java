import balloon.del;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * classname:demo
 * package_name:PACKAGE_NAME
 * Description(描述):
 *
 * @Date:2021/5/25 15:36
 * @Auther:yunshu
 */
public class demo {
    public static void main(String[] args) {
        String sx2 = "", sy2 = "";
        String str;
        int ix1 = 0, iy1 = 0, ix2 = 0, iy2 = 0;
        int x = 50000, y = 10000;
        BufferedImage bi = new BufferedImage
                (x, y, BufferedImage.TYPE_INT_RGB);//INT精确度达到一定,RGB三原色，高度70,宽度150
        // 得到它的绘制环境(这张图片的笔)
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.fillRect(0, 0, x, y);//填充一个矩形 左上角坐标(0,0),宽5000,高1000;填充整张图片
        g2.setColor(Color.WHITE);//设置颜色
        g2.fillRect(0, 0, x, y);//填充整张图片(其实就是设置背景颜色)
        g2.setColor(Color.black);
        g2.drawRect(0, 0, x - 1, y - 1); //画边框
//        File file = new File("/Users/xupengwei/hehe/" + picType);
        g2.setStroke(new BasicStroke(8.0f));
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\learn\\qq\\qq (1).nc"));
            //关于文件改名，可以全选文件同时改名
            //注意qq与”（“之间的空格
//            in.close();
            while ((str = in.readLine()) != null) {
                char G = ' ', I = ' ';
                G = str.charAt(0);
                I = str.charAt(1);
                if (G == 'G' && I == '1') {//判断是否为G1操作
                    String[] mac = str.split(" ");
                    del del = new del();
                    System.out.print(mac[1]);
                    System.out.print("\t");
                    System.out.println(mac[2]);
                    sx2 = del.del(mac[1]);//去除字母X
                    sy2 = del.del(mac[2]);//去除字母Y
                    ix2 = (int)del.magnifyx(sx2);
                    iy2 = (int)del.magnifyy(sy2);
                    System.out.print("X"+ix2);
                    System.out.print("\t");
                    System.out.println("Y"+iy2);
                } else {
                    ix2=iy2=0;//非G1操作码跳过本次循环
                }
                //得到图片缓冲区
//          g2.setFont(new Font("宋体",Font.BOLD,18)); //设置字体:字体、字号、大小
//          g2.setColor(Color.BLACK);//设置背景颜色
//                    System.out.println("绘图中"+times++);
                if((ix1 !=0 || iy1 != 0)&&(ix2!=0 || iy2!=0))
                    g2.drawLine(ix1, iy1, ix2, iy2);//画线段
//                    g2.drawString("绘图",ix1,iy1); //向图片上写字符串
                ix1 = ix2;
                iy1 = iy2;//赋值传递给线段起点
                sy2 = "";
                sx2 = "";
                ix2 = 0;
                iy2 = 0;
            }
            ImageIO.write(bi, "JPEG", new FileOutputStream("D:\\learn\\p\\balloon.jpg"));//保存图片 JPEG表示保存格式
            System.out.println("第1张图片已完成");
        } catch (IOException e) {
            System.out.println("读取失败");
        }
    }
}
