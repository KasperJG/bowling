import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    private final static int BOWLING_TOTAL_ROUND = 10;
    BowlingGame bowlingGame;

    @BeforeEach
    void setup(){
        bowlingGame = new BowlingGame();
    }

    @Test
    public void getZeroScoreDuringAllRound() {

        //given 게임을 진행하는 동안

        //when 모든 투구에서 하나의 핀도 쓰러트리지 못하면
        for(int i=0; i < BOWLING_TOTAL_ROUND; i++){
            Frame frame = new Frame();
            frame.frameRolls(0);
            frame.frameRolls(0);
            bowlingGame.addFrame(frame);
        }

        //then 점수는 0점이 된다
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void 플레이어는_첫_프레임의_첫_투구에서_1점을_기록하고_나머지는_모두_0점을_기록한다() {

        //given 게임을 진행하는 동안

        //when 첫 투구에서 1점을 기록하고 나머지는 모두 0점을 기록하면
        Frame firstframe = new Frame();
        firstframe.frameRolls(1);
        firstframe.frameRolls(0);
        bowlingGame.setBaseScore(firstframe.getFrameScore());
        for(int i=1; i < BOWLING_TOTAL_ROUND; i++){
            Frame frame = new Frame();
            frame.frameRolls(0);
            frame.frameRolls(0);
            bowlingGame.setBaseScore(frame.getFrameScore());
        }

        //then 점수는 1점이 된다
        assertEquals(1, bowlingGame.score());
    }

    @Test
    public void 플레이어는_각_투구에서_10개보다_많은_핀을_쓰러트릴_경우_런타임에러가_발생한다() {
        //given 게임을 진행하는 동안

        //when 투구에서 10개보다 많은 핀을 쓰러트리면

        //then 런타임 에러(IllegalArgumentException)가 발생한다
        assertThrows(IllegalArgumentException.class, () -> {
            // 테스트하려는 메소드 호출
            Frame frame = new Frame();
            frame.frameRolls(11);
        });
    }

    @Test
    public void 플레이어는_각_투구에서_0개보다_적은_핀을_쓰러트릴_경우_런타임에러가_발생한다() {
        //given 게임을 진행하는 동안
        //첫 번째 투구에서 7개의 핀을 쓰러트리고

        //when 투구에서 0개보다 적은 핀을 쓰러트리면

        //then 런타임 에러(IllegalArgumentException)가 발생한다
        assertThrows(IllegalArgumentException.class, () -> {
            // 테스트하려는 메소드 호출
            Frame frame = new Frame();
            frame.frameRolls(-1);
            //frame
        });
    }

//    @Test
//    public void 플레이어의_투구에서_스페어가_발생한다() {
//        //given 게임을 진행하는 동안
//        //when 두 번째 투구에서 나머지 3개의 핀을 쓰러트려 스페어를 한다면
//        Frame firstframe = new Frame();
//        firstframe.frameRolls(7);
//        firstframe.frameRolls(3);
//        bowlingGame.addFrame(firstframe);
//
//
//        bowlingGame.setBaseScore(firstframe.getFrameScore());
//
//        //then 다음 투구에서 쓰러뜨린 핀의 갯수만큼 보너스 점수로 받는다
//        //(Out Of Scope) 스트라이크.
//        bowlingGame.roll(2);
//        for(int i=3; i < 20; i++){
//            bowlingGame.roll(0);
//        }
//        // pr test
//        assertEquals(14, bowlingGame.score());
//    }

//    @Test
//    public void 플레이어는_첫_프레임에서_스트라이크를_기록하고_다음과_같은_점수를_얻는다() {
//        //given 게임을 진행하는 동안
//
//        //when
//        // 첫 프레임에서 스트라이크를 기록한다
//        //두번째 프레임의 투구들은 각 1점을 기록한다
//        //나머지 프레임은 0점을 기록한다
//
//        bowlingGame.roll(10);
//
//        bowlingGame.roll(1);
//        bowlingGame.roll(1);
//
//        for(int i=4; i < 20; i++){
//            bowlingGame.roll(0);
//        }
//        //then
//        // 점수는 14점이 된다
//        //(Out of Scope) 2회 연속 strike
//        assertEquals(14, bowlingGame.score());
//    }
//
//    @Test
//    public void 플레이어는_각_프레임에서_2번의_투구의_합이_최소_0개에서_최대_10개까지의_핀을_쓰러트릴_수_있다() {
//        //given 게임을 진행하는 동안
//        //when
//        // 마지막 프레임(10)을 제외하고, 프레임당 2번의 투구에서 쓰러뜨린 핀의 합이 0개보다 적거나 10개보다 많은 핀을 쓰러트리면
//        //then
//
//        // 스코어 계산시 런타임 에러(IllegalStateException)가 발생한다
//        //(Out of Scope) 10 프레임
//        assertThrows(IllegalArgumentException.class, () -> {
//            // 테스트하려는 메소드 호출
//            bowlingGame.roll(4);
//            bowlingGame.roll(7);
//        });
//    }
//
//    @Test
//    public void 플레이어는_모든_투구에서_스트라이크를_기록한다() {
//        //given
//        //when
//        //then
//    }
//
//    @Test
//    public void 플레이어는_1_프레임_초구가_스트라이크면_초구와_2구의_합이_10을_초과할_수_있다() {
//        //given
//        //when
//        //then
//    }
//
//    @Test
//    public void 플레이어는_한_게임_내에서_아래와_같은_스코어_보드의_투구를_진행한다() {
//        //given
//        //when
//        //then
//    }


}