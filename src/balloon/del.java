package balloon;

/**
 * classname:del
 * package_name:PACKAGE_NAME
 * Description(描述):
 *
 * @Date:2021/5/25 14:07
 * @Auther:yunshu33
 */
public class del {
   public static String del(String mac)
    {
        String x="";
        for(int z=1;z<mac.length();z++)
        x+= String.valueOf(mac.charAt(z));
        return x;
    }
    public static long magnifyy(String str){//转换与放大100倍
       long xy=0,k=0;
        for(int z=0;z<str.length();z++)//y放大与转换
        {
            if(str.charAt(z) == '.')
            {
                k=z;
            }
            else
            {
                xy=xy*10+Integer.parseInt(String.valueOf(str.charAt(z)));
            }
        }
        if(k!=0) {
            int j = 0;
            j = (int) (str.length() - k - 1);
            if (j < 3) {
                xy = xy * 10;
            }//检测小数点后是否只有两位
            if (j < 2) {
                xy = xy * 10;
            }//检测小数点后是否只有一位
        xy=10000-xy/10;//y轴翻转
//            xy = xy / 10;
        }
        else{
            xy=xy*100;
        }
       return xy;
    }
    public static long magnifyx(String str){//转换与放大100倍
        long xy=0,k=0;
        for(int z=0;z<str.length();z++)//y放大与转换
        {
            if(str.charAt(z) == '.')
            {
                k=z;
            }
            else
            {
                xy=xy*10+Integer.parseInt(String.valueOf(str.charAt(z)));
            }
        }
        if(k!=0) {
            int j = 0;
            j = (int) (str.length() - k - 1);
            if (j < 3)
            {
                xy = xy * 10;
                if (j < 2)
                {
                    xy = xy * 10;
                }//检测小数点后是否只有一位
            }//检测小数点后是否只有两位

            xy = xy / 10;
        }
        else{
            xy=xy*100;
        }
        return xy;
    }
}
