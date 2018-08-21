package caa.vendor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import caa.vendor.database.DBTest;

@RunWith(Suite.class)
@SuiteClasses({ DBTest.class })

public class AllTests {

}
