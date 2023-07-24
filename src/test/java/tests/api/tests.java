package tests.api;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import main.api.userAccount.miscellaneous.newEntry.Indicator;
import main.api.userAccount.miscellaneous.newEntry.Entry;
import main.api.specs.Specifications;
import org.testng.annotations.Test;
import java.time.LocalDateTime;
import java.util.List;
import static io.restassured.RestAssured.given;

public class tests {

    @Test
    @Owner("Влад")
    @Description("Успешное создание записи в 'Показатели здоровья' с текущими датой и временем")
    public void addNewEntry_success() {

        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpec200());
        LocalDateTime currentTime = LocalDateTime.now();

        var temperature = Entry.builder()
                .id(null)
                .createDate(currentTime.toString())
                .indicator(new Indicator(62, "Температура", "°С"))
                .value("36.6").build();
        var weight = Entry.builder()
                .id(null)
                .createDate(currentTime.toString())
                .indicator(new Indicator(81, "Вес", "кг"))
                .value("75").build();
        var pressure = Entry.builder()
                .id(null)
                .createDate(currentTime.toString())
                .indicator(new Indicator(82, "Давление", null))
                .value("[\"140\", \"90\"]").build();

        var indicators = List.of(temperature, weight, pressure);

        given()
                .body(indicators)
                .when().post("/api/pp/rest/health/saveAll")
                .then().log().all();
    }
}
