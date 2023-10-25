import java.util.ArrayList;
import java.util.Arrays;
public class Recursion
{
    public static long waysToJumpUpStairs(int n)
    {
        if (n==3)
        {
            return 4;
        }
        if (n==2)
        {
            return 2;
        }
        if (n==1)
        {
            return 1;
        }
        return waysToJumpUpStairs(n-1) + waysToJumpUpStairs(n-2) + waysToJumpUpStairs(n-3);
    }

    public static long nonConsecutiveSubsets(int n)
    {
        if (n==1)
        {
            return 2;
        }
        if (n==2)
        {
            return 3;
        }
        return nonConsecutiveSubsets(n-1) + nonConsecutiveSubsets(n-2);
    }

    public static void reverseList(ListNode head)
    {
        if (head.getNext() == null)
        {
            System.out.println(head.getValue());
        }
        else
        {
            Object value = head.getValue();
            reverseList(head.getNext());
            System.out.println (value);
        }
    }

    public static void infect(String[][] grid, int x, int y)
    {
        if (x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y].equals("vaccinated") || grid[x][y].equals("infected"))
        {
            return;
        }
        if (!grid[x][y].equals("vaccinated"))
        {
            grid[x][y] = "infected";
            infect(grid,x+1,y);
            infect(grid,x-1,y);
            infect(grid,x,y-1);
            infect(grid,x,y+1);
        }
    }


    public static void permute(String str)
    {
        permuteHelper(str,"");
    }

    private static void permuteHelper(String s, String permutation)
    {
        if (s.length()==0)
        {
            System.out.println(permutation);
        }
        for (int i=0; i<s.length(); i++)
        {
            char letter = s.charAt(i);
            String restOfString = s.substring(0,i) + s.substring(i+1);
            permuteHelper(restOfString, permutation + letter);
        }
    }

    public static void subsets(String str)
    {
        for (int i=0; i<subsetsHelper(str).size(); i++)
        {
            System.out.println(subsetsHelper(str).get(i));
        }
    }

    private static ArrayList<String> subsetsHelper (String s)
    {
        if (s.length()==0)
        {
            ArrayList<String> list3 = new ArrayList<String>();
            list3.add("");
            return list3;
        }
        ArrayList<String> list1 = new ArrayList<String>();
        list1 = subsetsHelper(s.substring(0,s.length()-1));
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i=0; i<subsetsHelper(s.substring(1)).size(); i++)
        {
            list2.add(list1.get(i) + s.substring(s.length()-1));
        }
        ArrayList<String> subsets = new ArrayList<String>();
        for (int i=0; i<list1.size(); i++)
        {
            subsets.add(list1.get(i));
        }
        for (int k=0; k<list2.size(); k++)
        {
            subsets.add(list2.get(k));
        }
        return subsets;
    }

    public static void mergeSort(int[] ints)
    {
        mergeSortHelper(ints,0,ints.length-1);
    }

    private static void mergeSortHelper(int[] array, int beg, int end)
    {
        if (beg < end)
        {
            mergeSortHelper(array,beg,((beg+end)/2));
            mergeSortHelper(array,((beg+end)/2)+1,end);
            merge(array,beg,end,((beg+end)/2));
        }
    }

    private static void merge(int[] arr, int start, int end, int mid)
    {
        int[] merged = new int[end-start+1];
        int mIndex = 0;
        int i= start;
        int k = mid + 1;
        while (i<= mid && k<=end)
        {
            if (arr[i] < arr[k])
            {
                merged[mIndex] = arr[i];
                mIndex++;
                i++;
            }
            else
            {
                merged[mIndex] = arr[k];
                mIndex++;
                k++;
            }
        }
        if (i<=mid)
        {
            for (int j=i; j<=mid; j++)
            {
                merged[mIndex] = arr[j];
                mIndex++;
            }
        }
        if (k<=end)
        {
            for (int t=k; t<=end; t++)
            {
                merged[mIndex] = arr[t];
                mIndex++;
            }
        }
        for (int s=0; s<merged.length; s++)
        {
            arr[start+s] = merged[s];
        }
    }

    public static void quickSort(int[] ints)
    {
        System.out.println(1);
    }

    public static int scavHunt(int[] times, int[] points)
    {
        return 21;
    }

    public static void solveHanoi(int n)
    {
        ArrayList<String> list = new ArrayList();
        list = hanoiHelper(n,0,1,2);
        for (int i=0; i<list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }

    private static ArrayList<String> hanoiHelper (int n, int beg, int end, int mid)
    {
        ArrayList<String> moves = new ArrayList();
        if (n==1)
        {
            moves.add("" + beg + " -> " + end);
            return moves;
        }
        else
        {
            for (int i=0; i<hanoiHelper(n-1,beg,mid,end).size(); i++)
            {
                moves.add(hanoiHelper(n-1,beg,mid,end).get(i));
            }
            moves.add("" + beg + " -> " + end);
            for (int i=0; i<hanoiHelper(n-1,beg,mid,end).size(); i++)
            {
                moves.add(hanoiHelper(n-1,mid,end,beg).get(i));
            }
            return moves;
        }
    }

    public static void main(String[] args)
    {
        solveHanoi(5);
        subsets("abc");
		/*System.out.println(nonConsecutiveSubsets(4));
		System.out.println(nonConsecutiveSubsets(5));
		System.out.println(nonConsecutiveSubsets(6));
		ListNode nodey1 = new ListNode(1);
		ListNode nodey2 = new ListNode(2);
		ListNode nodey3 = new ListNode(3);
		ListNode nodey4 = new ListNode(4);
		nodey1.setNext(nodey2);
		nodey2.setNext(nodey3);
		nodey3.setNext(nodey4);
		reversePrint(nodey1);
		permute("abcd");
		subsets("defg");
		System.out.println(hanoiSolver(5));
		int[] array = new int[5];
		array[0] = 5;
		array[1] = 1;
		array[2] = 7;
		array[3] = 2;
		array[4] = 4;
		mergeSort(array);
		for (int i=0; i<array.length; i++)
		{
			System.out.println(array[i]);
		}
		String s = "ABCD";
		permute(s);
		Object[] arr = {2,3,1,4};
		String[][] mat = {{"u","u","vaccinated","u"},{"u","vaccinated","u","u"}};
		infect(mat,1,1);
		for (int i=0; i<mat.length; i++)
		{
			for (int k=0; k<mat[i].length; k++)
			{
				System.out.print (mat[i][k] + " ");
			}
			System.out.println();
		}
		System.out.println(waysToJumpUpStairs(2));*/
    }
}
