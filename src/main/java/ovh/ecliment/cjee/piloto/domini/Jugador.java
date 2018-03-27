package ovh.ecliment.cjee.piloto.domini;
// Generated 26-mar-2018 13:41:13 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Jugador, classe amb anotacions per a Hibernate
 */
@Entity
@Table(name = "JUGADORES",
        schema = "PUBLIC",
        catalog = "PUBLIC"
)
public class Jugador implements java.io.Serializable {

    @Id
    @GenericGenerator(name="increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    @Column(name = "ID_JUGADOR", unique = true, nullable = false)
    private Integer idJugador;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EQUIPO")
    private Equip equip;
    @Column(name = "NOMBRE", length = 200)
    private String nom;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_NACIMIENTO", length = 10)
    private Date dataNaixement;
    @Column(name = "DIRECCION", length = 500)
    private String direccio;

    public Jugador() {
    }

    public Jugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador(Integer idJugador, Equip equipos, String nombre, Date fechaNacimiento, String direccion) {
        this.idJugador = idJugador;
        this.equip = equipos;
        this.nom = nombre;
        this.dataNaixement = fechaNacimiento;
        this.direccio = direccion;
    }

    public int getIdJugador() {
        return this.idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public Equip getEquip() {
        return this.equip;
    }

    public void setEquip(Equip equip) {
        this.equip = equip;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDataNaixement() {
        return this.dataNaixement;
    }

    public void setDataNaixement(Date dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public String getDireccio() {
        return this.direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

}
