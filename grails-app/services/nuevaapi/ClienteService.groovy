package nuevaapi

class ClienteService {
    static transactional = false

    String nuevoCliente() {
        return "hola"
    }

    String createCliente(nombre, apellido, localidad) {

        println("Entando a creaaaar: ${nombre.toString()}")
        def mensaje
        def NuevoCliente = new Cliente(
                nombre: nombre,
                apellido: apellido,
                localidad: localidad
        ).addToArticulos(new Articulos(nombre: "Auto",precio: 50))

        println("Cliente creado: ${NuevoCliente.toString()}")
        if (NuevoCliente.save(flush: true)) {
            mensaje = "ok"
        } else {
            mensaje = "no"
        }
        return mensaje
    }

    def buscarCliente(String id) {
        Long idLong = Long.parseLong(id)

        println("idBuscado: ${idLong}")
        Cliente clientConsult = Cliente.findById(idLong)
        Map responseMap
        if (null != clientConsult) {
            responseMap = [
                    response: [
                            message: "Existe Cliente: ${clientConsult.nombre} localidad:${clientConsult.localidad} "
                    ],
                    status  : 200
            ]
        } else {
            responseMap = [
                    response: [
                            message: "Error"
                    ],
                    status  : 500
            ]
        }
        println("Cliente: ${responseMap}")
        return responseMap
    }


    def updateCliente(String id) {
        Long idLong = Long.parseLong(id)
        Map responseMap
        def actCliente = Cliente.findById(idLong)
        actCliente.localidad = "BOL"
        //actCliente.save()
        if (actCliente.save(flush: true)) {
            responseMap = [
                    response: [
                            message: "Se actualizo de forma correcta",

                    ],
                    status  : 200
            ]
        } else {
            responseMap = [
                    response: [
                            message: "Error"
                    ],
                    status  : 500
            ]
        }

        println("Cliente se elimino????: ${responseMap}")
        return responseMap

    }

    def deleteCliente(String id) {
        Long idLong = Long.parseLong(id)
        Map responseMap
        def actCliente = Cliente.findById(idLong)
        println("Cliente a eliminar: ${actCliente}")
        if (actCliente.delete(flush: true)) {
            responseMap = [
                    response: [
                            message: "Se elimino de forma correcta",

                    ],
                    status  : 200
            ]
        } else {
            responseMap = [
                    response: [
                            message: "Error"
                    ],
                    status  : 500
            ]
        }

        return responseMap
    }

    def filtroCliente(Map param) {

        println("Lo que llego es:${param.toString()} y ${param.size()}")

        Map responseMap
        if (param.datefrom != null && param.date != null) {
            responseMap = [
                    response: [
                            message: "Cantidad de parametros correctos"
                    ],
                    status  : 200
            ]
        } else {
            responseMap = [
                    response: [
                            message: "Faltan parametros"
                    ],
                    status  : 400
            ]
        }

        return responseMap

    }


}
