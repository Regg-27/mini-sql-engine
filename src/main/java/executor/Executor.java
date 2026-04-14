package executor;

import parser.Query;
import storage.Database;
import storage.Row;
import storage.Table;

import java.util.ArrayList;

public class Executor {
    private Database database;

    public Executor(Database database) {
        this.database = database;
    }

    public ArrayList<Row> execute(Query query) {
        Table queryTable = database.getTable(query.getTableName());
        ArrayList<Row> results = new ArrayList<>();
        for (Row row : queryTable.getRows()) {
            if (query.getConditionColumn() != null) {
                Integer rowValue = (Integer) row.getValue(query.getConditionColumn());
                Integer conditionValue = Integer.parseInt(query.getConditionValue());

                switch (query.getConditionOperator()) {
                    case ">" -> {
                        if (rowValue > conditionValue) {
                            results.add(row);
                        }
                    }
                    case "=" -> {
                        if (rowValue.equals(conditionValue)) {
                            results.add(row);
                        }
                    }
                    case "<" -> {
                        if (rowValue < conditionValue) {
                            results.add(row);
                        }
                    }
                }
            } else {
                results.add(row);
            }
        }
        return results;
    }
}
