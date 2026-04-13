package storage;

import java.util.HashMap;

public class Database {
    private String databaseName;
    private HashMap<String, Table> tables;

    public Database(String databaseName) {
        this.databaseName = databaseName;
        tables = new HashMap<>();
    }

    public void addTable(Table table) {
        tables.put(table.getTableName(), table);
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    public String getDatabaseName() {
        return databaseName;
    }

}
