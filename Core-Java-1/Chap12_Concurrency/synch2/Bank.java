package Chap12_Concurrency.synch2;


import java.util.*;

/**
 * A bank with a number of bank accounts that uses locks for serializing access
 */
public class Bank {
    private final double[] accounts;
   

    /**
     * Constructs the bank
     * @param n the number of accounts
     * @param intialBalance the initial balance for each account
     */
    public Bank(int n , double intialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, intialBalance);
       
    }
    /**
     * Transfer money from one account to another
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     * @throws InterruptedException
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException 
    {
    
        while(accounts[from]<amount)
         wait();
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        notifyAll();
    }

    private synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts)
          sum+=a;
        return sum;
    }
    public int size()
    {
        return accounts.length;
    }

}
