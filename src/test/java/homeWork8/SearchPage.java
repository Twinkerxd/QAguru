package homeWork8;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private SelenideElement submitButton = $x("//button[@data-role='filters-submit']");
    private ElementsCollection filters = $$(".picked-filter");

    SearchPage getOperatorTariffs() {
        open("catalog/8ccf9d205ab44e77/tarify-operatorov/");
        return this;
    }

    SearchPage selectBrand(String brandName) {
        sleep(500);
        $x("//*[@data-id='brand']//span[contains(text(), '" + brandName + "')]").click();
        return this;
    }

    SearchPage clickSubmitButton() {
        sleep(500);
        submitButton.click();
        return this;
    }

    SearchPage checkIsFilterWasAdded(String brandName) {
        sleep(500);
        filters.shouldHave(CollectionCondition.itemWithText(("Производитель: " + brandName)));
        return this;
    }
}
