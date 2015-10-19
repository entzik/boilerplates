package com.foo.bar.restful.foobarservice;

import junit.framework.TestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;

/**
 * Created by emilkirschner on 12/10/15.
 */
@RunWith(Arquillian.class)
public class MyTest {
    @ArquillianResource
    private URL baseUrl;

    @Test
    @RunAsClient
    public void test1() {
        try {
            String url = new URL(baseUrl, "foobar/v1").toExternalForm();
            ClientRequest clientRequest = new ClientRequest(url);
            ClientResponse clientResponse = clientRequest.get();
            TestCase.assertEquals(ClientResponse.Status.OK, clientResponse.getResponseStatus());
            TestCase.assertEquals("{\"x\":\"delivery\",\"y\":12}", clientResponse.getEntity(String.class));
        } catch (Exception e) {
            TestCase.fail(e.toString());
        }
    }

    @Deployment
    public static Archive<?> createDeployment() {
        File file = new File("build/libs/resteasy-jaxrs-arquillian-1.0.0-SNAPSHOT.war");
        if (!file.exists())
            TestCase.fail("file does not exist: " + file.getAbsolutePath());
        return  ShrinkWrap.create(ZipImporter.class, "sample-restful.war")
                .importFrom(file)
                .as(WebArchive.class);
    }
}
