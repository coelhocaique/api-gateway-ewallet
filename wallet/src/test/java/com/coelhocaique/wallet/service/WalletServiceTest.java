package com.coelhocaique.wallet.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.coelhocaique.wallet.consts.TestConstants;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(MockitoJUnitRunner.class)
public class WalletServiceTest {
	
	
	@BeforeClass
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates(TestConstants.PACKAGE);
	}
	
	@Before
	public void setupMock() {
	}

}
