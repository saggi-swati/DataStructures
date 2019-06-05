package ds.saggi.in.datastructures.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DiscoverSiteMap {

    static class Link {
        char user;
        int page;

        Link(char user, int page) {
            this.user = user;
            this.page = page;
        }
    }

    public static void main(String[] args) {

        ArrayList<Link> links = new ArrayList<>();

        Link link1 = new Link('A', 1);
        links.add(link1);
        Link link2 = new Link('B', 5);
        links.add(link2);
        Link link3 = new Link('A', 2);
        links.add(link3);
        Link link4 = new Link('A', 1);
        links.add(link4);
        Link link5 = new Link('B', 2);
        links.add(link5);
        Link link6 = new Link('C', 7);
        links.add(link6);
        Link link7 = new Link('C', 3);
        links.add(link7);
        Link link8 = new Link('A', 3);
        links.add(link8);
        Link link9 = new Link('C', 1);
        links.add(link9);

        drawMap(links);
    }

    private static void drawMap(ArrayList<Link> links) {

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < links.size(); i++) {
            char c = links.get(i).user;
            int page = links.get(i).page;
            if (map.containsKey(c)) {
                ArrayList<Integer> l = map.get(c);
                l.add(page);
            } else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(page);
                map.put(c, l);
            }
        }

        for (char c :
                map.keySet()) {
            System.out.println(c + " --> " + Arrays.toString(map.get(c).toArray()));
        }
    }
}
