@GrabConfig(systemClassLoader=true)
@Grapes([
  @Grab(group='mysql', module='mysql-connector-java', version='5.0.8')
])
 

class Issue{
  Long id
  String description
  Integer priority
  Date dateCreated
}
 import groovy.sql.Sql
 
// Crea la base de datos
// create database groovy_issue_tracker;
def db = [
  url:'jdbc:mysql://localhost/groovy_issue_tracker',
  user:'root',
  password:'makingdevs',
  driver:'com.mysql.jdbc.Driver'
]
def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
// Si tienes un dataSource o un pool de conexiones lo puedes usar
// def sql = new Sql(dataSource)
sql.execute "drop table if exists issue;"
 
sql.execute """
  create table if not exists issue(
    id integer primary key auto_increment,
    description varchar(255),
    priority integer,
    date_created datetime);
"""

sql.execute """
  insert into issue(description,priority,date_created) values
    ('No funciona el Login',1,now()),
    ('No hay estilo CSS',2,now()),
    ('No se puede crear el cliente',3,now()),
    ('Faltan validaciones',4,now()),
    ('No se puede acceder al menu',1,now()),
    ('No se crean facturas',2,now()),
    ('No se puede capturar emisor',3,now()),
    ('No se puede capturar receptor',4,now()),
    ('No se puede acceder al sistema',1,now());
"""
 
dataset = sql.dataSet('issue')
//busquemos solo unos clientes bajo el id


dataset.add(
  description:"Queremos cervezas en la oficina!",
  priority:4,
  date_created:new Date() - 5
)
println "La cantidad de issues actual es: ${sql.rows('SELECT * FROM issue').size()}"

filterIssues = dataset.findAll{
  it.id > 1
}
println "Mostrando los issues con el ID entre 3 y 6"
filterIssues.each{
  printf "%-10s %-40s %-15s %s\n",it.id,it.description,it[2],it[3]
}

