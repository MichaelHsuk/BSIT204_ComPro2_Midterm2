public class Employee {
    private String first_name;
    private String last_name;
    private String address;
    private String email;
    private String job_position;
    private String rate;

    public Employee(String first_name, String last_name, String address, String email, String job_position, String rate) {
        this.first_name = ucfirst(first_name);
        this.last_name = ucfirst(last_name);
        this.address = (address);
        this.email = (email);
        this.job_position = ucfirst(job_position);
        this.rate = ucfirst(rate);
    }

    public String getFullName() {
        return this.last_name + ", " + this.first_name;
    }

    public String getFirstName() {
        return this.first_name;
    }

    public String getAddress() {
        return this.address;
    }     
    public String getemail() {
        return this.email;
    }   
    public String getjob_position() {
        return this.job_position;
    }
    public String getrate() {
        return this.rate;
        
    }

    private String ucfirst(String str) {
        return String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1, str.length());
    }
}