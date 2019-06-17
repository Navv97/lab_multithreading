package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BetterRadarTest {
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 15)
    public void testLaunchMissleWhenEnemySpotted(){
        PatriotBattery patriotBattery = mock(PatriotBattery.class);
        BetterRadar betterRadar = new BetterRadar(new LaunchExecutor(LaunchOption.CURRENT_THREAD), patriotBattery, 15);
        betterRadar.notice(new Scud());
        verify(patriotBattery, times(15)).launchPatriot();
    }
}