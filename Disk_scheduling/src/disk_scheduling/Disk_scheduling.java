package disk_scheduling;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Disk_scheduling {

    public static ArrayList<Integer> requests = new ArrayList<Integer>();
    public static int initial, nRequests;

    public static void main(String[] args) {
        
        int x=abs(120-38)+abs(38-180)+abs(180-130)+abs(130-10)+abs(10-50)+abs(50-15)+abs(15-190)+abs(190-90)+abs(90-150);
        System.out.println(x);

        int temp;
        //ArrayList<Integer> va = (ArrayList<Integer>) requests.clone();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial head start cylinder : ");
        initial = scanner.nextInt();

        System.out.print("Enter number of requests : ");
        nRequests = scanner.nextInt();

        for (int i = 0; i < nRequests; i++) {
            System.out.print("Enter request number " + (i + 1) + " : ");
            temp = scanner.nextInt();
            requests.add(temp);
        }
        fcfs();
        scan();
        look();
    }
    
    public static void fcfs()
    {
        int sum=0;
        System.out.print("< "+initial+" , ");
        for(int i=0;i<nRequests;i++)
        {
            if (i==nRequests-1)
            {
                System.out.println(requests.get(i)+" >");
            }
            else
                System.out.print(requests.get(i)+" , ");
        }
        System.out.print("Total Head movements = ");
        sum+=abs(initial-requests.get(0));
        for(int i=0;i<nRequests;i++)
        {
            if(i!=nRequests-1)
                sum+=abs(requests.get(i)-requests.get(i+1));
        }
        System.out.println(sum);
    }
    
    public static void scan()
    {
        int [] arr= new int[nRequests+2];
        arr[0]=0;
        arr[1]=initial;
        for (int i=2;i<nRequests+2;i++)
        {
            arr[i]=requests.get(i-2);
        }
        Arrays.sort(arr);
        int x=0;
        for(int i=0;i<nRequests+2;i++)
        {
            if(arr[i]==initial)
                x=i;
        }
        System.out.print("< "+initial+" , ");
        int sum=0;
        sum+=abs(initial-arr[x-1]);
        for(int i=x-1;i>=0;i--)
        {
            if(i!=0)
                sum+=abs(arr[i]-arr[i-1]);
            if (i==0)
            {
                System.out.print(arr[i]+" , ");
            }
            else
                System.out.print(arr[i]+" , ");
        }
        sum+=abs(arr[0]-arr[x+1]);
        for(int i=x+1;i<arr.length;i++)
        {
            if(i!=arr.length-1)
                sum+=abs(arr[i]-arr[i+1]);
            if (i==arr.length-1)
            {
                System.out.println(arr[i]+" >");
            }
            else
                System.out.print(arr[i]+" , ");
        }
       
        System.out.print("Total Head movements = ");
        System.out.println(sum);
        
    }
    
    public static void look()
    {
        int [] arr= new int[nRequests+1];
        arr[0]=initial;
        for (int i=1;i<nRequests+1;i++)
        {
            arr[i]=requests.get(i-1);
        }
        Arrays.sort(arr);
        int x=0;
        for(int i=0;i<nRequests+1;i++)
        {
            if(arr[i]==initial)
                x=i;
        }
        System.out.print("< "+initial+" , ");
        int sum=0;
        sum+=abs(initial-arr[x-1]);
        for(int i=x-1;i>=0;i--)
        {
            if(i!=0)
                sum+=abs(arr[i]-arr[i-1]);
            if (i==0)
            {
                System.out.print(arr[i]+" , ");
            }
            else
                System.out.print(arr[i]+" , ");
        }
        sum+=abs(arr[0]-arr[x+1]);
        for(int i=x+1;i<arr.length;i++)
        {
            if(i!=arr.length-1)
                sum+=abs(arr[i]-arr[i+1]);
            if (i==arr.length-1)
            {
                System.out.println(arr[i]+" >");
            }
            else
                System.out.print(arr[i]+" , ");
        }
       
        System.out.print("Total Head movements = ");
        System.out.println(sum);
        
    }

}
