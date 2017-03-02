package io.github.tiscs.demos.oauth2.providers;

import io.github.tiscs.demos.oauth2.entities.OAuth2ClientEntity;
import io.github.tiscs.demos.oauth2.repositories.OAuth2ClientRepository;
import io.github.tiscs.demos.oauth2.repositories.OAuth2ScopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

@Component
public class JPAClientDetailsService implements ClientDetailsService {
    private final OAuth2ClientRepository oAuth2ClientRepository;
    private final OAuth2ScopeRepository oAuth2ScopeRepository;

    @Autowired
    public JPAClientDetailsService(OAuth2ClientRepository oAuth2ClientRepository, OAuth2ScopeRepository oAuth2ScopeRepository) {
        this.oAuth2ClientRepository = oAuth2ClientRepository;
        this.oAuth2ScopeRepository = oAuth2ScopeRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OAuth2ClientEntity oAuth2ClientEntity = oAuth2ClientRepository.findOne(clientId);
        BaseClientDetails clientDetails = new BaseClientDetails(
                oAuth2ClientEntity.getId(),
                oAuth2ClientEntity.getResourceIds(),
                null,
                oAuth2ClientEntity.getGrantTypes(),
                oAuth2ClientEntity.getAuthorities(),
                oAuth2ClientEntity.getRedirectUris()
        );
        clientDetails.setClientSecret(oAuth2ClientEntity.getSecret());
        clientDetails.setScope(oAuth2ScopeRepository.findScopeKeysByClientId(clientId));
        return clientDetails;
    }
}
