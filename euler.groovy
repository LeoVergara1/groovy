def list = 1..999
def numbers = []

list.each{
  if(it%3 == 0 || it%5 == 0)
     numbers.add(it)
}

println "La suma es ${numbers.sum()}"


