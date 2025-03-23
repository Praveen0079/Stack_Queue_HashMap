package Hashmap;

import java.util.*;

class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key; V value; Entry<K, V> next;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }
    
    private final int SIZE = 1000;
    private Entry<K, V>[] table = new Entry[SIZE];
    
    public void put(K key, V value) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (table[index] == null) table[index] = newEntry;
        else {
            Entry<K, V> current = table[index];
            while (current.next != null && !current.key.equals(key)) current = current.next;
            if (current.key.equals(key)) current.value = value;
            else current.next = newEntry;
        }
    }
    
    public V get(K key) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) return current.value;
            current = current.next;
        }
        return null;
    }
    
    public void remove(K key) {
        int index = key.hashCode() % SIZE;
        Entry<K, V> current = table[index], prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) table[index] = current.next;
                else prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}