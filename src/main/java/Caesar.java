

public class Caesar {
    private int key;
    public Caesar(){}
    public Caesar(int key){
        if(key < 1 || key > 25) throw new IllegalArgumentException("the number has to be between 1 and 25!");
        this.key = key;
    }
    public void setKey(int key)
    {
        if(key < 1 || key > 25) throw new IllegalArgumentException("the number has to be between 1 and 25!");
        this.key = key;
    }

    public String encrypt(String plaintext)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < plaintext.length(); i++)
        {
            char c = plaintext.charAt(i);
            if (Character.isUpperCase(c)) c = (char)(((int)c + key - 65) % 26 + 65 );
            else if (Character.isLowerCase(c)) c = (char)(((int)c + key - 97) % 26 + 97 );
            else throw new IllegalArgumentException("Not English alphabet!");
            sb.append(c);
        }
        return sb.toString();
    }

    public String decrypt(String ciphertext)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ciphertext.length(); i++)
        {
            char c = ciphertext.charAt(i);
            if (Character.isUpperCase(c)) c = (char)(((int)c - key - 65 + 26) % 26 + 65 );
            else if (Character.isLowerCase(c)) c = (char)(((int)c - key - 97 + 26) % 26 + 97 );
            else throw new IllegalArgumentException("Not English alphabet!");
            sb.append(c);
        }
        return sb.toString();
    }


}
