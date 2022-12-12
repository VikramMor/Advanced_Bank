import java.util.HashMap;
import java.util.Random;


public class SBI implements Bank_Rules {

    private final String name;
    private final int age;
    private final String gender;
    private final String Nationality;
    private final boolean isSeniorCitizen;
    private long mobileNumber;
    private String email;
    private int pin;
    private final long accountNo;
//    private int money;
    private int balance;
    private final double interestRate;
    private final int minBalance;
    private final int DCwithdrawalLimit;
    private final boolean DCActivated;
    private final boolean CCActivated;

    Random random = new Random();

    public HashMap<Long, String> accountMap = new HashMap<>();

    public SBI(String name, int age, String gender, String nationality, boolean isSeniorCitizen, long mobileNumber, String email, int pin, boolean DCActivated, boolean CCActivated) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        Nationality = nationality;
        this.isSeniorCitizen = isSeniorCitizen;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.pin = pin;
        this.DCActivated = DCActivated;
        this.CCActivated = CCActivated;
        accountNo = random.nextLong(1000000000);
        this.accountMap.put(accountNo, name);

        if(this.isSeniorCitizen){
            this.minBalance = 1000;
        }
        else{
            this.minBalance = 10000;
        }

        if(this.isSeniorCitizen){
            this.interestRate = 7.2;
        }
        else{
            this.interestRate = 6;
        }

        this.DCwithdrawalLimit = 40000;
    }

    public String getAccountMap(long accountNo) {
        return accountMap.get(accountNo);
    }

    @Override
    public void addMoney(int money) {
        this.balance += money;
        System.out.println(money+ " has been added to your account "+accountNo+". Your current Balance is "+balance);
    }

    @Override
    public void withdrawMoney(int money, int pin) {
        if(money <= this.balance && pin == this.pin){
            this.balance -= money;
            System.out.println(money+ " has been withdrawn from your account "+this.accountNo+". Your current Balance is "+this.balance);
            if(this.balance < minBalance){
                System.out.println("Your balance is below the Mandated Minimum Balance");
            }
        }
        else if(money > this.balance && this.pin == pin){
            System.out.println("You do not have sufficient balance in your account "+this.accountNo+". The current balance is "+this.balance);
        }
        else{
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }

    }

    public void withdrawMoneyFromDC(int money, int pin){
        if(money <= this.balance && pin == this.pin && money <= this.DCwithdrawalLimit){
            this.balance -= money;
            System.out.println(money+ " has been withdrawn from your account "+this.accountNo+". Your current Balance is "+this.balance);
            if(this.balance < minBalance){
                System.out.println("Your balance is below the Mandated Minimum Balance");
            }
        }
        else if(money > this.DCwithdrawalLimit){
            System.out.println("You have exceeded your Debit Card Withdrawal limit, kindly try with lesser amount or try making direct withdrawal!!!");
        }
        else if(money > this.balance && this.pin == pin){
            System.out.println("You do not have sufficient balance in your account "+this.accountNo+". The current balance is "+this.balance);
        }
        else{
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
    }

    @Override
    public void checkBalance(int pin) {
        if(this.pin == pin) {
        }
        else{
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
    }

    public void getAccountNo(int pin) {
        if(this.pin == pin)
            System.out.println("Dear "+this.name+" your account number is "+this.accountNo);
        else{
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
    }

    @Override
    public void calculateInterest(int years) {
        double interest = balance*interestRate*years/100;
        System.out.println("At current balance your account will yield Rs "+interest+" in "+years+" years.");

    }

    @Override
    public boolean DCActivated() {
        return this.DCActivated;
    }

    @Override
    public boolean CCActivated() {
        return this.CCActivated;
    }

    public void getInterestRate() {
        System.out.println("Dear "+this.accountNo+" holder the Rate of Interest on you account is "+this.interestRate+"%");
    }

    public void getMinBalance(int pin) {
        if(this.pin == pin){
            System.out.println("Dear "+ this.accountNo+" holder the minimum balance you need to keep in your account is Rs "+this.minBalance);
        }
        else{
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
    }

    public void getDCwithdrawalLimit() {
        System.out.println("Your daily withdrawal limit for your debit card id Rs. "+this.DCwithdrawalLimit);
    }

    public void getName(long accountNo) { // to be used with database
        if(this.accountNo == accountNo && this.gender.equals("Male")){
            System.out.println("Name of the customer whose account no. is "+this.accountNo+" is Mr. "+this.name);
        }
        else if(this.accountNo == accountNo && this.gender.equals("Female")){
            System.out.println("Name of the customer whose account no. is "+this.accountNo+" is Ms. "+this.name);
        }
        else{
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }

    public void getAge(long accountNo) { // to be used with database
        if(this.accountNo == accountNo){
            System.out.println("Age of the customer whose account no. is "+this.accountNo+" is "+this.age+" years.");
        }
        else{
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }

    public void getGender(long accountNo) { // to be used with database
        if(this.accountNo == accountNo){
            System.out.println("Gender of the customer whose account no. is "+this.accountNo+" is "+this.gender);
        }
        else{
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }

    public void getNationality(long accountNo) { // to be used with database
        if(this.accountNo == accountNo){
            System.out.println("Nationality of the customer whose account no. is "+this.accountNo+" is "+this.Nationality);
        }
        else{
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }

    public boolean isSeniorCitizen() { // to be used with database
        if(isSeniorCitizen){
            System.out.println("The Account holder is a Senior Citizen");
            return true;
        }
        else{
            System.out.println("The Account holder is not a Senior Citizen");
            return false;
        }
    }

    public void getMobileNumber(long accountNo, int pin) { // to be used with database
        if(this.accountNo == accountNo && this.pin == pin){
            System.out.println("Mobile Number of the customer whose account no. is "+this.accountNo+" is "+this.mobileNumber);
        }
        else if(this.accountNo == accountNo){
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
        else {
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }

    public void getEmail(long accountNo, int pin) { // to be used with database
        if(this.accountNo == accountNo && this.pin == pin){
            System.out.println("Email address of the customer whose account no. is "+this.accountNo+" is "+this.email);
        }
        else if(this.accountNo == accountNo){
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
        else {
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }

    public boolean isDCActivated() {
        if(DCActivated){
            System.out.println("You can withdraw money using your Debit Card");
            return true;
        }
        else{
            System.out.println("You do not have any Debit Card issued against your account");
            return false;
        }
    }

    public boolean isCCActivated() {
        if(CCActivated){
            System.out.println("You can withdraw money using your Credit Card");
            return true;
        }
        else{
            System.out.println("You do not have any Credit Card issued against your account");
            return false;
        }
    }

    public void setMobileNumber(long mobileNumber,long accountNo, int pin) { // to be used with database
        if(this.accountNo == accountNo && this.pin == pin){
            this.mobileNumber = mobileNumber;
            System.out.println("Mobile Number of the customer whose account no. is "+this.accountNo+" has been updated to "+this.mobileNumber);
        }
        else if(this.accountNo == accountNo){
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
        else {
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }

    public void setEmail(String email, long accountNo, int pin) { // to be used with database
        if(this.accountNo == accountNo && this.pin == pin){
            this.email = email;
            System.out.println("Email address of the customer whose account no. is "+this.accountNo+" has been update to"+this.email);
        }
        else if(this.accountNo == accountNo){
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
        else {
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }

    public void setPin(long accountNo, int oldPin, int newPin) { // to be used with database
        if(this.accountNo == accountNo && this.pin == oldPin){
            this.pin = newPin;
            System.out.println("Security PIN of the customer whose account no. is "+this.accountNo+" has been changed");
        }
        else if(this.accountNo == accountNo){
            System.out.println("You have entered wrong PIN, kindly check and try again!!!");
        }
        else {
            System.out.println("The account no. you have entered does not exist in the system.");
        }
    }
}
