import org.karen.lock.NonReentrantLock;
import org.karen.lock.TASLock;

public class LockApplication {

    public static void main(String[] args) {
        TASLock lock = new NonReentrantLock();
        lock.lockTAS();
        System.out.println("Locked");
        lock.unlock();
        System.out.println("Unlocked");
    }
}
