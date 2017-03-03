package nuevaapi

class Cliente {

    String nombre
    String apellido
    String localidad

    static hasMany = [articulos:Articulos]
    static constraints = {
        nombre (nullable: false)
        apellido (nullable: false)
        localidad (nullable: false)
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", version=" + version +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
