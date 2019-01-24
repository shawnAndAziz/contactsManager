public class Person {
    private String name;
    private String number;

    public Person(String name, String phoneNumber){
        setName(name);
        setNumber(phoneNumber);

    }
    // GETTER => getes a value
    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
    // setter = >sets a value
    public void setName(String name){
        this.name = name;
    }
    public void setNumber(String number){
        this.number = number;
    }

    public void sayHello(){
        System.out.println("Hello " + name);
    }

}
