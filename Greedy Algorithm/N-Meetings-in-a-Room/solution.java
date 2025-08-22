class Meeting{
    int start;
    int end;
    Meeting(int start,int end){
        this.start=start;
        this.end=end;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        Meeting[] meetings=new Meeting[start.length];
        for(int i=0;i<start.length;i++){
            meetings[i]=new Meeting(start[i],end[i]);
        }
        Arrays.sort(meetings,(a,b)->Integer.compare(a.end,b.end));
        int freetime=-1;
        int count=0;
        for(Meeting m : meetings){
            if(m.start > freetime){
                freetime=m.end;
                count++;
            }
        }
        return count;
    }
}

