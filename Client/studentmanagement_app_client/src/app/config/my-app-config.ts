export default {

  oidc: {
    clientId: '0oa418d09nRloaTld5d7',  // use system.getenv for production
    issuer: 'https://dev-42131033.okta.com/oauth2/default',
    redirectUri: 'http://localhost:4200/login/callback',
    // have to change to :8080 later
    scopes: ['openid', 'profile', 'email']

  }

}
