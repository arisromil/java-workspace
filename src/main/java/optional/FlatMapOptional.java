package optional;

import optional.dao.Company;
import optional.dao.Department;
import optional.dao.Manager;

import java.util.Optional;

// Using the flatMap method in Optional to avoid wrapping an Optional inside another Optional
// e.g. Even possible to wrap the company in an Optional,
// then just use Optional.flatMap repeatedly to get to whatever property you want,
// finishing with an Optional.map operation.

public class FlatMapOptional {

    public static void main(String[] args) {

        Manager mrSlate = new Manager("Mr. Burns");

        Department d = new Department();
        d.setManager(mrSlate);

        Company co = new Company();
        co.setDepartment(d);

        Optional<Company> company = Optional.of(co);
        System.out.println(
                company.flatMap(Company::getDepartment)
                       .flatMap(Department::getManager)
                       .map(Manager::getName));
    }

}
