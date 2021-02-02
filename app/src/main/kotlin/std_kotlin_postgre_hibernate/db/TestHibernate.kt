package std_kotlin_postgre_hibernate.db

import std_kotlin_postgre_hibernate.db.HibernateUtil.sessionFactory
import std_kotlin_postgre_hibernate.db.HibernateUtil.shutdown
import std_kotlin_postgre_hibernate.db.entity.EmployeeEntity


object TestHibernate {
    @JvmStatic
    fun main(args: Array<String>) {
        val session = sessionFactory.openSession()
        session.beginTransaction()

        //Add new Employee object
        val emp = EmployeeEntity()
        emp.("demo-user@mail.com")
        emp.setFirstName("demo")
        emp.setLastName("user")
        session.save(emp)
        session.transaction.commit()
        shutdown()
    }
}