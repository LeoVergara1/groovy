
file = new File("day5.txt").text

conterNice = 0
stringRow = "aahgffgfhbb"

file.eachLine() { line ->
  (isNiceTheString(line)) ?conterNice++: ""
}

Boolean isNiceTheString(String line){
  Boolean isNice = false
  def numberVocal = line.findAll(~/[aeiou]?/)
  numberVocal?.removeAll([""])
  def doubleLetters = line.findAll(~/(.)\1+/)
  doubleLetters?.removeAll("")
  def notString = line.findAll(~/((ab)|(cd)|(pq)|(xy))?/)
  notString.removeAll([""])
  if ( doubleLetters && numberVocal.size() > 2 && !notString){
    isNice = true
  }
  isNice
}

println conterNice