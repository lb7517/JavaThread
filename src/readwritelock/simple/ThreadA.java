package readwritelock.simple;

public class ThreadA implements Runnable {

    Book book;

    ThreadA(){}

    ThreadA(Book book){
        this.book = book;
    }

    @Override
    public void run() {
        try {
            this.book.readBook();
            this.book.readBook();
//            this.book.writeBook();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
