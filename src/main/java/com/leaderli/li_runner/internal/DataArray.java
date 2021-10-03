package com.leaderli.li_runner.internal;

import java.util.Arrays;
import java.util.function.Consumer;

public class DataArray<T> {

    private final Object[] data;

    private int index;


    public DataArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
        this.data = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];
    }

    public void add(T t) {
        this.data[index++] = t;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(){
        Object[] temp = new Object[data.length];
        System.arraycopy(data,0,temp,0,data.length);
        return (T[]) temp;
    }
    public void forEach(Consumer<T> consumer){
        for (int i = 0; i <data.length ; i++) {
            consumer.accept(get(i));
        }
    }
}
