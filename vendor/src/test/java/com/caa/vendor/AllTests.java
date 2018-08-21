package com.caa.vendor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.caa.vendor.database.DBTest;

@RunWith(Suite.class)
@SuiteClasses({ DBTest.class })

public class AllTests {

}
