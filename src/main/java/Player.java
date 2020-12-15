public class Player {
    private String playerName;
    private PlayerGameState gameState;

    public Player(String name) {
        gameState = new PlayerGameState();
        this.playerName = name;
    }

    PlayerGameState getGameState() {
        return gameState;
    }

    public String getPlayerName() {
        return playerName;
    }
}
