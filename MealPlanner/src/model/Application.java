package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public final class Application extends Observable {

	private List<Profile> profiles = new ArrayList<Profile>();
	private Profile activeProfile;
	private static volatile Application instance = null;

	//***************************** Constructor(s) *****************************

	private Application() {
		initilizeProfile();
	}

	//*********************** Internal Helper Method(s) ************************

	private void initilizeProfile() {
		createProfile();
		setActiveProfile(profiles.get(0));
	}

	//************************** External Method(s) ****************************

	public void createProfile() {
		profiles.add(new Profile());
		setChanged();
		notifyObservers();
	}

	public void deleteProfile(int id) {
		profiles.remove(id);
		setChanged();
		notifyObservers();
	}

	public void renameProfile(Profile profile, String newName) {
		profile.setName(newName);

		setChanged();
		notifyObservers();
	}

	//************************ Getter(s) and Setter(s) *************************

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

	public Profile getActiveProfile() {
		return activeProfile;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setActiveProfile(Profile activeProfile) {
		this.activeProfile = activeProfile;

		setChanged();
		notifyObservers();
	}

}
