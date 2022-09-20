package homework8;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProcessorPage {

    private ElementsCollection processorType = $$(".multicard__values label");
    private SelenideElement price = $(".product-buy__price");

    public ProcessorPage() {
        open("product/21b660ca60db526f/processor-amd-fx-4300-oem/");
    }

    ProcessorPage clickProcessorType(String typeName) {
        processorType.find(text(typeName)).click();
        return this;
    }

    void checkProcessorPrice(String expectedPrice) {
        price.shouldHave(text(expectedPrice));
    }
}
