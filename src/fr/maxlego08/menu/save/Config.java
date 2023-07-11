package fr.maxlego08.menu.save;

import fr.maxlego08.menu.zcore.utils.storage.Persist;
import fr.maxlego08.menu.zcore.utils.storage.Saveable;

public class Config implements Saveable {

    public static boolean enableDebug = true;
    public static boolean enableDebugTime = false;
    public static boolean enableInformationMessage = true;
    public static boolean enableLogStorageFile = false;
    public static boolean enableOpenMessage = true;
    public static boolean enableMiniMessageFormat = true;
    public static boolean enablePlayerCommandInChat = false;
    public static int secondsSavePlayerData = 600;
    public static int secondsSavePlayerInventories = 600;
    public static boolean autoSaveFileInventoryOnUpdate = true;


    /**
     * static Singleton instance.
     */
    private static volatile Config instance;


    /**
     * Private constructor for singleton.
     */
    private Config() {
    }

    /**
     * Return a singleton instance of Config.
     */
    public static Config getInstance() {
        // Double lock for thread safety.
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null) {
                    instance = new Config();
                }
            }
        }
        return instance;
    }

    public void save(Persist persist) {
        persist.save(getInstance());
    }

    public void load(Persist persist) {
        persist.loadOrSaveDefault(getInstance(), Config.class);
    }

}
