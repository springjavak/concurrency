import org.karen.lock.GenericLock;
import org.karen.lock.TASLock;

public class LockApplication {

    public static void main(String[] args) {
        TASLock lock = new GenericLock();
        lock.lockTAS();
        System.out.println("Locked");
        lock.unlock();
        System.out.println("Unlocked");
    }
}
