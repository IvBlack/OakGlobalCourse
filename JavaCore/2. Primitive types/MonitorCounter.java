public class MonitorCounter {
    public static void main(String[] args) {
        int i = drawisMonitorsCounter(59, 50);
        System.out.println(i);
    }

    public static int drawisMonitorsCounter(int monitors, int programmers) {
        return monitors % programmers;
    }
}
