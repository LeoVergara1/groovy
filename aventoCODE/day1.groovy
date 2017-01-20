file = new File("day1.txt").text
int resu = 0
 file.each{
 	if(it==")") resu--
 	if(it=="(") resu++
 }

 println resu;
