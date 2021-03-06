package com.foo.bar.restful.foobarservice;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility methods for testing in Arquillian
 */
public class TestUtilities {
    /**
     * Calculates the path of the generated WAR artifact by using the project directory's name
     * and version information from the gradle.properties file. This ensures you can run your tests
     * without changing a line of code event if you rename your project or bump the version.
     *
     * @return a file pointing to the WAR artifact generated by the build system
     */
    public static File getWarArtifact() {
        File file = null;
        FileInputStream inStream = null;
        try {
            File home = new File(System.getProperty("user.dir"));
            String name = home.getName();

            Properties properties = new Properties();
            inStream = new FileInputStream("gradle.properties");
            properties.load(inStream);
            String version = properties.getProperty("version");

            file = new File("build/libs/" + name + "-" + version + ".war");
        } catch (IOException e) {
            TestCase.fail("unable to read gradle.properties");
        } finally {
            if (inStream != null)
                try {
                    inStream.close();
                } catch (IOException e) {
                    TestCase.fail("unable to close gradle.properties input stream: " + e.toString());
                }
        }
        return file;
    }
}
