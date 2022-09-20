package homework8;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class LocationPage {
    private ElementsCollection cities = $$x("//ul[@data-block-title='Город']//span");
    private SelenideElement citySelectText = $(".city-select__text");

    public LocationPage() {
        open("");
    }

    LocationPage clickCitySelect() {
        citySelectText.click();
        return this;
    }

    LocationPage chooseDistrict(String districtName) {
        $x("//span[contains(text(), '" + districtName + "')]").click();
        return this;
    }

    LocationPage chooseRegion(String regionName) {
        $x("//span[contains(text(), '" + regionName + "')]").click();
        return this;
    }

    LocationPage checkCitiesFromTheList(List<String> cities) {
        this.cities.shouldHave(CollectionCondition.texts(cities));
        return this;
    }
}
