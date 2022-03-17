package com.nc.edu.ta.kvasov.pr5;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/* --------------------------------------------------- *
 * All tests in one suite.                             *
 * Run only this test class.                           *
 * You can run only some of them,                      *
 * just comment the tests you don't want to run.       *
 * append pom.xml with:
        <dependency>
            <groupId>org.junit.platform</groupId>
            <artifactId>junit-platform-suite-engine</artifactId>
            <version>[1.8.2,2)</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>${junit-jupiter.version}</version>
            <scope>test</scope>
        </dependency>
 * --------------------------------------------------- */



@Suite
@SelectClasses({
    TaskTest.class
    //CloneTaskTest.class,
    //EqualsTaskTest.class,
    //TaskListTest.class,
    //CloneListTest.class,
    //EqualsListTest.class,
    //AdditionalTaskTest.class
})
public class AllTests {
}

