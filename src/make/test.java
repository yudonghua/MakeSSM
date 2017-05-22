package make;

/**
 * Created by Dell on 2017/5/22.
 */
public class test {
    public static void main(String arg[]){
        String ss = "aa";
        String str = "${ds}";
        str=str.replaceAll("\\$","\\\\\\$");
        System.out.println(str);
    }
}
