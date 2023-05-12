package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.CustomUserSteps;
import org.example.steps.serenity.EndUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CustomSearchByKeyword {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public CustomUserSteps anna;

    @Test
    public void search_for_wine_emag() {
        anna.is_the_home_page();
        anna.looks_for("vin");
        anna.should_see_definition("Vin Rosu Tohani Wine Chocolate Sweet, Dulce, 0.75l");
    }

    @Test
    public void search_for_heeheee_emag() {
        anna.is_the_home_page();
        anna.looks_for("michael jackson");
        anna.should_see_definition("Vinyl Michael Jackson - Thriller");
    }
}
