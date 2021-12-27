import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 
 * @author Steven D
 *
 */
public class Driver {
  public static void main(String args[]) {
    int toShift;
    Scanner scanner = new Scanner(System.in);
    int driverState = 0;
    Encrypter encrypter = new Encrypter(2);
    while (driverState != 5) {
      if (driverState == 0) {
        System.out.println("Welcome " + "Shift Count: " + encrypter.getShiftCount()
            + "\n[1] Encrypt\n[2] Decrypt\n[3] Set Shift\n" + "[4] Exit");
        try {
          driverState = scanner.nextInt();
          if (driverState <= 0 || driverState > 4) {
            throw new IllegalArgumentException("Number has to be 1 through 5");
          }
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
          driverState=0;
        }
        catch(InputMismatchException e) {
          System.out.println("Must be an integer");
          scanner.nextLine();
          driverState=0;
        }
      }
      if (driverState == 1) {
        System.out.println("Type in the message you would like to encrypt");
        try {
          String toEncrypt = scanner.next();
          if (toEncrypt.length() == 0) {
            throw new IllegalArgumentException("Please input a valid string");
          }
          System.out.println("Your encrypted message is: "+encrypter.encrypt(toEncrypt)+"\n");
          driverState=0;
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
        
      }
      if(driverState==2) {
        System.out.println("Type in the String you would like to decrypt");
        try {
          String toDecrypt = scanner.next();
          if (toDecrypt.length() == 0) {
            throw new IllegalArgumentException("Please input a valid string");
          }
          System.out.println("Your decrypted message is: "+encrypter.decrypt(toDecrypt)+"\n");
          driverState=0;
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      }
      if(driverState==3) {
        System.out.println("What would you like to change the shift to? Current shift is "+encrypter.getShiftCount());
        try {
          toShift = scanner.nextInt();
          encrypter.setShiftCount(toShift);
          
        }
        catch(InputMismatchException e) {
          System.out.println("Must be an integer");
          scanner.nextLine(); //empty out scanner
          
        }
        finally {
          driverState=0;
        }
      }
      if(driverState==4) {
        System.out.println("GOODBYE!!!");
        driverState=5;
      }
    }
  }
}
