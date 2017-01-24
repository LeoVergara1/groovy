def factorial(BigDecimal n){
  if(n==1) return 1
  n * factorial(n-1)
}

println factorial(10000)
