class Foo {
    private boolean firstDone = false;
    private boolean secondDone = false;
    
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(this) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstDone = true;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this) {
            while (!firstDone) {
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            this.secondDone = true;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this) {
            while (!secondDone) {
                this.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            this.notifyAll();
        }
    }
}
