package org.example.students;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<KEY, VALUE> extends LinkedHashMap<KEY, VALUE> {

    private final int capacity;

    public LRUCache(int capacity) {

        super(capacity, 0.75f, true);
        this.capacity = capacity;

    }

    /**
     * Determines if the eldest entry should be removed from the cache.
     * This method is called by the LinkedHashMap after each insertion.
     *
     * @param eldest the least recently accessed entry that will be removed
     *               if this method returns {@code true}
     * @return {@code true} if the size of the cache exceeds its capacity,
     *         indicating that the eldest entry should be removed;
     *         {@code false} otherwise
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<KEY, VALUE> eldest) {

        return size() > capacity;

    }

}