package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public final class MealPlannerApp extends Observable {
	
	private static List<Profile> profiles = new ArrayList<Profile>();
	
	// Singleton Pattern with lazy initialization
    private static volatile MealPlannerApp instance = null;

    private MealPlannerApp() {}

    public static MealPlannerApp getInstance() {
        if (instance == null) {
            synchronized(MealPlannerApp.class) {
                if (instance == null) {
                    instance = new MealPlannerApp();
                }
            }
        }
        return instance;
    }
    // End of Singleton Pattern
    
    public List<Profile> getProfiles() {
    	return profiles;
    }
   
	public void createProfile(String name) {
		profiles.add(new Profile(name));
		setChanged();
		notifyObservers();
	}

	public void deleteProfile(Profile profile) {
		profiles.remove(profile);
		setChanged();
		notifyObservers();
	}

	public void renameProfile(Profile profile, String newName) {
		profile.setName(newName);
		setChanged();
		notifyObservers();
	}

}
