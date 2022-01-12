package com.brandon.designPattern._18_IteratorDemo;

public class IteratorDemo {
    public static void main(String[] args) {
        Container nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        while (iterator.hasNext()) {
            System.out.println(String.format("Name : %s", iterator.next()));
        }

    }

}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class NameRepository implements Container {
    public String names[] = {"Robert", "John", "Julie", "Lora"};

    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        private int index;
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
