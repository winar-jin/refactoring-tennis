package cn.xpbootcamp.tennis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private int score;

    void wonPoint() {
        score += 1;
    }
}
