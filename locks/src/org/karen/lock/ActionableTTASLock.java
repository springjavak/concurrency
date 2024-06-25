package org.karen.lock;

public interface ActionableTTASLock {

    void lock(Runnable onSpinAction);
    void unlock();

}

