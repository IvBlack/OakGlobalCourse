package com.IVdev.advanced.GC;

/*
    Java предоставляет множество возможностей для оптимизации производительности приложений.
    ?? Одной из таких возможностей является использование современного сборщика мусора G1 (Garbage First),
    который улучшает работу приложений с большим объемом данных и снижает задержки.
    ?? Чтобы включить использование G1GC, необходимо добавить флаг -XX:+UseG1GC при запуске Java-приложения:
    java -XX:+UseG1GC G1GCExample

    Проверить инфо о текущем GC и околоGCшных вещей:  java -XX:+PrintCommandLineFlags -version
*/
public class Speed100BilTest {
    public static void main(String[] args) throws InterruptedException {

        int[] arr = new int[100_000_000];

        for(int i = 0; i < 5; i++) {
            long startTime = System.currentTimeMillis();
            for (int n = 0; n < arr.length; n++) {
                arr[n] = n;
            }
            Thread.sleep(2000);

            long endTime = System.currentTimeMillis();
            System.out.println("needed time is " + (endTime - startTime) + " ms.");
        }
    }
}
