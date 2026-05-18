package parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    @Test
    public void testParseTableName() {
        Parser parser = new Parser();
        Query query = parser.parse("SELECT Name, Age FROM USERS WHERE Age > 20");
        assertEquals("USERS", query.getTableName());
    }

    @Test
    public void testParseSelectedColumns() {
        Parser parser = new Parser();
        Query query = parser.parse("SELECT Name, Age FROM USERS");
        assertTrue(query.getSelectedColumns().contains("NAME"));
        assertTrue(query.getSelectedColumns().contains("AGE"));

    }

    @Test
    public void testParseWhereCondition() {
        Parser parser = new Parser();
        Query query = parser.parse("SELECT Name, Age FROM USERS WHERE Age > 20");
        assertEquals("AGE", query.getConditionColumn());
        assertEquals(">", query.getConditionOperator());
        assertEquals("20", query.getConditionValue());
    }
}