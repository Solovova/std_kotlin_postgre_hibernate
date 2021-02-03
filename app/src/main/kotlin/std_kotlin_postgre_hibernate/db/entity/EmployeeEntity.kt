package std_kotlin_postgre_hibernate.db.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(
    name = "Employee"
)
class EmployeeEntity : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "EMPLOYEE_id_seq")
    @SequenceGenerator(allocationSize = 5000, name="EMPLOYEE_id_seq", sequenceName="EMPLOYEE_id_seq")
    @Column(name = "ID", unique = true, nullable = false)
    private val employeeId: Int? = null

    @Column(name = "FIRST_NAME", length = 255)
    private var firstName: String? = null
    fun setFirstName(firstName:String) {
        this.firstName = firstName
    }

    @Column(name = "LAST_NAME", length = 255)
    private var lastName: String? = null // Accessors and mutators for all four fields
    fun setLastName(lastName:String) {
        this.lastName = lastName
    }

    companion object {
        private const val serialVersionUID = 7263309927526074109L
    }
}