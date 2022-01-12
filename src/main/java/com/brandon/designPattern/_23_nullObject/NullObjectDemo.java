package com.brandon.designPattern._23_nullObject;

public class NullObjectDemo {
    public static void main(String[] args) {
        CustomerFactory customerFactory = new CustomerFactory();
        AbstractCustomer rob = customerFactory.getCustomer("Rob");
        System.out.println(rob.getName());

        AbstractCustomer jim = customerFactory.getCustomer("Jim");
        System.out.println(jim.getName());
    }
}

class CustomerFactory {
    private static final String[] names = {"Rob", "Joe", "Julie"};
    public AbstractCustomer getCustomer(String name) {
        for (String n : names) {
            if (n.equals(name)) {
                return new RealCustomer(n);
            }
        }

        return new NullCustomer();
    }
}

abstract class AbstractCustomer {
    protected String name;
    abstract boolean isNil();
    abstract String getName();
}

class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    boolean isNil() {
        return false;
    }

    @Override
    String getName() {
        return name;
    }
}

class NullCustomer extends AbstractCustomer {
    @Override
    boolean isNil() {
        return true;
    }

    @Override
    String getName() {
        return "NULL";
    }
}