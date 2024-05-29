import javax.swing.*;
import java.awt.event.*;
public class UnitConversion implements ActionListener{
   JFrame frame;
   JTextField input,output;
   JButton button;
   JComboBox combo, combo2;
   public static void main(String args[])
   {
      UnitConversion converter = new UnitConversion();
      converter.makeui();
      

   }
   public void makeui(){
   frame = new JFrame("Select Units");
   String units[] = {"kilometer","meter","centimeter","inch","mile","yard","milimeter","nanometer"};
   combo = new JComboBox(units);
   combo2 = new JComboBox(units);
   combo.setBounds(50,50,125,20);
   combo2.setBounds(200,50,125,20);
   input = new JTextField();
   input.setBounds(50,70,125,20);
   output = new JTextField();
   output.setBounds(200,70,125,20);
   output.setEditable(false);
   button = new JButton("Compute");
   button.setBounds(125,25,100,20);
   button.addActionListener(this);    
   frame.add(output);frame.add(input);frame.add(button);
   frame.add(combo);
   frame.add(combo2);
   frame.setLayout(null);
   frame.setSize(400,500);
   frame.setVisible(true);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   }
   public double toMeters(double inner)// need to add "inch","mile","yard","milimeter","nanometer"
   {
      if (combo.getSelectedItem() == "meter")
         {
            return inner;
         }
      else if (combo.getSelectedItem() == "kilometer")
         {
            return inner * 1000;
         }
      else if (combo.getSelectedItem() == "centimeter")
         {
            return inner / 100;
         }
       else if (combo.getSelectedItem() == "inch")
         {
            return inner * 0.0254;
         }
       else if (combo.getSelectedItem() == "mile")
         {
            return inner * 1609.35; 
         }
       else if (combo.getSelectedItem() == "yard")
         {
            return inner * 0.9144;
         }
       else if (combo.getSelectedItem() == "milimeter")
         {
            return inner * 0.001;
         }
       else if (combo.getSelectedItem() == "nanometer")
         {
            return inner * 0.000000001;
         }
     return 0;
   
   }
   public double toUnit(double outer)// need to add "inch","mile","yard","milimeter","nanometer"
   {
      if (combo2.getSelectedItem() == "meter")
      {
         return outer;
      }
      else if (combo2.getSelectedItem() == "kilometer")
      {
         return outer / 1000;
      }
      else if( combo2.getSelectedItem() == "centimeter")
      {
         return outer * 100;
      }
      else if (combo2.getSelectedItem() == "inch")
      {
         return outer * 39.37;
      }
      else if (combo2.getSelectedItem() == "mile")
      {
         return outer * 0.0006213689;
      }
      else if (combo2.getSelectedItem() == "yard")
      {
         return outer * 1.0936132983;
      }
      else if (combo2.getSelectedItem() == "milimeter")
      {
         return outer * 1000;
      }
      else if (combo2.getSelectedItem() == "nanometer")
      {
         return outer * 1000000000;
      }
      return 0;
    }
   
   
   
   
   
   
   
   @Override
   public void actionPerformed(ActionEvent e){
   String in = input.getText();
   double meters;
   double outer;
   String out = "test";
   if(e.getSource() == button){
      meters = toMeters(Double.parseDouble(in));
      
      out =  String.format("%.2f", toUnit(meters)   );
      
      output.setText(out);
   }
   
   }
   
   
}
