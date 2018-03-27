package ovh.ecliment.cjee.piloto.domini;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Equips , classe amb anotacions per a Hibernate
 */
@Entity
@Table(name = "EQUIPOS",
         schema = "PUBLIC",
         catalog = "PUBLIC"
)
public class Equip implements java.io.Serializable {

    @Id
    @GenericGenerator(name="increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    @Column(name = "ID_EQUIPO", unique = true, nullable = false)
    private Integer idEquip;
    @Column(name = "NOMBRE", length = 200)
    private String nom;
    @Column(name = "DIRECCION", length = 500)
    private String direccio;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipByIdEquipLocal")
    private Set<Partit> partitsForIdEquipLocal = new HashSet<Partit>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipByIdEquipVisitant")
    private Set<Partit> partitsForIdEquipVisitant = new HashSet<Partit>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equip")
    private Set<Jugador> jugadors = new HashSet<Jugador>(0);

    public Equip() {
    }

    public Equip(Integer idEquip) {
        this.idEquip = idEquip;
    }

    public Equip(Integer idEquipo, String no, String direccio,
            Set<Partit> partitsForIdEquipLocal,
            Set<Partit> partitsForIdEquipVisitant, Set<Jugador> jugadors) {
        this.idEquip = idEquip;
        this.nom = nom;
        this.direccio = direccio;
        this.partitsForIdEquipLocal = partitsForIdEquipLocal;
        this.partitsForIdEquipVisitant = partitsForIdEquipVisitant;
        this.jugadors = jugadors;
    }

    public Integer getIdEquip() {
        return this.idEquip;
    }

    public void setIdEquip(int idEquip) {
        this.idEquip = idEquip;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNombre(String nom) {
        this.nom = nom;
    }

    public String getDireccion() {
        return this.direccio;
    }

    public void setDireccion(String direccio) {
        this.direccio = direccio;
    }

    public Set<Partit> getPartitsForIdEquipLocal() {
        return this.partitsForIdEquipLocal;
    }

    public void setPartitsForIdEquipLocal(Set<Partit> partitsForIdEquipLocal) {
        this.partitsForIdEquipLocal = partitsForIdEquipLocal;
    }

    public Set<Partit> getPartidtsForIdEquipVisitant() {
        return this.partitsForIdEquipVisitant;
    }

    public void setPartitsForIdEquipVisitant(Set<Partit> partitsForIdEquipVisitant) {
        this.partitsForIdEquipVisitant = partitsForIdEquipVisitant;
    }

    public Set<Jugador> getJugadors() {
        return this.jugadors;
    }

    public void setJugadors(Set<Jugador> jugadors) {
        this.jugadors = jugadors;
    }

// Overrides necesaris per a la UI web
    @Override
    public boolean equals(Object obj) {
        boolean igual = false;
        if (obj instanceof Equip) {
            igual = ((Equip) obj).getIdEquip() == this.idEquip;
        }
        if (obj instanceof Integer) {
            igual = ((Integer) obj).intValue() == this.idEquip.intValue();
        }
        return igual;
    }

    @Override
    public String toString() {        
        return this.nom;
    }
}
