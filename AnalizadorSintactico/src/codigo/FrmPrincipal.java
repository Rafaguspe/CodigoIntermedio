/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Charly Ponce
 */
public class FrmPrincipal extends javax.swing.JFrame {
DefaultTableModel modelo; 
Object fila []= new Object[3];
String[] divi;
  String finalInter;
private TableRowSorter trsfiltro;
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
       
        initComponents();
         modelo = (DefaultTableModel) JtableLexer.getModel();
        
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        for (int i = 0; i < JtableLexer.getRowCount(); i++) {
        modelo.removeRow(i);
        i-=1;
            }
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        fila[0]="LINEA " + cont ;
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    fila[0]="LINEA " + cont ;
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    fila[2]="Comillas";
                    fila[1]=lexer.lexeme;
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    fila[2]="Tipo de dato";
                    fila[1]=lexer.lexeme;
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    fila[2]="Tipo de dato";
                    fila[1]=lexer.lexeme;
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    fila[2]="Reservada if";
                    fila[1]=lexer.lexeme;
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    fila[2]="Reservada else";
                    fila[1]=lexer.lexeme;
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    fila[2]="Reservada do";
                    fila[1]=lexer.lexeme;
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                     fila[2]="Reservada while";
                    fila[1]=lexer.lexeme;
                    break;
                case For:
                    resultado += "  <Reservada for>\t" + lexer.lexeme + "\n";
                     fila[2]="Reservada for";
                    fila[1]=lexer.lexeme;
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                     fila[2]="Operador igual";
                    fila[1]=lexer.lexeme;
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                     fila[2]="Operador suma";
                    fila[1]=lexer.lexeme;
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    fila[2]="Operador resta";
                    fila[1]=lexer.lexeme;
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    fila[2]="Operador multiplicacion";
                    fila[1]=lexer.lexeme;
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    fila[2]="Operador division";
                    fila[1]=lexer.lexeme;
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                      fila[2]="Operador logico";
                    fila[1]=lexer.lexeme;
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                     fila[2]="Operador incremento";
                    fila[1]=lexer.lexeme;
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                    fila[2]="Operador relacional";
                    fila[1]=lexer.lexeme;
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n";
                   fila[2]="Operador atribucion";
                    fila[1]=lexer.lexeme;
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                   fila[2]="Operador booleano";
                    fila[1]=lexer.lexeme;
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    fila[2]="Parentesis de apertura";
                    fila[1]=lexer.lexeme;
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                   fila[2]="Parentesis de cierre";
                    fila[1]=lexer.lexeme;
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                      fila[2]="Llave de apertura";
                    fila[1]=lexer.lexeme;
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                     fila[2]="Llave de cierre";
                    fila[1]=lexer.lexeme;
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    fila[2]="Corchete de apertura";
                    fila[1]=lexer.lexeme;
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexer.lexeme + "\n";
                     fila[2]="Corchete de cierre";
                    fila[1]=lexer.lexeme;
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    fila[2]="Reservada main";
                    fila[1]=lexer.lexeme;
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                   fila[2]="Punto y coma";
                    fila[1]=lexer.lexeme;
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    fila[2]="Identificador";
                    fila[1]=lexer.lexeme;
                    break;
                  
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    fila[2]="Numero";
                    fila[1]=lexer.lexeme;
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    fila[2]="Simbolo no definido";
                    
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
         //   System.out.println("Fila 0>"+fila[0]+" fila1>"+fila[1]+" fila2>"+fila[2]);
            modelo.addRow(fila);
          //  JtableLexer.setModel(modelo); 
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        JtableLexer = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnAnalizarLex = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLimpiarCodigo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        btnAnalizarSin = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtIntermedio = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        JtableLexer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Linea", "Variable", "Tipo Variable"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(JtableLexer);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 195, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Lexico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnArchivo.setText("Abrir archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        btnAnalizarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarLex.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setText("Resultado Analizador Lexico");

        btnLimpiarCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarCodigo.setText("Limpiar Codigo");
        btnLimpiarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCodigoActionPerformed(evt);
            }
        });

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        jPanel2.setBackground(new java.awt.Color(199, 0, 57));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Sintactico / Semántico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        btnAnalizarSin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        btnLimpiarSin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLimpiarSin.setText("Limpiar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAnalizarSin)
                        .addGap(357, 357, 357)
                        .addComponent(btnLimpiarSin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarSin)
                    .addComponent(btnLimpiarSin))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel2.setText("Rafael Peña 1-19-7122");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel3.setText("Codigo en Java");

        txtIntermedio.setColumns(20);
        txtIntermedio.setRows(5);
        jScrollPane5.setViewportView(txtIntermedio);

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(btnLimpiarLex))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpiarCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnalizarLex)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(102, 102, 102)
                                .addComponent(jButton1)))))
                .addGap(793, 793, 793))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnalizarLex)
                            .addComponent(btnLimpiarLex)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnLimpiarCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(582, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 325, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

       
    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        // TODO add your handling code here:
        txtAnalizarLex.setText(null);
        
          for (int i = 0; i < JtableLexer.getRowCount(); i++) {
        modelo.removeRow(i);
        i-=1;
            }
        
        
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        // TODO add your handling code here:
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        // TODO add your handling code here:
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
            Seman((sym.right + 1),(sym.left + 1),sym.value);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    
    private void Seman(Object rigth,Object left, Object valor)
    {
        String val= valor.toString();
       int val2= 2;
        
        if (rigth!="1") {
                
        switch (val) {
            case "=":
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: Declarar un identificador");
            txtAnalizarSin.setForeground(Color.red);
            break;
           
              case "}":
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: variables sin cerrar, no se encontre un retorno u accion");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
               case "int":
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: falta cerrar la variable");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
               case "\"":
          txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: Los datos no son compatibles");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
            
                 case ")":
          txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: LLenar los campos necesarios entre los ()");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
                   case "(":
          txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: LLenar los campos necesarios entre los (),no necesario en este campo");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
            
            
                     case "+":
          txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: Operador colocado indebidamente");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
            
                    case "-":
          txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: Operador colocado indebidamente");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
                     case "/":
          txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: Operador colocado indebidamente");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
            
                     case "*":
          txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: Operador colocado indebidamente");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
                       default:
                        
          txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: No se encuentra dentro la funcion, no creado, falta de tipo de valor");
            txtAnalizarSin.setForeground(Color.red);
            break;
            
        }// fin del switch
        
        switch(val2)
        {
        
            case 3:
                 txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: Los datos no son compatibles");
            txtAnalizarSin.setForeground(Color.red);
                break;
        
        }//fin otro switch
        
        
        
        
        
    }//fin if de rigth
         if (rigth=="1") {
         txtAnalizarSin.setText("Error de sintaxis. Linea: " + rigth + " Columna: " + left + ", Texto: \"" + valor + "\""+
                    "\nPosible solucion Semántica: Inicializar la funcion main");
            txtAnalizarSin.setForeground(Color.red);
         }
        
    
    } // fin de seman
    
    
    
   public void GenerarIntermedio() 
   {
       //limpiamos el text area
       txtIntermedio.setText(null);
       //tomamos el codigo y lo dividimos por lineas
       String elresul=txtResultado.getText();
       String [] lineas = elresul.split("\n");
       //cantidad de lineas
       int casifin=lineas.length;
       String Intermedio="";
       StringBuilder stringBuilderInter = new StringBuilder();
       
       
       //revisamos todas las lineas
       for (int i = 0; i < lineas.length; i++) {
        
           
           //si en la linea 1 y 2 existe estas palabras introducimos la estructura de java
           if ("int main (){".equals(lineas[0]) || ("int main ()".equals(lineas[0]) && "{".equals(lineas[1]))
               ||"int main(){".equals(lineas[0]) || ("int main()".equals(lineas[0]) && "{".equals(lineas[1]))    ) {

            Intermedio ="package NombreArchivo;"+"\n\n\n"+"public class NombreArchivo{"+"\n\n"+"public static void main(String[] args) {"+"\n\n";
           }// Fin //si en la linea 1 y 2 existe estas palabras introducimos la estructura de java
           
           
           
            if ("}".equals(lineas[casifin-1])) {
               
                finalInter="}\n\n}";
              
           }// Si la ultima tiene } 
            
            
            
            
         //si es mayor a la linea 2 y la penultima linea
           if (i>1 && i<casifin-1) {
           
          
                //si la linea contiene printf
             if (lineas[i].contains("printf")) {
           //remplazamos printf por System.out.println
           String prin= lineas[i].replace("printf","System.out.println");
           
               //Agregamos esta linea al StringBuilder
                   stringBuilderInter.append(prin).append("\n");
               
               
               }// si es un printf



               // si la linea tiene un scanf
              if (lineas[i].contains("scanf")) {
                  // modificamos la parte inicial del codigo de Java importando el Scanner
           Intermedio ="package NombreArchivo;"+"\n"+"import java.util.Scanner;"+"\n\n"+"public class NombreArchivo{"+"\n\n"+"public static void main(String[] args) {"+"\n"
                   + "\nScanner entrada =new Scanner(System.in);\n";
           
           String [] prin= lineas[i].split("&");
           //dividimos la cadena para poder separar la variable
               if (prin[0]!=null) {
                   String lini=prin[1];
                   String divisor="\\)\\;";
                    String [] prin2= lini.split(divisor);
                   String impri=prin2[0]+"= entrada.nextInt();";
                   //agregamos esa linea modificada al Stringbuilder
                   stringBuilderInter.append(impri).append("\n");
               }
               
               }// si es un scanf
               
               
              
              
              
              
               boolean esta=lineas[i].contains("printf");
               boolean esta2=lineas[i].contains("scanf");
               
               //En caso de que no exista ni un printf o un scanf
            if(esta==false && esta2==false) {
                   System.out.println("esta "+esta+"   "+"esta2 "+esta2);   
           //Agregamos la linea de igual forma
          stringBuilderInter.append(lineas[i]).append("\n");
            }
         
     }//Fin si no es linea inicial o final
            

            
            
       }//fin for
      
      
       System.out.println(Intermedio);
       System.out.println(stringBuilderInter);
       System.out.println(finalInter);
      
       
       //creamos un StringBuilder nuevo 
       StringBuilder CodigoIntermedio= new StringBuilder();
       
       //Determinamos la estrcutura que sera intermedio la parte inicial el Stringbuilder Intermedio la parte del centro
       // y finalInter como la parte que cierra el codigo
       CodigoIntermedio.append(Intermedio).append(stringBuilderInter).append(finalInter);
      
       
       //le ponemos el codigo intermedio al text Area
        txtIntermedio.setText(CodigoIntermedio.toString());
       
   }
    
    
    
    private void btnLimpiarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCodigoActionPerformed
       txtResultado.setText(null);
    }//GEN-LAST:event_btnLimpiarCodigoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        GenerarIntermedio();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtableLexer;
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnLimpiarCodigo;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtIntermedio;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
