import java.util.Scanner;


public class Sudoku {
	
	public static void main(String args[])
	{
		int[][] matrix=new int[9][9];
		Scanner s= new Scanner(System.in);
		for(int i=0;i<9;i++)
		{
			System.out.println("Enter Line :"+(i+1));
			for(int j=0;j<9;j++)
			{
				matrix[i][j] = s.nextInt();
			}
			
			
		}
		
		System.out.println("Your Sudoku\n");
		writeMatrix(matrix);
		System.out.println("Answer:");
		if (solve(0,0,matrix))    // solves in place
		    writeMatrix(matrix);
		else
			System.out.println("WRONG SUDOKU..");
		
	}
	
	

	
	static boolean legal(int i, int j, int val, int cells[][]) {
			int k,m;
			for (k = 0; k < 9; ++k)  // row
			    if (val == cells[k][j])
				return false;

			for (k = 0; k < 9; ++k) // col
			    if (val == cells[i][k])
				return false;

			int boxRowOffset = (i / 3)*3;
			int boxColOffset = (j / 3)*3;
			for (k = 0; k < 3; ++k) // box
			    for (m = 0; m < 3; ++m)
				if (val == cells[boxRowOffset+k][boxColOffset+m])
				    return false;

			return true; // no violations, so it's legal
		    }
	 
	 
	 static boolean solve(int i, int j, int cells[][])
	   {
		if (i == 9)
		{
		    i = 0;
		    if (++j == 9)
			return true;
		}
		if (cells[i][j] != 0)  // skip filled cells
		    return solve(i+1,j,cells);

		for (int val = 1; val <= 9; ++val)
		{
		    if (legal(i,j,val,cells))
		    {
			cells[i][j] = val;
			if (solve(i+1,j,cells))
			    return true;
		    }
		}
		cells[i][j] = 0; // reset on backtrack
		return false;
	    }
	 
	 
	static  void writeMatrix(int solution[][])
     {
	for (int i = 0; i < 9; ++i)
	{
	    if (i % 3 == 0)
	    	System.out.println(" ---------------\n");
	    for (int j = 0; j < 9; ++j)
	    {
		if (j % 3 == 0)
			System.out.print("| ");
		if(solution[i][j] == 0)
			System.out.print("0\t");
		else
		{
			
			System.out.print(solution[i][j]+	"\t");
		}
	    }
	    System.out.println("|");
	}
	System.out.println("---------------\n");
    }

}
