public class Worker {
    private  String name;
    private  int age;
    private  double salary;
    public Worker(){ }


    public Worker(String name, int age, double salary){

        this.age=age;
        this.name=name;
        this.salary=salary;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + "  work");
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Worker)){
            return false;
        }
        final Worker person = (Worker) obj;
        if(!this.getName().equals(person.getName())){
            return false;
        }
        if(this.getName() != person.getName()){
            return false;
        }
        if(this.getAge() != person.getAge()){
            return false;
        }
        if(this.getSalary() != person.getSalary()){
            return false;
        }
        return true;

    }



    @Override
    public String toString() {
        return "Worker [age=" + age + ", name=" + name + ", salary=" + salary + "]";
    }
}
