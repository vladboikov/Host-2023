package main.api.userAccount.miscellaneous.newEntry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entry {
    public Integer id;
    public String createDate;
    public Indicator indicator;
    public String value;
}
