package sample;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Student extends Person
{
    int serial;
    int rollno;
    String fatherwork;
    String classname;
    int classfee;
    int fee=0;
    boolean feesubmited=false;



    public Student(int serial,String name,String fatherName,String gender,String cnic,String classname,int rollno,LocalDate birthday,String phoneNumber,String fatherwork,String religion,String address) {
        super(name, fatherName,cnic, gender, birthday, religion, phoneNumber, address);
        this.rollno = rollno;
        this.fatherwork = fatherwork;
        this.classname = classname;
        this.serial=serial;
        setclassFee();
    }




    public void setclassFee()
    {
        if(classname.equalsIgnoreCase("nursery"))
            classfee=200;
        if(classname.equalsIgnoreCase("prep"))
            classfee=200;
        if(classname.equalsIgnoreCase("one"))
            classfee=300;
        if(classname.equalsIgnoreCase("two"))
            classfee=300;
        if(classname.equalsIgnoreCase("three"))
            classfee=300;
        if(classname.equalsIgnoreCase("four"))
            classfee=300;
        if(classname.equalsIgnoreCase("five"))
            classfee=350;
        if(classname.equalsIgnoreCase("six"))
            classfee=350;
        if(classname.equalsIgnoreCase("seven"))
            classfee=350;
        if(classname.equalsIgnoreCase("eight"))
            classfee=350;
    }
    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getFatherwork() {
        return fatherwork;
    }

    public void setFatherwork(String fatherwork) {
        this.fatherwork = fatherwork;
    }

    @Override
    public String toString()
    {
        return "Name:"+ super.name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getSerial()
    {
        return this.serial;
    }
    public int getFee()
    {
        feeManger();
        return fee;
    }

    public void feeManger()
    {
        LocalDate time = null;
        LocalDate current =time.now();
        System.out.println(current);
        LocalDate temp1=current.plusMonths(1);
        LocalDate temp=temp1.withDayOfMonth(1);
        long days = temp.until( current, ChronoUnit.DAYS);
        if(current.isAfter(temp))
        {
            fee+=classfee;
            if(feesubmited==false && days>7)
                fee+=10*(days-7);
        }
    }

    public String submitFee(int amount)
    {
        String message="";
        fee-=amount;
        message+="Fee is successfully submitted";
        return message;
    }

}
