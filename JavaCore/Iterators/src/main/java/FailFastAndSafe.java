import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
The fail-fast iterator throws a ConcurrentModificationException
if the collection changes during the iteration, but runs faster. 
example fail-fast - Vector и Hashtable.

fail-safe does not raise exceptions when changing the structure of the collection, because it works with its clone.
The fail-safe example is CopyOnWriteArrayList and the keySet iterator of the ConcurrentHashMap collection.
*/

public class FailFastAndSafe {
    public static void main(String[] args) {
        faleSafeIterator();
        //failFastIterator();
    }

    private static void faleSafeIterator() {
        String[] data = {"Tomcat", "Undertow", "Kubernetes", "WebSphere", "JBoss"};
        CopyOnWriteArrayList<String> dataList = new CopyOnWriteArrayList<String>(data);

        //iterator created
        Iterator<String> it = dataList.iterator();
        while (it.hasNext()) {
            String server = it.next();
            System.out.println(server);

            //works with array copy
            if (server.equals("Tomcat")) {
                dataList.add("Jetty");
            }
        }
    }

    //works with real array
    private static void failFastIterator() {
        ArrayList<String> servers = new ArrayList<String>();
        servers.add("Tomcat");

        //iterator created
        Iterator<String> it = servers.iterator();
        while (it.hasNext()) {
            String server = it.next();
            System.out.println(server);
            servers.add("Jetty"); // !!!!add after ierator creating 
        }
    }
}
