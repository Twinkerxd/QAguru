package homeWork8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

public class Tests extends BaseTest {

    @ValueSource(strings = {"Теле2", "Yota"})
    @ParameterizedTest(name = "Проверяем добавление фильтра для оператора {0}")
    void addingNewFilter(String brandName) {
        new SearchPage()
                .getOperatorTariffs()
                .selectBrand(brandName)
                .clickSubmitButton()
                .checkIsFilterWasAdded(brandName);
    }

    @CsvSource(value = {
            "BOX, 2 299 ₽",
            "OEM, 1 999 ₽"
    })

    @ParameterizedTest(name = "Проверяем стоимость процессора {0} ценой: {1}")
    void priceOfProcessorsForDifferentTypes(String processorType, String expectedPrice) {
        // Тест нестабильный, победить не смог :c
        new ProcessorPage()
                .clickProcessorType(processorType)
                .checkProcessorPrice(expectedPrice);
    }

    static Stream<Arguments> dataProviderForCitiesCheck() {
        return Stream.of(
                Arguments.of("Дальневосточный", "Бурятия",
                        List.of("Гусиноозерск", "Кяхта", "Северобайкальск", "Селенгинск", "Улан-Удэ")),
                Arguments.of("Сибирский", "Алтай",
                        List.of("Горно-Алтайск", "Кош-Агач", "Майма", "Онгудай", "Турочак"))
        );
    }

    @MethodSource("dataProviderForCitiesCheck")
    @ParameterizedTest(name = "Проверяем наличие городов для округа: {0}, региона: {1}")
    void citiesForTheSelectedDistrictAndRegion(String district, String region, List<String> cities) {
        new LocationPage()
                .clickCitySelect()
                .chooseDistrict(district)
                .chooseRegion(region)
                .checkCitiesFromTheList(cities);
    }
}
