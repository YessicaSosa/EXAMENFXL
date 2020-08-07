package com.mycompany.examenfx;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;



public class PrimaryController {

    @FXML
  private TextArea txtArea;
      @FXML
  private Button btnConsulta;
    
    
    @FXML
    private void OnAntionConsulta(ActionEvent event) {
        
        ArrayList<String> Listadatos = new ArrayList<String>();
        
       try{ 
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection com = DriverManager.getConnection("jdbc:mysql://24.152.40.30:3306/examenits", "its", "12345678");
           System.out.println("Ok funciona");
           Statement stm = com.createStatement();
           ResultSet rs = stm.executeQuery("SELECT * FROM personas");
           int acum = 0;
          
           while(rs.next()){
               Integer id = rs.getInt("idpersona");
               String nombre = rs.getString("nombres");
               String apellido = rs.getString("apellidos");
               System.out.println(id+" - "+nombre+" "+apellido);
               //txtArea.setText(id + "-" + nombre + "-" + apellido);
               
               Listadatos.add(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " \n");
           }
       }catch(Exception ex){
           System.out.println("Error al conectar: "+ex);
       }
       txtArea.setText(Listadatos+"");
    }
} 
    
    
