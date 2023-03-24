package homework.commands;

import homework.Catalog;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * This class represents the report command.
 * Report: creates (and opens) an HTML report representing the content of the catalog.
 */
public class ReportCommand implements Command{
    public static void execute(Catalog catalog, String path) throws IOException {
        VelocityEngine engine = new VelocityEngine();
        engine.init();
        VelocityContext context = new VelocityContext();
        context.put("name", catalog.getName());
        context.put("documents", catalog.getDocs());

        Writer writer = new FileWriter(path);
        engine.mergeTemplate("src/main/resources/templates/template.vm", "UTF-8", context, writer);
        writer.flush();
        writer.close();
        System.out.printf("Report created at " + path);

    }
}
