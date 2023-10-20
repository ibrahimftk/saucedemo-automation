/*
 * File: runnerLogout.java
 * File Created: Friday, 20th October 2023 8:41:01 am
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
    plugin = {"html:target/LogoutTestingReport.html"},
    tags = "@Logout"
)

public class runnerLogout {
    
}

