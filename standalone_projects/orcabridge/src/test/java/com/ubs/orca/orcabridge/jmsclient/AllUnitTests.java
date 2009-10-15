/*
 * AllUnitTests.java created on 13 Oct 2009 19:09:33 by suggitpe for project Orca Bridge
 * 
 */
package com.ubs.orca.orcabridge.jmsclient;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.ubs.orca.orcabridge.jmsclient.impl.ContextBuilderTest;
import com.ubs.orca.orcabridge.jmsclient.impl.JmsConnectionTest;
import com.ubs.orca.orcabridge.jmsclient.impl.JmsReaderTest;
import com.ubs.orca.orcabridge.jmsclient.impl.JmsSenderTest;

/**
 * Test suite for the JMS client unit tests.
 * 
 * @author suggitpe
 * @version 1.0 13 Oct 2009
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { ContextBuilderTest.class, JmsConnectionTest.class, JmsSenderTest.class,
                      JmsReaderTest.class })
public class AllUnitTests
{}
