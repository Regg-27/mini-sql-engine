package parser;

import java.util.ArrayList;

public class Parser {
    public Query parse(String sql) {
        sql = sql.toUpperCase();
       String[] tokens = sql.split(" ");
       if (tokens[0].equals("SELECT")) {
           ArrayList<String> columns = new ArrayList<>();
           String tableName = null;
           boolean collectingColumns = false;
           String column = null;
           String operator = null;
           String value = null;

           for (int i = 0; i < tokens.length; i++) {
               if (tokens[i].equals("SELECT")) {
                   collectingColumns = true;
               } else if (tokens[i].equals("FROM")) {
                   collectingColumns = false;
                   tableName = tokens[i + 1];
               } else if (collectingColumns) {
                   columns.add(tokens[i].replace(",", ""));
               } else if (tokens[i].equals("WHERE")) {
                   column = tokens[i + 1];
                   operator = tokens[i + 2];
                   value = tokens[i + 3];
               }
           }
           Query query = new Query(QueryType.SELECT, columns, tableName);
           query.setConditionColumn(column);
           query.setConditionOperator(operator);
           query.setConditionValue(value);
           return query;
       }
       return null;
    }
}
