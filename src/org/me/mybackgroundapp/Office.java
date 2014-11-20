/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.mybackgroundapp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "OFFICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Office.findAll", query = "SELECT o FROM Office o"),
    @NamedQuery(name = "Office.findByOnumber", query = "SELECT o FROM Office o WHERE o.onumber = :onumber"),
    @NamedQuery(name = "Office.findByOtele", query = "SELECT o FROM Office o WHERE o.otele = :otele")})
public class Office implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ONUMBER")
    private BigDecimal onumber;
    @Basic(optional = false)
    @Column(name = "OTELE")
    private BigInteger otele;
    @OneToMany(mappedBy = "fOffice")
    private Collection<Nurse_1> nurseCollection;

    public Office() {
    }

    public Office(BigDecimal onumber) {
        this.onumber = onumber;
    }

    public Office(BigDecimal onumber, BigInteger otele) {
        this.onumber = onumber;
        this.otele = otele;
    }

    public BigDecimal getOnumber() {
        return onumber;
    }

    public void setOnumber(BigDecimal onumber) {
        this.onumber = onumber;
    }

    public BigInteger getOtele() {
        return otele;
    }

    public void setOtele(BigInteger otele) {
        this.otele = otele;
    }

    @XmlTransient
    public Collection<Nurse_1> getNurseCollection() {
        return nurseCollection;
    }

    public void setNurseCollection(Collection<Nurse_1> nurseCollection) {
        this.nurseCollection = nurseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (onumber != null ? onumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Office)) {
            return false;
        }
        Office other = (Office) object;
        if ((this.onumber == null && other.onumber != null) || (this.onumber != null && !this.onumber.equals(other.onumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.me.mybackgroundapp.Office[ onumber=" + onumber + " ]";
    }
    
}
