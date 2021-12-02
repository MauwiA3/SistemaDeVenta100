package interfaz;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import controlador.ClienteDao;
import modelo.Configuracion;
import modelo.Detalle;
import controlador.Evento;
import controlador.LoginDao;
import modelo.Producto;
import controlador.ProductoDao;
import modelo.Proveedor;
import controlador.ProveedorDao;
import modelo.Venta;
import controlador.VentaDao;
import modelo.login;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author MauwiA3
 * @version 27-11-2021
 */
public class Sistema extends javax.swing.JFrame {

    /**
     * Creates new form Sistema
     */
    Cliente cl = new Cliente();
    ClienteDao client = new ClienteDao();
    Proveedor pr = new Proveedor();
    ProveedorDao prDao = new ProveedorDao();
    Producto pro = new Producto();
    ProductoDao proDao = new ProductoDao();
    Venta vent = new Venta();
    VentaDao vdao = new VentaDao();
    Detalle dt = new Detalle();
    Configuracion conf = new Configuracion();
    login lg = new login();
    LoginDao login = new LoginDao();
    Evento event = new Evento();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();
    int item;
    double totalPagar = 0.00;

    public Sistema() {
        initComponents();
        
    }
    
    public Sistema (login priv){   
        initComponents();
        this.setLocationRelativeTo(null);
        txt_idCliente.setVisible(false);
        txt_idCliente.setVisible(false);
        txt_idPro.setVisible(false);
        AutoCompleteDecorator.decorate(cbx_proveedorPro);
        proDao.consultarProveedor(cbx_proveedorPro);
        txt_idConfig.setVisible(false);
        if (priv.getRol().equals("Asistente")) {
            btn_productoss.setEnabled(false);
            btn_proveedor.setEnabled(false);
            label_vendedor.setText(priv.getNombre());
        }else{
            label_vendedor.setText(priv.getNombre());
        }
    } 

    //Listar a los clientes
    public void ListarCliente() {
        List<Cliente> ListarCl = client.listarCliente();
        modelo = (DefaultTableModel) table_cliente.getModel();
        Object[] ob = new Object[6];

        for (int i = 0; i < ListarCl.size(); i++) {
            ob[0] = ListarCl.get(i).getId();
            ob[1] = ListarCl.get(i).getRut();
            ob[2] = ListarCl.get(i).getNombre();
            ob[3] = ListarCl.get(i).getTelefono();
            ob[4] = ListarCl.get(i).getDireccion();
            ob[5] = ListarCl.get(i).getRazon();
            modelo.addRow(ob);
        }
        table_cliente.setModel(modelo);
    }

    //Listar a los proveedores
    public void ListarProveedor() {
        List<Proveedor> ListarPr = prDao.listarProveedor();
        modelo = (DefaultTableModel) table_proveedor.getModel();
        Object[] ob = new Object[6];

        for (int i = 0; i < ListarPr.size(); i++) {
            ob[0] = ListarPr.get(i).getId();
            ob[1] = ListarPr.get(i).getRut();
            ob[2] = ListarPr.get(i).getNombre();
            ob[3] = ListarPr.get(i).getTelefono();
            ob[4] = ListarPr.get(i).getDireccion();
            ob[5] = ListarPr.get(i).getRazon();
            modelo.addRow(ob);
        }
        table_proveedor.setModel(modelo);
    }

    //Listar productos
    public void ListarProductos() {
        List<Producto> ListarPro = proDao.listarProductos();
        modelo = (DefaultTableModel) table_producto.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarPro.size(); i++) {
            ob[0] = ListarPro.get(i).getId();
            ob[1] = ListarPro.get(i).getCodigo();
            ob[2] = ListarPro.get(i).getNombre();
            ob[3] = ListarPro.get(i).getProveedor();
            ob[4] = ListarPro.get(i).getStock();
            ob[5] = ListarPro.get(i).getPrecio();
            modelo.addRow(ob);
        }
        table_producto.setModel(modelo);
    }
    
    //Listar ususarios
    public void ListarUsuarios() {
        List<login> Listar = login.listarUsuarios();
        modelo = (DefaultTableModel) table_usuarios.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < Listar.size(); i++) {
            ob[0] = Listar.get(i).getId();
            ob[1] = Listar.get(i).getNombre();
            ob[2] = Listar.get(i).getCorreo();
            ob[3] = Listar.get(i).getRol();
            modelo.addRow(ob);
        }
        table_usuarios.setModel(modelo);
    }
    
    //Listar configuracion
    public void ListarConfig() {
        conf = proDao.buscarDatos();
        txt_idConfig.setText("" + conf.getId());
        txt_rutConfig.setText("" + conf.getRut());
        txt_nombreConfig.setText("" + conf.getNombre());
        txt_telefonoConfig.setText("" + conf.getTelefono());
        txt_direccionConfig.setText("" + conf.getDireccion());
        txt_razonConfig.setText("" + conf.getRazon());
    }

    //Metodo limpiar tabla
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_nuevaVenta = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        btn_proveedor = new javax.swing.JButton();
        btn_productoss = new javax.swing.JButton();
        btn_config = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_regUsuarios = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txt_codigoVenta = new javax.swing.JTextField();
        txt_descripcionVenta = new javax.swing.JTextField();
        txt_cantidadVenta = new javax.swing.JTextField();
        txt_precioVenta = new javax.swing.JTextField();
        txt_stockDisponible = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_venta = new javax.swing.JTable();
        btn_eliminarVenta = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txt_rutVenta = new javax.swing.JTextField();
        txt_nombreClienteVenta = new javax.swing.JTextField();
        btn_generarVenta = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();
        txt_telefonoCV = new javax.swing.JTextField();
        txt_direccionCV = new javax.swing.JTextField();
        txt_razonCV = new javax.swing.JTextField();
        txt_idPro = new javax.swing.JTextField();
        label_vendedor = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_rutCliente = new javax.swing.JTextField();
        txt_nombreCliente = new javax.swing.JTextField();
        txt_telefonoCliente = new javax.swing.JTextField();
        txt_direccionCliente = new javax.swing.JTextField();
        txt_razonCliente = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_cliente = new javax.swing.JTable();
        btn_guardarCliente = new javax.swing.JButton();
        btn_editarCliente = new javax.swing.JButton();
        btn_nuevoCliente = new javax.swing.JButton();
        btn_eliminarCliente = new javax.swing.JButton();
        txt_idCliente = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_rutProveedor = new javax.swing.JTextField();
        txt_nombreProveedor = new javax.swing.JTextField();
        txt_telefonoProveedor = new javax.swing.JTextField();
        txt_direccionProveedor = new javax.swing.JTextField();
        txt_razonProveedor = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        table_proveedor = new javax.swing.JTable();
        btn_guardarProveedor = new javax.swing.JButton();
        btn_editarProveedor = new javax.swing.JButton();
        btn_eliminarProveedor = new javax.swing.JButton();
        btn_nuevoProveedor = new javax.swing.JButton();
        txt_idProveedor = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txt_codigoPro = new javax.swing.JTextField();
        txt_descPro = new javax.swing.JTextField();
        txt_cantidadPro = new javax.swing.JTextField();
        txt_precioPro = new javax.swing.JTextField();
        cbx_proveedorPro = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        table_producto = new javax.swing.JTable();
        btn_guardarPro = new javax.swing.JButton();
        btn_editarPro = new javax.swing.JButton();
        btn_elimianrPro = new javax.swing.JButton();
        btn_nuevoPro = new javax.swing.JButton();
        txt_idpro = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        txt_rutConfig = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txt_direccionConfig = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txt_razonConfig = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txt_nombreConfig = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        txt_telefonoConfig = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        txt_idConfig = new javax.swing.JTextField();
        btn_actualizarConfig = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_usuarios = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        btn_registrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbx_rol = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoDuoc.jpg"))); // NOI18N

        btn_nuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo_1.png"))); // NOI18N
        btn_nuevaVenta.setText("Nueva venta");
        btn_nuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaVentaActionPerformed(evt);
            }
        });

        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/objetivo.png"))); // NOI18N
        btn_clientes.setText("Clientes");
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        btn_proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor_1.png"))); // NOI18N
        btn_proveedor.setText("Proveedor");
        btn_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proveedorActionPerformed(evt);
            }
        });

        btn_productoss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paquete.png"))); // NOI18N
        btn_productoss.setText("Productos");
        btn_productoss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productossActionPerformed(evt);
            }
        });

        btn_config.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuraciones.png"))); // NOI18N
        btn_config.setText("Config");
        btn_config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_configActionPerformed(evt);
            }
        });

        jLabel3.setText("Empresa MauwiA3");

        btn_regUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrado.png"))); // NOI18N
        btn_regUsuarios.setText("Reg Usuarios");
        btn_regUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_clientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_proveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_productoss, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_config, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_regUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_nuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_productoss, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_config, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_regUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 620));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Codigo");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Descripcion");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Cantidad");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Precio");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Stock Disponible");

        txt_codigoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoVentaKeyTyped(evt);
            }
        });

        txt_descripcionVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionVentaActionPerformed(evt);
            }
        });
        txt_descripcionVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descripcionVentaKeyTyped(evt);
            }
        });

        txt_cantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cantidadVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadVentaKeyTyped(evt);
            }
        });

        txt_precioVenta.setEditable(false);
        txt_precioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioVentaActionPerformed(evt);
            }
        });

        table_venta.setBackground(new java.awt.Color(102, 102, 102));
        table_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane5.setViewportView(table_venta);
        if (table_venta.getColumnModel().getColumnCount() > 0) {
            table_venta.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_venta.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_venta.getColumnModel().getColumn(2).setPreferredWidth(30);
            table_venta.getColumnModel().getColumn(3).setPreferredWidth(30);
            table_venta.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        btn_eliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btn_eliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarVentaActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Rut");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("Nombre");

        txt_rutVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rutVentaKeyPressed(evt);
            }
        });

        txt_nombreClienteVenta.setEditable(false);

        btn_generarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/print.png"))); // NOI18N
        btn_generarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarVentaActionPerformed(evt);
            }
        });

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/money.png"))); // NOI18N
        jLabel38.setText("Total a pagar:");

        label_total.setText("---------");

        label_vendedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_vendedor.setText("Vendedor: Juanito Alcachofa");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_codigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_descripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(txt_precioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(txt_stockDisponible)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_idPro, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btn_eliminarVenta)
                                .addGap(25, 25, 25))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_rutVenta)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_vendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombreClienteVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_telefonoCV, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_direccionCV, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_razonCV, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_generarVenta)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btn_eliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_codigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_descripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_stockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_precioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_idPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_generarVenta)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_rutVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(label_total)
                            .addComponent(txt_telefonoCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_direccionCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_razonCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_vendedor)))
                .addGap(48, 48, 48))
        );

        jTabbedPane2.addTab("tab1", jPanel8);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Rut");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Nombre");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Teléfono");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Dirección");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Razon social");

        txt_razonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_razonClienteActionPerformed(evt);
            }
        });

        table_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUT", "NOMBRE", "TELÉFONO", "DIRECCIÓN", "RAZON SOCIAL"
            }
        ));
        table_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_clienteMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_cliente);
        if (table_cliente.getColumnModel().getColumnCount() > 0) {
            table_cliente.getColumnModel().getColumn(0).setPreferredWidth(20);
            table_cliente.getColumnModel().getColumn(1).setPreferredWidth(50);
            table_cliente.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_cliente.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_cliente.getColumnModel().getColumn(4).setPreferredWidth(80);
            table_cliente.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        btn_guardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        btn_guardarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarClienteActionPerformed(evt);
            }
        });

        btn_editarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar (2).png"))); // NOI18N
        btn_editarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarClienteActionPerformed(evt);
            }
        });

        btn_nuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btn_nuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoClienteActionPerformed(evt);
            }
        });

        btn_eliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btn_eliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_telefonoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                        .addComponent(txt_direccionCliente)
                                        .addComponent(txt_nombreCliente, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(txt_rutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_razonCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_guardarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_eliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_nuevoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_editarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txt_rutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txt_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txt_telefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txt_direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txt_razonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_guardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_eliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab2", jPanel9);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("RUT:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("NOMBRE:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("TELÉFONO:");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("DIRECCION:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("RAZON SOCIAL:");

        table_proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUT", "NOMBRE", "TELÉFONO", "DIRECCIÓN", "RAZON SOCIAL"
            }
        ));
        table_proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_proveedorMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(table_proveedor);
        if (table_proveedor.getColumnModel().getColumnCount() > 0) {
            table_proveedor.getColumnModel().getColumn(0).setPreferredWidth(20);
            table_proveedor.getColumnModel().getColumn(1).setPreferredWidth(40);
            table_proveedor.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_proveedor.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_proveedor.getColumnModel().getColumn(4).setPreferredWidth(80);
            table_proveedor.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        btn_guardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        btn_guardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarProveedorActionPerformed(evt);
            }
        });

        btn_editarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar (2).png"))); // NOI18N
        btn_editarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarProveedorActionPerformed(evt);
            }
        });

        btn_eliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btn_eliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarProveedorActionPerformed(evt);
            }
        });

        btn_nuevoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btn_nuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_direccionProveedor)
                                    .addComponent(txt_telefonoProveedor)
                                    .addComponent(txt_razonProveedor)
                                    .addComponent(txt_nombreProveedor)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txt_rutProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(txt_idProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_guardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_eliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_editarProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_nuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rutProveedor)
                            .addComponent(txt_idProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telefonoProveedor))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txt_direccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txt_razonProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_guardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_editarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_eliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_nuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel10);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Código:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("Descripción:");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Cantidad:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setText("Precio:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("Proveedor");

        txt_precioPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioProKeyTyped(evt);
            }
        });

        cbx_proveedorPro.setEditable(true);

        table_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CÓDIGO", "DESCRIPCIÓN", "PROVEEDOR", "STOCK", "PRECIO"
            }
        ));
        table_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productoMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(table_producto);
        if (table_producto.getColumnModel().getColumnCount() > 0) {
            table_producto.getColumnModel().getColumn(0).setPreferredWidth(20);
            table_producto.getColumnModel().getColumn(1).setPreferredWidth(50);
            table_producto.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_producto.getColumnModel().getColumn(3).setPreferredWidth(60);
            table_producto.getColumnModel().getColumn(4).setPreferredWidth(40);
            table_producto.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        btn_guardarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GuardarTodo.png"))); // NOI18N
        btn_guardarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarProActionPerformed(evt);
            }
        });

        btn_editarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar (2).png"))); // NOI18N
        btn_editarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarProActionPerformed(evt);
            }
        });

        btn_elimianrPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btn_elimianrPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elimianrProActionPerformed(evt);
            }
        });

        btn_nuevoPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btn_nuevoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_codigoPro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txt_descPro, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_precioPro, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cantidadPro, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idpro, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_nuevoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(btn_guardarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_editarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btn_elimianrPro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(cbx_proveedorPro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(txt_codigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_descPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cantidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(txt_precioPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_proveedorPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_guardarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_editarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_elimianrPro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_nuevoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab4", jPanel11);

        jLabel61.setText("RUT");

        jLabel62.setText("DIRECCIÓN");

        txt_razonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_razonConfigActionPerformed(evt);
            }
        });

        jLabel63.setText("RAZON SOCIAL");

        jLabel64.setText("NOMBRE");

        jLabel65.setText("TELEFONO");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel66.setText("DATOS DE LA EMPRESA");

        btn_actualizarConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Actualizar (2).png"))); // NOI18N
        btn_actualizarConfig.setText("Actualizar");
        btn_actualizarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(161, 161, 161)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel63)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_direccionConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_rutConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombreConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_razonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txt_idConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telefonoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel66))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(btn_actualizarConfig)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel66)
                .addGap(28, 28, 28)
                .addComponent(txt_idConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rutConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefonoConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_direccionConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_razonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(btn_actualizarConfig)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab5", jPanel12);

        table_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "CORREO", "ROL"
            }
        ));
        jScrollPane1.setViewportView(table_usuarios);
        if (table_usuarios.getColumnModel().getColumnCount() > 0) {
            table_usuarios.getColumnModel().getColumn(0).setPreferredWidth(20);
            table_usuarios.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_usuarios.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_usuarios.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciar.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Ingrese Correo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Ingrese contraseña");

        btn_registrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_registrar.setText("Registrar");
        btn_registrar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Nombre:");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("Rol:");

        cbx_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Asistente" }));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoDuoc.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(txt_pass)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_correo)
                            .addComponent(txt_nombre)
                            .addComponent(cbx_rol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btn_registrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab6", jPanel2);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 870, 430));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/concepto-de-encabezado-tipográfico-comercio-planificación-empresarial-y-ventas-crecimiento-las-promoción-operaciones-183304441.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 870, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
        LimpiarTable();
        ListarCliente();
        jTabbedPane2.setSelectedIndex(1);


    }//GEN-LAST:event_btn_clientesActionPerformed

    private void btn_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proveedorActionPerformed
        LimpiarTable();
        ListarProveedor();
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_btn_proveedorActionPerformed

    private void btn_productossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productossActionPerformed
        LimpiarTable();
        ListarProductos();
        jTabbedPane2.setSelectedIndex(3);

    }//GEN-LAST:event_btn_productossActionPerformed

    private void btn_nuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaVentaActionPerformed
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_btn_nuevaVentaActionPerformed

    private void btn_elimianrProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elimianrProActionPerformed
        //eliminar
        if (!"".equals(txt_idPro.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txt_idPro.getText());
                proDao.eliminarProductos(id);
                LimpiarTable();
                LimpiarProductos();
                ListarProductos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        }
    }//GEN-LAST:event_btn_elimianrProActionPerformed

    private void btn_editarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarProActionPerformed

        if ("".equals(txt_idPro.getText())) {
            JOptionPane.showMessageDialog(null, "Seleecione una fila");
        } else {
            if (!"".equals(txt_codigoPro.getText()) || !"".equals(txt_descPro.getText()) || !"".equals(txt_cantidadPro.getText()) || !"".equals(txt_precioPro.getText())) {
                pro.setCodigo(txt_codigoPro.getText());
                pro.setNombre(txt_descPro.getText());
                pro.setProveedor(cbx_proveedorPro.getSelectedItem().toString());
                pro.setStock(Integer.parseInt(txt_cantidadPro.getText()));
                pro.setPrecio(Double.parseDouble(txt_precioPro.getText()));
                pro.setId(Integer.parseInt(txt_idPro.getText()));
                proDao.modificarProductos(pro);

                JOptionPane.showMessageDialog(null, "Producto Modificado!");
                LimpiarTable();
                ListarProductos();
                LimpiarProductos();
            }
        }
    }//GEN-LAST:event_btn_editarProActionPerformed

    private void btn_guardarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarProActionPerformed
        if (!"".equals(txt_codigoPro.getText()) || !"".equals(txt_descPro.getText()) || !"".equals(cbx_proveedorPro.getSelectedItem()) || !"".equals(txt_cantidadPro.getText()) || !"".equals(txt_precioPro.getText())) {

            pro.setCodigo(txt_codigoPro.getText());
            pro.setNombre(txt_descPro.getText());
            pro.setProveedor(cbx_proveedorPro.getSelectedItem().toString());
            pro.setStock(Integer.parseInt(txt_cantidadPro.getText()));
            pro.setPrecio(Double.parseDouble(txt_precioPro.getText()));
            proDao.registrarProductos(pro);

            JOptionPane.showMessageDialog(null, "Producto Registrado!");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios!");
        }
    }//GEN-LAST:event_btn_guardarProActionPerformed

    private void table_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productoMouseClicked

        int fila = table_producto.rowAtPoint(evt.getPoint());
        txt_idPro.setText(table_producto.getValueAt(fila, 0).toString());
        txt_codigoPro.setText(table_producto.getValueAt(fila, 1).toString());
        txt_descPro.setText(table_producto.getValueAt(fila, 2).toString());
        cbx_proveedorPro.setSelectedItem(table_producto.getValueAt(fila, 3).toString());
        txt_cantidadPro.setText(table_producto.getValueAt(fila, 4).toString());
        txt_precioPro.setText(table_producto.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_table_productoMouseClicked

    private void btn_nuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoProveedorActionPerformed
        LimpiarProveedor();
    }//GEN-LAST:event_btn_nuevoProveedorActionPerformed

    private void btn_eliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarProveedorActionPerformed
        if (!"".equals(txt_idProveedor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txt_idProveedor.getText());
                prDao.eliminarProveedor(id);
                LimpiarTable();
                ListarProveedor();
                LimpiarProveedor();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btn_eliminarProveedorActionPerformed

    private void btn_editarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarProveedorActionPerformed
        if ("".equals(txt_idProveedor.getText())) {
            JOptionPane.showMessageDialog(null, "Seleecione una fila");
        } else {
            if (!"".equals(txt_rutProveedor.getText()) || !"".equals(txt_nombreProveedor.getText()) || !"".equals(txt_telefonoProveedor.getText()) || !"".equals(txt_direccionProveedor.getText())) {
                pr.setRut(Integer.parseInt(txt_rutProveedor.getText()));
                pr.setNombre(txt_nombreProveedor.getText());
                pr.setTelefono(Integer.parseInt(txt_telefonoProveedor.getText()));
                pr.setDireccion(txt_direccionProveedor.getText());
                pr.setRazon(txt_razonProveedor.getText());
                pr.setId(Integer.parseInt(txt_idProveedor.getText()));
                prDao.modificarProveedor(pr);
                JOptionPane.showMessageDialog(null, "Proveedor Modificado!");
                LimpiarTable();
                ListarProveedor();
                LimpiarProveedor();
            }
        }
    }//GEN-LAST:event_btn_editarProveedorActionPerformed

    private void btn_guardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarProveedorActionPerformed
        //Guardar proveedor
        if (!"".equals(txt_rutProveedor.getText()) || !"".equals(txt_nombreProveedor.getText()) || !"".equals(txt_telefonoProveedor.getText()) || !"".equals(txt_direccionProveedor.getText())) {
            pr.setRut(Integer.parseInt(txt_rutProveedor.getText()));
            pr.setNombre(txt_nombreProveedor.getText());
            pr.setTelefono(Integer.parseInt(txt_telefonoProveedor.getText()));
            pr.setDireccion(txt_direccionProveedor.getText());
            pr.setRazon(txt_razonProveedor.getText());

            prDao.registrarProveedor(pr);
            JOptionPane.showMessageDialog(null, "Proveedor Registrado!");
            LimpiarTable();
            ListarProveedor();
            LimpiarProveedor();

        } else {
            JOptionPane.showMessageDialog(null, "Los campos esta vacios!");
        }
    }//GEN-LAST:event_btn_guardarProveedorActionPerformed

    private void table_proveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_proveedorMouseClicked
        int fila = table_proveedor.rowAtPoint(evt.getPoint());
        txt_idProveedor.setText(table_proveedor.getValueAt(fila, 0).toString());
        txt_rutProveedor.setText(table_proveedor.getValueAt(fila, 1).toString());
        txt_nombreProveedor.setText(table_proveedor.getValueAt(fila, 2).toString());
        txt_telefonoProveedor.setText(table_proveedor.getValueAt(fila, 3).toString());
        txt_direccionProveedor.setText(table_proveedor.getValueAt(fila, 4).toString());
        txt_razonProveedor.setText(table_proveedor.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_table_proveedorMouseClicked

    private void btn_eliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarClienteActionPerformed
        //Boton eliminar cliente
        if (!"".equals(txt_idCliente.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txt_idCliente.getText());
                client.eliminarCliente(id);
                LimpiarTable();
                LimpiarCliente();
                ListarCliente();
            }
        }
    }//GEN-LAST:event_btn_eliminarClienteActionPerformed

    private void btn_nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoClienteActionPerformed
        LimpiarCliente();
    }//GEN-LAST:event_btn_nuevoClienteActionPerformed

    private void btn_editarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarClienteActionPerformed
        //Boton editar cliente
        if ("".equals(txt_idCliente.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (!"".equals(txt_rutCliente.getText()) || !"".equals(txt_nombreCliente.getText()) || !"".equals(txt_telefonoCliente.getText())) {
                cl.setRut(Integer.parseInt(txt_rutCliente.getText()));
                cl.setNombre(txt_nombreCliente.getText());
                cl.setTelefono(Integer.parseInt(txt_telefonoCliente.getText()));
                cl.setDireccion(txt_direccionCliente.getText());
                cl.setRazon(txt_razonCliente.getText());
                cl.setId(Integer.parseInt(txt_idCliente.getText()));
                client.modificarCliente(cl);

                JOptionPane.showMessageDialog(null, "Cliente Modificado!");
                LimpiarTable();
                ListarCliente();
                LimpiarCliente();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios!");
            }
        }
    }//GEN-LAST:event_btn_editarClienteActionPerformed

    private void btn_guardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarClienteActionPerformed
        //Guardando registros
        if (!"".equals(txt_rutCliente.getText()) || !"".equals(txt_nombreCliente.getText()) || !"".equals(txt_telefonoCliente.getText()) || !"".equals(txt_direccionCliente.getText())) {
            cl.setRut(Integer.parseInt(txt_rutCliente.getText()));
            cl.setNombre(txt_nombreCliente.getText());
            cl.setTelefono(Integer.parseInt(txt_telefonoCliente.getText()));
            cl.setDireccion(txt_direccionCliente.getText());
            cl.setRazon(txt_razonCliente.getText());
            client.registrarCliente(cl);
            LimpiarTable();
            LimpiarCliente();
            ListarCliente();
            JOptionPane.showMessageDialog(null, "Cliente Registrado!");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios!");
        }
    }//GEN-LAST:event_btn_guardarClienteActionPerformed

    private void table_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clienteMouseClicked

        int fila = table_cliente.rowAtPoint(evt.getPoint());
        txt_idCliente.setText(table_cliente.getValueAt(fila, 0).toString());
        txt_rutCliente.setText(table_cliente.getValueAt(fila, 1).toString());
        txt_nombreCliente.setText(table_cliente.getValueAt(fila, 2).toString());
        txt_telefonoCliente.setText(table_cliente.getValueAt(fila, 3).toString());
        txt_direccionCliente.setText(table_cliente.getValueAt(fila, 4).toString());
        txt_razonCliente.setText(table_cliente.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_table_clienteMouseClicked

    private void txt_razonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_razonClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_razonClienteActionPerformed

    private void btn_generarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarVentaActionPerformed
        if (table_venta.getRowCount() > 0) {
            if (!"".equals(txt_nombreClienteVenta.getText())) {
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();
                LimpiarTableVenta();
                LimpiarClienteVenta();
            } else {
                JOptionPane.showMessageDialog(null, "Debes buscar un cliente!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Noy productos en la venta!");
        }
    }//GEN-LAST:event_btn_generarVentaActionPerformed

    private void txt_rutVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rutVentaKeyPressed
        //Validacion para el rut en la ventana venta
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txt_rutVenta.getText())) {
                int rut = Integer.parseInt(txt_rutVenta.getText());
                cl = client.buscarcliente(rut);

                if (cl.getNombre() != null) {
                    txt_nombreClienteVenta.setText("" + cl.getNombre());
                    txt_telefonoCV.setText("" + cl.getTelefono());
                    txt_direccionCV.setText("" + cl.getDireccion());
                    txt_razonCV.setText("" + cl.getRazon());
                } else {
                    txt_rutVenta.setText("");
                    JOptionPane.showMessageDialog(null, "El cliente no existe!");
                }
            }
        }
    }//GEN-LAST:event_txt_rutVentaKeyPressed

    private void btn_eliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarVentaActionPerformed
        //Eliminar una venta
        modelo = (DefaultTableModel) table_venta.getModel();
        modelo.removeRow(table_venta.getSelectedRow());
        TotalPagar();
        txt_codigoVenta.requestFocus();
    }//GEN-LAST:event_btn_eliminarVentaActionPerformed

    private void txt_cantidadVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadVentaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txt_cantidadVenta.getText())) {
                String cod = txt_codigoVenta.getText();
                String descripcion = txt_descripcionVenta.getText();
                int cant = Integer.parseInt(txt_cantidadVenta.getText());
                double precio = Double.parseDouble(txt_precioVenta.getText());
                double total = cant * precio;
                int stock = Integer.parseInt(txt_stockDisponible.getText());
                if (stock >= cant) {
                    item = item + 1;
                    tmp = (DefaultTableModel) table_venta.getModel();
                    for (int i = 0; i < table_venta.getRowCount(); i++) {
                        if (table_venta.getValueAt(i, 1).equals(txt_descripcionVenta.getText())) {
                            JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(cod);
                    lista.add(descripcion);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] O = new Object[5];
                    O[0] = lista.get(1);
                    O[1] = lista.get(2);
                    O[2] = lista.get(3);
                    O[3] = lista.get(4);
                    O[4] = lista.get(5);
                    tmp.addRow(O);
                    table_venta.setModel(tmp);
                    TotalPagar();
                    LimparVenta();
                    txt_codigoVenta.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
            }
        }
    }//GEN-LAST:event_txt_cantidadVentaKeyPressed

    private void txt_descripcionVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionVentaActionPerformed

    private void txt_codigoVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoVentaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txt_codigoVenta.getText())) {
                String cod = txt_codigoVenta.getText();
                pro = proDao.buscarPro(cod);

                if (pro.getNombre() != null) {
                    txt_descripcionVenta.setText("" + pro.getNombre());
                    txt_precioVenta.setText("" + pro.getPrecio());
                    txt_stockDisponible.setText("" + pro.getStock());
                    txt_cantidadVenta.requestFocus();
                } else {
                    LimparVenta();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el codigo del productos");
                txt_codigoVenta.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_codigoVentaKeyPressed

    private void txt_razonConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_razonConfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_razonConfigActionPerformed

    private void txt_codigoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoVentaKeyTyped
        //Validaciones de los campos
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txt_codigoVentaKeyTyped

    private void txt_descripcionVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripcionVentaKeyTyped
        //Validaciones de los campos
        event.textKeyPress(evt);
    }//GEN-LAST:event_txt_descripcionVentaKeyTyped

    private void txt_cantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadVentaKeyTyped
        //Validaciones de los campos
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txt_cantidadVentaKeyTyped

    private void txt_precioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioVentaActionPerformed

    private void txt_precioProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioProKeyTyped
        event.numberDecimalKeyPress(evt, txt_precioPro);
    }//GEN-LAST:event_txt_precioProKeyTyped

    private void btn_actualizarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarConfigActionPerformed
        if (!"".equals(txt_rutConfig.getText()) || !"".equals(txt_nombreConfig.getText()) || !"".equals(txt_telefonoConfig.getText()) || !"".equals(txt_direccionConfig.getText())) {
                
                conf.setRut(Integer.parseInt(txt_rutConfig.getText()));
                conf.setNombre(txt_nombreConfig.getText());
                conf.setTelefono(Integer.parseInt(txt_telefonoConfig.getText()));
                conf.setDireccion(txt_direccionConfig.getText());
                conf.setRazon(txt_razonConfig.getText());
                conf.setId(Integer.parseInt(txt_idConfig.getText()));
                proDao.modificarDatos(conf);

                JOptionPane.showMessageDialog(null, "Datos de la empresa modificados!");
                ListarConfig();
                
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios!");
            }
    }//GEN-LAST:event_btn_actualizarConfigActionPerformed

    private void btn_configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_configActionPerformed
        jTabbedPane2.setSelectedIndex(4);
    }//GEN-LAST:event_btn_configActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        if(txt_nombre.getText().equals("") || txt_correo.getText().equals("") || txt_pass.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "Todo los campos son requeridos");
        }else{
            String correo = txt_correo.getText();
            String pass = String.valueOf(txt_pass.getPassword());
            String nom = txt_nombre.getText();
            String rol = cbx_rol.getSelectedItem().toString();
            lg.setNombre(nom);
            lg.setCorreo(correo);
            lg.setPass(pass);
            lg.setRol(rol);
            login.registrar(lg);
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            LimpiarTable();
            ListarUsuarios();
            nuevoUsuario();
        }
    }//GEN-LAST:event_btn_registrarActionPerformed
     private void nuevoUsuario(){
        txt_nombre.setText("");
        txt_correo.setText("");
        txt_pass.setText("");
    }
     
    private void btn_regUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regUsuariosActionPerformed
        jTabbedPane2.setSelectedIndex(5);
        LimpiarTable();
    }//GEN-LAST:event_btn_regUsuariosActionPerformed

    private void btn_nuevoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoProActionPerformed
        LimpiarProductos();
    }//GEN-LAST:event_btn_nuevoProActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Sistema().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizarConfig;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_config;
    private javax.swing.JButton btn_editarCliente;
    private javax.swing.JButton btn_editarPro;
    private javax.swing.JButton btn_editarProveedor;
    private javax.swing.JButton btn_elimianrPro;
    private javax.swing.JButton btn_eliminarCliente;
    private javax.swing.JButton btn_eliminarProveedor;
    private javax.swing.JButton btn_eliminarVenta;
    private javax.swing.JButton btn_generarVenta;
    private javax.swing.JButton btn_guardarCliente;
    private javax.swing.JButton btn_guardarPro;
    private javax.swing.JButton btn_guardarProveedor;
    private javax.swing.JButton btn_nuevaVenta;
    private javax.swing.JButton btn_nuevoCliente;
    private javax.swing.JButton btn_nuevoPro;
    private javax.swing.JButton btn_nuevoProveedor;
    private javax.swing.JButton btn_productoss;
    private javax.swing.JButton btn_proveedor;
    private javax.swing.JButton btn_regUsuarios;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JComboBox<String> cbx_proveedorPro;
    private javax.swing.JComboBox<String> cbx_rol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel label_vendedor;
    private javax.swing.JTable table_cliente;
    private javax.swing.JTable table_producto;
    private javax.swing.JTable table_proveedor;
    private javax.swing.JTable table_usuarios;
    private javax.swing.JTable table_venta;
    private javax.swing.JTextField txt_cantidadPro;
    private javax.swing.JTextField txt_cantidadVenta;
    private javax.swing.JTextField txt_codigoPro;
    private javax.swing.JTextField txt_codigoVenta;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_descPro;
    private javax.swing.JTextField txt_descripcionVenta;
    private javax.swing.JTextField txt_direccionCV;
    private javax.swing.JTextField txt_direccionCliente;
    private javax.swing.JTextField txt_direccionConfig;
    private javax.swing.JTextField txt_direccionProveedor;
    private javax.swing.JTextField txt_idCliente;
    private javax.swing.JTextField txt_idConfig;
    private javax.swing.JTextField txt_idPro;
    private javax.swing.JTextField txt_idProveedor;
    private javax.swing.JTextField txt_idpro;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_nombreClienteVenta;
    private javax.swing.JTextField txt_nombreConfig;
    private javax.swing.JTextField txt_nombreProveedor;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_precioPro;
    private javax.swing.JTextField txt_precioVenta;
    private javax.swing.JTextField txt_razonCV;
    private javax.swing.JTextField txt_razonCliente;
    private javax.swing.JTextField txt_razonConfig;
    private javax.swing.JTextField txt_razonProveedor;
    private javax.swing.JTextField txt_rutCliente;
    private javax.swing.JTextField txt_rutConfig;
    private javax.swing.JTextField txt_rutProveedor;
    private javax.swing.JTextField txt_rutVenta;
    private javax.swing.JTextField txt_stockDisponible;
    private javax.swing.JTextField txt_telefonoCV;
    private javax.swing.JTextField txt_telefonoCliente;
    private javax.swing.JTextField txt_telefonoConfig;
    private javax.swing.JTextField txt_telefonoProveedor;
    // End of variables declaration//GEN-END:variables
private void LimpiarCliente() {
        txt_idCliente.setText("");
        txt_rutCliente.setText("");
        txt_nombreCliente.setText("");
        txt_telefonoCliente.setText("");
        txt_direccionCliente.setText("");
        txt_razonCliente.setText("");
    }

    private void LimpiarProveedor() {
        txt_idProveedor.setText("");
        txt_rutProveedor.setText("");
        txt_nombreProveedor.setText("");
        txt_telefonoProveedor.setText("");
        txt_direccionProveedor.setText("");
        txt_razonProveedor.setText("");
    }

    private void LimpiarProductos() {
        txt_idPro.setText("");
        txt_codigoPro.setText("");
        cbx_proveedorPro.setSelectedItem(null);
        txt_descPro.setText("");
        txt_cantidadPro.setText("");
        txt_precioPro.setText("");
    }

    private void TotalPagar() {
        totalPagar = 0.00;
        int numFila = table_venta.getRowCount();

        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(table_venta.getModel().getValueAt(i, 4)));
            totalPagar = totalPagar + cal;
        }
        label_total.setText(String.format("%.2f", totalPagar));
    }

    private void LimparVenta() {
        txt_codigoVenta.setText("");
        txt_descripcionVenta.setText("");
        txt_cantidadVenta.setText("");
        txt_stockDisponible.setText("");
        txt_precioVenta.setText("");
    }

    private void RegistrarVenta() {
        String cliente = txt_nombreClienteVenta.getText();
        String vendedor = label_vendedor.getText();
        double monto = totalPagar;
        vent.setCliente(cliente);
        vent.setVendedor(vendedor);
        vent.setTotal(monto);

        vdao.registrarVenta(vent);
    }

    private void RegistrarDetalle() {
        int id = vdao.idVenta();
        for (int i = 0; i < table_venta.getRowCount(); i++) {
            String cod = table_venta.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(table_venta.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(table_venta.getValueAt(i, 3).toString());

            dt.setCod_pro(cod);
            dt.setCantidad(cant);
            dt.setPrecio(precio);
            dt.setId(id);
            vdao.registrarDetalle(dt);
        }
    }

    private void ActualizarStock() {
        for (int i = 0; i < table_venta.getRowCount(); i++) {
            String cod = table_venta.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(table_venta.getValueAt(i, 2).toString());
            pro = proDao.buscarPro(cod);
            int StockActual = pro.getStock() - cant;
            vdao.actualizarStock(StockActual, cod);

        }
    }

    private void LimpiarTableVenta() {
        tmp = (DefaultTableModel) table_venta.getModel();
        int fila = table_venta.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }

    private void LimpiarClienteVenta() {
        txt_rutVenta.setText("");
        txt_nombreClienteVenta.setText("");
        txt_telefonoCV.setText("");
        txt_direccionCV.setText("");
        txt_razonCV.setText("");
    }

}
