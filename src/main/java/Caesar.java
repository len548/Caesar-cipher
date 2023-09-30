public class Caesar {
    private int n;
    public Caesar(){}
    public Caesar(int n){
        if(n < 1 || n > 25) throw new IllegalArgumentException("the number has to be between 1 and 25!");
        this.n = n;
    }
    public void setCaesar(int n)
    {
        if(n < 1 || n > 25) throw new IllegalArgumentException("the number has to be between 1 and 25!");
        this.n = n;
    }

    public String encrypt(String text)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) c = (char)(((int)c + n - 65) % 26 + 65 );
            else if (Character.isLowerCase(c)) c = (char)(((int)c + n - 97) % 26 + 97 );
            else throw new IllegalArgumentException("Not English alphabet!");
            sb.append(c);
        }
        return sb.toString();
    }

    public String decrypt(String text)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (Character.isUpperCase(c)) c = (char)(((int)c - n - 65 + 26) % 26 + 65 );
            else if (Character.isLowerCase(c)) c = (char)(((int)c - n - 97 + 26) % 26 + 97 );
            else throw new IllegalArgumentException("Not English alphabet!");
            sb.append(c);
        }
        return sb.toString();
    }


}
