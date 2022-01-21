package com.yintaowang.assignment;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    //use a doublyQueue to maintain the order of the Cache
    private Deque<Character> doublyQueue;
    //use a hashMap to store the key-value pairs.
    private HashMap<Character, Integer> map;
    //cache capacity
    private final int CACHE_SIZE;

    public LRUCache(int capacity) {
        this.doublyQueue = new LinkedList<>();
        this.map = new HashMap<>();
        this.CACHE_SIZE = capacity;
    }

    public Integer get(Character key) {

        if (map.containsKey(key)) {
            doublyQueue.remove(key);
            doublyQueue.push(key);
        } else {
            if (doublyQueue.size() == CACHE_SIZE) {
                Character LRUKey = doublyQueue.removeLast();
                map.remove(LRUKey);
            }
            /*
            * fetch corresponding value from DB.
            * (here I just set a fixed value for demonstration purpose.
            * */
            Integer fetchedValue = 67;
            doublyQueue.push(key);
            map.put(key, fetchedValue);
        }
        return map.get(key);
    }

    public void set(Character key, Integer value) {
        map.put(key, value);
        doublyQueue.push(key);
    }

    public void clearCache() {
        map.clear();
        doublyQueue.clear();
    }

    public void displayCache() {
        for (Character key : doublyQueue) {
            System.out.print(key + "-->" + map.get(key) + "\t");
        }
        System.out.println();
    }
}

class TestLRUCache {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(5);
        cache.set('a', 1);
        cache.set('b', 2);
        cache.set('c', 3);
        cache.set('d', 4);
        cache.set('e', 5);
        cache.displayCache();
        cache.get('c');
        cache.displayCache();
        cache.get('g');
        cache.displayCache();

        //clear cache
        cache.clearCache();
        cache.displayCache();

        cache.get('v');
        cache.displayCache();
        cache.get('w');
        cache.displayCache();
        cache.get('x');
        cache.displayCache();
        cache.get('y');
        cache.displayCache();
        cache.get('z');
        cache.displayCache();
        cache.get('a');
        cache.displayCache();

/* result:
        e-->5	d-->4	c-->3	b-->2	a-->1
        c-->3	e-->5	d-->4	b-->2	a-->1
        g-->67	c-->3	e-->5	d-->4	b-->2

        v-->67
        w-->67	v-->67
        x-->67	w-->67	v-->67
        y-->67	x-->67	w-->67	v-->67
        z-->67	y-->67	x-->67	w-->67	v-->67
        a-->67	z-->67	y-->67	x-->67	w-->67

        Process finished with exit code 0
        */

    }
}