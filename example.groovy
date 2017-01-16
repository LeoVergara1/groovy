class HolaMundo {

  def nombre
  	
  def saluda() {
    "Hola ${this.nombre} !!!"
  }

}

HolaMundo objeto = new HolaMundo(nombre:"jorge")
println objeto.saluda()