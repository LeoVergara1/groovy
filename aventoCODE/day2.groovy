
medidas = new File("day2.txt")
 int total= 0

medidas.eachLine(){
def lw = it.split("x")[0].toInteger() * it.split("x")[1].toInteger() 
def wh = it.split("x")[1].toInteger() * it.split("x")[2].toInteger() 
def hl = it.split("x")[2].toInteger() * it.split("x")[0].toInteger() 
lista = []
lista << lw << wh << hl
lista.sort()
suma = 2*lw + 2*wh + 2*hl + lista[0].toInteger()
/*println medidas.class
println "${lw} ${wh} ${hl} ${lista[0].toInteger()}"*/
println suma 
total+= suma 
}
println total
/*println lw
println wh
println hl*/