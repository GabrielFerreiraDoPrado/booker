

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.booker.domain.user.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.booker.domain.user.UserRole'
grails.plugin.springsecurity.authority.className = 'com.booker.domain.user.Role'

grails.plugin.springsecurity.auth.loginFormUrl = '/user/login'
grails.plugin.springsecurity.logout.afterLogoutUrl = '/'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/book/index'
grails.plugin.springsecurity.failureHandler.defaultFailureUrl = '/user/error'
grails.plugin.springsecurity.successHandler.alwaysUseDefault = false
grails.plugin.springsecurity.dao.hideUserNotFoundExceptions = false
grails.plugin.springsecurity.adh.errorPage="/logoff"
grails.plugin.springsecurity.password.algorithm = 'bcrypt'

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"

grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/user/myAccount', access: ['ROLE_USER']],
		[pattern: '/book/**', access: ['ROLE_USER']],
		[pattern: '/**',          access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
]

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

