package com.trues.config;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.trues.config.model.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceConfig {

    private static Environments  environments;


    public static Environments parse(InputStream inputStream) throws IOException, SAXException {

        XStream xstream = new XStream(new Xpp3Driver());
        xstream.ignoreUnknownElements();
        xstream.alias("resources", Resources.class);
        xstream.alias("environments", Environments.class);
        xstream.useAttributeFor(Environments.class, "active");
        xstream.addImplicitMap(Environments.class, "envs", "env", Env.class, "name");
        xstream.useAttributeFor(Env.class, "name");
        xstream.alias("dataSource", DataSource.class);
        xstream.useAttributeFor(Report.class, "name");
        //xstream.addImplicitCollection(Env.class, "reports", "report", Report.class);
        xstream.alias("reports", List.class);
        xstream.alias("report", Report.class);
        Resources environments = (Resources)xstream.fromXML(inputStream);
        ServiceConfig.environments = environments.getEnvironments();

        return  ServiceConfig.environments;
    }
}
