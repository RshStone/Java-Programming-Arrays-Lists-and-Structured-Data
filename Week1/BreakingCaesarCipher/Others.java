
/**
 * Write a description of Others here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Others {
    public String encrypt(String input, int key) {
        int n = input.length();
        String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted = original.substring(key, 26);
        shifted = shifted + original.substring(0, key);
        String newinput = new String();
        for (int i = 0; i < n; i++) {
            int position = original.indexOf(input.substring(i, i + 1));
            if (position == -1) {
                position = original.toLowerCase().indexOf(input.substring(i, i + 1));
                if (position > -1) newinput = newinput + shifted.substring(position, position+1).toLowerCase();
                else newinput = newinput + input.substring(i, i + 1);
            }
            else if (position > -1) newinput = newinput + shifted.substring(position, position+1);
        }
        return(newinput);
    }
    
    public void testencrypt() {
        //FileResource fr = new FileResource();
        //String message = fr.asSting();
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String result = encrypt(message, 15);
        System.out.println("key is "+ 15 + "\n" + result);
    }
    
    public String encryptTwokeys(String input, int key1, int key2) {
        int n = input.length();
        String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted_even = original.substring(key1, 26);
        shifted_even = shifted_even + original.substring(0, key1);
        String shifted_odd = original.substring(key2, 26);
        shifted_odd = shifted_odd + original.substring(0, key2);
        
        String newinput1 = new String();
        String newinput2 = new String();
        String newinput = new String();
        
        for (int i = 0; i < n; i= i + 2) {
            int position = original.indexOf(input.substring(i, i + 1));
            if (position == -1) {
                position = original.toLowerCase().indexOf(input.substring(i, i + 1));
                if (position > -1) newinput1 = newinput1 + shifted_even.substring(position, position+1).toLowerCase();
                else newinput1 = newinput1 + input.substring(i, i + 1);
            }
            else if (position > -1) newinput1 = newinput1 + shifted_even.substring(position, position+1);
        }
        
        for (int i = 1; i < n; i= i + 2) {
            int position = original.indexOf(input.substring(i, i + 1));
            if (position == -1) {
                position = original.toLowerCase().indexOf(input.substring(i, i + 1));
                if (position > -1) newinput2 = newinput2 + shifted_odd.substring(position, position+1).toLowerCase();
                else newinput2 = newinput2 + input.substring(i, i + 1);
            }
            else if (position > -1) newinput2 = newinput2 + shifted_odd.substring(position, position+1);
        }
        
        int n1 = newinput1.length();
        int n2 = newinput2.length();
        
        if (n1 > n2) {
            for (int i = 0; i < n2; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
            newinput = newinput + newinput1.substring(n1-1, n1);
        }
        
        if (n1 == n2) {
            for (int i = 0; i < n2; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
        }
        
        if (n1 < n2) {
            for (int i = 0; i < n1; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
            newinput = newinput + newinput2.substring(n2-1, n2);
        }
        
        return(newinput);
    }
    
    public void testencryptTwoKeys() {
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String result = encryptTwokeys(message, 8, 21);
        System.out.println(result);
    }

}
