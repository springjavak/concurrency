import org.karen.lock.NonReentrantLock;
import org.karen.lock.ReentrantLock;
import org.karen.lock.TASLock;
import org.karen.lock.TTASLock;

public class LockApplication {

    public static void main(String[] args) {

        TASLock lock2 = new ReentrantLock();
        lock2.lockTAS();
        lock2.lockTAS();
        System.out.println("Reentered!");

        TASLock lock = new NonReentrantLock();
        lock.lockTAS();
        System.out.println("Locked non-reentrant");
        lock.lockTAS();
        System.out.println("Buggy non-reentrant");
    }
}
