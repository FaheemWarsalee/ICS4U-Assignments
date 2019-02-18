import java.util.*;

class MovieTester { 
  
  public static void main(String[] args){
    
    String userEntry;
    
    //Create the movies array
    MovieRecord[] movies = new MovieRecord[5]; //All the variables
    
    //To Create and Instantiate Each MovieRecord inside the movies Array
    for(int i = 0; i < movies.length ; i++)
      movies[i] = new MovieRecord();
    
    try{
    //To fill the Object Array with user data
    Scanner sc = new Scanner(System.in); //JVM for taking keystrokes in
    for(int i = 0; i < movies.length ; i++){ //Counted to go through each record
      System.out.println("What is the name of the movie ");
      movies[i].title = sc.nextLine();           
      System.out.println("What is the director's name? ");
      movies[i].director = sc.nextLine();
      System.out.println("Year of Release: ");
      userEntry = sc.nextLine();
      //Parse to int
      
      movies[i].yearRelease = Integer.parseInt(userEntry);
      System.out.println("Run Time: ");
      userEntry = sc.nextLine();
      movies[i].runTime = Integer.parseInt(userEntry);
      System.out.println("Rating out of 10: ");
      userEntry = sc.nextLine();
      movies[i].rating = Float.parseFloat(userEntry);
      
      sc.close();
      }
    }catch(Exception e){
      System.out.println("Error");
    }
    
    for(int i = 0 ; i < movies.length ; i++)
      System.out.println(movies[i].printData());   
      
    }
    
  }