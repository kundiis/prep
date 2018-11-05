package Array;

public class HammingDistance {

    /*
        the length where number of positions of characters are different
     */
    public int hammingDistance(int x, int y) {
        int out = x^y;
        System.out.println(out);
        String s = Integer.toBinaryString(out);
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1,4));
    }

}
