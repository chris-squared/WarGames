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
        	updatePlayer(player);
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

    public void updatePlayer(Player player) {
        JSONObject playerStats = (JSONObject)playerJSONMap.get(player.getUsername());
        playerStats.replace("Wins", player.getPlayerWins());
        playerStats.replace("Losses", player.getPlayerLosses());
        playerJSONMap.put(player.getUsername(),playerStats);
    	
    }

    //TODO: Create json file using File object

    public void processPlayerProfile(){
        try{
            File f = new File("WarGames_Final/PlayerProfiles/playerProfiles.json");
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
            try(FileWriter fileWriter = new FileWriter("WarGames_Final/PlayerProfiles/playerProfiles.json")){
                fileWriter.write(playerJSONMap.toJSONString());
            }
        }catch (Exception m){
            System.out.println("Failed to retrieve file: " + m.getMessage());
        }
    }

    public void readFromFile(){
        try{
            try(FileReader fileReader = new FileReader("WarGames_Final/PlayerProfiles/playerProfiles.json")){
                JSONParser jsonParser = new JSONParser();
                Object object = jsonParser.parse(fileReader);
                playerJSONMap = (JSONObject)object;
            }
        }catch (Exception m){
            System.out.println("Failed to retrieve file: " + m.getMessage());
        }
    }


}
