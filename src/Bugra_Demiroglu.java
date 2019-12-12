import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

/***
 * @author Bugra Demiroglu
 * @version 1.0
 *
 *Date: 15.11.2019
 *Student ID: 041601016
 *
 *
 * That program takes a file as a java class and checks that file is correct or not with comparing parantheses.
 * In a programming language, parantheses must be correctly matched otherwise compiler gives an error.
 * So in our parantheses checker program, we use stack to compare the parantheses. While reading the file if we see parantheses then push into the stack
 * if we see ),},] and their peek value is matched. Then pop from the stack.
 * After the Operations, If the stack is empty then that java file's parantheses correctly matched.
 */
public class Bugra_Demiroglu {
    public static void main(String[] args) throws IOException {
      // Created a stack object to use stack's property.
      myStack stack = new myStack();
      // Asking from the user to reaching java file location.
      System.out.println("Enter your file location: ");
      Scanner scan = new Scanner(System.in);
      // keeping that file which has already in that location.
      String  location = scan.nextLine();
      // Creating Filereader and Buffer reader to reading the java file.
        File f=new File(location);     //Creation of File Descriptor for input file
        FileReader fr=new FileReader(f);   //Creation of File Reader object
        BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object

        // Creating a int "c" value to be able to read the file as character by character
        int c = 0;
        // Creating a while loop to walking in the file
        while((c = br.read()) != -1)         //Read char by Char
        {
            char character = (char) c;          //converting integer to char

            if (character == '(' || character == '{' || character == '[') { // If at that moment character equals to (, { or [ adding into the stack
                stack.push(character);
                stack.Print();

            }

          else if (character == ')' || character == '}' || character == ']') { // If at that moment character equalts to ), }, ] and if peek value is it's opposite then pop the value from the stack
              if (stack.isEmpty()) {

                  stack.push(character);
              }
              else if (character == ')' && (char)stack.peek() == '(' || character == '}' && (char)stack.peek() == '{' ||character == ']' && (char)stack.peek() == '[') {
                  stack.pop();
                  stack.Print();
              }

            }

        }
        // After pushing poping operations, if the stack is empty then parantheses are correctly match.
        if (stack.isEmpty()) {
            System.out.println("Parantheses are correctly match!");
        }
        // Else, they are not.
        else if (!stack.isEmpty()) {
            System.out.println("Parantheses do not match!");
        }

        else {
            try {
                throw new Exception("Unkown Error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}




