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

    @org.junit.jupiter.api.Test
    public void test1() {
        String text = "Hello!";
        String time = "0 12 24 48 128 129";
        int lengthText = text.length();
        int maxTime = 0;
        int maxIndex = 0;
        String[] timeSplited = time.split(" ");

        for (int i = 1; i < timeSplited.length; i++) {
            if (Integer.parseInt(timeSplited[i]) - Integer.parseInt(timeSplited[i - 1]) > maxTime) {
                maxTime = Integer.parseInt(timeSplited[i]);
                maxIndex = i;
            }
        }
        String[] textSplited = text.split("");
        System.out.println("textSplited[maxIndex] = " + text.split("")[maxIndex]);
    }
}
