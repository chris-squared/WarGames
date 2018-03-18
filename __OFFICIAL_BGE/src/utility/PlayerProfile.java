package utility;

import bge.Player;
import org.json.simple.JSONObject;


public class PlayerProfile {

    //JSON Object is derived from a Hashmap
    private JSONObject playerJSONMap = new JSONObject();

    public void addPlayer(Player player){
        playerJSONMap.put(player.getUsername(), player);
    }

    public void removePlayer(String username){
        playerJSONMap.remove(username);
    }

    public Player getPlayer(String username){
        return (Player)playerJSONMap.get(username);
    }

    public void printJSON(){
        System.out.println(getPlayer("Pablo").getUsername());
    }

    //TODO: Create json file using File object


}
