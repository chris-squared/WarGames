package utility;

import bge.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class PlayerProfile {

    //JSON Object is derived from a Hashmap
    public JSONObject playerJSONMap = new JSONObject();


    public PlayerProfile(){
        processPlayerProfile();
    }

    public void addPlayer(Player player){
        if (playerJSONMap.containsKey(player.getUsername())){
            JSONObject playerStats = (JSONObject)playerJSONMap.get(player.getUsername());
            int newWins =  ((Number)playerStats.get("Wins")).intValue() + player.getPlayerWins();
            int newLosses = ((Number)playerStats.get("Losses")).intValue() + player.getPlayerLosses();
            playerStats.replace("Wins", newWins);
            playerStats.replace("Losses", newLosses);
            playerJSONMap.put(player.getUsername(),playerStats);
        }else {
            JSONObject playerStats = new JSONObject();
            playerStats.put("Wins", player.getPlayerWins());
            playerStats.put("Losses", player.getPlayerLosses());
            playerJSONMap.put(player.getUsername(), playerStats);
        }
    }

    public void removePlayer(String username){
        playerJSONMap.remove(username);
    }

    public JSONObject getPlayer(String username){
        return (JSONObject) playerJSONMap.get(username);
    }

    public void printJSON(){
        System.out.println(playerJSONMap.toJSONString());
    }


    //TODO: Create json file using File object

    public void processPlayerProfile(){
        try{
            File f = new File("__OFFICIAL_BGE/PlayerProfiles/playerProfiles.json");
            if(f.exists()){
                readFromFile();
            }else{
                f.createNewFile();
            }
        }catch (Exception e){
            System.out.println("Failed to process file: " + e.getMessage());
        }
    }

    public void writeToFile(){
        try{
            try(FileWriter fileWriter = new FileWriter("__OFFICIAL_BGE/PlayerProfiles/playerProfiles.json")){
                fileWriter.write(playerJSONMap.toJSONString());
            }
        }catch (Exception m){
            System.out.println("Failed to retrieve file: " + m.getMessage());
        }
    }

    public void readFromFile(){
        try{
            try(FileReader fileReader = new FileReader("__OFFICIAL_BGE/PlayerProfiles/playerProfiles.json")){
                JSONParser jsonParser = new JSONParser();
                Object object = jsonParser.parse(fileReader);
                playerJSONMap = (JSONObject)object;
            }
        }catch (Exception m){
            System.out.println("Failed to retrieve file: " + m.getMessage());
        }
    }

//    public void update(JSONObject playerStats, Player player){
//        try{
//            try(FileWriter fileWriter = new FileWriter("__OFFICIAL_BGE/PlayerProfiles/playerProfiles.json")){
//                playerStats.replace("Wins", (Long)playerStats.get("Wins") + player.getPlayerWins());
//                playerStats.replace("Losses", (Long)playerStats.get("Losses") + player.getPlayerLosses());
//                fileWriter.write(playerJSONMap.toJSONString());
//            }
//        }catch (Exception m){
//            System.out.println("Failed to retrieve file: " + m.getMessage());
//        }
//    }
//
//    public void updatePlayerStats(Player player){
//        try {
//            File f = new File("__OFFICIAL_BGE/PlayerProfiles/playerProfiles.json");
//            if (f.exists()) {
//                JSONParser jsonParser = new JSONParser();
//                Object object = jsonParser.parse(new FileReader("__OFFICIAL_BGE/PlayerProfiles/playerProfiles.json"));
//                JSONObject playerObject = (JSONObject) object;
//                JSONObject playerStats = (JSONObject) playerObject.get(player.getUsername());
//                update(playerStats, player);
//            }else{
//
//            }
//
//
//        }catch (Exception m){
//            System.out.println("Failed to update player stats: " + m.getMessage());
//        }
//
//    }

}
