
import java.util.ArrayList;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class DOFProject{

    public static int DOF(ArrayList<String> actor,ArrayList<String> movies,ArrayList<String> year,String Actorname, String Actorname2 ){   
       //testers to make sure the Degree logic works
        actor.add("test");
        actor.add("Joe");
        actor.add("Mog");
        actor.add("Mog");
        movies.add("test the movie");
        movies.add("Endgame");
        movies.add("test the movie");
        movies.add("Endgame");
        ArrayList<String> coActors = new ArrayList<>();
        ArrayList<String> coString = new ArrayList<>();
        String finalmovie = null;
        String finalyear = null;
// this is a check to see if the person simply missspelled
        if (!actor.contains(Actorname) || !actor.contains(Actorname2)){
        return -1;}
        for(int i = 0; i < actor.size(); i++){
          // this is looping over movies and finding the people who coacted in that movie 
           if(actor.get(i).equals(Actorname)){
              String currmovie = movies.get(i);
              for(int j = 0; j < movies.size(); j++){
                  if(movies.get(j).equals(currmovie) && !actor.get(j).equals(Actorname)){
                     coActors.add(actor.get(j));
                      finalmovie = currmovie;
                      finalyear = year.get(i);}
               }
              }
             }
             // this is a check to see if the Coactor is our actor 2 and if it is then it gives you bacon degree one.
        
         for(int i = 0; i <coActors.size(); i++){
            if(coActors.get(i).equals(Actorname2)){
               System.out.println(Actorname + " was in " + finalmovie + "(" + finalyear +  ") with " + Actorname2); 
               return 1;
          
               }
            }
            //This uses a four level nested loop to check for degree of 2
         for(int i = 0; i < coActors.size();i++){
              // iterates the big list over itself after checking the small list
              for(int w =0; w < actor.size(); w++){
               if(coActors.get(i).equals(actor.get(w))){
                  String currmove = movies.get(w);
                    //now checking the movies 
                     for (int j = 0; j < movies.size() ; j++){
                        if (movies.get(j).equals(currmove)){
                           coString.add(actor.get(j));
                              //final check for degree 2
                              for ( int k = 0; k < coString.size(); k++){
                                 if( coString.get(k).equals(Actorname2)){
                                    System.out.println(Actorname + " was in " + finalmovie + "(" + finalyear + ") with " + coActors.get(i));
                                    System.out.println(coActors.get(i) +  " was in "+ currmove + "("+ year.get(w) + ") with " + Actorname2);
                                    return 2;}
                               }
                         }
                       }
                  }
                }
          }
                  return 0;   
                  
    }
    // a void delete movie, takes in the arrays and then removes them if everything lines up
    public static void deleteMovie(ArrayList<String> actor,ArrayList<String> movies,ArrayList<String> year,String Actor, String movie,String years){
      if( (actor.contains(Actor)) && (movies.contains(movie))){
         for ( int i =0; i < movies.size(); i++){
            if ((actor.get(i).equals(Actor)) && (movies.get(i).equals(movie)) && (year.get(i).equals(years))){
               actor.remove(i);
               movies.remove(i);
               year.remove(i);
               break;
             }
          }
      }
    }
    // a void add movie, makes sure that it doesn't contain the actor and movie already and then adds it
    public static void addMovie(ArrayList<String> actor,ArrayList<String> movies,ArrayList<String> year,String Actor,String movie,String years){
      if( (!actor.contains(Actor)) && (!movies.contains(movie))){
         actor.add(Actor);
         movies.add(movie);
         year.add(years);
         }
        
    }
           
              
              
              
              
              
              
      
      
        
        
    

    public static void main(String[] args) throws Exception{
        ArrayList<String> actorList = new ArrayList<>();
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> movieList = new ArrayList<>();
        ArrayList<String> yearList = new ArrayList<>();
        FileInputStream input = null;
        input = new FileInputStream("output.txt");
        Scanner inFS = null;
        inFS = new Scanner(input);
        while (inFS.hasNext()){
        String full = inFS.nextLine();
        String[] array = full.split(" ");
        String name = array[0] + " " + array[1];
        String year = array[array.length - 1];
        String movie = "";
        for(int i = 2; i < array.length - 1; i++){
         
         movie += array[i] + " ";
         
        }
        movieList.add(movie);
        actorList.add(name);
        yearList.add(year);
        }

       
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
         //if else statments based on choice
        int choice = 0;
        while (choice != 113){
        System.out.println("Select Options (Enter q to Quit):");
        System.out.println("1. Bacon Degrees of Freedom");
        System.out.println("2. Seperation bewteen any two actors");
        System.out.println("3. Add Entry");
        System.out.println("4. Delete Entry");
        choice = scnr.next().charAt(0);
        scnr.nextLine();
        if (choice == '1'){
         System.out.println("Enter the actor you would like to compare to Kevin Bacon");
         String actor = scnr.nextLine();
         int result = DOF(actorList,movieList,yearList,"Kevin Bacon", actor);
         System.out.println("Degrees of Kevin Bacon: " + result);
         }
        else if (choice == '2'){
         System.out.println("Enter the 2 actors you would like to find a link bewteen");
         String actor3 = scnr.nextLine();
         String actor4 = scnr.nextLine();
         int result = DOF(actorList,movieList,yearList,actor3,actor4);
         System.out.println("Degrees of seperation: " + result);
         
         }
        else if (choice == '3'){
        System.out.println("Enter the name of the actor you want to add");
        String adda = scnr.nextLine();
        System.out.println("Enter the name of the movie you want to add");
        String addm = scnr.nextLine() + " "; 
        System.out.println("Enter the year the movie came out");
        String year = scnr.nextLine();
        addMovie(actorList, movieList, yearList, adda, addm,year);
        
        }
        
        
        else if (choice == '4'){
        System.out.println("Enter the name of the actor you want to delete");
        String dela = scnr.nextLine();
        System.out.println("Enter the Movie you want to delete");
        String delm = (scnr.nextLine() + " ");
        System.out.println("Enter the year the movie came out");
        String dely = scnr.nextLine();
        deleteMovie(actorList,movieList,yearList,dela,delm,dely);
        
        
        }
         }
       //runs all the arrays through a for loop and then prints it to file
       try{  
         for( int i = 0 ; i < movieList.size() + 1; i++){
        writer.write(actorList.get(i) + " " + movieList.get(i) + yearList.get(i) + "\n");
        
        }
        }
        // makes sure to close the file no matter what if there is an exception.
        catch (IndexOutOfBoundsException e){
        writer.close();}
        writer.close();


       
    }

}

