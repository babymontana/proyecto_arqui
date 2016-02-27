package proyecto_arqui;

import java.util.Date;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
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
    private ArrayList<Libro> data = new ArrayList<Libro>();
    private ArrayList<ArrayList<Integer>> seleccion= new ArrayList<ArrayList<Integer>> ();
    private JPanel abajo;
    private JButton generate;
    private JButton regresar=new JButton("Regresar");
    private JTable capitulos = new JTable();
    private JTextPane datos = new JTextPane();
    
    
    public Proyecto_arqui() {
        
        //usuario
        usuario.setId(12234);
        usuario.setFechaRegistro(new Date(2008,06,12));
        usuario.setNombre("Emmanuel Páez");
        
        //libro 1
         String texto_1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam consequat."; 
        String texto_2 = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident";
        String texto_3 = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae";
        Capitulo c1_a = new Capitulo(texto_1, "Capitulo 1", 2);
        Capitulo c1_b = new Capitulo(texto_2, "Capitulo 2", 3);
        Capitulo c1_c = new Capitulo(texto_3, "Capitulo 3", 2);
        ArrayList<Partes> cap_libro1 = new ArrayList<Partes>();
        cap_libro1.add(c1_a);
        cap_libro1.add(c1_b);
        cap_libro1.add(c1_c);
        primero = new Libro();
        primero.setNombre("UML");
        primero.setFecha(new Date(2005,01,21));
        primero.setCapitulos(cap_libro1);
        
        //Libro 2
        String texto_4 = "Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime";
        String texto_5 = "Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.";
        String texto_6 = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";
        Capitulo c2_a = new Capitulo(texto_4, "Capitulo 1", 1);
        Capitulo c2_b = new Capitulo(texto_5, "Capitulo 2", 2);
        Capitulo c2_c = new Capitulo(texto_6, "Capitulo 3", 3);
        ArrayList<Partes> cap_libro2 = new ArrayList<Partes>();
        cap_libro2.add(c2_a);
        cap_libro2.add(c2_b);
        cap_libro2.add(c2_c);        
        segundo = new Libro();
        segundo.setNombre("Cuentos del Pato Donald");
        segundo.setFecha(new Date(2016,05,21));
        segundo.setCapitulos(cap_libro2);
        
         data.add(primero);
         data.add(segundo);
         seleccion.add(new ArrayList<Integer>());
         seleccion.add(new ArrayList<Integer>());
         
         
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
       
      DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
        
       for(Libro l : this.data){
           
          
       String [] data = {l.getNombre(),l.getFechaString()};
        tableModel.addRow(data);  

       }
       
       
       
        
        table = new JTable(tableModel);
        panel = new  JScrollPane(table);
        table.setFillsViewportHeight(true);
        generate = new JButton("it al visor");
        generate.addActionListener(new Listener());
        abajo.add(generate);
        setLayout(new BorderLayout(10, 10));
        add(arriba, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
        regresar.addActionListener(new Listener());
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {            
            @Override
            public void valueChanged(ListSelectionEvent e) {
               listaLibro(table.getSelectedRow());
               
            }
        });


    }
    //Lista de capitulos del libro seleccionado (validacion vencimiento)
    public void listaLibro(int index){ 
        ZoneId zonedId = ZoneId.of( "America/Montreal" );
        LocalDate today = LocalDate.now(zonedId);
        Date hoy = new Date(today.getYear(),today.getMonthValue(), today.getDayOfMonth());
        if(hoy.before(this.data.get(index).getFechaVencimiento())){
          
        this.setTitle("Capitulos( "+this.data.get(index).getNombre()+")");
        String col[] = {"Titulo","no. Paginas","Seleccionar"};

            DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        
         int i=0;
          for(Partes c: this.data.get(index).getPartes()){
              boolean flag=false;
              if (seleccion.get(index).contains(i)){
                  flag = true;
              }
              Object[] data = {c.getTitulo(),c.getLongitud(),flag};
            tableModel.addRow(data);
            i++;
          }
       
        capitulos = new JTable(tableModel);
        capitulos.setFillsViewportHeight(true);
        panel.setViewportView(capitulos);
        panel.revalidate();
        panel.repaint();
        abajo.removeAll();
        abajo.add(regresar);
        abajo.revalidate();
        abajo.repaint();
        
        }else{
        JOptionPane.showMessageDialog(null, "Este producto ha vencido, porfavor renueve su pago", "Pago Vencido", JOptionPane.ERROR_MESSAGE);

        }
        
    }

    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
             if (e.getSource() == generate) {
                 
                 Productos productos = new Productos();    
                Visor visor = new Visor(productos);     
                int i=0;
                for (Libro L : data){
                  productos.agregarLibro(L, seleccion.get(i));
                  i++;
                }
        
               
                datos.setText(visor.visualizarProductos());
                panel.setViewportView(datos);
                panel.revalidate();
                panel.repaint();
                setTitle("Visor");
                abajo.removeAll();
                abajo.add(regresar);
                abajo.revalidate();
                abajo.repaint();
                
            }
             
             if (e.getSource()==regresar){
                 if(table.getSelectedRow()>-1){
                seleccion.get(table.getSelectedRow()).clear();
                 }
                 
                 for (int i=0;i<capitulos.getModel().getRowCount();i++){
                     if((boolean)capitulos.getModel().getValueAt(i, 2)){
                           seleccion.get(table.getSelectedRow()).add(i);
                     }

                
                 }
        setTitle("Mis libros");           
        panel.setViewportView(table);
        panel.revalidate();
        panel.repaint();
        abajo.removeAll();
        abajo.add(generate);
        abajo.revalidate();
        abajo.repaint();
             }
             
           
            
        }
        
    }

    public static void main(String[] args) {

        Proyecto_arqui ventana = new Proyecto_arqui();
     
    }


}