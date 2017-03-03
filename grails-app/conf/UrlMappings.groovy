class UrlMappings {

	static mappings = {
//        "/$controller/$action?/$id?(.$format)?"{
//            constraints {
//                // apply constraints here
//            }
//        }

        "/"(controller: "cliente") {
            action = [ GET: "get" ]
        }

        "/client"(controller: "cliente") {
            action = [POST: "create"]
        }
        "/clientes/$idCliente"(controller: "cliente") {
            action = [GET: "buscarCliente",PUT: "actualizarCliente",DELETE: "deleteCliente"]
        }

        "/clientes/search?"(controller: "cliente") {
            action = [GET: "filtroCliente"]
        }

//        "/"(view:"/index")
//        "500"(view:'/error')
	}
}






