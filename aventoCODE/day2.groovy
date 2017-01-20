
medidas = new File("day2.txt").text.split("x")
lista = []


def lw = medidas[0].toInteger() * medidas[1].toInteger() 
def wh = medidas[1].toInteger() * medidas[2].toInteger() 
def hl = medidas[2].toInteger() * medidas[0].toInteger() 
lista << lw << wh << hl
lista.sort()
suma = 2*lw + 2*wh + 2*hl + lista[0].toInteger()
/*println medidas.class
println "${lw} ${wh} ${hl} ${lista[0].toInteger()}"*/
println suma 
/*println lw
println wh
println hl*/