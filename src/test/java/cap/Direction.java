package cap;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum Direction {
        UP("up"),
        DOWN("down"),
        RIGHT("right"),
        LEFT("left");
        String direction;
        Direction(String direction){
            this.direction = direction;
        }
}
