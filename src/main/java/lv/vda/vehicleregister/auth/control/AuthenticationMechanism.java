/*
 * Copyright (c) 2020 Dimitrijs Fedotovs
 * This code is licensed under MIT license
 * (see LICENSE.txt for details)
 */

package lv.vda.vehicleregister.auth.control;

import lv.vda.vehicleregister.auth.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.AutoApplySession;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@Default
@AutoApplySession
@ApplicationScoped
public class AuthenticationMechanism implements HttpAuthenticationMechanism {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationMechanism.class);
    @Inject
    private IdentityStoreHandler identityStoreHandler;

    @Override
    @Transactional
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) {
        String servletPath = request.getServletPath();
        LOGGER.debug("validating request {}", servletPath);
        if (httpMessageContext.isAuthenticationRequest()) {
            Credential tmpCred = httpMessageContext.getAuthParameters().getCredential();
            if (!(tmpCred instanceof UsernamePasswordCredential)) {
                LOGGER.error("Invalid mechanism");
                throw new IllegalStateException("Invalid mechanism");
            }
            CredentialValidationResult result = identityStoreHandler.validate(tmpCred);
            if (result.getStatus() == CredentialValidationResult.Status.VALID) {
                return httpMessageContext.notifyContainerAboutLogin(result);
            } else {
                LOGGER.warn("Login failed");
                return AuthenticationStatus.SEND_FAILURE;
            }
        } else if (servletPath.startsWith("/app") && !isUser(request)
                || servletPath.startsWith("/manage") && !isManager(request)
                || servletPath.startsWith("/admin") && !isAdmin(request)) {
            LOGGER.debug("forwarding to login page");
            return httpMessageContext.forward("/login.xhtml");
        }
        return httpMessageContext.doNothing();
    }

    private boolean isUser(HttpServletRequest request) {
        // roles inheritance is defined in JpaIdentityStore
        return request.isUserInRole(Role.USER.toString());
    }

    private boolean isManager(HttpServletRequest request) {
        // roles inheritance is defined in JpaIdentityStore
        return request.isUserInRole(Role.MANAGER.toString());
    }

    private boolean isAdmin(HttpServletRequest request) {
        // roles inheritance is defined in JpaIdentityStore
        return request.isUserInRole(Role.ADMIN.toString());
    }
}