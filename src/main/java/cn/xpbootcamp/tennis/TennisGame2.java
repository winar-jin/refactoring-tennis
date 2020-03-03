package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {

    public String P1res = "";
    public String P2res = "";
    private Player player1;
    private Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    public String getScore() {
        String score = "";
        if (player1.getPoint() == player2.getPoint() && player1.getPoint() < 4) {
            score = player1.getScore();
            score += "-All";
        }
        if (player1.getPoint() == player2.getPoint() && player1.getPoint() >= 3)
            score = "Deuce";

        if (player1.getPoint() > 0 && player2.getPoint() == 0) {
            P1res = player1.getScore();
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (player2.getPoint() > 0 && player1.getPoint() == 0) {
            P2res = player2.getScore();

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (player1.getPoint() > player2.getPoint() && player1.getPoint() < 4) {
            P1res = player1.getScore();
            P2res = player2.getScore();
            score = P1res + "-" + P2res;
        }
        if (player2.getPoint() > player1.getPoint() && player2.getPoint() < 4) {
            P1res = player1.getScore();
            P2res = player2.getScore();
            score = P1res + "-" + P2res;
        }

        if (player1.getPoint() > player2.getPoint() && player2.getPoint() >= 3) {
            score = "Advantage player1";
        }

        if (player2.getPoint() > player1.getPoint() && player1.getPoint() >= 3) {
            score = "Advantage player2";
        }

        if (player1.getPoint() >= 4 && player2.getPoint() >= 0 && (player1.getPoint() - player2.getPoint()) >= 2) {
            score = "Win for player1";
        }
        if (player2.getPoint() >= 4 && player1.getPoint() >= 0 && (player2.getPoint() - player1.getPoint()) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void wonPoint(String player) {
        if (player1.getName().equals(player))
            player1.wonPoint();
        else
            player2.wonPoint();
    }
}