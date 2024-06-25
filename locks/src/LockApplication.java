import org.karen.lock.GenerickLock;
import org.karen.lock.TASLock;

public class LockApplication {

    public static void main(String[] args) {
        TASLock lock = new GenerickLock();
        lock.unlock();
        lock.lock();
        System.out.println("Locked");
        lock.lock();
        System.out.println("Unlocked");
    }
}
