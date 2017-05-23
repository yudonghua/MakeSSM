package make;

/**
 * Created by Dell on 2017/5/22.
 */
public class Service {
    public static void main(String arg[]){
        getService("ads sad");
        getImpl("ads sad");
    }
    public static void getImpl(String service){
        String beans[]=service.split(" |,");
        for(String bean:beans){
            String content = "package com.service.impl;\r\n" +
                    "\r\n" +
                    "import com.dao.XxxDao;\r\n" +
                    "import com.entity.Xxx;\r\n" +
                    "import com.service.XxxService;\r\n" +
                    "\r\n" +
                    "import java.util.List;\r\n" +
                    "\r\n" +
                    "/**\r\n" +
                    " * Created by Dell on 2017/5/20.\r\n" +
                    " */\r\n" +
                    "public class XxxServiceImpl implements XxxService {\r\n" +
                    "    private XxxDao xxxDao;\r\n" +
                    "    public void setXxxDao(XxxDao XxxDao) {this.xxxDao = XxxDao;}\r\n" +
                    "    public List<Xxx> getAllXxx(Xxx xxx){return this.xxxDao.getAllXxx(xxx);};\r\n" +
                    "    public void updateXxx(Xxx xxx){ this.xxxDao.updateXxx(xxx);};\r\n" +
                    "    public void insertXxx(Xxx xxx){ this.xxxDao.insertXxx(xxx);}\r\n" +
                    "    public Xxx getXxx(String id){return this.xxxDao.getXxx(id);}\r\n" +
                    "    public void deleteXxx(String id){this.xxxDao.deleteXxx(id);}\r\n" +
                    "}\r\n";
            String name=(char)(bean.charAt(0)+'A'-'a')+bean.substring(1);
            content = content.replaceAll("xxx",bean);
            content = content.replaceAll("Xxx",name);
            WriteStringToFile.write("com/service/impl/"+name+"ServiceImpl.java",content);
        }
    }
    public static void getService(String service) {
        String beans[]=service.split(" |,");
        for(String bean:beans){
            String content = "package com.service;\r\n" +
                    "\r\n" +
                    "import com.entity.Xxx;\r\n" +
                    "import org.mybatis.spring.annotation.Mapper;\r\n" +
                    "import java.util.List;\r\n" +
                    "/**\r\n" +
                    " * Created by Yhd on 2017/5/20.\r\n" +
                    " */\r\n" +
                    "@Mapper(\"xxxService\")\r\n" +
                    "public interface XxxService {\r\n" +
                    "    public List<Xxx> getAllXxx(Xxx xxx);\r\n" +
                    "    public void updateXxx(Xxx xxx);\r\n" +
                    "    public void insertXxx(Xxx xxx);\r\n" +
                    "    public Xxx getXxx(String id);\r\n" +
                    "    public void deleteXxx(String id);\r\n" +
                    "}\r\n";
            String name=(char)(bean.charAt(0)+'A'-'a')+bean.substring(1);
            content = content.replaceAll("xxx",bean);
            content = content.replaceAll("Xxx",name);
            WriteStringToFile.write("com/service/"+name+"Service.java",content);
        }
    }

}
