package org.karen.lock;

public interface ActionableTTASLock {

    void lockTTAS(Runnable onSpinAction);
    void unlock();

}

