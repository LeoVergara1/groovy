@GrabConfig(systemClassLoader=true)
@Grapes([
  @Grab(group='mysql', module='mysql-connector-java', version='5.0.8')
])


import groovy.model.DefaultTableColumn
import groovy.model.DefaultTableModel
import groovy.model.PropertyModel
import groovy.model.ValueHolder
import groovy.inspect.swingui.TableSorter
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

bldr = new groovy.swing.SwingBuilder()
 
contador = 0



frame = bldr.frame(
  title:"Swing",
  size:[600,600],
  layout:new java.awt.FlowLayout(),
  defaultCloseOperation: javax.swing.WindowConstants.EXIT_ON_CLOSE
){
  lbl = label(text:"Prueba")
  btn = button(text:'Presioname', actionPerformed:{
    contador++
    btn.text="Presionado ${contador} veces"
    lbl.text="Groovy mostrado $contador veces"


     })
 label 'Etiqueta'


}
frame.show()
