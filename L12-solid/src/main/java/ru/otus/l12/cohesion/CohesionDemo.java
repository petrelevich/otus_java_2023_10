package ru.otus.l12.cohesion;

/**
 * @author spv created on 11.02.20.
 */

// Где Cohesion больше: A или B (класс B ниже)?

@SuppressWarnings({"java:S106", "java:S125", "java:S1118"})
class A {
    private String message;
    // Инициализация message опущена

    public void process() {
        // ...
        send();
    }

    private void send() {
        // ... Здесь может быть какая-то логика...
        System.out.println("Send: " + this.message);
    }
}

@SuppressWarnings({"java:S106", "java:S125", "java:S1118"})
class B {
    private String message;
    // Инициализация message опущена

    //    public  B(String message){
    //        this.message = message;
    //    }
    public void process() {
        // ...
        Helper.send(this.message);
    }

    //    private void send(String message) {
    //        // ... Здесь может быть какая-то логика...
    //        System.out.println(
    //                "Send: " + message);
    //    }
}

// См. еще код ниже

@SuppressWarnings({"java:S106", "java:S125", "java:S1118"})
class Helper {
    public static void send(String message) {
        // ... Здесь может быть какая-то логика...
        System.out.println("Send: " + message);
    }
}
