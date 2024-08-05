package com.outbound.spring_outbound.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "insured_person")
public class InsuredPerson extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "journey_from")
    private String journeyFrom = "Myanmar";

    @Column(name = "contact_phone_no")
    private int contactPhoneNo;

    @Column(name = "foreign_contact_no")
    private int foreignContactNo;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "race")
    private String race;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "address_in_myanmar")
    private String addressInMyanmar;

    @Column(name = "address_abroad")
    private String addressAbroad;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "passport_issued_date")
    private LocalDate passportIssuedDate;

    @Column(name = "NRC")
    private String NRC;

    @Column(name = "isChild")
    private boolean forChild;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "journey_to_id")
    private Country JourneyTo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "destination_country_id")
    private Country countryForDestination;

    @ManyToOne
    @JoinColumn(name="passport_issued_country_id")
    private Country passportIssuedCountry;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiary_id")
    private BeneficiaryInfomation beneficiaryInfomation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJourneyFrom() {
        return journeyFrom;
    }

    public void setJourneyFrom(String journeyFrom) {
        this.journeyFrom = journeyFrom;
    }

    public int getContactPhoneNo() {
        return contactPhoneNo;
    }

    public void setContactPhoneNo(int contactPhoneNo) {
        this.contactPhoneNo = contactPhoneNo;
    }

    public int getForeignContactNo() {
        return foreignContactNo;
    }

    public void setForeignContactNo(int foreignContactNo) {
        this.foreignContactNo = foreignContactNo;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddressInMyanmar() {
        return addressInMyanmar;
    }

    public void setAddressInMyanmar(String addressInMyanmar) {
        this.addressInMyanmar = addressInMyanmar;
    }

    public String getAddressAbroad() {
        return addressAbroad;
    }

    public void setAddressAbroad(String addressAbroad) {
        this.addressAbroad = addressAbroad;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportIssuedDate() {
        return passportIssuedDate;
    }

    public void setPassportIssuedDate(LocalDate passportIssuedDate) {
        this.passportIssuedDate = passportIssuedDate;
    }

    public String getNRC() {
        return NRC;
    }

    public void setNRC(String NRC) {
        this.NRC = NRC;
    }

    public boolean isForChild() {
        return forChild;
    }

    public void setForChild(boolean forChild) {
        this.forChild = forChild;
    }

    public Country getJourneyTo() {
        return JourneyTo;
    }

    public void setJourneyTo(Country journeyTo) {
        JourneyTo = journeyTo;
    }

    public Country getCountryForDestination() {
        return countryForDestination;
    }

    public void setCountryForDestination(Country countryForDestination) {
        this.countryForDestination = countryForDestination;
    }

    public Country getPassportIssuedCountry() {
        return passportIssuedCountry;
    }

    public void setPassportIssuedCountry(Country passportIssuedCountry) {
        this.passportIssuedCountry = passportIssuedCountry;
    }

    public BeneficiaryInfomation getBeneficiaryInfomation() {
        return beneficiaryInfomation;
    }

    public void setBeneficiaryInfomation(BeneficiaryInfomation beneficiaryInfomation) {
        this.beneficiaryInfomation = beneficiaryInfomation;
    }
}