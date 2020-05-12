package metodic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeAppMetodic {
    public static void main(String[] args) throws IOException {
        int value;
        TreeMetodic theTreeMetodic = new TreeMetodic();
        theTreeMetodic.insert(new PersonMetodic());
        theTreeMetodic.insert(new PersonMetodic());
        theTreeMetodic.insert(new PersonMetodic());
        theTreeMetodic.insert(new PersonMetodic());
        theTreeMetodic.insert(new PersonMetodic());
        theTreeMetodic.insert(new PersonMetodic());
        theTreeMetodic.insert(new PersonMetodic());

        while(true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert, find, delete, or traverse: ");
            int choice = getChar();
            switch(choice) {
                case 's':
                    theTreeMetodic.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTreeMetodic.insert(new PersonMetodic());
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    NodeMetodic found = theTreeMetodic.find(value);
                    if(found != null) {
                        System.out.print("Found: ");
                    }
                    found.display();
                    System.out.print("\n");
                    break;
            }
        }
    }

    public static String getString() throws  IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
