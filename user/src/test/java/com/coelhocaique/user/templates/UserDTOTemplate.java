package com.coelhocaique.user.templates;

import com.coelhocaique.user.consts.TestConstants;
import com.coelhocaique.user.dto.UserDTO;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UserDTOTemplate implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(UserDTO.class).addTemplate(TestConstants.USER_DTO, new Rule(){{
			add("username", "testUser");
		}});	
	}

}
