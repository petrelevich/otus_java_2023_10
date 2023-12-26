package ru.otus.flyweight.cow;

import java.util.ArrayList;
import java.util.List;

public class SmartList {

    private Data data;

    public SmartList() {
        this.data = new Data();
        this.data.data = new ArrayList<>();
        this.data.users = 1;
    }

    private SmartList(Data data) {
        this.data = data;
        data.users += 1;
    }


    public int get(int n) {
        return data.data.get(n);
    }

    public int size() {
        return data.data.size();
    }

    public void add(int v) {
        if (data.users > 1) {
            data.users -= 1;
            data = data.copy();
        }
        data.data.add(v);
    }

    public SmartList copy() {
        return new SmartList(data);
    }

    private class Data {
        List<Integer> data;
        int users;

        Data copy() {
            var res = new Data();
            res.data = new ArrayList<>(data);
            res.users = 1;
            return res;
        }
    }


    public static void main(String[] args) {
        var a = new SmartList();
        a.add(1);
        a.add(2);

        var b = a.copy();
        b.get(0);
        b.add(3);

        System.out.println(a.size());
        System.out.println(b.size());
    }

}
