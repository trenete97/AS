package junit.com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestIntegration.class, TestBonificacioEnMinuts.class, TestSenseBonificacio.class, TestPayStation.class,
        TestBonificacioEnPercentatge.class })
public class AllTests {

}