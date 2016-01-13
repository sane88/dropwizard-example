package io.dwzrd.example.health;


import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck{

    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        String saynig = String.format(template, "TEST");
        if(!saynig.contains("TEST")){
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
