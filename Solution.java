package test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;
public class Solution
{
	public static PriorityQueue<State> pq = new PriorityQueue<State>(); 
	public static ArrayList<State> expanded = new ArrayList<State>();
	public static String[][] goal;
	public Solution(State first) {
		if(first==null) {
			System.out.println("Please provide an input");
		}
		pq.add(first);
		ArrayList<State> list = new ArrayList<State>();
		while(!pq.isEmpty())
		{	
			int visited;
			State current = pq.poll();
			expanded.add(current);
			if(Arrays.deepEquals(current.blocks, goal))
			{
				break;
			}
			list = current.expand(current); // get all children for this current state
			//avoid looping with same state
			for (State l:list) 
			{
				visited = 0;
				for (State e:expanded)
				{
					if(Arrays.deepEquals(l.blocks, e.blocks))
					{
						visited = 1;
					}
				}
				if(visited==1)
					continue;
				pq.add(l);
			}
		}
	}
	public static void main(String args[])
	{
		String intial[][];
		int i,j,k,rows,columns;
		rows=columns=3;
		String array_intial[] = new String[rows*columns];
		String array_goal[] = new String[rows*columns];
		Scanner sc = new Scanner(System.in);
		intial = new String[rows][columns];
		goal = new String[rows][columns];
		System.out.println("Please input the elements for initial state :");
		k=0;
		for (i=0;i<intial.length;i++)
		{
			for(j=0;j<intial.length;j++)
			{
				intial[i][j] = sc.nextLine();
				array_intial[k] = intial[i][j];
				k++;
				if(intial[i][j].length()!=1 || (intial[i][j].charAt(0)<'1' && intial[i][j].charAt(0)!=' ') || intial[i][j].charAt(0)>'8')
				{
					System.out.println("Error: Input should be any number between 1 to 8 or a single space\nProgram Terminated");
					return;
				}
			}
		}
		System.out.println("Please input the Goal state:");
		// The below code validates the goal input provided by the user and terminates for invalid input.
		k=0;
		for (i=0;i<goal.length;i++)
		{
			for(j=0;j<goal.length;j++)
			{
				goal[i][j] = sc.nextLine();
				array_goal[k] = goal[i][j];
				k++;
				if(goal[i][j].length()!=1 || (intial[i][j].charAt(0)<'1' && intial[i][j].charAt(0)!=' ') || intial[i][j].charAt(0)>'8')
				{
					System.out.println("Error: Input should be any number between 1 to 8 or a single space\nProgram Terminated");
					return;
				}
			}
		}
		// test if the given inputs is Solvable
		int counter1=0,counter2=0;
		for (i=0;i<rows*columns;i++) {
			for (j=i+1;j<rows*columns;j++) {
				if (array_intial[i].charAt(0)!=' ' && array_intial[j].charAt(0)!=' ') {
					if (array_intial[i].charAt(0) > array_intial[j].charAt(0))
						counter1++;
						
				}
				if (array_goal[i].charAt(0)!=' ' && array_goal[j].charAt(0)!=' ') {
					if (array_goal[i].charAt(0) > array_goal[j].charAt(0))
						counter2++;
				}
			}
		}
		if ((counter1 % 2 != 0 && counter2 % 2 == 0) || (counter1 % 2 == 0 && counter2 % 2 != 0)){
			System.out.println("Error: Unsolvable State");
			return;
		}
		// solution start from here
		State state_intial = new State(intial,0);
		new Solution(state_intial);
		for(State states:expanded) {
			for (int l = 0;l<3;l++)
			{
				for (int m=0;m<3;m++)
				{
					System.out.print(states.blocks[l][m]+"\t");
				}
				System.out.println();
			}
			System.out.println("f(n) :"+states.f);
			System.out.println("h(n) :"+(states.f-states.level));
			System.out.println("g(n) :"+(states.level));
			System.out.println('\n');
		}
		System.out.println("Total Nodes expanded :"+expanded.size());
		System.out.println("Total Nodes generated:"+(expanded.size()+pq.size()));
	}
}
