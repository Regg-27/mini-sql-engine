package executor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.Parser;
import parser.Query;
import planner.Planner;
import storage.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExecutorTest {
    Database database = new Database("database");
    Parser parser = new Parser();
    Executor executor = new Executor(database);
    Planner planner = new Planner(executor);

    @BeforeEach
    public void databaseSetUp() {
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

    }

    @Test
    public void testWhereGreaterThan() {
        String sqlQuery = "SELECT Name, Age FROM users WHERE Age > 20";
        ArrayList<Row> results = planner.plan(parser.parse(sqlQuery));
        assertEquals(2, results.size());
    }

    @Test
    public void testWhereLessThan() {
        String sqlQuery = "SELECT Name, Age FROM users WHERE Age < 20";
        ArrayList<Row> results = planner.plan(parser.parse(sqlQuery));
        assertEquals(1, results.size());
    }

    @Test
    public void testNoWhereClause() {
        String sqlQuery = "SELECT Name, Age FROM users";
        ArrayList<Row> results = planner.plan(parser.parse(sqlQuery));
        assertEquals(3, results.size());
    }
}
