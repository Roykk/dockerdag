package no.sonat.live;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LiveDemoApplication extends Application<LiveDemoConfig> {
    public static void main(String[] args) throws Exception {
        new LiveDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "LiveDemo";
    }

    @Override
    public void initialize(Bootstrap<LiveDemoConfig> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(LiveDemoConfig configuration,
                    Environment environment) {
        environment.jersey().register(new LiveDemoResource(configuration.getGreeting()));
    }

}