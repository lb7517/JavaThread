package readwritelock.wlock;

public class Book {

    ReadWriteLock readWriteLock;

    Book(){}

    Book(ReadWriteLock readWriteLock){
        this.readWriteLock = readWriteLock;
    }

    public void readBook() throws InterruptedException {
        this.readWriteLock.lockRead();
        System.out.println("正在读书: "+Thread.currentThread().getName());
        this.readWriteLock.unlockRead();
    }

    public void writeBook() throws InterruptedException {
        this.readWriteLock.lockWrite();
        System.out.println("正在写书: "+ Thread.currentThread().getName());
        this.readWriteLock.unlockWrite();
    }
}
