package rk.learn.rest.payroll;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id)
    {
        super("Could not find employee " + id);
    }
}
