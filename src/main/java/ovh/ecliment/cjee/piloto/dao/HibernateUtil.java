/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.dao;

import com.fasterxml.classmate.AnnotationConfiguration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import ovh.ecliment.cjee.piloto.domini.Equip;
import ovh.ecliment.cjee.piloto.domini.Jugador;
import ovh.ecliment.cjee.piloto.domini.Partit;


/**
 * @author ecliment
 */
public class HibernateUtil {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction tx;

    public static Session getSession() {
        if (session == null) {
            getSessionFactory();
            return sessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession() {
        session.close();
        session = null;
    }

    public static void beginTransaction() {
        if (tx == null) {
            tx = getSession().beginTransaction();
        }
    }

    public static void endTransaction() {
        tx.commit();
        tx = null;
    }

    public static SessionFactory getSessionFactory() {
        
            try {                
                // Create registry builder
                StandardServiceRegistryBuilder registryBuilder = 
                        new StandardServiceRegistryBuilder();

                
                Map<String, String> settings = new HashMap<>();
                settings.put(Environment.DRIVER, "org.hsqldb.jdbcDriver");
                settings.put(Environment.URL,
                        "jdbc:hsqldb:hsql://localhost/futbol");
                settings.put(Environment.USER, "sa");
                settings.put(Environment.PASS, "");
                settings.put(Environment.DIALECT, 
                        "org.hibernate.dialect.HSQLDialect");
                
                

                // Apply settings
                registryBuilder.applySettings(settings);
                              
                // Create registry
                registry = registryBuilder.build();
                

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);             
                // Configurem les classes amb anotacions
                
                sources.addAnnotatedClass(Partit.class);
                sources.addAnnotatedClass(Equip.class);
                sources.addAnnotatedClass(Jugador.class);
                
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                
               

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
               

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
