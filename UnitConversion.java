import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
public class UnitConversion implements ActionListener{
   private JFrame frame;
   private JTextField input,output;
   private JButton button;
   private JComboBox combo, combo2, selector;
   private HashMap<String, Double> units = new HashMap<>();
   private String length[] = {"kilometer","meter","centimeter","inch","mile","yard","milimeter","nanometer","feet"};
   private String volume[] = {"liter","mililiter","cubic centimeter","gallon","quart","pint","cup","fluid ounce"};
   private String weight[] = {"kilogram", "gram","milligram","US ton","pound","ounce"};
   public static void main(String args[])
   {
      UnitConversion converter = new UnitConversion();
      converter.innit();
      converter.makeui();
   }
   public  void innit()
   {// centimeter 0.01 inch 0.0254 mile 1609.35 yard 0.9144 milimeter 0.001 nanometer 0.000000001
   //Lengths
   units.put("kilometer", 1000.0);
   units.put("meter", 1.0);
   units.put("centimeter", 0.01);
   units.put("inch", 0.0254);
   units.put("mile", 1609.35);
   units.put("yard", 0.9144);
   units.put("milimeter",0.001);
   units.put("nanometer", 0.000000001);
   units.put("feet", 0.3048);
   
   //Volumes
   units.put("liter",1.0);
   units.put("mililiter",0.001);
   units.put("cubic centimeter", 0.001);
   units.put("gallon",3.7854);
   units.put("quart",0.946);
   units.put("pint",0.4731);
   units.put("cup",0.2365);
   units.put("fluid ounce", 0.0295);
   
   //Weights
   
   units.put("kilogram", 1000.0);
   units.put("gram",1.0);
   units.put("milligram",0.001);
   units.put("US ton",907184.0);
   units.put("pound",453.592);
   units.put("ounce",28.3495);
   
   
   }
   public void makeui(){
      frame = new JFrame("Select Units");
   
      String Types[] = {"Length","Weight","Volume"};
   
      //combo boxes
      combo = new JComboBox(length);
      combo2 = new JComboBox(length);
      selector = new JComboBox(Types);
      combo.setBounds(50,50,125,20);
      combo2.setBounds(200,50,125,20);
      selector.setBounds(125,100,125,20);
      selector.addActionListener(this);

   
      //Text fields
      input = new JTextField();
      input.setBounds(50,70,125,20);
      output = new JTextField();
      output.setBounds(200,70,125,20);
      output.setEditable(false);
   
      //Button
      button = new JButton("Compute");
      button.setBounds(150,25,100,20);
      button.addActionListener(this);
   
   
      //frame setup
      frame.add(output);frame.add(input);frame.add(button);
      frame.add(combo);
      frame.add(combo2);
      frame.add(selector);
      frame.setLayout(null);
      frame.setSize(400,500);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   }
   public double toMeters(double inner) {
     return inner * units.get((String) combo.getSelectedItem());
   
   }
   public double toUnit(double outer)   {
      return outer / units.get( (String) combo2.getSelectedItem());
    }
    
   
   
   
   
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
   String in = input.getText();
   double meters;
   double outer;
   String out = "test";
      if(e.getSource() == button)
         {
      
      
            meters = toMeters(Double.parseDouble(in));
            out =  String.format("%f", toUnit(meters));
            output.setText(out);
         }
      else if(e.getSource() == selector)
      {
         updateComboBoxes();
      }
   }
   public void updateComboBoxes()
   {
   String selectedtype = (String) selector.getSelectedItem();
   combo.removeAllItems();
   combo2.removeAllItems();
   
      if("Length".equals(selectedtype))
      {
         for(String item : length)
         {
            combo.addItem(item);
            combo2.addItem(item);
         
         }
      }
      else if ("Volume".equals(selectedtype))
      {
         for(String item : volume)
         {
            combo.addItem(item);
            combo2.addItem(item);
         }
      }
      else if("Weight".equals(selectedtype))
      {
         for(String item : weight)
         {
            combo.addItem(item);
            combo2.addItem(item);
         }
      }
   }
   }
   
   
