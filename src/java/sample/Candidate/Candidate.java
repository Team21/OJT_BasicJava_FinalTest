/* 
 * Le Hung Thien
 * ThienLH1
 * FSOFT OJT
 * 09.02.2015
 * Basic Java Final Test
 **/

package sample.Candidate;

import java.util.Calendar;

/**
 *
 * @author thienlh
 */
public class Candidate {

    private int id;
    private String FirstName;
    private String LastName;
    private int BirthDate;  //  Year only
    private String Address;
    private String Phone;
    private String Email;
    private int Candidate_type;

    public Candidate() {
    }

    public Candidate(int id, String FirstName, String LastName, int Candidate_type) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Candidate_type = Candidate_type;
    }

    public Candidate(String FirstName, String LastName, int BirthDate, String Address, String Phone, String Email, int Candidate_type) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BirthDate = BirthDate;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
        this.Candidate_type = Candidate_type;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the BirthDate
     */
    public int getBirthDate() {
        return BirthDate;
    }

    /**
     * @param BirthDate the BirthDate to set
     */
    public void setBirthDate(int BirthDate) {
        this.BirthDate = BirthDate;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Candidate_type
     */
    public int getCandidate_type() {
        return Candidate_type;
    }

    /**
     * @param Candidate_type the Candidate_type to set
     */
    public void setCandidate_type(int Candidate_type) {
        this.Candidate_type = Candidate_type;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid() {
        boolean isValid = true;
        //  Email validation
        String form = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(form);
        java.util.regex.Matcher m = p.matcher(this.getEmail());

        if (!m.matches()) {
            isValid = false;
        }
        //  BirthDate
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (this.getBirthDate() < 1900 || this.getBirthDate() >= currentYear) {
            isValid = false;
        }
        //  Phone
        long phoneValid = Long.parseLong(this.getPhone());
        if (phoneValid<1000000) {
            isValid = false;
        }

        return isValid;
    }

    @Override
    public String toString() {
        return "Candidate{" + "id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", BirthDate=" + BirthDate + ", Address=" + Address + ", Phone=" + Phone + ", Email=" + Email + ", Candidate_type=" + Candidate_type + '}';
    }

}
