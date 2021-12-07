public class NewPuzzle
{
     static String[][] insertSample()
    {
        String sample[][]={{"5","3",".",".","7",".",".",".","."}, 
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."}, 
                {"8",".",".",".","6",".",".",".","3"}, 
                {"4",".",".","8",".","3",".",".","1"}, 
                {"7",".",".",".","2",".",".",".","6"}, 
                {".","6",".",".",".",".","2","8","."}, 
                {".",".",".","4","1","9",".",".","5"}, 
                {".",".",".",".","8",".",".","7","9"}};
        return sample;
    }
     static String [][] makePuzzle()
    {
        return makePuzzle(9);
    }
     static String [][] makePuzzle(int n)
    {
        String newPuzzle[][]=new String[n][n];
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                newPuzzle[i][j]=" ";
            }
        }
        return newPuzzle;
    }
}