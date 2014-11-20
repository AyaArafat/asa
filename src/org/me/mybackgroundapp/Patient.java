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
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author click
 */
@Entity
@Table(name = "PATIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.insertall", query = "insert into "),

    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findBySsn", query = "SELECT p FROM Patient p WHERE p.ssn = :ssn"),
    @NamedQuery(name = "Patient.findByFname", query = "SELECT p FROM Patient p WHERE p.fname = :fname"),
    @NamedQuery(name = "Patient.findBySname", query = "SELECT p FROM Patient p WHERE p.sname = :sname"),
    @NamedQuery(name = "Patient.findByLname", query = "SELECT p FROM Patient p WHERE p.lname = :lname"),
    @NamedQuery(name = "Patient.findByDateBirth", query = "SELECT p FROM Patient p WHERE p.dateBirth = :dateBirth"),
    @NamedQuery(name = "Patient.findByInssuranceType", query = "SELECT p FROM Patient p WHERE p.inssuranceType = :inssuranceType"),
    @NamedQuery(name = "Patient.findByInssuranceRebate", query = "SELECT p FROM Patient p WHERE p.inssuranceRebate = :inssuranceRebate"),
    @NamedQuery(name = "Patient.findByTel", query = "SELECT p FROM Patient p WHERE p.tel = :tel"),
    @NamedQuery(name = "Patient.findByMobile", query = "SELECT p FROM Patient p WHERE p.mobile = :mobile"),
    @NamedQuery(name = "Patient.findByBloodType", query = "SELECT p FROM Patient p WHERE p.bloodType = :bloodType"),
    @NamedQuery(name = "Patient.findBySex", query = "SELECT p FROM Patient p WHERE p.sex = :sex"),
    @NamedQuery(name = "Patient.findByCity", query = "SELECT p FROM Patient p WHERE p.city = :city"),
    @NamedQuery(name = "Patient.findByStreet", query = "SELECT p FROM Patient p WHERE p.street = :street"),
    @NamedQuery(name = "Patient.findByZip", query = "SELECT p FROM Patient p WHERE p.zip = :zip"),
    @NamedQuery(name = "Patient.findByDateIn", query = "SELECT p FROM Patient p WHERE p.dateIn = :dateIn"),
    @NamedQuery(name = "Patient.findByDateOut", query = "SELECT p FROM Patient p WHERE p.dateOut = :dateOut"),
    @NamedQuery(name = "Patient.findByPatientIn", query = "SELECT p FROM Patient p WHERE p.patientIn = :patientIn"),
    @NamedQuery(name = "Patient.findByPatientOut", query = "SELECT p FROM Patient p WHERE p.patientOut = :patientOut")})
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SSN")
    private BigDecimal ssn;
    @Basic(optional = false)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @Column(name = "SNAME")
    private String sname;
    @Basic(optional = false)
    @Column(name = "LNAME")
    private String lname;
    @Basic(optional = false)
    @Column(name = "DATE_BIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBirth;
    @Column(name = "INSSURANCE_TYPE")
    private String inssuranceType;
    @Column(name = "INSSURANCE_REBATE")
    private BigInteger inssuranceRebate;
    @Column(name = "TEL")
    private String tel;
    @Basic(optional = false)
    @Column(name = "MOBILE")
    private String mobile;
    @Basic(optional = false)
    @Column(name = "BLOOD_TYPE")
    private String bloodType;
    @Column(name = "SEX")
    private String sex;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "DATE_IN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIn;
    @Column(name = "DATE_OUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOut;
    @Column(name = "PATIENT_IN")
    private Character patientIn;
    @Column(name = "PATIENT_OUT")
    private Character patientOut;
    @JoinTable(name = "GIVES_APPOINTMENT", joinColumns = {
        @JoinColumn(name = "PATIENT_SSN", referencedColumnName = "SSN")}, inverseJoinColumns = {
        @JoinColumn(name = "RECEPTIONIST_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Receptionist_1> receptionistCollection;
    @JoinColumn(name = "BED_ID", referencedColumnName = "BED_NO")
    @ManyToOne
    private Bed bedId;
    @JoinColumn(name = "REPORT_ID", referencedColumnName = "REPORT_ID")
    @ManyToOne
    private Report reportId;

    public Patient() {
    }

    public Patient(BigDecimal ssn) {
        this.ssn = ssn;
    }

    public Patient(BigDecimal ssn, String fname, String sname, String lname, Date dateBirth, String mobile, String bloodType, String city) {
        this.ssn = ssn;
        this.fname = fname;
        this.sname = sname;
        this.lname = lname;
        this.dateBirth = dateBirth;
        this.mobile = mobile;
        this.bloodType = bloodType;
        this.city = city;
    }

    public BigDecimal getSsn() {
        return ssn;
    }

    public void setSsn(BigDecimal ssn) {
        this.ssn = ssn;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getInssuranceType() {
        return inssuranceType;
    }

    public void setInssuranceType(String inssuranceType) {
        this.inssuranceType = inssuranceType;
    }

    public BigInteger getInssuranceRebate() {
        return inssuranceRebate;
    }

    public void setInssuranceRebate(BigInteger inssuranceRebate) {
        this.inssuranceRebate = inssuranceRebate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public Character getPatientIn() {
        return patientIn;
    }

    public void setPatientIn(Character patientIn) {
        this.patientIn = patientIn;
    }

    public Character getPatientOut() {
        return patientOut;
    }

    public void setPatientOut(Character patientOut) {
        this.patientOut = patientOut;
    }

    @XmlTransient
    public Collection<Receptionist_1> getReceptionistCollection() {
        return receptionistCollection;
    }

    public void setReceptionistCollection(Collection<Receptionist_1> receptionistCollection) {
        this.receptionistCollection = receptionistCollection;
    }

    public Bed getBedId() {
        return bedId;
    }

    public void setBedId(Bed bedId) {
        this.bedId = bedId;
    }

    public Report getReportId() {
        return reportId;
    }

    public void setReportId(Report reportId) {
        this.reportId = reportId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.me.mybackgroundapp.Patient[ ssn=" + ssn + " ]";
    }
    
}
