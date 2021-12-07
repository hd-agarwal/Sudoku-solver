import java.io.*;
import java.util.*;
public class Sudoku
{
    public static void main(String[] args)throws IOException
    {
        Display disp=new Display();
        NewPuzzle np=new NewPuzzle();
        Logicals logi=new Logicals();
        Solver sol=new Solver();
        int n=9;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        String ch1,ch2="1",in;
        int i,j;
        String board[][]=new String[n][n];
        disp.Sopln("WELCOME TO THE SUDOKU SOLVER PROGRAM!");
        disp.Sopln("Select 1 : To solve a custom puzzle.");
        disp.Sopln("Select any other : To see a sample puzzle get solved.");
        ch1=br.readLine();
        if(ch1.equals("1"))
        {
            disp.clear();
            disp.Sopln("Are you sure you want to enter your own puzzle?");
            disp.Sopln("WARNING!!");
            disp.Sopln("-> Entering your own puzzle may be tedious!");
            disp.Sopln("-> Chances of typing mistakes exist!");
            disp.Sopln();
            disp.Sopln("Select 1 : To enter your own puzzle anyways");
            disp.Sopln("Select any other : No, See a sample puzzle get solved");
            ch2=br.readLine();
        }
        if(ch1.equals("1")&&ch2.equals("1"))
        {
            disp.clear();
            disp.Sopln("OK, Start entering your own puzzle...");
            board=np.makePuzzle();
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    board[i][j]="_";
                    disp.printBoard(board,true);
                    disp.Sopln("NOTE:");
                    disp.Sopln("1 : Type the numbers 1 to 9 one by one for the puzzle");
                    disp.Sopln("2 : Hit the ENTER key after each entry and your entry will be updated in the puzzle");
                    disp.Sopln("3 : You can place a .(dot)/0(zero)/*(star)/single space(' ') or any other character other than the numbers 1 to 9 to indicate empty spaces");
                    disp.Sopln("4 : The empty places will be displayed as dots('.') in the puzzle");
                    disp.Sopln();
                    disp.Sopln("Fill the next cell");
                    in=br.readLine();
                    if(logi.isDigit(in))
                        board[i][j]=in;
                    else
                        board[i][j]=".";
                }
            }
        }
        else
        {
            board=np.insertSample();
        }
        disp.clear();
        disp.Sopln("The unsolved puzzle is : ");
        disp.printBoard(board);
        disp.Sopln();
        disp.Sopln("Select 1 : To see the puzzle getting solved.(This may take much time!)");
        disp.Sopln("Select any other : To go directly to solution");
        String ch3;
        ch3=br.readLine();
        boolean see;
        if(ch3.equals("1"))
            see=true;
        else
            see=false;
        boolean isSolvable=sol.sudoku(board,see);
        if(!isSolvable)
            disp.Sopln("The puzzle is unsolvable");
        else
        {
            disp.printBoard(board,true);
            disp.Sopln("Here is your solved sudoku puzzle");
        }
    }
}