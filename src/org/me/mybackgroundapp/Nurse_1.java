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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author click
 */
@Entity
@Table(name = "NURSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nurse_1.findAll", query = "SELECT n FROM Nurse_1 n"),
    @NamedQuery(name = "Nurse_1.findById", query = "SELECT n FROM Nurse_1 n WHERE n.id = :id"),
    @NamedQuery(name = "Nurse_1.findByNoOfHours", query = "SELECT n FROM Nurse_1 n WHERE n.noOfHours = :noOfHours")})
public class Nurse_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "NO_OF_HOURS")
    private String noOfHours;
    @OneToMany(mappedBy = "nurseId")
    private Collection<Bed> bedCollection;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "F_OFFICE", referencedColumnName = "ONUMBER")
    @ManyToOne
    private Office fOffice;

    public Nurse_1() {
    }

    public Nurse_1(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(String noOfHours) {
        this.noOfHours = noOfHours;
    }

    @XmlTransient
    public Collection<Bed> getBedCollection() {
        return bedCollection;
    }

    public void setBedCollection(Collection<Bed> bedCollection) {
        this.bedCollection = bedCollection;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Office getFOffice() {
        return fOffice;
    }

    public void setFOffice(Office fOffice) {
        this.fOffice = fOffice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nurse_1)) {
            return false;
        }
        Nurse_1 other = (Nurse_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.me.mybackgroundapp.Nurse_1[ id=" + id + " ]";
    }
    
}
