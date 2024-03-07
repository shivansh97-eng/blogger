import com.Blogger2.Employee;
import com.Blogger2.Movie;
import com.Blogger2.MovieName;
import com.Blogger2.MovieYear;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainUtil {
//    public static void main(String[] args) {
//        Predicate<Integer> condtn = x->x>10;
//        boolean test = condtn.test(5);
//        System.out.println(test);
//    }


//    public static void main(String[] args) {
//        Predicate<String> condtn = x->x.equals("mike");
//        boolean test = condtn.test("mike");
//        System.out.println(test);
//    }


//    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(10, 20, 30, 40, 50);
//        List<Integer> collect = data.stream().filter(x -> x > 10).collect(Collectors.toList());
//        System.out.println(collect);
//    }


    //01/12/23

//    public static void main(String[] args) {                                  //prefix to find String
//        List<String> data = Arrays.asList("mike", "mohn", "james", "lame");
//        List<String> collect = data.stream().filter(x -> x.startsWith("m")).collect(Collectors.toList());
//        System.out.println(collect);
//    }


//    public static void main(String[] args) {                                    //suffix to find String
//        List<String> data = Arrays.asList("mike", "lame", "Kim");
//        List<String> collect = data.stream().filter(x -> x.endsWith("e")).collect(Collectors.toList());
//        System.out.println(collect);
//    }


//    public static void main(String[] args) {                                    //count same String appeared in the List
//        List<String> data = Arrays.asList("mike", "mike", "john", "mike");
//        List<String> collect = data.stream().filter(x -> x.equals("mike")).collect(Collectors.toList());
//        System.out.println(collect.size());
//    }


                                                                                    //Employee

//    public static void main(String[] args) {
//        Employee e1 = new Employee();
//        e1.setName("john");
//        e1.setCity("Bhilai");
//        e1.setSalary(10000);
//
//        Employee e2 = new Employee();
//        e2.setName("Sam");
//        e2.setCity("Bangalore");
//        e2.setSalary(2000);
//
//        Employee e3 = new Employee();
//        e3.setName("Johnap");
//        e3.setCity("Chennai");
//        e3.setSalary(5000);
//
//        Employee e4 = new Employee();
//        e4.setName("Kim");
//        e4.setCity("Kolkata");
//        e4.setSalary(10000);

//        List<Employee> data = Arrays.asList(e1, e2, e3, e4);
//        List<Employee> collect = data.stream().filter(x -> x.getSalary() == 10000).collect(Collectors.toList());
//
//        for (Employee employee:collect){
//            System.out.println(employee.getName());
//            System.out.println(employee.getSalary());
//            System.out.println(employee.getCity());
//        }


//        List<Employee> data = Arrays.asList(e1, e2, e3, e4);
//        List<Employee> collect = data.stream().filter(x -> x.getCity().equalsIgnoreCase("bhilai")).collect(Collectors.toList());
//
//        for (Employee employee:collect){
//            System.out.println(employee.getName());
//            System.out.println(employee.getSalary());
//            System.out.println(employee.getCity());
//        }
//
//    }


    //map-its used for the n numbers of list execution at the same time

//    public static void main(String[] args) {                                              //square
//        List<Integer> data = Arrays.asList(10, 2, 3, 4);
//        List<Integer> collect = data.stream().map(n -> n * n).collect(Collectors.toList());
//        System.out.println(collect);
//    }


//    public static void main(String[] args) {                                                //Double divide by double
//        List<Double> data = Arrays.asList(1.2, 3.3, 2.3, 4.1);
//        List<Double> collect = data.stream().map(n -> n / 2.1).collect(Collectors.toList());
//        System.out.println(collect);
//    }


    //Sort

//    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(10, 2, 3, 1);
//        List<Integer> collect = data.stream().sorted().collect(Collectors.toList());
//        System.out.println(collect);
//    }


    //Remove Duplicate

//    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(2, 2, 1, 3, 4, 1);
//        List<Integer> collect = data.stream().distinct().collect(Collectors.toList());
//        System.out.println(collect);
//    }



    //04/12/23

    //Sorting of the objects on their parameters

//    public static void main(String[] args) {
//        Movie m1 = new Movie("bbb",8,1999);
//        Movie m2 = new Movie("aaa",4,2000);
//        Movie m3 = new Movie("ccc",9,1994);
//
//        ArrayList<Movie> list = new ArrayList<Movie>();
//
//        list.add(m1);
//        list.add(m2);
//        list.add(m3);
//
////        Collections.sort(list);             //Comparable- compareTo , for year and name sort
//
//        MovieYear movieYear = new MovieYear();
//        MovieName movieName = new MovieName();
////        Collections.sort(list,movieYear);      //Comparator- compare, for year and name
//        Collections.sort(list,movieName);
//
//        for (Movie movie:list){
//            System.out.println(movie.getName());
//            System.out.println(movie.getRating());
//            System.out.println(movie.getYear());
//        }
//
//    }


    //Max and Min val in the given list


//    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(4000, 20, 500, 4000);
//        Integer maxVal = data.stream().max(Integer::compareTo).get();
//        Integer minVal = data.stream().min(Integer::compareTo).get();
//
//        System.out.println(maxVal);
//        System.out.println(minVal);
//    }

    //Max and Min val from given object

//    public static void main(String[] args) {
//        Employee e1 = new Employee("John",5000,"Bhilai");
//        Employee e2 = new Employee("Mike",2000,"Bangalore");
//        Employee e3 = new Employee("Jame",500,"Raipur");
//
//        List<Employee> data = Arrays.asList(e1, e2, e3);
//        Employee employee = data.stream().max(Employee::compareTo).get();
//
//        System.out.println(employee.getName());
//        System.out.println(employee.getSalary());
//        System.out.println(employee.getCity());
//    }


    //05/12/23

    //Grouping of the objects

    public static void main(String[] args) {
        List<Employee> data = Arrays.asList(
                new Employee("John", 5000, "Bhilai"),
                new Employee("James", 10000, "Raipur"),
                new Employee("Mike", 5000, "Bangalore")
        );

        Map<Double, List<Employee>> groups = data.stream().collect(Collectors.groupingBy(Employee::getSalary));

        for (Map.Entry<Double, List<Employee>> entry :groups.entrySet()){
            Double salary = entry.getKey();
            List<Employee> employeeList = entry.getValue();
            System.out.println("Salary:"+salary+":of:");
            for (Employee employee:employeeList){
                System.out.println(employee.getName());
            }
        }

    }

}
