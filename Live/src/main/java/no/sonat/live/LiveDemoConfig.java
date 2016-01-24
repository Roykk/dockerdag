package no.sonat.live;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created 24.01.2016.
 */



public class LiveDemoConfig extends Configuration {

    @NotEmpty
    private String greeting = "Hei";

    public String getGreeting() {
        return greeting;
    }
}
