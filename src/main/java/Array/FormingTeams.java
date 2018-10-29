package Array;

import java.util.*;

public class FormingTeams {

    private  void findTeams(char[] x, int mod) {
        int i = 0;
        Map<Character, Queue<Integer>> lookup = new TreeMap<>();
        for(char q: x){
            if(!lookup.containsKey(q)){
                lookup.put(q, new LinkedList<>());
            }
            lookup.get(q).add(i++);
        }

        List<Character> list = new ArrayList<>();
        for(Character s: lookup.keySet()){
            list.add(s);
        }

        Set<Integer> data = new HashSet<>();
        for(int j = 0; j < list.size()-1; j++){
            char first = list.get(j);
            char second = list.get(j+1);

            boolean isEligible = isEligible(first, second, lookup.get(first).peek(), lookup.get(second).peek(), mod);

            if(isEligible){
                // remove from list and add to the same team
                data.add(lookup.get(first).peek());
                data.add(lookup.get(second).peek());

                lookup.get(first).poll();
                lookup.get(second).poll();

            }
        }
        System.out.println(data);
    }

    private boolean isEligible(char first, char second, int roll1, int roll2, int mod){
        return second - first == 1 &&
                roll2%mod >= roll1%mod &&
                roll2/mod >= roll1/mod;
    }

    private boolean isEligible(Data first, Data second, int mod){
        return second.x - first.x == 1 &&
                second.rollno%mod >= first.rollno%mod &&
                second.rollno/mod >= first.rollno/mod;
    }

    class Data implements Comparable<Data>{
        char x;
        int rollno;
        boolean isVisited = false;

        public Data(char x, int rollno) {
            this.x = x;
            this.rollno = rollno;
        }

        @Override
        public int compareTo(Data o) {
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "rollno=" + rollno +
                    '}';
        }
    }

    private void sortAndAdd(char[] x, int mod){
        List<Data> dataList = new ArrayList<>();

        int index = 0;
        for(char q: x){
            Data data = new Data(q, index++);
            dataList.add(data);
        }
        Collections.sort(dataList);

        List<List<Data>> lol = new ArrayList<>();

        findAllTeams2(dataList, mod, 0, new ArrayList<>(), lol);
        System.out.println(lol);
    }

    private void findAllTeams(List<Data> dataList, int mod, int position, ArrayList<Data> tempList, List<List<Data>> lol) {

        if(position == dataList.size()){
            lol.add(new ArrayList<>(tempList));
            return;
        }else {

            for (int i = position; i < dataList.size(); i++) {
                if(dataList.get(i).isVisited) continue;

                if(tempList.size() > 0 && !isEligible(tempList.get(tempList.size()-1), dataList.get(i), mod)) continue;

                dataList.get(i).isVisited = true;
                tempList.add(dataList.get(i));

                findAllTeams(dataList, mod, i + 1, tempList, lol);
            }
        }
    }

    private void findAllTeams2(List<Data> dataList, int mod, int position, ArrayList<Data> tempList, List<List<Data>> lol) {

        for(int j=0; j< dataList.size(); j++) {
            tempList = new ArrayList<>();
            for (int i = j; i < dataList.size(); i++) {
                if (dataList.get(i).isVisited) continue;

                if (tempList.size() > 0 && !isEligible(tempList.get(tempList.size() - 1), dataList.get(i), mod))
                    continue;

                dataList.get(i).isVisited = true;
                tempList.add(dataList.get(i));
            }
            if(tempList.size()>1){
                lol.add(tempList);
            }
        }

    }


    public static void main(String[] args) {
        // https://www.codechef.com/problems/TEAMS

        char[] x = {'a','b','a','a','c','c','a', 'b', 'c'};
        int mod = 3;

        new FormingTeams().sortAndAdd(x, mod);
    }
}
