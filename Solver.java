public class Solver
{
    static Logicals logi=new Logicals();
    static Display disp=new Display();
     static boolean isSafe(String board[][],int i,int j,int n)
    {
        return isSafe(board,i,j,n,9);
    }
     static boolean isSafe(String board[][],int i,int j,int n,int p)
    {
        int cs=0,rs=0,r,c,step=(int)Math.sqrt(p);
        while(rs<=i)
        {
            rs+=step;
        }
        rs-=step;
        while(cs<=j)
        {
            cs+=step;
        }
        cs-=step;
        for(r=rs;r<rs+step;r++)
        {
            for(c=cs;c<cs+step;c++)
            {
                if((r!=i||c!=j)&&board[r][c].equals(logi.itos(n)))
                    return false;
            }
        }
        for(int k=0;k<p;k++)
        {
            if(k!=i&&board[k][j].equals(logi.itos(n)))
                return false;
            if(k!=j&&board[i][k].equals(logi.itos(n)))
                return false;
        }
        return true;
    }

     static boolean sudoku(String board[][],boolean see)
    {
        return sudoku(board,see,9,0,0,".");
    }

     static boolean sudoku(String board[][],boolean see,int n,int r,int c,String empty)
    {
        if(r==n||c==n)
        {
            if(see)
            {
                disp.mywait();
                disp.printBoard(board,true);
            }
            return true;
        }
        if(board[r][c].equals(empty)==false)
        {
            if(c==n-1)
                return sudoku(board,see,n,r+1,0,empty);
            else
                return sudoku(board,see,n,r,c+1,empty);
        }
        for(int i=1;i<=n;i++)
        {
            if(isSafe(board,r,c,i))
            {
                board[r][c]=logi.itos(i);
                if(see)
                {
                    disp.mywait();
                    disp.printBoard(board,true);
                }
                boolean banPaya;
                if(c==n-1)
                {
                    banPaya=sudoku(board,see,n,r+1,0,empty);
                }
                else
                {
                    banPaya=sudoku(board,see,n,r,c+1,empty);
                }
                if(banPaya)
                    return true;
                board[r][c]=empty;
            }
        }
        return false;
    }
}