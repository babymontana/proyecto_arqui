package proyecto_arqui;

import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Proyecto_arqui extends JFrame {

    private Usuario usuario= new Usuario();
    private Libro primero;
    private Libro segundo;
    private JLabel ID;
    private JLabel nombre;
    private JScrollPane panel;
    private JTable table;
    private Libro[] data;
    private JPanel abajo;
    private JButton generate;
    private JTable capitulos;
    
    public Proyecto_arqui() {
        
        
        usuario.setId(12234);
        usuario.setFechaRegistro(new Date(2008,06,12));
        usuario.setNombre("Emmanuel Páez");
         String texto_1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam consequat."; 
        String texto_2 = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident";
        String texto_3 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae";
        Capitulo c1_a = new Capitulo(texto_1, "ABC", 2);
        Capitulo c1_b = new Capitulo(texto_2, "RST", 3);
        Capitulo c1_c = new Capitulo(texto_3, "XYZ", 2);
        ArrayList<Capitulo> cap_libro1 = new ArrayList<Capitulo>();
        cap_libro1.add(c1_a);
        cap_libro1.add(c1_b);
        cap_libro1.add(c1_c);
        primero = new Libro();
        primero.setNombre("UML");
        primero.setFecha(new Date(2005,05,21));
        primero.setCapitulos(cap_libro1);
        
        //Libro 2
        String texto_4 = "Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime";
        String texto_5 = "Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.";
        String texto_6 = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
        Capitulo c2_a = new Capitulo(texto_4, "IJK", 1);
        Capitulo c2_b = new Capitulo(texto_5, "UVW", 2);
        Capitulo c2_c = new Capitulo(texto_6, "OPQ", 3);
        ArrayList<Capitulo> cap_libro2 = new ArrayList<Capitulo>();
        cap_libro2.add(c2_a);
        cap_libro2.add(c2_b);
        cap_libro2.add(c2_c);        
        segundo = new Libro();
        segundo.setNombre("Cuentos del Pato Donald");
        segundo.setFecha(new Date(2016,05,21));
        segundo.setCapitulos(cap_libro2);
        
         Libro[] aux={primero,segundo};
         this.data=aux;
        setTitle("Mis libros");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createContents();
        setVisible(true);
    }

    private void createContents() {
        
        JPanel arriba = new JPanel(new FlowLayout());      
        abajo = new JPanel(new FlowLayout());
        ID= new JLabel("ID: "+this.usuario.getId());
        nombre=new JLabel("Nombre: "+this.usuario.getNombre());
        arriba.add(ID);
        arriba.add(nombre);
        
       String[] columnas = {"Nombre",
                        "Fecha Vencimiento"
                            };
       
       String [][] data = {
           {primero.getNombre() , primero.getFechaVencimiento()},
           {segundo.getNombre() , segundo.getFechaVencimiento()}
       };
       
     
        
        table = new JTable(data,columnas);
        panel = new  JScrollPane(table);
        table.setFillsViewportHeight(true);

        setLayout(new BorderLayout(10, 10));
        add(arriba, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
       
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {            
            @Override
            public void valueChanged(ListSelectionEvent e) {
               listaLibro(table.getSelectedRow());
            }
        });


    }
    
    public void listaLibro(int index){
        this.setTitle("Capitulos( "+this.data[index].getNombre()+")");
        String col[] = {"Titulo","no. Paginas","Seleccionar"};

            DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        
       
          for(Capitulo c: this.data[index].getCapitulos()){
              
              Object[] data = {c.getTitulo(),c.getNumeroPaginas(),false};
            tableModel.addRow(data);
          }
       
        capitulos = new JTable(tableModel);
        capitulos.setFillsViewportHeight(true);
        generate = new JButton("Ver libro");
       generate.addActionListener(new Listener());
        abajo.add(generate);
        panel.setViewportView(capitulos);
        panel.revalidate();
        abajo.revalidate();
        abajo.repaint();
        panel.repaint();
    }

    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
             if (e.getSource() == generate) {
                 ArrayList<Integer> listaCapitulos = new ArrayList<Integer>();
       
       
                 for (int i=0;i<capitulos.getModel().getRowCount();i++){
                     if((boolean)capitulos.getModel().getValueAt(i, 2)){
                          listaCapitulos.add(i);
                     }
                 }
                
            }
            
        }
        
    }

    public static void main(String[] args) {

        Proyecto_arqui ventana = new Proyecto_arqui();
         
        
        
        Productos productos = new Productos();    
        Visor visor = new Visor(productos);     
        
        //Lista de capitulos
        ArrayList<Integer> listaCapitulos = new ArrayList<Integer>();
        listaCapitulos.add(0);
        listaCapitulos.add(2);
        
        //productos.agregarLibro(primero, listaCapitulos);
        
    }


}