package main.models;

import java.util.HashMap;
import java.util.Map;

public class Themes {
    private String selectedTheme;
    private static final Map<String, String[]> themeColors = new HashMap<>();

    // Initialize theme color palettes
    static {
        themeColors.put("Chill", new String[] { "#C5E1A5", "#424242", "#B39DDB", "#80CBC4" }); // Green, Charcoal,
                                                                                               // Lavender, Teal
        themeColors.put("Dark Academia", new String[] { "#3E2723", "#D7CCC8", "#6D4C41", "#BCAAA4" }); // Espresso,
                                                                                                       // Beige, Maroon,
                                                                                                       // Gold
        themeColors.put("Beach", new String[] { "#81D4FA", "#FFECB3", "#FFD54F", "#FFAB91" }); // Sky Blue, Sandy Beige,
                                                                                               // Sun Yellow, Coral
                                                                                               // Peach
    }

    // Constructor (Default Theme)
    public Themes() {
        this.selectedTheme = "Chill"; // Default theme
    }

    // Set Theme
    public void setTheme(String theme) {
        if (themeColors.containsKey(theme)) {
            this.selectedTheme = theme;
            System.out.println("🎨 Theme set to: " + theme);
        } else {
            System.out.println("❌ Invalid theme! Please choose Chill, Dark Academia, or Beach.");
        }
    }

    // Get Selected Theme
    public String getSelectedTheme() {
        return selectedTheme;
    }

    // Get Color Palette for Selected Theme
    public String[] getThemeColors() {
        return themeColors.get(selectedTheme);
    }

    // Display Theme Colors (For Testing)
    public void displayThemeColors() {
        String[] colors = getThemeColors();
        System.out.println("🎨 " + selectedTheme + " Theme Colors:");
        System.out.println("Background: " + colors[0]);
        System.out.println("Text: " + colors[1]);
        System.out.println("Buttons: " + colors[2]);
        System.out.println("Accent: " + colors[3]);
    }
}
