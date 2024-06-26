package org.karen.lock;

import java.util.concurrent.atomic.AtomicReference;

public class ReentrantLock implements TASLock {
    private record ReentrantLockState(long threadId, long threadCount) {
    }

    private final AtomicReference<ReentrantLockState> state = new AtomicReference<>(new ReentrantLockState(-1, 0));

    @Override
    public void lockTAS() {
        var currentThreadId = Thread.currentThread().getId();
        ReentrantLockState localState;
        long threadCount;
        long threadId;
        boolean allowedToEnter;
        do {
            localState = state.get();
            threadCount = localState.threadCount;
            threadCount++;
            threadId = localState.threadId;
            allowedToEnter = threadId == -1 || threadId == currentThreadId;
        }
        while (allowedToEnter && !state.compareAndSet(localState, new ReentrantLockState(currentThreadId, threadCount)));
    }

    @Override
    public void unlock() {
        ReentrantLockState localState;
        long threadCount;
        long threadId;
        do {
            localState = state.get();
            threadCount = localState.threadCount;
            threadCount--;
            threadId = localState.threadId;
            if (threadCount == 0) {
                threadId = -1;
            }
        } while (!state.compareAndSet(localState, new ReentrantLockState(threadId, threadCount)));
    }
}
