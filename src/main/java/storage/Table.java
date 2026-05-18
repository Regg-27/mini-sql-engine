package storage;

import storage.index.HashIndex;

import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private ArrayList<Column> columns;
    private ArrayList<Row> rows;
    private String tableName;
    private HashMap<String, HashIndex> map;

    public Table(String tableName) {
        this.tableName = tableName;
        columns = new ArrayList<>();
        rows = new ArrayList<>();
        map = new HashMap<>();
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public String getTableName() {
        return tableName;
    }

    public void buildIndex(String columnName) {
        HashIndex index = new HashIndex(columnName);
        for (Row row : rows) {
            index.insert(row.getValue(columnName), row);
        }
        map.put(columnName, index);
    }

    public HashIndex getIndex(String columnName) {
        return map.get(columnName);
    }
}
