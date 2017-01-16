//def saluda(nombre) {
//  "Hola ${nombre} !!!"
//}
//
//def cuadrado(n) { n * n }
//def cubo(n) { cuadrado(n) * n }
//
//println saluda("Juan")
//println "Cuadrado de 4 = ${cuadrado(4)}"
//println "Cubo de 4 = ${cubo(4)}"

// ============================

Integer operacion(n, closure){
  println "Ejecutando operacion"
  closure(n)
}


//println operacion(4 , { it * 3 })
//println operacion(4) { it * 3 }
//println operacion(4) { numero -> numero * 3 }

//lista = [1,2,3,4,'a','b','c',"Jorge","Juan","Carlo","Brandon",12.3,4.3,3.2,5.2]
//
//lista.each { e ->
//  def otraVar = e.class
//  println "${otraVar} de $e"
//}


//def metodo(parametro){
//  "algo"
//}
//
c = { it == it.reverse() }
c2 = { it.size() > 5 }

def valida(s, validador){
  if(validador(s))
    "Correcto"
  else
    "Incorrecto"
}

println valida("oso", c2)

//captura = this.&metodo
//
//println valida("oso", captura)

//s = "algo"
//
//c2 = s.&charAt(2)
//
//println c2
