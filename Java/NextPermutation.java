public class Solution {
    public void nextPermutation(ArrayList<Integer> a) {
        boolean swapped = false;
        int index = -1;
        for(int i = a.size() - 1; i>0; i--) {
            if(a.get(i) > a.get(i-1)) {
              index = i-1;
              swapped = true;
              break;
            }
        }
        
        if(!swapped) {
            Collections.reverse(a);
            return;
        }
        
        int swapIndex = -1;
        for(int j = a.size() - 1; j>index; j--) {
            if(a.get(j) > a.get(index)) {
                swapIndex = j;
                break;
            }
        }
        
        int ele = a.get(index);
        a.set(index, a.get(swapIndex));
        a.set(swapIndex, ele);
        
         Collections.sort(a.subList(index+1, a.size()));
            
       
    
    }
}

