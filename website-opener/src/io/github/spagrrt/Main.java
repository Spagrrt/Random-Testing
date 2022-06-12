package io.github.spagrrt;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
	    if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
	        Desktop.getDesktop().browse(new URI(WebsiteList.websiteList[(int) (Math.random() * WebsiteList.websiteList.length)]));
        }
    }
}
