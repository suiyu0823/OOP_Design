/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suiyu
 */
import java.util.Scanner;
import java.io.*;
public class Login {
    public static void main(String[] args) {     // program starts from here
       Manager k = Manager.getinstance(); 
     
       Logout exits = new Logout();
      // k.execute();
       try {
       File f = new File("UserProfiles.txt");
       BufferedReader br = new BufferedReader(new FileReader(f));
       Scanner pro = new Scanner(br);
           System.out.println(pro.next());
           System.out.println(pro.next());
           System.out.println(pro.skip("checking"));
           System.out.println(pro.next());
           System.out.println(pro.next());
       String text;
      // String text = fr.read();
       
      // int ch = fr.read();
       
       while ((text = br.readLine()) != null){
           System.out.println(text);
       }
       }
       catch (Exception ex){
           System.out.println(ex);
       }
       exits.exit(1);
}
}
        