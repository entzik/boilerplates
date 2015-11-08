package com.foo.bar.restful.foobarservice;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.TimeUnit;

/**
 * Created by emilkirschner on 08/11/15.
 */
public class ContextListener implements ServletContextListener {
    private Slf4jReporter reporter;
    private MetricRegistry metrics;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        metrics = new MetricRegistry();
        sce.getServletContext().setAttribute("metrics.registry", metrics);
        if (reporter == null) {
            reporter = Slf4jReporter.forRegistry(metrics)
                    .outputTo(LoggerFactory.getLogger("api.metrics"))
                    .convertRatesTo(TimeUnit.SECONDS)
                    .convertDurationsTo(TimeUnit.MILLISECONDS)
                    .build();
            reporter.start(15, TimeUnit.SECONDS);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        reporter.stop();
    }
}
