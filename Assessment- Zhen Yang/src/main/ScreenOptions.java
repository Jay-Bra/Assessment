package main;


public class ScreenOptions {
		
	
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
    public static FileOptions FileOptions = new FileOptions();

    public static Screen CurrentScreen = WelcomeScreen;

    public static Screen getCurrentScreen() {
        
    	return CurrentScreen;
    	
    }

    
    public static void setCurrentScreen(Screen currentScreen) {
        
    	CurrentScreen = currentScreen;
    	
    }
}
