class Item{
    int val , wt;
    Item(int val , int wt){
        this.wt=wt;
        this.val=val;
    }
    static Comparator<Item> ratio=new Comparator<Item>(){
       public int compare(Item x,Item y){
            double a=(double)x.val / x.wt;
            double b=(double)y.val / y.wt;
            return Double.compare(b,a);
        }
    };
}
class Solution {
    double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        Item[] arr=new Item[wt.length];
        for(int i=0;i<wt.length;i++){
            arr[i]=new Item(val[i],wt[i]);
        }
        Arrays.sort(arr,Item.ratio);
        double sum=0;
        for(int i=0;i<val.length;i++){
            if(arr[i].wt <= capacity){
                    sum+=arr[i].val;
                    capacity-=arr[i].wt;
            }else{
                sum+= ((double)arr[i].val/arr[i].wt)*capacity;
                break;
            }
        }
        return sum;
    }
}
