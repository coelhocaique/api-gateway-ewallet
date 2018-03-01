package com.coelhocaique.wallet.templates;

import com.coelhocaique.wallet.consts.TestConstants;
import com.coelhocaique.wallet.dto.WalletResponseDTO;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class WalletDTOTemplate implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(WalletResponseDTO.class).addTemplate(TestConstants.WALLET_DTO, new Rule(){{
		
		}});	
	}

}
