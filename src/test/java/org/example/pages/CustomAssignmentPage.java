package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro/")
public class CustomAssignmentPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"searchboxTrigger\"]")
    private WebElementFacade searchTerms;

    @FindBy(xpath="//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.xpath("//*[@id=\"card_grid\"]/div[1]"));
        return definitionList.findElements(By.xpath("//*[@id=\"card_grid\"]/div[1]/div/div/div[3]/div/h2/a")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }
}
