package planner;

import executor.Executor;
import parser.Query;
import storage.Row;

import java.util.ArrayList;

public class Planner {
    private Executor executor;

    public Planner(Executor executor) {
        this.executor = executor;
    }

    public ArrayList<Row> plan(Query query) {
        return executor.execute(query);
    }

}
