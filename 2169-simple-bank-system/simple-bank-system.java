class Bank {
    long[] balance;
    public Bank(long[] balance) {
        this.balance=balance;
    }
    private boolean accountCheck(int account){
        if(account>=0 && account<balance.length){
            return true;
        }
        return false;
    }
    public boolean transfer(int account1, int account2, long money) {
        if(!accountCheck(account1-1) || !accountCheck(account2-1)){
            return false;
        }
        if(!withdraw(account1,money)){
            return false;
        }
        deposit(account2,money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        
        if(!accountCheck(account-1)){
            return false;
        }
        balance[account-1]+=money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!accountCheck(account-1)){
            return false;
        }
        if(balance[account-1]<money){
            return false;
        }
        balance[account-1]-=money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */