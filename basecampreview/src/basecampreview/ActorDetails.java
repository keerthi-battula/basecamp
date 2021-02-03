package basecampreview;
public class ActorDetails {
private int Id;
private String name;
private String Industry;
private double salary;
public ActorDetails(int id, String name, String industry, double salary) {
	super();
	Id = id;
	this.name = name;
	Industry = industry;
	this.salary = salary;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIndustry() {
	return Industry;
}
public void setIndustry(String industry) {
	Industry = industry;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}
