package org.karen.lock;

import java.util.concurrent.atomic.AtomicBoolean;

public class NonReentrantLock implements TASLock, TTASLock, ActionableTASLock, ActionableTTASLock {
    private final AtomicBoolean locked = new AtomicBoolean();

    @Override
    public void lockTAS() {
        while (locked.getAndSet(true)) {
        }
    }

    @Override
    public void lockTTAS() {
        while (locked.get()) {
        }
        while (locked.getAndSet(true)) {
        }
    }

    @Override
    public void lockTAS(Runnable onSpinAction) {
        while (locked.getAndSet(true)) {
            onSpinAction.run();
        }
    }

    @Override
    public void lockTTAS(Runnable onSpinAction) {
        while (locked.get()) {
            onSpinAction.run();
        }
        while (locked.getAndSet(true)) {
            onSpinAction.run();
        }
    }

    @Override
    public void unlock() {
        locked.set(false);
    }
}
