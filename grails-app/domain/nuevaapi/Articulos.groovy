package nuevaapi

class Articulos {

    String nombre
    int precio
    static belongsTo = [cliente:Cliente]
    static constraints = {
    }
}
