package ru.otus.decorator;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipInputStream;

public class Demo {
    public static void main(String[] args)  throws Exception {
        var ds = new DataSourceImpl();
        printer(ds);

        printer(new DataSourceDecoratorAdder(ds));
        printer(new DataSourceDecoratorMultiplicator(ds));
        printer(new DataSourceDecoratorMultiplicator(new DataSourceDecoratorAdder(new DataSourceDecoratorMultiplicator(ds))));

        // Пример из JDK - система ввода вывода
        // InputStream, FileInputStream, BufferedInputStream

//        FileInputStream fis = new FileInputStream("/objects.gz");
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        DataInputStream dis;
//        ZipInputStream zis = new ZipInputStream(fis);
//        GzipInputStream gis = new GzipInputStream(bis);
//
//        ObjectInputStream ois = new ObjectInputStream(gis);
//        SomeObject someObject = (SomeObject) ois.readObject();
    }

    private static void printer(DataSource ds) {
        System.out.println(ds.getInteger());
    }
}
