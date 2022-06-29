package com.dave.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "rerun:target/rerun.txt",
                "html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"},

        publish = true,
        features = "src/test/resources/features",
        glue = "com/dave/step_definitions",
        dryRun = false,
        tags = "@wip"


)

public class CukesRunner {
}
