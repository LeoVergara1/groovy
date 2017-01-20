leer = new File("cadena.txt")
def x=0
def y=0
def casas=[[0,0]]

leer.text.each(){
  if(it==">")
    x++
  if(it=="<")
    x--
  if(it=="^")
    y++
  if(it=="v")
    y--
 casas.add([x,y])
}
casas = casas.unique()
println "El numnero de casas es ${casas.size()}"
