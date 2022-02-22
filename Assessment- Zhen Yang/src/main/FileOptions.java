package main;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class FileOptions implements Screen {
		
	private ArrayList<String> options = new ArrayList<>();

    public FileOptions() {
    	
    	options.add("1. Add a file");
        options.add("2. Delete a file");
        options.add("3. Search a file");
        options.add("4. Return to Menu");
        
    }
    
    
    @Override
    public void Show() {
    	
    	System.out.println("\nFile Options:\n");
        
    	for (String s : options) {
            
        	System.out.println(s);
        	
        }
    }

    public void UserInput() {
        
    	int selectedOption;
        
    	while ((selectedOption = this.getOption()) != 4) {
            
    		this.Navigate(selectedOption);
    		
        }
    }

    @Override
    public void Navigate(int option)  {
        
    	switch(option) {

           case 1:  
                
        	   this.AddFile();
               this.Show();
               break;
                
            case 2:  
                
            	this.DeleteFile();
                this.Show();
                break;
                
            case 3:  
                
            	this.SearchFile();
                this.Show();
                break;
            
            default:
                
            	System.out.println("Invalid Option Entered. Please choose between 1, 2, 3 and 4.");
                break;
                
        }

    }
    
    
	String folderPath = "Test";
	File folder = new File (folderPath);
	
	Scanner in = new Scanner(System.in);
    
    public void AddFile() {

    	System.out.print("Please enter the name of the file you want to add: ");
    	String fileName = in.nextLine();
        fileName = fileName + ".txt";        
        File file = new File (folder, fileName);
        
		if (file.isFile()) {
			
			System.out.println ("File '" + fileName + "' alreay exists, do you want to delete it and create a new file?\n1.Yes\n2.no");
			
			} else {
				
				try {
					
					file.createNewFile();
					
				} catch (IOException e) {

					e.printStackTrace();
					
				}
				
				System.out.println ("File '" + fileName + "' has been created successfully.");
				return;
			
			}
			
		String delete = in.nextLine();
			
		if (delete.equals("1")) {
				
			boolean deleteFile = file.delete();
			try {
					
				file.createNewFile();
				
				} catch (IOException e) {

					e.printStackTrace();
					
				}
			
				System.out.println ("The old file has been deleted; The new file was created.");
				
			}else {
				
				System.out.println ("The new file was not created.");
				return;
				
			}
    	}
        
    
    public void DeleteFile() {
    	
		System.out.print("Please enter the name of the file that you want to delete: ");
		String fileName = in.nextLine();
        fileName = fileName + ".txt";
		File file = new File (folder, fileName);
		
		if (file.isFile()) {
			
			boolean deleteFile = file.delete();
			System.out.println ("The file '" + fileName + "'has been deleted.");
			
			} else {
				
				System.out.println ("The file '" + fileName + "' does not exist.");
				return;
				
			}
    }
    
    public void SearchFile() {
    	
		System.out.print("Please enter the name of the file you want to search: ");
		String fileName = in.nextLine();
        fileName = fileName + ".txt";
		File file = new File (folder, fileName);
		
		if (file.isFile()) {
			
			System.out.println ("File '" + fileName + "' has been found.");
			
			} else {
				
				System.out.println ("File '" + fileName + "' could not be found.");
				return;
				
			}
    }
    
    
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    
    private int getOption() {
        
    	Scanner in = new Scanner(System.in);

        int returnOption = 0;
        
        try {
            
        	returnOption = in.nextInt();
        	
        }
        
        catch (InputMismatchException ex) {
        	
        	System.out.println("Invalid input");
        	
        }
        
        return returnOption;
        
    }
}