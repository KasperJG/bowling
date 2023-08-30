import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private Integer baseScore=0;

    private final List<Integer> rolls =new ArrayList<>();

    private List<Frame> frames = new ArrayList<>();

    public void addFrame(Frame frame){
        frames.add(frame);
    }

    public void setBaseScore(Integer inputSocre){
        baseScore+=inputSocre;
    }
    public void roll(Integer pins) {
        if(pins > 10 || pins < 0) throw new IllegalArgumentException();
        baseScore+=pins;

        if(rolls.size()%2==1) checkPeriodLimit();

        if(pins == 10){
            rolls.add(pins);
            rolls.add(0);
        }else{
            rolls.add(pins);
        }
    }

    void calcScore(){

    }

    void checkPeriodLimit(){
        for(int i=0; i < rolls.size(); i++){
            if( i < (rolls.size()-1) && (rolls.get(i)+rolls.get(i+1) > 10))throw new IllegalArgumentException();
        }
    }

    public int score() {
        Integer bonusPoint = 0;

        for(int i=0; i < frames.size(); i++){

        }

        for(int i=0; i < rolls.size();++i){
            if(i < (rolls.size()-2) && rolls.get(i) + rolls.get(i+1) == 10){
                if(i%2==0){
                    //strike
                    bonusPoint += rolls.get(i+2);
                    bonusPoint += rolls.get(i+3);
                }else{
                    //spare
                    bonusPoint += rolls.get(i+2);
                }

            }
        }

        return baseScore + bonusPoint;
    }

}
