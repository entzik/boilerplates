package com.foo.bar.restful.foobarservice;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Response;
import java.util.concurrent.Callable;

/**
 * Created by emilkirschner on 08/11/15.
 */
public class Tasks {

    public static Response profile(ServletContext servletContext, String taskName, Callable<Response> task) {
        MetricRegistry metricRegistry = (MetricRegistry) servletContext.getAttribute("metrics.registry");
        metricRegistry.meter(taskName + "-metric").mark();
        final Timer timer = metricRegistry.timer(taskName + "-timer");
        final Timer.Context timerContext = timer.time();
        try {
            return task.call();
        } catch (Exception e) {
            return Response.serverError().entity("an error has occurred while processing task").build();
        } finally {
            timerContext.stop();
        }
    }
}
