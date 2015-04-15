// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.resources.adhoc.includes = ['/images/**', '/css/**', '/js/**', '/plugins/**']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}


// Mobile Spring Security Rest plugin
grails.plugin.springsecurity.rest.login.active=true
grails.plugin.springsecurity.rest.login.failureStatusCode=401
grails.plugin.springsecurity.rest.login.useJsonCredentials=true

grails.plugin.springsecurity.filterChain.chainMap = [
    '/api/**': 'JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter',  // Stateless chain
    '/**': 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'                                                                          // Traditional chain
]

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.useSecurityEventListener = true
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.test.user.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.test.user.UserRole'
grails.plugin.springsecurity.authority.className = 'com.test.user.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
    '/':                              ['permitAll'],
  '/sitemap.xml':                   ['permitAll'],
  '/robots.txt':                    ['permitAll'],
  '/blocked':                       ['permitAll'],
  '/privacypolicy':                 ['permitAll'],
  '/termsconditions':               ['permitAll'],
  '/sitemap/**':                    ['permitAll'],  
    '/index':                         ['permitAll'],
    '/index.gsp':                     ['permitAll'],
    '/assets/**':                     ['permitAll'],
    '/**/js/**':                      ['permitAll'],
    '/**/css/**':                     ['permitAll'],
    '/**/images/**':                  ['permitAll'],
    '/**/favicon.ico':                ['permitAll'],
  '/dbconsole':                     ['ROLE_SUPER_ADMIN'],//['ROLE_ADMIN', 'ROLE_SUPER_ADMIN']],
  '/dbconsole.*':                   ['ROLE_SUPER_ADMIN'],
  '/dbconsole/**':                  ['ROLE_SUPER_ADMIN'],
  '/console':                       ['ROLE_SUPER_ADMIN'],
  '/console.*':                     ['ROLE_SUPER_ADMIN'],
  '/console/**':                    ['ROLE_SUPER_ADMIN'],
  '/**/vendor/**':                  ['ROLE_SUPER_ADMIN'],    
  '/**/dist/**':                    ['ROLE_SUPER_ADMIN'],
  '/user/index':                    ['ROLE_ADMIN', 'ROLE_SUPER_ADMIN'],
  '/quartz/list':                   ['ROLE_SUPER_ADMIN'],   
  '/quartz/**':                     ['ROLE_SUPER_ADMIN'],   
  '/user/**':                       ['permitAll'],
  '/look/**':                       ['permitAll'], 
  '/board/**':                      ['permitAll'], 
  '/item/**':                       ['permitAll'],
  '/business/**':                   ['permitAll'],
  '/register/**':                   ['permitAll'],
  '/reset/**':                      ['permitAll'],
  '/confirm/**':                    ['permitAll'],
  '/emailConfirmation/**':          ['permitAll'],
  '/j_spring_*':                    ['permitAll'],
  '/login/**':                      ['permitAll'],
  '/logout/**':                     ['permitAll'],    
  '/oauth/**':                      ['permitAll'],
  '/springSecurityOAuth/**':        ['permitAll'],
  //'/oauth/**': ['permitAll'],
  //'/api/**':                        ['permitAll'],

]


oauth {
  providers {
    facebook {
          api = org.scribe.builder.api.FacebookApi
          scope = 'email, user_about_me'
          //Supported scopes: create_event create_note email export_stream friends_about_me friends_activities friends_birthday friends_checkins friends_education_history friends_events friends_games_activity friends_groups friends_hometown friends_interests friends_likes friends_location friends_notes friends_online_presence friends_photo_video_tags friends_photos friends_questions friends_relationship_details friends_relationships friends_religion_politics friends_status friends_subscriptions friends_videos friends_website friends_work_history manage_friendlists manage_notifications manage_pages offline_access photo_upload publish_actions publish_checkins publish_stream read_friendlists read_insights read_mailbox read_page_mailboxes read_requests read_stream rsvp_event share_item sms status_update user_about_me user_activities user_birthday user_checkins user_education_history user_events user_friends user_games_activity user_groups user_hometown user_interests user_likes user_location user_notes user_online_presence user_photo_video_tags user_photos user_questions user_relationship_details user_relationships user_religion_politics user_status user_subscriptions user_videos user_website user_work_history video_upload xmpp_login
          key = "my key"
          secret = "my secret"
          successUri = "${baseURL}/springSecurityOAuth/onSuccess?provider=Facebook"//"${baseURL}/springSecurityOAuth/onSuccess"//'${grails.serverURL}/oauth/facebook/success' //'${grails.serverURL}/user/onFacebookSuccess'
          failureUri = "${baseURL}/springSecurityOAuth/onFailure?provider=Facebook"
          callback = "${baseURL}/oauth/facebook/callback"
    }
  
  }
}



