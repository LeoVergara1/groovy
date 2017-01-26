import groovy.beans.Bindable;
import groovy.swing.SwingBuilder
import java.awt.BorderLayout
import javax.swing.JFrame
import java.beans.PropertyChangeListener 

Bindable ObservableList people = [ [name:"Mary", age:18],
                                    [name:"Tom", age:25] ]

def swingBuilder = new SwingBuilder()
swingBuilder.edt {  // edt method makes sure UI is build on Event Dispatch Thread.
    lookAndFeel 'system'  // Simple change in look and feel.
    frame(  title: 'Display a table',
            size: [400,300],
            show: true,
            locationRelativeTo: null,
            defaultCloseOperation: JFrame.HIDE_ON_CLOSE) {
        menuBar() {
            menu(text: "File", mnemonic: 'F'){
                menuItem(text: "Add", actionPerformed: {
                    people << [name:"Harry", age:17]
                    println people
                }
            ) }
        }
        panel(layout: new BorderLayout()) {
            scrollPane(constraints: BorderLayout.CENTER) {
                table {
                    def listTeacher
                    tableModel( id:'model', list: people) { m ->
                        propertyColumn(header: 'Name', propertyName: 'name')
                        propertyColumn(header: 'Age', propertyName: 'age')
                    }
                }
            }
            people.addPropertyChangeListener( { e -> model.fireTableDataChanged() } as PropertyChangeListener )
        }
    } 
}
