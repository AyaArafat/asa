/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.mybackgroundapp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author click
 */
@Entity
@Table(name = "BED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bed.findAll", query = "SELECT b FROM Bed b"),
    @NamedQuery(name = "Bed.findByBedNo", query = "SELECT b FROM Bed b WHERE b.bedNo = :bedNo")})
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "BED_NO")
    private BigDecimal bedNo;
    @JoinColumn(name = "NURSE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Nurse_1 nurseId;
    @OneToMany(mappedBy = "bedId")
    private Collection<Patient> patientCollection;

    public Bed() {
    }

    public Bed(BigDecimal bedNo) {
        this.bedNo = bedNo;
    }

    public BigDecimal getBedNo() {
        return bedNo;
    }

    public void setBedNo(BigDecimal bedNo) {
        this.bedNo = bedNo;
    }

    public Nurse_1 getNurseId() {
        return nurseId;
    }

    public void setNurseId(Nurse_1 nurseId) {
        this.nurseId = nurseId;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bedNo != null ? bedNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bed)) {
            return false;
        }
        Bed other = (Bed) object;
        if ((this.bedNo == null && other.bedNo != null) || (this.bedNo != null && !this.bedNo.equals(other.bedNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.me.mybackgroundapp.Bed[ bedNo=" + bedNo + " ]";
    }
    
}
