package ru.otus.objectpool;

@SuppressWarnings("java:S106")
public class ConnectionPostgres implements Connection {
    @Override
    public void connect() {
        System.out.print("start connect...");
        sleep(2000);
        System.out.println("connected");
    }

    @Override
    public void execSelect() {
        System.out.println("run SELECT");
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
