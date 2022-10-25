//comment: so the problem is in line 14, which will cause "Time Limit Exceeded", integer sum overflows!
//replace it with line 15.
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//public class LC0278 extends VersionControl {
//    public int firstBadVersion(int n) {
//        int low = 1;
//        int high = n;
//        int mid;
//        boolean prev;
//        if (isBadVersion(low)) return 1;
//        while (true){
//            // System.out.println(low+","+high);
////            mid = (low+high)/2;
//            mid = low+((high-low)>>1);
//            if (low == mid) return high;
//            prev = isBadVersion(mid);
//            if (prev==false) low = mid;//ver(low) is guaranteed false
//            else high = mid;//ver(high) is guaranteed true
//        }
//    }
//}
