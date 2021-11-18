package Interface;

public class CharSequencePlus implements CharSequence {

  private String s;


  public CharSequencePlus(String s) {
    this.s = s;
  }


  @Override
  public int length() {
    return s.length();
  }


  @Override
  public char charAt(int index) {
    if ((index < 0) || (index >= s.length())) {
      throw new StringIndexOutOfBoundsException(index);
    }

    return s.charAt(index);
  }


  @Override
  public CharSequence subSequence(int start, int end) {
    if (start < 0) {
      throw new StringIndexOutOfBoundsException(start);
    }
    if (end > s.length()) {
      throw new StringIndexOutOfBoundsException(end);
    }
    if (start > end) {
      throw new StringIndexOutOfBoundsException(start - end);
    }
    StringBuilder sub = new StringBuilder(s.subSequence(start, end));

    return sub.reverse();
  }


  public String toString() {
    StringBuilder s = new StringBuilder(this.s);

    return s.reverse().toString();
  }


  private static int random(int max) {
    return (int) Math.round(Math.random() * (max+1));
  }


  public static void main(String[] args) {
    CharSequencePlus s = new CharSequencePlus("Select one of the sentences from this book to use as the data.");

    for (int i = 0; i < s.length(); i++) {
      System.out.print(s.charAt(i));
    }
    
    System.out.println("");

    int start = random(s.length() - 1);
    int end = random(s.length() - 1 - start) + start;
    System.out.println(s.subSequence(start, end));

    //exercise toString();
    System.out.println(s);

  }

}