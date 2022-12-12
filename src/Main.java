public class Main {
    public static void main(String[] args) {

        SBI user1 = new SBI("Vikram", 30, "Male", "Indian", false, 946816677, "er.vickymor@gmail.com", 1234, true, true );

        user1.addMoney(500000);
        user1.withdrawMoney(100000,1234);
        user1.withdrawMoneyFromDC(50000,1234);
        user1.checkBalance(1234);
        user1.getAccountNo(1234);
        user1.calculateInterest(5);
        user1.getInterestRate();
        user1.getMinBalance(1234);
        user1.getDCwithdrawalLimit();
    }
}
