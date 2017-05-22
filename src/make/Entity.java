package make;

/**
 * Created by Dell on 2017/5/22.
 */
public class Entity {
    public static void main(String arg[]){
        getBean("goods","das ads sad");
    }
    public static void getBean(String table,String entity) {
        String beans[]=entity.split(" |,");
        String content="package com.entity;\r\n" +
                "public class Xxx {"+"\r\n";
        for(String bean:beans){
            content+="private String "+bean+";"+"\r\n";
        }
        for(String bean:beans){
            content+="public void set"+(char)(bean.charAt(0)+'A'-'a')+bean.substring(1)
                    +"(String "+bean+")"+"{this."+bean+"="+bean+";}"+"\r\n";
        }
        for(String bean:beans){
            content+="public String get"+(char)(bean.charAt(0)+'A'-'a')
                    +bean.substring(1)+"()"+"{return this."+bean+";}"+"\r\n";
        }
        String str="String "+beans[0];
        for(int i=1;i<beans.length;i++)str+=",String "+beans[i];
        content+="public Xxx("+str+"){";
        str="";
        for(int i=0;i<beans.length;i++)str+="this."+beans[i]+"="+beans[i]+";";
        content+=str+"}"+"\r\n";
        content+="public Xxx(){}"+"\r\n";
        content+="\r\n}";
        content=content.replaceAll("xxx",table);
        String name = (char)(table.charAt(0)+'A'-'a')+table.substring(1);
        content=content.replaceAll("Xxx",name);
        WriteStringToFile.write("com/entity/"+name+".java",content);
    }
}
