package ds.saggi.in.datastructures.booking;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingUserByAge {

    static class Person implements Comparable<Person> {
        String fname;
        String lname;
        int age;
        String address;

        @Override
        public int compareTo(@NonNull Person o) {
            return this.age - o.age;
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>(4);
        Person p1 = new Person();
        p1.fname = "fname1";
        p1.lname = "lname1";
        p1.age = 24;
        p1.address = "address1";
        list.add(p1);

        Person p2 = new Person();
        p2.fname = "fname2";
        p2.lname = "lname2";
        p2.age = 35;
        p2.address = "address2";
        list.add(p2);

        Person p3 = new Person();
        p3.fname = "fname3";
        p3.lname = "lname3";
        p3.age = 15;
        p3.address = "address3";
        list.add(p3);

        Person p4 = new Person();
        p4.fname = "fname4";
        p4.lname = "lname4";
        p4.age = 42;
        p4.address = "address4";
        list.add(p4);
        Collections.sort(list);

        for(int i = 0;i< list.size();i++) {
            System.out.println(list.get(i).fname + " " + list.get(i).lname + " " + list.get(i).age + " " + list.get(i).address);
        }
    }
}
