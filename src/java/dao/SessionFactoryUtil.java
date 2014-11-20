package dao;

import entidade.Fornecedor;
import entidade.FornecedorPeca;
import entidade.Usuario;
import entidade.OS;
import entidade.OSServico;
import entidade.Servico;
import entidade.OSPeca;
import entidade.Funcionario;
import entidade.Peca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

/**
 *
 * @author Heitor
 */
public class SessionFactoryUtil {

    private static AnnotationConfiguration cfg;
    /** The single instance of hibernate SessionFactory */
    private static org.hibernate.SessionFactory sessionFactory;  
    
    
    public static void main(String[] args) {
        initiate();
    }

    public static void initiate() {
        if (cfg == null) {
            try {
                cfg = new AnnotationConfiguration();
                cfg.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
                cfg.setProperty("hibernate.current_session_context_class", "thread");
                cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                String driver = "com.mysql.jdbc.Driver";
//                cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//                String driver = "org.postgresql.Driver";
//                String driver = "org.my.Driver";
                cfg.setProperty("hibernate.connection.driver_class", driver);
                cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/controle_os");
//                cfg.setProperty("hibernate.connection.username", "root");
//                cfg.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost/controle_os");
                cfg.setProperty("hibernate.connection.username", "root");
                cfg.setProperty("hibernate.connection.password", "vertrigo");
//                cfg.setProperty("hibernate.hbm2dll.auto", "validate");  
                cfg.setProperty("hibernate.hbm2dll.auto", "validate");  
                
                //ENTIDADES
                cfg.addAnnotatedClass(Fornecedor.class);
                cfg.addAnnotatedClass(FornecedorPeca.class);
                cfg.addAnnotatedClass(Funcionario.class);
                cfg.addAnnotatedClass(OS.class); 
                cfg.addAnnotatedClass(OSPeca.class);
                cfg.addAnnotatedClass(OSServico.class);
                cfg.addAnnotatedClass(Servico.class);
                cfg.addAnnotatedClass(Peca.class);
                cfg.addAnnotatedClass(Usuario.class);
                //
                
                sessionFactory = cfg.buildSessionFactory();
                updateDatabase();
            } catch (Exception ex) {
                cfg = null;
                throw new RuntimeException(ex);
            }
        }
    }
    
    public static Session openSession(Connection connection) {
        if (sessionFactory == null) {
            Logger.getLogger(SessionFactoryUtil.class.getName()).info("Iniciando SessionFactory.");
            initiate();
        }
        Session session = sessionFactory.openSession();
        return session;
    }
    
    public static Connection openConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/controle_os", "root", "vertrigo");
            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private static void updateDatabase() {
        new SchemaUpdate(cfg).execute(true, true);
    }    
    
}
