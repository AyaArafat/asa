/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.mybackgroundapp;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author click
 */
@Entity
@Table(name = "USERPASS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userpass.findAll", query = "SELECT u FROM Userpass u"),
    @NamedQuery(name = "Userpass.findByUsername", query = "SELECT u FROM Userpass u WHERE u.username = :username"),
    @NamedQuery(name = "Userpass.findByPassword", query = "SELECT u FROM Userpass u WHERE u.password = :password"),
    @NamedQuery(name = "Userpass.findByTypee", query = "SELECT u FROM Userpass u WHERE u.typee = :typee")})
public class Userpass implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private BigDecimal username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TYPEE")
    private String typee;

    public Userpass() {
    }

    public Userpass(BigDecimal username) {
        this.username = username;
    }

    public Userpass(BigDecimal username, String password) {
        this.username = username;
        this.password = password;
    }

    public BigDecimal getUsername() {
        return username;
    }

    public void setUsername(BigDecimal username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypee() {
        return typee;
    }

    public void setTypee(String typee) {
        this.typee = typee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userpass)) {
            return false;
        }
        Userpass other = (Userpass) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.me.mybackgroundapp.Userpass[ username=" + username + " ]";
    }
    
}
