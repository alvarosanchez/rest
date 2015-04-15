package com.test.look

import grails.plugin.springsecurity.annotation.Secured

class LookController {

	def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['permitAll'])
    def lookAjax(){
    	log.info "hello! lookAjax"
    	def isLogged = springSecurityService.isLoggedIn()
    	log.info "logged?: $isLogged"
    	render "ok"
    }

    @Secured(['permitAll'])
    def followedAjax(){
    	log.info "hello! followedAjax"
    	def isLogged = springSecurityService.isLoggedIn()
    	log.info "logged?: $isLogged"
    	render "ok"
    }

    @Secured(['permitAll'])
    def lookShow(){
    	log.info "hello! lookShow"
    	def isLogged = springSecurityService.isLoggedIn()
    	log.info "logged?: $isLogged"
    	render "ok"
    }
}
       

