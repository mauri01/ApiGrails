package nuevaapi

import grails.converters.JSON

class ClienteController {

    ClienteService clienteService

    def get() {
        render([key: "value"] as JSON)
    }

    def create() {

        println("Entrando a create")
        //crear

        Map responseMap
        def mensaje = clienteService.createCliente("Jose","Aante","VEN")
        println("mensaje: ${mensaje}")
        if (mensaje == "ok")
        {
            responseMap = [
                    response: [
                            message: "Creado de forma correcta"
                    ],
                    status  : 201
            ]
        } else {
            responseMap = [
                    response: [
                            message: "Error"
                    ],
                    status  : 500
            ]
        }
        render(responseMap as JSON)
    }

    def buscarCliente(){
        Map requestParameters = getParams()
        println("Entrando a bucar cliente${requestParameters}")
        Map mensaje = clienteService.buscarCliente(requestParameters.idCliente)
        println("El mensaje es $mensaje")
        render(mensaje as JSON)
    }

    def actualizarCliente(){
        Map requestParameters = getParams()
        println("Entrando a actualizar cliente${requestParameters}")
        Map mensaje = clienteService.updateCliente(requestParameters.idCliente)
        render(mensaje as JSON)

    }

    def deleteCliente(){
        Map requestParameters = getParams()
        println("Entrando a eliminar cliente${requestParameters}")
        Map mensaje = clienteService.deleteCliente(requestParameters.idCliente)
        render(mensaje as JSON)
    }

    def filtroCliente(){
        Map requestParameters = getParams()
        println("Lo que envias es:${requestParameters.toString()}")
        Map responseMap = clienteService.filtroCliente(requestParameters)

        render(responseMap as JSON)
    }
}
