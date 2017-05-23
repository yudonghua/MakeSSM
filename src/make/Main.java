package make;

/**
 * Created by Dell on 2017/5/22.
 */
public class Main {
    public static void main (String args[]){
        String table ="goods";
        String entity = "customer business status";
        getAll(table,entity);
    }
    public static void getAll(String table,String entity){
        entity = "id "+entity;
        new Entity().getBean(table,entity);
        new Dao().getDao(table);
        new Service().getImpl(table);
        new Service().getService(table);
        new Sql().getSql(table,entity);
        new Xml().getXml(table,entity);
        new Controller().getController(table,entity);
    }
}
