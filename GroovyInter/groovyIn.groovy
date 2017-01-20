import groovy.swing.SwingBuilder
import javax.swing.*
import javax.swing.tree.DefaultMutableTreeNode as TreeNode
 
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
    [name: "Groovy", folders: [[name: "El lenguaje dinámico"], [name: "Productividad"],[name: "Grails"]]],
    [name: "JavaScript", folders: [[name: "jQuery"], [name: "Essentials"]]],
    [name: "Agil", folders: [[name: "Scrum"], [name: "Kanban"]]],
    [name: "Spring", folders: [[name: "Spring Batch"], [name: "Spring WebServices"]]]
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
              scrollPane(constraints: "top") { asistenteTable = table() }
          }
      }
      ["Asistente", "Empresa"].each { asistenteTable.model.addColumn(it) }
 
}
 
trainingTree.model.root.removeAllChildren()
trainings.each {course ->
    def node = new TreeNode(course.name)
    course.folders.each { folder -> node.add(new TreeNode(folder.name)) }
    trainingTree.model.root.add(node)
}
trainingTree.model.reload(trainingTree.model.root)