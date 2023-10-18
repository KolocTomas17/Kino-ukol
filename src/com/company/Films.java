package com.company;

public class Films {
    private String name;
    private int accessibility;
    private String redirector;
    private boolean backup3d;

    /**
     *
     * @param name - nazev filmu
     * @param accessibility - přístupnost filmu
     * @param redirector - jméno režiséra
     * @param backup3d - podpora 3D
     */

    public Films(String name, int accessibility, String redirector, boolean backup3d) {
        this.name = name;
        this.accessibility = accessibility;
        this.redirector = redirector;
        this.backup3d = backup3d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(int accessibility) {
        this.accessibility = accessibility;
    }

    public String getRedirector() {
        return redirector;
    }

    public void setRedirector(String redirector) {
        this.redirector = redirector;
    }

    public boolean isBackup3d() {
        return backup3d;
    }

    public void setBackup3d(boolean backup3d) {
        this.backup3d = backup3d;
    }

}
