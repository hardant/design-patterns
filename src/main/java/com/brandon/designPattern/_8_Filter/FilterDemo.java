package com.brandon.designPattern._8_Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterDemo {
    private static class Person {
        private String name;
        private String gender;
        /**
         * 婚姻状况
         */
        private String maritalStatus;

        public Person(String name, String gender, String maritalStatus) {
            this.name = name;
            this.gender = gender;
            this.maritalStatus = maritalStatus;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }
    }

    private interface Criteria {
        List<Person> meetCriteria(List<Person> persons);
    }

    private static class CriteriaMale implements Criteria {
        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> list = new ArrayList<Person>();
            for(Person p: persons) {
                if (p.gender.equals("MALE")) {
                    list.add(p);
                }
            }
            return list;
        }
    }

    private static class CriteriaFeMale implements Criteria {
        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> list = new ArrayList<Person>();
            for(Person p: persons) {
                if (p.gender.equals("FEMALE")) {
                    list.add(p);
                }
            }
            return list;
        }
    }

    private static class CriteriaSingle implements Criteria {
        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> list = new ArrayList<Person>();
            for(Person p: persons) {
                if (p.maritalStatus.equals("SINGLE")) {
                    list.add(p);
                }
            }
            return list;
        }
    }

    private static class CriteriaMarried implements Criteria {
        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> list = new ArrayList<Person>();
            for(Person p: persons) {
                if (p.gender.equals("MARRIED")) {
                    list.add(p);
                }
            }
            return list;
        }
    }

    private static class AndCriteria implements Criteria {
        private Criteria criteria;
        private Criteria otherCriteria;

        public AndCriteria(Criteria criteria, Criteria otherCriteria) {
            this.criteria = criteria;
            this.otherCriteria = otherCriteria;
        }

        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> list1 = criteria.meetCriteria(persons);
            List<Person> list2 = otherCriteria.meetCriteria(list1);
            return list2;
        }
    }

    private static class OrCriteria implements Criteria {
        private Criteria criteria;
        private Criteria otherCriteria;

        public OrCriteria(Criteria criteria, Criteria otherCriteria) {
            this.criteria = criteria;
            this.otherCriteria = otherCriteria;
        }

        public List<Person> meetCriteria(List<Person> persons) {
            List<Person> list1 = criteria.meetCriteria(persons);
            List<Person> list2 = otherCriteria.meetCriteria(persons);

            for (Person p: list2) {
                if (!list1.contains(p)) {
                    list1.add(p);
                }
            }
            return list1;
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person("A", "MALE", "SINGLE"));
        persons.add(new Person("B", "MALE", "MARRIED"));
        persons.add(new Person("C", "FEMALE", "SINGLE"));

        Criteria maleCriteria = new CriteriaMale();
        Criteria singleCriteria  = new CriteriaSingle();
        Criteria andCriteria = new AndCriteria(maleCriteria, singleCriteria);
        List<Person> singleMen = andCriteria.meetCriteria(persons);

        for (Person p: singleMen) {
            System.out.println(p.getName());
        }
        System.out.println("----");
        Criteria orCriteria = new OrCriteria(maleCriteria, singleCriteria);

        List<Person> ManOrSingle = orCriteria.meetCriteria(persons);

        for (Person p: ManOrSingle) {
            System.out.println(p.getName());
        }
    }
}
