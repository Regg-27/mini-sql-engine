package main;

import executor.Executor;
import parser.Parser;
import parser.Query;
import parser.QueryType;
import planner.Planner;
import storage.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Database database = new Database("database");
        Table table = new Table("USERS");

        Column column1 = new Column("NAME", DataType.STRING);
        Column column2 = new Column("AGE", DataType.INTEGER);
        table.addColumn(column1);
        table.addColumn(column2);

        Row row1 = new Row();
        Row row2 = new Row();
        Row row3 = new Row();
        row1.addValue("NAME", "Alice");
        row2.addValue("NAME", "Bob");
        row3.addValue("NAME", "Charlie");
        row1.addValue("AGE", 25);
        row2.addValue("AGE", 17);
        row3.addValue("AGE", 30);
        table.addRow(row1);
        table.addRow(row2);
        table.addRow(row3);

        database.addTable(table);
        Parser parser = new Parser();
        Executor executor = new Executor(database);
        Planner planner = new Planner(executor);

        String sqlQuery = "SELECT Name, Age FROM users WHERE Age > 20";
        ArrayList<Row> results = planner.plan(parser.parse(sqlQuery));
        for (Row row : results) {
            System.out.print(row.getValue("NAME") + " ");
            System.out.println(row.getValue("AGE"));
        }
    }
}
