/* Author: your name
 * Date: 4/11/19
 * Desc: Employee class represents an employee
 */
package business;

public class Employee {

    //data fields
    private long empNumber;
    private long phone;
    private int payCode;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String gender;
    private String status;
    private String hireDate;
    private String termDate;

    //constructor
    public Employee() {
        empNumber = 0;
        phone = 0;
        payCode = 0;
        String[] fields = {firstName, lastName, middleName, suffix,
            address1, address2, city, state, zip, gender, status, hireDate, termDate
        };
        for (String s : fields) {
            s = "";
        }
    }

    public Employee(long empno, long phone, int paycode, String lastName, String firstName,
            String middleName, String suffix, String address1, String address2,
            String city, String state, String zip, String gender, String status,
            String hireDate, String termDate) {
        this.empNumber = empno;
        this.phone = phone;
        this.payCode = paycode;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.gender = gender;
        this.status = status;
        this.hireDate = hireDate;
        this.termDate = termDate;
    }

    public long getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(long empNumber) {
        this.empNumber = empNumber;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getPayCode() {
        return payCode;
    }

    public void setPayCode(int payCode) {
        this.payCode = payCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return this.lastName + ", " + this.firstName + " " + this.middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getTermDate() {
        return termDate;
    }

    public void setTermDate(String termDate) {
        this.termDate = termDate;
    }

    public String toString() {
        return this.empNumber + "," + this.firstName + ","
                + this.lastName + "," + this.middleName + ","
                + this.suffix + ","
                + this.address1 + ","
                + this.address2 + ","
                + this.city + ","
                + this.state + ","
                + this.zip + ","
                + this.phone + ","
                + this.gender + ","
                + this.status + ","
                + this.hireDate + ","
                + this.termDate + ","
                + this.payCode;
    }
}
