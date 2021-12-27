import java.util.ArrayList;
/**
 * 
 * @author Steven D
 *
 */
public class Encrypter {
  private int shiftCount;
  private ArrayList<Character> letters;
  public Encrypter(int shiftCount) {
    this.shiftCount=shiftCount;
    this.letters=new ArrayList<Character>();
    int ASCII =97;
    for(int i =0;i<26;i++) {
      letters.add((char)ASCII);
      ASCII++;
    }
  }
  /**
   * Encrypts the message
   * @param message Message to be encrypted
   * @return An encrypted message
   */
  public String encrypt(String message) {
    String encryptedMessage="";
    message=message.toLowerCase();
    for(int i =0;i<message.length();i++) {
      char letter = message.charAt(i);
      if(letters.indexOf(letter)>=0) {
        letter=letters.get(((letters.indexOf(letter)+shiftCount)%26));
        
      }
      encryptedMessage=encryptedMessage+String.valueOf(letter);
      
    }
    return encryptedMessage;
  }
  
  /**
   * Decrypts the message
   * @param message Message to be decrypted
   * @return A decrypted message
   */
  public String decrypt(String message) {
    String decryptedMessage="";
    message=message.toLowerCase();
    for(int i =0;i<message.length();i++) {
      char letter = message.charAt(i);
      if(letters.indexOf(letter)>=0) {
        letter=letters.get(((letters.indexOf(letter)-shiftCount)%26));
        
      }
      decryptedMessage=decryptedMessage+String.valueOf(letter);
      
    }
    return decryptedMessage;
  }
  
  /**
   * Setter method changes how much the letters are shifted by
   * @param shiftCount The amount letters are to be shifted by
   */
  public void setShiftCount(int shiftCount) {
    this.shiftCount=shiftCount;
  }
  /**
   * Getter method returns the amount the letters are shifted by
   * @return The amount the letters are shifted by
   */
  public int getShiftCount() {
    return this.shiftCount;
  }
}
