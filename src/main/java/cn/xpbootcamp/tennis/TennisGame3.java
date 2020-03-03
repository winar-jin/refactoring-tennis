package cn.xpbootcamp.tennis;

public class TennisGame3 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame3(String p1Name, String p2Name) {
        this.player1 = new Player(p1Name, 0);
        this.player2 = new Player(p2Name, 0);
    }

    public String getScore() {
        String s;
        if (player1.getPoint() < 4 && player2.getPoint() < 4 && !(player1.getPoint() + player2.getPoint() == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[player1.getPoint()];
            return (player1.getPoint() == player2.getPoint()) ? s + "-All" : s + "-" + p[player2.getPoint()];
        } else {
            if (player1.getPoint() == player2.getPoint())
                return "Deuce";
            s = player1.getPoint() > player2.getPoint() ? player1.getName() : player2.getName();
            return ((player1.getPoint() - player2.getPoint()) * (player1.getPoint() - player2.getPoint()) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

}