package com.foo.bar.util;

import java.util.Map;

/**
 * Created by emilkirschner on 12/10/15.
 */
public class ServiceVersionInfo {
    /**
     * short service name
     */
    final String serviceName;
    /**
     * longer description
     */
    final String serviceDescription;
    /**
     * release notes
     */
    final String releaseNotes;
    /**
     * api version - bare integer: 1, 2, 3, .....
     */
    final int apiVersion;
    /**
     * hierarchical version - 0:major, 1:minor, 2:micro, 4: buildNo
     */
    final int[] implVersion;

    public ServiceVersionInfo(String serviceName, String serviceDescription, String releaseNotes, int apiVersion, int[] implVersion) {
        this.serviceName = serviceName;
        this.serviceDescription = serviceDescription;
        this.releaseNotes = releaseNotes;
        this.apiVersion = apiVersion;
        this.implVersion = implVersion;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public String getReleaseNotes() {
        return releaseNotes;
    }

    public int getApiVersion() {
        return apiVersion;
    }

    public int[] getImplVersion() {
        return implVersion;
    }

}
