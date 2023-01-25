package demoqa.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {
    String title = "Thanks for submitting the form";

    public RegistrationResultsModal verifyResultsAppears (){
        $("#example-modal-sizes-title-lg").shouldHave(text(title));

        return this;
    }
    public RegistrationResultsModal checkAllOutputData(String value)
    {

        $("tbody").shouldHave(text(value));

        return this;
    }
}
