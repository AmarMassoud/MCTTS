package me.amar.mctts.Listener;

import me.amar.mctts.Files.DataYml;
import me.amar.mctts.MCTTS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AcronymListener {
        public static boolean isAcronymInList(String word) {
            Collection<String> items = DataYml.getDataYml().getConfigurationSection("Acronyms").getKeys(false);
            for (String item : items) {
                if (word.equalsIgnoreCase(item)) {
                    return true;
                }

            }
            return false;
        }
        public static void  addAcronymToList(String acronym, String word) {
            DataYml.getDataYml().getConfigurationSection("Acronyms").set(acronym, word);
            DataYml.saveDataYml();
            }

            public static String convertMessage(String message) {
                StringBuilder newMessage = new StringBuilder();
                for (String word : message.split(" ")) {
                    Collection<String> items = DataYml.getDataYml().getConfigurationSection("Acronyms").getKeys(false);
                    for (String item : items) {
                        System.out.println("word: " + word);
                        if (item.equalsIgnoreCase("acronym")) {
                            newMessage.append(DataYml.getDataYml().get("Acronyms." + item) + " ");
                            System.out.println("Item: " + DataYml.getDataYml().get("Acronyms." + item) + " ");
                        } else {
                            newMessage.append(word);
                        }
                    }
                }
                System.out.println(newMessage.toString());
                return newMessage.toString();
            }

}




