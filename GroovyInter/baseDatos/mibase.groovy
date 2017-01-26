@GrabConfig(systemClassLoader=true)
@Grapes([
  @Grab(group='mysql', module='mysql-connector-java', version='5.0.8')
])
import groovy.swing.SwingBuilder
import java.awt.BorderLayout
import javax.swing.JFrame
import java.awt.GridLayout
import java.awt.Color
import groovy.sql.Sql
import javax.swing.*                                                    
import javax.swing.tree.DefaultMutableTreeNode as TreeNode

  class Dictionary{
		long id
		String english
		String german
		String french
		String spanish		
		
		
	}
def db = [
  url:'jdbc:mysql://localhost/idiomas',
  user:'root',
  password:'makingdevs',
  driver:'com.mysql.jdbc.Driver'
]
def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)

/*sql.execute """ drop table if exists Dictionary"""*/
sql.execute """
  insert into Dictionary(english,german,french,spanish) values('Yes','Yah','Je','Si')
  """

sql.execute """
  create table if not exists Dictionary(
    id integer primary key auto_increment,
    english varchar(255),
    german varchar(255),
    french varchar(255),
    spanish varchar(255))	
"""
processMeta = { metaData ->
  printf "%-10s %-40s %-15s %s\n",metaData.getColumnLabel(1),metaData.getColumnLabel(2),metaData.getColumnLabel(3),metaData.getColumnLabel(4)
}
consulta = "SELECT * FROM Dictionary"
sql.eachRow(consulta,processMeta){
  printf "%-10s %-40s %-15s %s\n",it.id,it.spanish,it[4],it[2],it[3]
}
dataset = sql.dataSet('Dictionary')

hola= dataset.findAll{ it.id}

swing = new SwingBuilder()
 
salir = swing.action(
  name:'Salir',
  closure:this.&salirAction,
  mnemonic:'S',
  accelerator:'alt F4'
)
 
abrir = swing.action(
  name:'Abrir',
  closure:this.&abrirAction,
  mnemonic:'A',
  accelerator:'ctrl O'
)
 
def salirAction(event) {
  frame.dispose()
}
 
def abrirAction(event) {
  println "Abriendo"
}
trainings = [
    [name: "Idiomas", folders: [[name: "Dictionary"]]],

]
JTree trainingTree

frame = swing.frame(title:"Ejemplo de SwingBuilder con Menus", defaultCloseOperation: JFrame.DISPOSE_ON_CLOSE,
    size: [800, 600], show: true, locationRelativeTo: null) {
  menuBar {
    menu('mnemonic':'A','Archivo') {
      menuItem(action:abrir)
      separator()
      menuItem(action:salir)
    }
    //glue()
    menu('Edicion') {
      menuItem('Copiar')
      menuItem('Pegar')
    }
  }
  splitPane {
          scrollPane(constraints: "left", preferredSize: [160, -1]) {
              trainingTree = tree(rootVisible: false)
          }
          splitPane(orientation:JSplitPane.VERTICAL_SPLIT, dividerLocation:280) {
              scrollPane(constraints: "top") { 
                //asistenteTable = table() 
                lista = []
               hola.each(){ lista.add(it.id)}
            
              
                data = [[col1:"hola",col2:"B"],[col1:"C",col2:"D"]]
                lista.each(){
                  data.put[it,it]
                }
                data.put("col","HH")
                println data
                table {
                  tableModel(list: data) {
                    propertyColumn(header:'ID', propertyName:'1')
                    propertyColumn(header:'English', propertyName:'col2')
                    propertyColumn(header:'German', propertyName:'col2')
                    propertyColumn(header:'French', propertyName:'col2')
                    propertyColumn(header:'Spanish', propertyName:'col2')
                  }
                }
                //table()
              }
          }
      }

      //["ID","English", "German", "French", "Spanish"].each { asistenteTable.model.addColumn(it) }



 
}

 
trainingTree.model.root.removeAllChildren()
trainings.each {course ->
    def node = new TreeNode(course.name)
    course.folders.each { folder -> node.add(new TreeNode(folder.name)) }
    trainingTree.model.root.add(node)
}
trainingTree.model.reload(trainingTree.model.root)

