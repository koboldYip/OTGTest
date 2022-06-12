package first;

import lombok.Data;

@Data
public class Table {
    private String name;
    private String category;
    private String numberOfSubscribers;
    private String description;
    private String link;
    private Boolean hiddenFromTheNews;
}
