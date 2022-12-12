public interface Bank_Rules {
    
    void addMoney(int money);
    void withdrawMoney(int money, int pin);
    void checkBalance(int pin);
    void calculateInterest(int years);
    boolean DCActivated();
    boolean CCActivated();
    
}
