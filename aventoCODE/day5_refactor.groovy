
file = new File("day5.txt").text

conterNice = 0
stringRow = "aahgffgfhbb"

file.eachLine() { line ->
  (isNiceTheString(line)) ?conterNice++: ""
}

Boolean isNiceTheString(String line){
  Boolean isNice = false
  def numberVocal = line.findAll("[aeiou]?")
  numberVocal?.removeAll([""])
  def doubleLetters = line.findAll("((aa)|(bb)|(cc)|(dd)|(ee)|(ff)|(gg)|(hh)|(ii)|(jj)|(kk)|(ll)|(mm)|(nn)|(oo)|(pp)|(qq)|(rr)|(ss)|(tt)|(uu)|(vv)|(xx)|(yy)|(zz))?")
  doubleLetters?.removeAll("")
  def notString = line.findAll("((ab)|(cd)|(pq)|(xy))?")
  notString.removeAll([""])
  if ( doubleLetters && numberVocal && !notString){
    isNice = true
  }
  isNice
}

println conterNice