package org.karen.lock;

public class GenerickLock implements TASLock {
    private boolean locked = false;

    @Override
    public void lock() {
        while (true) {
            while (locked) {
            }
            if (!locked) {
                locked = true;
                return;
            }
        }
    }

    @Override
    public void unlock() {
        locked = false;
    }
}
