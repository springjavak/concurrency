package org.karen.lock;

public interface ActionableTASLock {

    void lockTAS(Runnable onSpinAction);
    void unlock();

}

