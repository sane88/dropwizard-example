package io.dwzrd.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dwzrd.example.config.DwzrdExampleConfiguration;
import io.dwzrd.example.health.TemplateHealthCheck;
import io.dwzrd.example.resources.HelloResource;

/**
 * Hello world!
 *
 */
public class DwzrdExampleApplication extends Application<DwzrdExampleConfiguration>{
    public static void main( String[] args ) throws Exception {
        new DwzrdExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "dwzrd-example";
    }

    @Override
    public void initialize(Bootstrap<DwzrdExampleConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(DwzrdExampleConfiguration dwzrdExampleConfiguration, Environment environment) throws Exception {
        HelloResource resource = new HelloResource(dwzrdExampleConfiguration.getTemplate(), dwzrdExampleConfiguration.getDefaultName());

        TemplateHealthCheck healthCheck = new TemplateHealthCheck(dwzrdExampleConfiguration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
