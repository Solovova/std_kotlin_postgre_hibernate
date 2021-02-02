package std_kotlin_postgre_hibernate.db.entity

import org.hibernate.annotations.OptimisticLockType
import java.io.Serializable
import javax.persistence.*

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(
    name = "Employee",
    uniqueConstraints = [UniqueConstraint(columnNames = "ID"), UniqueConstraint(columnNames = "EMAIL")]
)
class EmployeeEntity : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private val employeeId: Int? = null

    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private val email: String? = null

    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private val firstName: String? = null

    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private val lastName: String? = null // Accessors and mutators for all four fields

    companion object {
        private const val serialVersionUID = -1798070786993154676L
    }
}