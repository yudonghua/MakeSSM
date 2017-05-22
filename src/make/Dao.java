package make;

/**
 * Created by Dell on 2017/5/22.
 */
public class Dao {
    public static void main(String args[]){
        getDao("ads das");
    }
    public static void getDao(String dao) {
        String beans[]=dao.split(" |,");
        for(String bean:beans){
            String content = "package com.dao;\r\n" +
                    "\r\n" +
                    "import com.entity.Xxx;\r\n" +
                    "import org.mybatis.spring.annotation.Mapper;\r\n" +
                    "import java.util.List;\r\n" +
                    "/**\r\n" +
                    " * Created by Yhd on 2017/5/20.\r\n" +
                    " */\r\n" +
                    "@Mapper(\"xxxDao\")\r\n" +
                    "public interface XxxDao {\r\n" +
                    "    public List<Xxx> getAllXxx(Xxx xxx);\r\n" +
                    "    public void updateXxx(Xxx xxx);\r\n" +
                    "    public void insertXxx(Xxx xxx);\r\n" +
                    "    public Xxx getXxx(String id);\r\n" +
                    "}\r\n";
            String name=(char)(bean.charAt(0)+'A'-'a')+bean.substring(1);
            content = content.replaceAll("xxx",bean);
            content = content.replaceAll("Xxx",name);
            WriteStringToFile.write("com/dao/"+name+"Dao.java",content);
        }
    }
}
