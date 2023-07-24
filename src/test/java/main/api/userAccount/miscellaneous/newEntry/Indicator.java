package main.api.userAccount.miscellaneous.newEntry;
import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Indicator{
    public int id;
    public String name;
    public String unit;
}
