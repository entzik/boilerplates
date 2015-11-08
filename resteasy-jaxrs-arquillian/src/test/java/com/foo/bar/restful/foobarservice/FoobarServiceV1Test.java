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
 * Sample Arquilian web service integration test. Arquillian will deploy the web archive created by the createDeployment
 * method in a container as configured in the arquillian.xml file under src/test/resources.
 */
@RunWith(Arquillian.class) // tell JUnit to run this test case using the Arquillian test runner
public class FoobarServiceV1Test {
    /**
     * the arquillian test runner will inject in here ther URL where your webapp will be available in the test container
     */
    @ArquillianResource private URL baseUrl;

    @Test // tell JUnit this is a test method
    @RunAsClient // run this test as a client
    public void testWithJSONString() {
        try {
            String url = new URL(baseUrl, "foobar").toExternalForm();
            ClientRequest clientRequest = new ClientRequest(url);
            ClientResponse clientResponse = clientRequest.get();
            TestCase.assertEquals(ClientResponse.Status.OK, clientResponse.getResponseStatus());
            TestCase.assertEquals("{\"x\":\"delivery\",\"y\":12}", clientResponse.getEntity(String.class));
        } catch (Exception e) {
            TestCase.fail(e.toString());
        }
    }

    @Test // tell JUnit this is a test method
    @RunAsClient // run this test as a client
    public void testWithJavaClass() {
        try {
            String url = new URL(baseUrl, "foobar").toExternalForm();
            ClientRequest clientRequest = new ClientRequest(url);
            ClientResponse clientResponse = clientRequest.get();
            TestCase.assertEquals(ClientResponse.Status.OK, clientResponse.getResponseStatus());
            Payload entity = (Payload) clientResponse.getEntity(Payload.class);
            TestCase.assertEquals("delivery", entity.getX());
            TestCase.assertEquals(12, entity.getY());
        } catch (Exception e) {
            TestCase.fail(e.toString());
        }
    }

    /**
     * Create a .war file for Arquillian to deploy. In this case we use the module's generated artifact.
     * Because the artifact's name is calculated by {@link TestUtilities#getWarArtifact()} using the project
     * directory name and version info from gradle.properties, it means you can run this test without change
     * even if you rename your project or bump the version.
     *
     * @return the artifact to deploy
     */
    @Deployment
    public static Archive<?> createDeployment() {
        File file = TestUtilities.getWarArtifact();

        if (!file.exists())
            TestCase.fail("file does not exist: " + file.getAbsolutePath());
        return  ShrinkWrap.create(ZipImporter.class, "sample.war")
                .importFrom(file)
                .as(WebArchive.class);
    }

}
