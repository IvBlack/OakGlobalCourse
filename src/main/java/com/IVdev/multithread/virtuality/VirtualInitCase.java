//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
//import org.apache.logging.log4j.core.LoggerContext;
//
//public class VirtualInitCase {
//    private static final Logger log = Logger.
//
//    public static void main(String[] args) {
//        Thread.ofPlatform().start(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                sleep();
//                log.info("do something");
//            }
//        });
//
//        Thread.ofVirtual().start(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                sleep();
//                log.info("sleep");
//            }
//        });
//    }
//
//    private static void sleep() {
//        try {
//            Thread.sleep(Duration.of(10, ChronoUnit.SECONDS));
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//}
