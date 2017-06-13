package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public final class Application extends Observable {

	private List<Profile> profiles = new ArrayList<Profile>();
	private Profile activeProfile;

	// Singleton Pattern with lazy initialization
	private static volatile Application instance = null;

	private Application() {
		if (profiles.size() == 0) {
			createProfile("default");
			setActiveProfile(profiles.get(0));
		}
	}

	public static Application getInstance() {
		if (instance == null) {
			synchronized(Application.class) {
				if (instance == null) {
					instance = new Application();
				}
			}
		}
		return instance;
	}
	// End of Singleton Pattern

	public Profile getActiveProfile() {
		return activeProfile;
	}

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

	public void setActiveProfile(Profile activeProfile) {
		this.activeProfile = activeProfile;
		setChanged();
		notifyObservers();
	}

}
