import java.util.*;


public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<arr.length;i++){
            arr[i] = in.nextInt();
        }

        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){


                if(subarraySum(arr,i,j)<0){
                    count++;
                }

            }
        }

        System.out.println(count);
    }

    public static int subarraySum(int[] arr,int startIndex,int finalIndex){
        int subarraySum = 0;
        if(startIndex==finalIndex) return arr[startIndex];
        else if(startIndex<finalIndex){
            while(startIndex<=finalIndex){
                subarraySum += arr[startIndex];
                startIndex++;
            }
        }
        return subarraySum;
    }
}














