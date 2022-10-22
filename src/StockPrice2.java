public class StockPrice2 {

    private class node{
        int val;
        int time;
        node next;
        public node(int val,int time){
            this.val = val;
            this.time = time;
        }
    }
    private node head = null;
    public StockPrice2() {
    }
    public void update(int timestamp, int price) {

        node temp = new node(price,timestamp);
//        System.out.println(temp.val+","+temp.time);

        if (head == null){
            head = temp;
            temp.next = null;
        }
        else{//head!=null;
            if(head.time<temp.time){
                temp.next = head;
                head = temp;
            }
            else if (head.time == temp.time){
                head.val = temp.val;
            }
            else {//head!=null && head.time>temp.time;
                node curr = head.next;
                node prev = head;

                while(true){
                    if (curr == null){
                        prev.next = temp;
                        temp.next = null;
                        break;
                    }
                    else {//current != null;
                        if (curr.time == temp.time){
                            curr.val = temp.val;
                            break;
                        }
                        else if  (curr.time < temp.time) {
                            prev.next = temp;
                            temp.next = curr;
                            break;
                        }
                        else {
                            prev = curr;
                            curr = curr.next;
                        }
                    }
                }
            }
        }
    }

    public int current() {
        return head.val;
    }

    public int maximum() {
        int max = 0;
        node curr = head;
        while(curr!=null){
            if(max<curr.val) max = curr.val;
            curr = curr.next;
        }
        return max;
    }

    public int minimum() {

        int min = 1000000000;
        node curr = head;
        while(curr!=null){
            if(min>curr.val) min = curr.val;
            curr = curr.next;
        }
        return min;
    }

    public void printAll()
    {
        node curr = head;
        while(curr!=null){
            System.out.println(curr.time+", "+curr.val);
            curr = curr.next;
        }
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */