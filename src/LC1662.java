public class LC1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
//        System.out.println(word1[0]);
        int i1=0,i2=0,j1=0,j2=0;
        int l1 = word1.length,l2 = word2.length;
        do{
//            System.out.println(i1+":"+j1+","+i2+":"+j2);
//            System.out.println(word1[i1].length()+":"+word2[i1].charAt(j1));
//            System.out.println(word1[i2].length()+":"+word2[i2].charAt(j2));
            if(l1==i1&&l2==i2) return true;
            else if (l1==i1||l2==i2) return false;//only one of them is zero;
            else if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) return false;
            if (word1[i1].length()==j1+1){
                j1=0;
                i1++;
            }
            else{
                j1++;
            }
            if (word2[i2].length()==j2+1){
                j2=0;
                i2++;
            }
            else{
                j2++;
            }
        }
        while (true);

    }
}