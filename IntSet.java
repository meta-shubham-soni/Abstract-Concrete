import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;


public class IntSet {
    private final int[] arraySet;
    
    IntSet(int[] arr){
        Arrays.sort(arr);
        arraySet = arr;
    }
    
    IntSet(){
        arraySet = new int[0];
    }
    
    public int[] getArray(){
        return arraySet;
    }
    
    /**
     * Check if set contain num
     * @param num
     * @return boolean
     */
    public boolean isMember(int num){
        return binarySearch(arraySet,0,arraySet.length-1,num) != -1 ? true : false;
    }
    
    public int size(){
        return arraySet.length;
    }
    
    /**
     * Check is subSet is Subset of this.set
     * @param subSet
     * @return
     */
    public boolean isSubSet(IntSet subSet){
        int[] subSetArray = subSet.getArray();
        HashMap<Integer,Integer> occurenceCount = new HashMap<Integer,Integer>();
        
        for(int i=0;i<arraySet.length;i++){
            if(occurenceCount.containsKey(arraySet[i])){
                int newValue = occurenceCount.get(arraySet[i]) + 1;
                occurenceCount.put(arraySet[i],newValue);
            }
            else
                occurenceCount.put(arraySet[i],1);
        }
        
        for(int i=0;i<subSetArray.length;i++){
            if(occurenceCount.containsKey(subSetArray[i]) && occurenceCount.get(subSetArray[i]) > 0){
                int newValue = occurenceCount.get(subSetArray[i]) - 1;
                occurenceCount.put(subSetArray[i],newValue);
            }
            else
                return false;
        }
        
        return true;
    }
    
    /**
     * Function to return complement of this.set
     * @return
     */
    public int[] getComplement(){
        int lenOfComplement =  1000 - arraySet.length;
        int[] complementSet = new int[lenOfComplement];
        int ind = 0;
        HashMap<Integer,Integer> occurenceCount = new HashMap<Integer,Integer>();
        
        for(int i=0;i<arraySet.length;i++){
            if(occurenceCount.containsKey(arraySet[i])){
                int newValue = occurenceCount.get(arraySet[i]) + 1;
                occurenceCount.put(arraySet[i],newValue);
            }
            else
                occurenceCount.put(arraySet[i],1);
        }
        for(int i=1;i<=1000;i++){
            if(!occurenceCount.containsKey(i)){
                complementSet[ind] = i;
                ind+=1;
            }
        }
        for(int i=0;i<complementSet.length;i++)
            System.out.print(complementSet[i] + " ");
        
        return complementSet;
    }
    
    /**
     * Function to return union of s1 & s2
     * @param s1
     * @param s2
     * @return
     */
    public int[] union(IntSet s1,IntSet s2){
        int[] arr1 = s1.getArray();
        int[] arr2 = s2.getArray();
        ArrayList<Integer> unionArray = new ArrayList<Integer>();
        for(int i=0;i<arr1.length;i++){
            unionArray.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            if(isMember(arr2[i]) == false){
                unionArray.add(arr2[i]);
            }
        }
        int[] finalAns = new int[unionArray.size()];
        for(int i = 0;i<unionArray.size();i++){
        	finalAns[i] = unionArray.get(i);
        }
        return finalAns;
    }
    
    
    //helper function for binary searching
    int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
        	System.out.println(l + " " + r);
            int mid = l + (r - l) / 2; 
        	System.out.println(mid);  

            if (arr[mid] == x) 
                return mid; 
  
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        return -1; 
    }
    
}