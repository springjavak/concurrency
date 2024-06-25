package org.karen.lock;

public interface ActionableTASLock {

    void lock(Runnable onSpinAction);
    void unlock();

}

