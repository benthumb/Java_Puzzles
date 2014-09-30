package org.benthumb.tests;

public class Palindrome {

  public Palindrome() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    String forward = "";
    String reverse = "";
    
    for(int i = 0; i < args.length; i++){
      forward = args[i];
      for(int j = forward.length()-1; j >= 0; j--){
        reverse += forward.charAt(j);
      }
      System.out.println("Forward: " + forward);
      System.out.println("Reverse: " + reverse);
      if(forward.equals(reverse)){
        System.out.println("T");
      }else{
        System.out.println("F");
      }
      reverse = "";
    }
  }
}
