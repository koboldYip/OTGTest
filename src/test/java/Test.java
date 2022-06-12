import first.JSONMapper;
import first.Table;
import first.XLSXWriter;

import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void test() {
        JSONMapper jsonMapper = new JSONMapper();
        List<Table> table = jsonMapper.mapJSON("src/main/resources/4test.json");
        XLSXWriter xlsxWriter = new XLSXWriter();
        xlsxWriter.writeXLSX(table);
        System.out.println();
    }
}
