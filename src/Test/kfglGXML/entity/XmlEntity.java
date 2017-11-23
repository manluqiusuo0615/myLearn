package Test.kfglGXML.entity;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-10-19 10:11
 */
public class XmlEntity {
    private String table_name;
    private String sql_id;
    private String sql_content;

    public String getSql_content() {
        return sql_content;
    }

    public void setSql_content(String sql_content) {
        this.sql_content = sql_content;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getSql_id() {
        return sql_id;
    }

    public void setSql_id(String sql_id) {
        this.sql_id = sql_id;
    }
}
