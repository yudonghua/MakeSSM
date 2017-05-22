package make;

/**
 * Created by Dell on 2017/5/22.
 */
public class Sql {
    public static void main(String args[]){
        getSql("goods","id ads sad");
    }
    public static String getSql(String table,String bean){
        String[] beans=bean.split(" |,");
        String content="drop table if exists xxx;\r\n" +
                "create table xxx(sss)" +
                "ENGINE=InnoDB DEFAULT CHARSET=utf8;\r\n";
        String sql="id varchar(255) primary key,";
        for(int i=1;i<beans.length-1;i++){
            sql+=beans[i]+" varchar(255),";
        }
        sql+=beans[beans.length-1]+" varchar(255)";
        content=content.replaceAll("xxx","xxx."+table);
        content=content.replaceAll("sss",sql);
        WriteStringToFile.write("com/spring_config/initDataBase.sql",content);
        return content;
    }

}
