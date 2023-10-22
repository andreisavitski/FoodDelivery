package by.pvt.fooddelivery.repository.impl.hibernate;

import by.pvt.fooddelivery.domain.Admin;
import by.pvt.fooddelivery.repository.AdminRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepositoryHibernate extends RepositoryCRUD implements AdminRepository {

    @Override
    public void addAdmin(Admin admin) {
        add(admin);
    }

    @Override
    public void deleteAdminById(Long adminId) {
        deleteById(Admin.class, adminId);
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return getById(Admin.class, id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return getAll(Admin.class);
    }

    @Override
    public void updateAdmin(Admin admin) {
        update(admin);
    }
}
