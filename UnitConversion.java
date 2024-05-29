import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
public class UnitConversion implements ActionListener{
   private JFrame frame;
   private JTextField input,output;
   private JButton button;
   private JComboBox combo, combo2;
   private HashMap<String, Double> length = new HashMap<>();
   
   public static void main(String args[])
   {
      UnitConversion converter = new UnitConversion();
      converter.innit();
      converter.makeui();
      
      

   }
   public  void innit()
   {// centimeter 0.01 inch 0.0254 mile 1609.35 yard 0.9144 milimeter 0.001 nanometer 0.000000001
   length.put("kilometer", 1000.0);
   length.put("meter", 1.0);
   length.put("centimeter", 0.01);
   length.put("inch", 0.0254);
   length.put("mile", 1609.35);
   length.put("yard", 0.9144);
   length.put("milimeter",0.001);
   length.put("nanometer", 0.000000001);
   length.put("feet", 0.3048);
   }
   public void makeui(){
   frame = new JFrame("Select Units");
   String units[] = {"kilometer","meter","centimeter","inch","mile","yard","milimeter","nanometer","feet"};
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
   public double toMeters(double inner)// centimeter 0.01 inch 0.0254 mile 1609.35 yard 0.9144 milimeter 0.001 nanometer 0.000000001
   {
     return inner * length.get((String) combo.getSelectedItem());
   
   }
   public double toUnit(double outer)// need to add "inch","mile","yard","milimeter","nanometer"
   {
      return outer / length.get( (String) combo2.getSelectedItem());
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
