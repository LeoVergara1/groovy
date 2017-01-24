file = new File("day5.txt").text

prueba = "aahgffgfh"
vocal = 0;
dd=0;
cont = 0

file.eachLine(){ s = it
	println s
	vocal=0
	s.each(){
	if(it == "a" || it =="e" || it =="i" || it =="o" || it =="u"  ){println "Entro"; vocal++}
	if( (2<vocal && vocal<30) && (s.contains("dd") || s.contains("aa") || s.contains("xx") || s.contains("bb") || s.contains("cc"))){ println "Contiene doble letra";

			if( (2<vocal && vocal<30) && (s.contains("ab") || s.contains("cd")|| s.contains("pq")|| s.contains("xy"))){ println "Se quito";}

			else {
				vocal = 49; cont++
			}
			
		}
	if( (vocal<3) && (s.contains("dd") || s.contains("aa") || s.contains("xx") || s.contains("bb") || s.contains("cc"))){ println "Contiene doble letra";
			if( (vocal<3) && (s.contains("ab") || s.contains("cd")|| s.contains("pq")|| s.contains("xy"))){ println "Se quito";}

			else {
				vocal = 49; cont++
			}}
	}

	  
}

print cont
