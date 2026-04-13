package storage;

import java.util.ArrayList;

public class Table {
    private ArrayList<Column> columns;
    private ArrayList<Row> rows;
    private String tableName;

    public Table(String tableName) {
        this.tableName = tableName;
        columns = new ArrayList<>();
        rows = new ArrayList<>();
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
}
