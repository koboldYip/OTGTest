package first;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

@Data
public class JSONMapper {
    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public List<Table> mapJSON(String filePath) {
        return objectMapper.readValue(
                new File(filePath), new TypeReference<>() {
                }
        );
    }
}
