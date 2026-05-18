package storage.index;

import storage.Row;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class HashIndex {
    private String columnName;
    private HashMap<Object, ArrayList<Row>> map;

    public HashIndex(String columnName) {
        this.columnName = columnName;
        map = new HashMap<>();
    }

    public void insert(Object key, Row row) {
        ArrayList<Row> rows = map.getOrDefault(key, new ArrayList<>());
        rows.add(row);
        map.put(key, rows);
    }

    public ArrayList<Row> get(Object key) {
        return map.get(key);
    }
}
