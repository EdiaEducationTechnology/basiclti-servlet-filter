package org.imsglobal.basiclti.consumersecret.impl;
/**********************************************************************************
 * $URL$
 * $Id$
 **********************************************************************************
 *
 * Copyright (c) 2011 IMS GLobal Learning Consortium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License. 
 *
 **********************************************************************************/

import org.imsglobal.basiclti.consumersecret.model.OauthConsumerSecret;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * Test for PropertiesConsumerSecretServiceImpl
 *   
 * @author Roland Groen (roland@edia.nl)
 *
 */
public class PropertiesConsumerSecretServiceImplTest {

	PropertiesConsumerSecretServiceImpl propertiesConsumerSecretServiceImpl = new PropertiesConsumerSecretServiceImpl();

	@Before
	public void setUp() throws Exception {
		propertiesConsumerSecretServiceImpl.setLocation(new ClassPathResource("/test_secrets.properties", getClass()));
	}

	@Test
	public void testGetConsumerSecret() {
		assertEquals("secret", propertiesConsumerSecretServiceImpl.getConsumerSecret("one"));
	}

	@Test
	public void testSearchOauthConsumerSecrets() {
		assertEquals(4, propertiesConsumerSecretServiceImpl.searchOauthConsumerSecrets().size());
		for (OauthConsumerSecret sec : propertiesConsumerSecretServiceImpl.searchOauthConsumerSecrets()) {
			if ("one".equals(sec.getConsumerKey())) {
				assertEquals("secret", sec.getConsumerSecret());
			}
	        
        }
	}

	@Test
	public void testSetConsumerSecret() {
		try {
			propertiesConsumerSecretServiceImpl.setConsumerSecret("one", "two");
			fail("UnsupportedOperationException");
		} catch (Exception e) {
		}

	}

}
