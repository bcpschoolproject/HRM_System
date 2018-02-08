/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrm;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DelaTorreNelson
 */
@MappedSuperclass
@Table(name = "contact")
@XmlRootElement
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contact_id")
    private Integer contactId;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "telephone_no")
    private int telephoneNo;
    @Basic(optional = false)
    @Column(name = "cellphone_no")
    private long cellphoneNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId")
    private Collection<Guests> guestsCollection;

    public Contact() {
    }

    public Contact(Integer contactId) {
        this.contactId = contactId;
    }

    public Contact(Integer contactId, String email, int telephoneNo, long cellphoneNo) {
        this.contactId = contactId;
        this.email = email;
        this.telephoneNo = telephoneNo;
        this.cellphoneNo = cellphoneNo;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(int telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public long getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(long cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    @XmlTransient
    public Collection<Guests> getGuestsCollection() {
        return guestsCollection;
    }

    public void setGuestsCollection(Collection<Guests> guestsCollection) {
        this.guestsCollection = guestsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hrm.Contact[ contactId=" + contactId + " ]";
    }
    
}
