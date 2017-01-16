Integer a= 10
def lista=[1,2]
def pares = []

(0..30).each(){
  lista.add(lista[it]+lista[it+1])
 }

lista.each(){
  if(it<4000000 && it%2==0)
    pares.add(it)
}

println "La suma ${pares.sum()}"

//println lista
println((0..30).collect {
  lista[it]+lista[it+1]
 }.collect{
  if(it<4000000 && it%2==0)
    it
  else
    0
}.sum())
