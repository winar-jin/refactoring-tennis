package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name, 0);
        this.player2 = new Player(player2Name, 0);
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        if (player1.getScore() == player2.getScore()) {
            return withSameScore();
        }

        if (player1.getScore() >= 4 || player2.getScore() >= 4) {
            return beyondScoreOf4();
        }

        return scoreBetween1To3();
    }

    private String scoreBetween1To3() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1.getScore();
            else {
                score.append("-");
                tempScore = player2.getScore();
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score.toString();
    }

    private String beyondScoreOf4() {
        StringBuilder score;
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score.toString();
    }

    private String withSameScore() {
        StringBuilder score;
        switch (player1.getScore()) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score.toString();
    }
}