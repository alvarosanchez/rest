class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')


        // Look
        "/api/v1/look/lookAjax"(controller: "look", action: 'lookAjax')
        "/api/v1/look/followedAjax"(controller: "look", action: 'followedAjax')
        "/api/v1/look/lookShow/$id"(controller: "look", action: 'lookShow')

        "/look/lookAjax"(controller: "look", action: 'lookAjax')
        "/look/followedAjax"(controller: "look", action: 'followedAjax')
        "/look/lookShow/$id"(controller: "look", action: 'lookShow')
        
	}
}
