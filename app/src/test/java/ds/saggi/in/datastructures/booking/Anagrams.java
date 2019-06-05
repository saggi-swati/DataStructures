package ds.saggi.in.datastructures.booking;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Represent a group by a list of integers representing the index in the original list.
 * <p>
 * Anagrams : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 * Note: All inputs will be in lower-case.
 * Input :
 * <p>
 * cat, god, atc, dog
 * <p>
 * Output :
 * [cat atc ]
 * [dog god ]
 */
public class Anagrams {

    private static ArrayList<ArrayList<String>> anagrams(final List<String> a) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            char[] c = a.get(i).toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if (!map.containsKey(s)) {
                ArrayList<String> l = new ArrayList<>();
                l.add(a.get(i));
                map.put(s, l);
            } else {
                ArrayList<String> l = map.get(s);
                if (l != null)
                    l.add(a.get(i));
                map.put(s, l);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("cat");
        a.add("dog");
        a.add("god");
        a.add("act");
        a.add("eat");
        a.add("tea");
        a.add("ate");
        a.add("sat");

        ArrayList<ArrayList<String>> result = anagrams(a);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(
                    Arrays.toString(result.get(i).toArray()));
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null) return null;

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            ArrayList<String> l;
            if(map.containsKey(s)) {
                l = map.get(s);
            } else {
                l = new ArrayList<>();
            }
            if(l == null)
                l = new ArrayList<>();

            l.add(strs[i]);
            map.put(s, l);
        }

        List<List<String>> list = new ArrayList<>(map.values());

        Collections.sort(list, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.size()-o2.size();
            }
        });
        return list;
    }
}
