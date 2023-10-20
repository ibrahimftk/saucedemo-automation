/*
 * File: runnerLogin.java
 * File Created: Thursday, 19th October 2023 3:11:28 pm
 * Author: ibrahimftkurniawan (ibrahimftk@banksultra.co.id)
 * Copyright @ 2023 Ibrahim FT Kurniawan
 */

package cucumber.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/cucumber/features/",
    glue =  "cucumber/stepDef",
    plugin = {"html:target/LoginTestingReport.html"},
    tags = "@Login"
)

public class runnerLogin {
    
}