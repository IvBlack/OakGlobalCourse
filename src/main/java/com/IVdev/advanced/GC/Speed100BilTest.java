package com.IVdev.advanced.GC;

/*
    Java ������������� ��������� ������������ ��� ����������� ������������������ ����������.
    ?? ����� �� ����� ������������ �������� ������������� ������������ �������� ������ G1 (Garbage First),
    ������� �������� ������ ���������� � ������� ������� ������ � ������� ��������.
    ?? ����� �������� ������������� G1GC, ���������� �������� ���� -XX:+UseG1GC ��� ������� Java-����������:
    java -XX:+UseG1GC G1GCExample

    ��������� ���� � ������� GC � �����GC���� �����:  java -XX:+PrintCommandLineFlags -version
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
