
package pizza_project;
import java.util.*;

public class PIZZA_PROJECT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to add your choice of incredients in your Pizza");
      String crust = crust();
      String sauce = sauce();
      String sauceAmount = "";
      switch(sauce) {
          case "red sauce":
            sauceAmount =  sauceAmount();
            break;
          case "no red sauce":
              break;
        }
                 if("red sauce".equals(sauce)) {
       System.out.println("You chose:\t" + sauce+ " = \t" + sauceAmount  + " cup *");
      }else {
          System.out.println("You choose:\t" +sauce);
            }
    
       String choice;
      int ingredientNumber = 0;
      int j = 0;
              ArrayList ing = new ArrayList();
              String[] amount = new String[6]; 
        do{
            ing.add(ingredient());
            String ingred = (String) ing.get(j);
            //ing.get(j);
            switch(ingred) {
                case "pizza cheese":
                    amount[j] = sauceAmount(); 
                break;
                case "diced onion":
                    amount[j] = onionAmount(1/8, 1/4);
                break;
                case "green pepper":
                    amount[j] = onionAmount(1/8, 1/4);
                break;
            case "pepperoni":
                amount[j] = pieces();
                break;
            case "sliced mushroom":
                amount[j] = onionAmount(1/8, 1/4);
                break;
            case "jalapenos":
                amount[j] = onionAmount(1/8, 1/4);
                break;
            case "sardines":
                amount[j] = eachamt();
                break;
          case "pineapple chunks":
              amount[j] = pieces();
                break;
            case "tofu":
                amount[j] = sauceAmount();
                break;
            case "ham chunks":
                amount[j] = eachamt();
                break;
            case "red pepper":
                amount[j] = gensprink();
                break;
            case "dried basil":
                amount[j] = Gensprink(1, 2);
                break;
            default: 
                amount[j] = "invalid ingredient";
                break;
            
    }
            ingredientNumber++;
            j++;
            System.out.println("Would you like to choose another ingredient?");
            System.out.println("a. continue\t b. exit");
            System.out.print("Enter choice: ");
            choice = input.next();
        while(!(choice.equals("a") || choice.equals("b"))){
      System.out. println("Please enter either a or b: ");
    choice= input.next();}
        }while(choice.equals("a") && ingredientNumber < 6); 
         if ("b".equals(choice)){
             System.out.println("*************************");
       System.out.println();}
             System.out.println("* Your pizza recipe*");
       System.out.println(crust + "\t1"); //use this for result
       System.out.println(sauce + "\t" + sauceAmount);
       
       for(int i = 0; i < ingredientNumber; i++){
                      if(ing.get(i).equals("invalid ingredient") && amount[i].equals("invalid ingredient")) {   
           }     else{
            System.out.println(ing.get(i) + "\t"+amount[i]+"\t");
                   }       
              }
       System.out.println(" * Pizza is to be appropriately cooked until crust is cooked and toppings are warmed *");
                  System.exit(0);
   }
              public static String crust() {
        Scanner input= new Scanner(System.in);
        String crust = "";
        int number=1;
      String choice;
      System.out.println("*************************");
      System.out.println("Please choose one crust option: \n");
      System.out.println("a. regular crust\t" + "b. gluten-free crust \n");
      System.out. print("Enter choice: ");
      choice= input.next();
           while(!(choice.equals("a") || choice.equals("b"))){
      System.out. print("Please enter either a or b: ");
      choice= input.next();
     }
      if (choice.equals("a")) {
           crust = "regular crust" ;
                       System.out.println("You Chose:\t a. regular crust "+ number + " *");

        } else if(choice.equals("b")){
            System.out.println("You Chose:\t b. gluten-free crust " + number + " *");
             crust = "gluten-free crust";
        } System.out.println("*************************");
       return crust;    
    }     
    
    public static String sauce() {
        Scanner input= new Scanner(System.in);
      String choice;
      String sauce = "";
System.out.println("Please choose one sauce option:");
System.out.println("a. red sauce\t" + "b. no red sauce");
System.out. print("Enter choice: ");
 choice= input.next();
      while(!(choice.equals("a") || choice.equals("b"))){
System.out. println("Please enter either a or b: ");
      choice= input.next();
     }
      if (choice.equals("a")) {
     sauce = "red sauce";
     } else if(choice.equals("b")){
        sauce = "no red sauce";
        }
             return sauce;
    }     
    
    public static String sauceAmount(){
        Scanner input = new Scanner(System.in);
         String choice;
         String sauceAmount = "";
          System.out.println("Please choose one amount:");
       System.out.println("a. 1/4 cup \t" + "b. 1/2 cup");
       System.out. print("Enter choice: ");
      choice= input.next();
      
     while(!(choice.equals("a") || choice.equals("b"))){
      System.out. println("Please enter either a or b: ");
      choice= input.next();
     }
     if (choice.equals("a")) {
          sauceAmount = "1/4";
        } else if(choice.equals("b")){
            sauceAmount = "1/2";
        }
           return sauceAmount;
    }

 public static String ingredient(){
    Scanner input= new Scanner(System.in);
        String choice;
              System.out.println("*************************");
       // String amt1= "";
   
    System.out.println("Please choose one ingredient option:");
    System.out.println("a. pizza cheese\t" + "b. diced onion \t\t" + " c. diced green pepper\n");
    System.out.println("d. pepperoni\t" + "e. sliced mushroom\t" + "f. diced jalapenos\n");
    System.out.println("g. sardines\t" + "h. pineapple chunks\t" + "i. tofu\n");
    System.out.println("j. ham chucks\t" + "k. dry red pepper\t" + "l. dry basil\n");
 System.out. print("Enter choice: ");
    choice= input.next();
   switch(choice){
        case "a":
               choice = "pizza cheese";
                                  System.out.println("You chose: " + choice);
            break;case "b":
            choice = "diced onion";
         System.out.println("You chose: " + choice);
           break;case "c":
            choice = "green pepper";
            System.out.println("You chose: " + choice);
            break;case "d":
            choice = "pepperoni";
            System.out.println("You chose :" + choice);
            break;case "e":
                choice = "sliced mushroom";
            System.out.println("You chose :" + choice);
            break;case "f":
                choice = "jalapenos";
            System.out.println("You chose : " + choice);
            break;case "g":
                choice= "sardines";
             System.out.println("You chose :" + choice);
            break;case "h":
                choice= "pineapple chunks";
            System.out.println("You chose: " + choice);
            break;case "i":
                choice = "tofu";
            System.out.println("You chose: " + choice);
            break;case "j":
                 choice= "ham chunks";
            System.out.println("You chose: "+ choice);
            break;case "k":
                choice = "red pepper";
            System.out.println("You chose: "+ choice);
            break;case "l":
                choice = "dry basil";
            System.out.println("You chose: "+ choice);
            break;
            default:
            System.out.print("invalid ingredient\t");
            choice = "invalid ingredient";
            break;}
 return choice;
}

public static String pieces(){
 Scanner input = new Scanner(System.in);
         String choice;
         String pieces;
System.out.println("Please choose the amount option:");
System.out.println("a. 2 pieces \t" + "b. 4 pieces\t" + "c. 6 pieces\t" + "d. 8 pieces");
System.out. print("Enter choice: ");
      choice= input.next();
      while(!(choice.equals("a") || choice.equals("b") || choice.equals("c") || choice.equals("d"))){
      System.out. println("Please enter either a or b or c or d: ");
      choice= input.next();
     }
        switch (choice) {
            case "a":
                pieces = "2 pieces";
                break; case "b":
                pieces = "4 pieces";
                break;case "c":
                pieces = "6 pieces";
                break;default:
                pieces = "8 pieces";
                break; }
return pieces;
        
    }

public static String onionAmount(double a, double b){
        Scanner input = new Scanner(System.in);
         String choice;
         String onionAmount = "";
          System.out.println("Please choose one amount:");
       System.out.println("a. 1/8 cup \t" + "b. 1/4 cup");
       System.out. print("Enter choice: ");
      choice= input.next();
           while(!(choice.equals("a") || choice.equals("b"))){
      System.out. println("Please enter either a or b: ");
      choice= input.next();
     }
     if (choice.equals("a")) {
          onionAmount = "1/8 cup";
        } else if(choice.equals("b")){
            onionAmount = "1/4 cup";
        }
           return onionAmount;
    }

  public static String pepperamt(double a, double b){
        Scanner input = new Scanner(System.in);
         String choice;
         String pepperamt = "";
          System.out.println("Please choose one amount:");
       System.out.println("a. 1/8 cup \t" + "b. 1/4 cup");
       System.out. print("Enter choice: ");
      choice= input.next();
           while(!(choice.equals("a") || choice.equals("b"))){
      System.out. println("Please enter either a or b: ");
      choice= input.next(); }
     if (choice.equals("a")) {
          pepperamt = "1/8 cup";
        } else if(choice.equals("b")){
            pepperamt = "1/4 cup";
        }  return pepperamt;
         }
public static String eachamt(){
 Scanner input = new Scanner(System.in);
         String choice;String pieces="";
System.out.println("Please choose the amount option:");
System.out.println("a. 1 pieces \t" + "b. 2 pieces\t" + "c. 3 pieces\t" + "d. 4 pieces");
System.out. print("Enter choice: ");
      choice= input.next();
      while(!(choice.equals("a") || choice.equals("b") || choice.equals("c") || choice.equals("d"))){
      System.out. println("Please enter either a or b or c or d: ");
      choice= input.next();
     } switch (choice) {
            case "a":
                pieces = "1 piece";
                break;case "b":
                pieces = "2 pieces";
                break; case "c":
                pieces = "3 pieces";
                break; default:
                pieces = " 4 pieces";
                break;}return pieces;}
public static String gensprink(){
 Scanner input = new Scanner(System.in);
         String choice;
        String Generous_sprinkle;
       System.out.println("Please choose the amount option:");
System.out.println("a. 1 Generous Sprinkle \t" + "b. 2 Generous Sprinkle \t" + "c. 3 Generous Sprinkle \t" + "d. 4 Generous Sprinkle");
System.out. print("Enter choice: ");
      choice= input.next();
      while(!(choice.equals("a") || choice.equals("b") || choice.equals("c") || choice.equals("d"))){
      System.out. println("Please enter either a or b or c or d: ");
      choice= input.next();
     }
        switch (choice) {
            case "a":
                Generous_sprinkle= "1 Genrous Sprinkle";
                break;
            case "b":
                Generous_sprinkle= "2 Generous Sprinkles";
                break;
            case "c":
                Generous_sprinkle= "3 Generous Sprinkles";
                break;
            default:
                Generous_sprinkle= " 4 Generous Sprinkles";
                break;
        }
return Generous_sprinkle;
        
    }
public static String Gensprink(double a, double b){
 Scanner input = new Scanner(System.in);
         String choice;
        String Generous_sprinkle;
System.out.println("Please choose the amount option:");
System.out.println("a. 1 Generous Sprinkle \t" + "b. 2 Generous Sprinkle \t");
System.out. print("Enter choice: ");
      choice= input.next();
      while(!(choice.equals("a") || choice.equals("b") || choice.equals("c") || choice.equals("d"))){
      System.out. println("Please enter either a or b: ");
      choice= input.next();
     }if (choice.equals("a")) {
          Generous_sprinkle= "1 Genrous Sprinkle";
        } else 
           Generous_sprinkle= "2 Generous Sprinkles";
        return Generous_sprinkle;}}
        
