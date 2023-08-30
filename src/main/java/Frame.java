import java.util.ArrayList;
import java.util.List;

public class Frame {
    int frameScore;
    List<Integer> frameRolls = new ArrayList<>();

    public void frameRolls(Integer pins) {
        if(pins > 10 || pins < 0) throw new IllegalArgumentException();
        frameScore+=pins;
        frameRolls.add(pins);
    }

    public int getFrameScore(){
        return frameScore;
    }
}
