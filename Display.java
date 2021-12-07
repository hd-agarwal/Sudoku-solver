public class Display
{
    static void Sop(int n)
    {
        System.out.print(n);
    }

    static void Sop(char ch)
    {
        System.out.print(ch);
    }

    static void Sop(String s)
    {
        System.out.print(s);
    }

    static void Sopln()
    {
        System.out.println();
    }

    static void Sopln(int n)
    {
        System.out.println(n);
    }

    static void Sopln(char ch)
    {
        System.out.println(ch);
    }

    static void Sopln(String s)
    {
        System.out.println(s);
    }

    static void clear()
    {
        Sop('\u000C');
        Sopln();
    }

    static void mywait()
    {
        for(long i=1l;i<=9999999l;i++);
    }

    static void printBoard(String [][]board,boolean cl)
    {
        printBoard(board,cl,9);
    }

    static void printBoard(String [][]board)
    {
        printBoard(board,false,9);
    }

    static void printBoard(String [][]board,boolean cl,int n)
    {
        int i,j;
        if(cl)
            clear();
        for(i=0;i<n;i++)
        {
            if(i%3==0)
            {
                for(j=0;j<8*n/3+1;j++)
                {
                    if(j%8==0)
                        Sop('+');
                    else
                        Sop('-');
                }
            }
            Sopln();
            for(j=0;j<n;j++)
            {
                if(j%3==0)
                    Sop("| ");
                Sop(board[i][j]+" ");
            }
            Sopln('|');
            if(i%3!=2)
            {
                for(j=0;j<8*n/3+1;j++)
                {
                    if(j%8==0)
                        Sop('|');
                    else
                        Sop(' ');
                }
            }
        }
        for(j=0;j<8*n/3+1;j++)
        {
            if(j%8==0)
                Sop('+');
            else
                Sop('-');
        }
        Sopln();
    }
}