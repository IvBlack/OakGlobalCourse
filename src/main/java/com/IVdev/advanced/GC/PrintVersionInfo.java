package com.IVdev.advanced.GC;


import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

/*
    Решение позволяет обратиться к запущенному в системе процессу java
    и отдать инфо о текущем GC.
* */
public class PrintVersionInfo {
    public static void main(String[] args) throws Exception {
        String rmiHostname = "localhost";
        String defaultUrl = "service:jmx:rmi:///jndi/rmi://" + rmiHostname + ":15740/jmxrmi";
        JMXServiceURL jmxServiceURL = new JMXServiceURL(defaultUrl);

        JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxServiceURL);
        MBeanServerConnection mbsc = jmxConnector.getMBeanServerConnection();

        ObjectName gcName = new ObjectName(ManagementFactory.GARBAGE_COLLECTOR_MXBEAN_DOMAIN_TYPE + ",*");

        for (ObjectName name : mbsc.queryNames(gcName, null)) {
            GarbageCollectorMXBean gc = ManagementFactory.newPlatformMXBeanProxy(mbsc,
                    name.getCanonicalName(),
                    GarbageCollectorMXBean.class);
            System.out.println(gc.getName());
        }
    }
}
