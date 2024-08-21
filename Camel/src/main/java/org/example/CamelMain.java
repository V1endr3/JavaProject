package org.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.main.Main;

@Slf4j
public class CamelMain {
    public static void main(String[] args) throws Exception {
        // use Camels Main class
        Main main = new Main(CamelMain.class);
        // and add all the XML routes
        main.configure().withRoutesIncludePattern("routes/*.xml");
        // turn on reloading routes on code-changes
        main.configure().withRoutesReloadEnabled(true);
        main.configure().withRoutesReloadDirectory("src/main/resources");
        main.configure().withRoutesReloadPattern("routes/*.xml");

        // now keep the application running until the JVM is terminated (ctrl + c or sigterm)
        main.run(args);
    }
}
