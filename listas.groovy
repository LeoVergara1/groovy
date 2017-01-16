l = 1..100

c = { it%2 == 0 }

def pares = []

l.each {
  if(c(it))
    pares.add(it)
}

def cuadrados = []

pares.each {
  cuadrados.add(it*it)
}

mayores = []

cuadrados.each {
  if(it > 5000)
    mayores.add(it)
}

println mayores
