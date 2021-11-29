package com.company.Hw;

import java.util.ArrayList;
import java.util.Arrays;

public class t_04_06_16 {
    public void main() throws t_04_06_16Exception {
        Account[] accounts = {
                new CurrentAccount("monobank", "8853733138572206", 10208, 17.8),
                new CurrentAccount("privatbank", "5364733408579006", 588, 250),
                new BlockAccount("privatbank", "2351853408576336", 3147, "23.05.20")
        };
        Client client = new Client(accounts);
        System.out.println(client);
        System.out.println(client.search("privatbank"));
    }
}

abstract class Account {
    private String name;
    private String account;
    private double cash;

    public Account(String name, String account, double cash) throws t_04_06_16Exception {
        setName(name);
        setAccount(account);
        setCash(cash);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAccount(String account) throws t_04_06_16Exception {
        if (account.length() != 16) {
            throw new t_04_06_16Exception("Incorrect account number. (must be like **** **** **** ****)");
        }
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setCash(double cash) throws t_04_06_16Exception {
        if (cash < 0) {
            throw new t_04_06_16Exception("Cash cannot be negative.");
        }
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "name='" + name + ", account=" + account + ", cash=" + cash;
    }
}

class CurrentAccount extends Account {
    private double lastAction;

    public CurrentAccount(String name, String account, double cash, double lastAction) throws t_04_06_16Exception {
        super(name, account, cash);
        setLastAction(lastAction);
    }

    public void getCash(double neededCash) throws t_04_06_16Exception {
        if (this.getCash() < neededCash) {
            throw new t_04_06_16Exception("There's not enough money on the account.");
        }
        this.setCash(this.getCash() - neededCash);
        setLastAction(neededCash);
    }

    public void setLastAction(double lastAction) {
        this.lastAction = lastAction;
    }

    public double getLastAction() {
        return lastAction;
    }

    @Override
    public String toString() {
        return "CurrentAccount: {" + super.toString() + ", lastAction=" + this.getLastAction() + "}";
    }
}

class BlockAccount extends Account {
    private String blockDate;

    public BlockAccount(String name, String account, double cash, String blockDate) throws t_04_06_16Exception {
        super(name, account, cash);
        setBlockDate(blockDate);
    }

    public void setBlock(String blockDate) {
        setBlockDate(blockDate);
    }

    public void setBlockDate(String blockDate) {
        this.blockDate = blockDate;
    }

    public String getBlockDate() {
        return blockDate;
    }

    @Override
    public String toString() {
        return "BlockAccount: {" + super.toString() + ", blockDate='" + blockDate + "}";
    }
}

class Client {
    private Account[] accounts;

    public Client(Account[] accounts) {
        setAccounts(accounts);
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public Client search(String bank_name) {
        ArrayList<Account> accounts = new ArrayList<>();
        for (Account account : this.getAccounts()) {
            if (account.getName().equals(bank_name)) {
                accounts.add(account);
            }
        }
        return new Client(accounts.toArray(new Account[0]));
    }

    public Client search(String bank_name, String bank_account) {
        ArrayList<Account> accounts = new ArrayList<>();
        for (Account account : this.getAccounts()) {
            if (account.getName().equals(bank_name) && account.getAccount().equals(bank_account)) {
                accounts.add(account);
            }
        }
        return new Client(accounts.toArray(new Account[0]));
    }

    @Override
    public String toString() {
        return "Client: {\n" + "accounts=" + Arrays.toString(accounts) + "\n}";
    }
}

class t_04_06_16Exception extends Exception {
    public String message = "";

    public t_04_06_16Exception() {}

    public t_04_06_16Exception(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Exception [" + this.message + "]";
    }
}
