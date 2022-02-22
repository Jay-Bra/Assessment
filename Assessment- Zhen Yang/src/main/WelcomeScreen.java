package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeScreen implements Screen {

    private ArrayList<String> options = new ArrayList<>();

    public void Info() {
    	
    	System.out.println("Welcome to LockedMe.com!");
        System.out.println("Application Developer Info: Zhen (Jay) Yang\n");
        System.out.println("Special note: this is an interesting project. It is also the first Java project for me. I don't have prior experience, but felt I've learned a lot. Thank you for the leaning experiences!\n");
        Show();
        
    }
    
    
    public WelcomeScreen() {
    	
        options.add("1. Show Existing Files");
        options.add("2. Show File Options");
        options.add("3. Exit");
        
    }
   
    
    @Override
    public void Show() {
    	
    	System.out.println("\nMenu Options:\n");
        for (String s : options)  {
            System.out.println(s);
            
        }
    }

    
    public void UserInput() {
    	
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            
        	this.Navigate(selectedOption);
        	
        } 
    }

    
    @Override
    public void Navigate(int option) {
        
    	switch(option) {
            case 1:
                
            	this.ShowFiles();               
                this.Show();
                
                break;
                
            case 2:
            	
            	ScreenOptions.setCurrentScreen(ScreenOptions.FileOptions);
                ScreenOptions.getCurrentScreen().Show();
                ScreenOptions.getCurrentScreen().UserInput();
                this.Show();
                
                break;
                
            default:
            	
                System.out.println("Invalid Option Entered. Please choose between 1, 2 and 3.");
                break;
                
        } 
    }

    
    public void ShowFiles() {
    		
    		Scanner in = new Scanner(System.in);
            System.out.println("Please enter the file path (e.g., name of the folder, you may try 'Test'): ");
            String dirPath = in.nextLine();  

            File folder = new File(dirPath);
            
            if(folder.isDirectory()){
            	
                File[] fileList = folder.listFiles();

                Arrays.sort(fileList);

                System.out.println("\nTotal number of files present in the directory: " + fileList.length );

                for(File file:fileList){
                	
                    System.out.println(file.getName());
                    
                }
                
              } else {
                	
            	  System.out.println("The folder '" + folder + "' does not exist.");
            	  return;
                	
                }       
    	}

    
    private int getOption() {
    	
        Scanner in = new Scanner(System.in);
        int returnOption = 0;
        
        try {
        	
            returnOption = in.nextInt();
        }
        
        catch (InputMismatchException ex) {

        }
        
        return returnOption;

    }  
}
