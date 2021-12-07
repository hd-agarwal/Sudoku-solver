public class Logicals
{
     static boolean isDigit(String s)
    {
        if(s.equals("1")||s.equals("2")||s.equals("3")||s.equals("4")||s.equals("5")||s.equals("6")||s.equals("7")||s.equals("8")||s.equals("9"))
            return true;
        return false;
    }
     static String itos(int n)
    {
        if(n==0)
        {
            return "0";
        }
        String s="";
        while(n!=0)
        {
            s=(n%10)+s;
            n/=10;
        }
        return s;
    }
     static int stoi(String s)
    {
        if(s.equals("0")||s.length()==0)
            return 0;
        return (int)s.charAt(s.length()-1)-48+10*stoi(s.substring(0,s.length()-1));
    }
}