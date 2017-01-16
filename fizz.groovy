/*def i
for(i=1; i<=100; i++){
	if(((i%3)||(i%5))==0)
		println "FizzBuzz"
        else if((i%3)==0)
            println "Fizz"
        else if((i%5)==0)
            println "Buzz"
        else
            println "numero ${i}"
}*/
lista= 1..100

/*e = { if(((lista[it]%3)||(lista[it]%5))==0)
		println "FizzBuzz"
        else if((ilista[it]%3)==0)
            println "Fizz"
        else if((lista[it]%5)==0)
            println "Buzz"
        else
            println lista[it]}

lista.each(){
	
	e

}*/

def fizz = []
def buzz = []
def fibu = []

e = { if(((lista[it]%3)||(lista[it]%5))==0)
		fizz.add(it)
        else if((ilista[it]%3)==0)
            buzz.add(it)
        else if((lista[it]%5)==0)
            fibu.add(it)
        else
            println lista[it]}

lista.each(){
	
	e

}
println lista
println fizz[2]
