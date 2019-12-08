https://leetcode.com/problems/fizz-buzz-multithreaded/
class FizzBuzz {
    private int n;
    private int counter = 1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(true){
            //not divisible by 3 , and divisible by 5 , then wait
            while(counter <= n && (counter % 3 != 0 || counter % 5 == 0)){
                wait();
            }
            if(counter > n) break;
            printFizz.run();
            ++counter;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(true){
            //not divisible by 5 , and divisible by 3 , then wait
            while(counter <= n && (counter % 5 != 0 || counter % 3 == 0)){
                wait();
            }
            if(counter > n) break;
            printBuzz.run();
            ++counter;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true){
            //not divisible by 3 , and not divisible by 5 , then wait
            while(counter <= n && !(counter % 3 == 0 && counter % 5 == 0)){
                wait();
            }
            if(counter > n) break;
            printFizzBuzz.run();
            ++counter;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(true){
            //divisible by 3 , and divisible by 5 , then wait
            while(counter <= n && (counter % 3 == 0 || counter % 5 == 0)){
                wait();
            }
            if(counter > n) break;
            printNumber.accept(counter);
            ++counter;
            notifyAll();
        }
    }
}
