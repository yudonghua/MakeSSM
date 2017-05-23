package make;

/**
 * Created by Dell on 2017/5/22.
 */
public class Xml {
    public static void main(String arg[]){
        String dao = "goods";
        String entity = "das,dsa,da";
        getXml(dao,entity);
    }
    public static void getXml(String dao,String entity){
        String beans[]=entity.split(" |,");
        String content="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n" +
                "<!DOCTYPE mapper\r\n" +
                "        PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\r\n" +
                "        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n" +
                "<mapper namespace=\"com.dao.XxxDao\">\r\n" +
                "    <insert id=\"insertXxx\" parameterType=\"Xxx\">\r\n" +
                "        <selectKey keyProperty=\"id\" resultType=\"String\" order=\"BEFORE\">\r\n" +
                "            select replace(uuid(),'-','') from dual\r\n" +
                "        </selectKey>\r\n" +
                "        insert into xxx(bean) values(bntwo)\r\n" +
                "    </insert>\r\n" +
                "    <delete id=\"deleteXxx\" parameterType=\"String\">\r\n" +
                "        delete from xxx where id = #{id}\r\n" +
                "    </delete>\r\n"+
                "    <select id=\"getAllXxx\" resultType=\"Xxx\" parameterType=\"Xxx\">\r\n" +
                "        SELECT bean FROM xxx\r\n" +
                "        <trim suffixOverrides=\"and\">\r\n" +
                "            <where>\r\n" +
                "                condition\r\n" +
                "            </where>\r\n" +
                "        </trim>\r\n" +
                "    </select>\r\n" +
                "    <select id=\"getXxx\" resultType=\"Xxx\" parameterType=\"String\">\r\n" +
                "        SELECT bean FROM xxx where xxx.id=#{id}\r\n" +
                "    </select>\r\n" +
                "    <update id=\"updateXxx\" parameterType=\"Xxx\">\r\n" +
                "        update xxx set\r\n" +
                "        <trim suffixOverrides=\",\">\r\n" +
                "                cdtwo\r\n" +
                "        </trim>\r\n" +
                "        where id=#{id}\r\n" +
                "    </update>\r\n" +
                "</mapper>";
        String cd="<if test=\"xxx!=null\"> xxx like CONCAT('%','${xxx}','%') and </if> \r\n";
        String cd2="<if test=\"xxx!=null\"> xxx=#{xxx},</if> \r\n";
        String condition="";
        String condition2="";
        String name=(char)(dao.charAt(0)+'A'-'a')+dao.substring(1);
        String bean=beans[0];
        String bean2="#{"+beans[0]+"}";
        for(int i=1;i<beans.length;i++){
            bean+=","+beans[i];
            bean2+=",#{"+beans[i]+"}";
            condition+=cd.replaceAll("xxx",beans[i]);
            condition2+=cd2.replaceAll("xxx",beans[i]);
        }
        condition = condition.replaceAll("\\$","\\\\\\$");
        content = content.replaceAll("Xxx",name);
        content = content.replaceAll("xxx",dao);
        content = content.replaceAll("bean",bean);
        content = content.replaceAll("bntwo",bean2);
        content = content.replaceAll("condition",condition);
        content = content.replaceAll("cdtwo",condition2);
        WriteStringToFile.write("mybatis_config/"+name+".xml",content);
    }
}
