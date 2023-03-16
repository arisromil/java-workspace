package optional.dao;

import java.util.Optional;

public class Department {
    private Manager manager;

    public Optional<Manager> getManager() {
        return Optional.ofNullable(manager);
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
