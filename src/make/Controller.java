package make;

/**
 * Created by Dell on 2017/5/22.
 */
public class Controller {
    public static void main(String args[]){
        getController("goods","id order customer business status");
    }
    public static void getController(String table,String entity){
        String beans[]=entity.split(" |,");
        String param = "@RequestParam(value = \"xxx\", required = false)String xxx";
        String params=param.replaceAll("xxx",beans[1]);
        String content="package com.view;\r\n" +
                "\r\n" +
                "import com.entity.Xxx;\r\n" +
                "import com.service.XxxService;\r\n" +
                "import org.springframework.stereotype.Controller;\r\n" +
                "import org.springframework.web.bind.annotation.*;\r\n" +
                "\r\n" +
                "import java.util.List;\r\n"+
                "import javax.annotation.Resource;\r\n" +
                "import javax.servlet.http.HttpServletRequest;\r\n" +
                "\r\n" +
                "@Controller\r\n" +
                "public class XxxController {\r\n" +
                "    @Resource\r\n" +
                "    private XxxService xxxService;\r\n" +
                "    public XxxService getXxxService() {\r\n" +
                "        return xxxService;\r\n" +
                "    }\r\n" +
                "    public void setXxxService(XxxService xxxService) {\r\n" +
                "        this.xxxService = xxxService;\r\n" +
                "    }\r\n" +
                "    @RequestMapping(\"searchXxx\")\r\n" +
                "    public @ResponseBody\r\n" +
                "    List<Goods> searchXxx(HttpServletRequest req," +
                "@RequestParam(value = \"id\", required = false)String id,ppp){\r\n" +
                "        Xxx xxx = new Xxx(ideee);\r\n"+
                "        List<Xxx> xxxs = xxxService.getAllXxx(xxx);\r\n" +
                "        return xxxs;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    @RequestMapping(value=\"xxx\", method= RequestMethod.GET)\r\n" +
                "    public @ResponseBody\r\n" +
                "    List<Xxx> allXxx(){\r\n" +
                "        List<Xxx> xxxs = xxxService.getAllXxx(null);\r\n" +
                "        return xxxs;\r\n" +
                "    }\r\n" +
                "    @RequestMapping(value=\"xxx\", method= RequestMethod.POST)\r\n" +
                "    public @ResponseBody\r\n" +
                "    String insertXxx(ppp){\r\n" +
                "        Xxx xxx = new Xxx(nulleee);\r\n" +
                "        xxxService.insertXxx(xxx);\r\n" +
                "        return \"success\";\r\n" +
                "    }\r\n" +
                "    @RequestMapping(value=\"xxx/{id}\", method= RequestMethod.GET)\r\n" +
                "    public @ResponseBody\r\n" +
                "    List<Xxx> idXxx(@PathVariable(\"id\") String id){\r\n" +
                "        Xxx xxx=new Xxx();\r\n" +
                "        xxx.setId(id);\r\n" +
                "        List<Xxx> xxxs = xxxService.getAllXxx(xxx);\r\n" +
                "        return xxxs;\r\n" +
                "    }\r\n" +
                "    @RequestMapping(value=\"xxx/{id}\", method= RequestMethod.PUT)\r\n" +
                "    public @ResponseBody\r\n" +
                "    String putXxx(@PathVariable(\"id\") String id,ppp){\r\n" +
                "        Xxx xxx = new Xxx(ideee);\r\n"+
                "        xxxService.updateXxx(xxx);\r\n" +
                "        return \"success\";\r\n" +
                "    }\r\n" +
                "    @RequestMapping(value=\"xxx/{id}\", method= RequestMethod.DELETE)\r\n" +
                "    public @ResponseBody\r\n" +
                "    String deleteXxx(@PathVariable(\"id\") String id){\r\n" +
                "        xxxService.deleteXxx(id);\r\n" +
                "        return \"success\";\r\n" +
                "    }\r\n" +
                "}\r\n";
        String eee = "";
        for(int i=1;i<beans.length;i++){
            eee +=","+beans[i];
        }
        for(int i=2;i<beans.length;i++){
            params+=","+param.replaceAll("xxx",beans[i]);
        }
        String name=(char)(table.charAt(0)+'A'-'a')+table.substring(1);
        content = content.replaceAll("eee",eee);
        content = content.replaceAll("ppp",params);
        content = content.replaceAll("xxx",table);
        content = content.replaceAll("Xxx",name);
        WriteStringToFile.write("com/view/"+name+"Controller.java",content);
    }
}
