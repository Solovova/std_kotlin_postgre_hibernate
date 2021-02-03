package std_kotlin_postgre_hibernate.db

import org.hibernate.boot.Metadata
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.hibernate.service.ServiceRegistry
import org.hibernate.tool.hbm2ddl.SchemaExport
import org.hibernate.tool.schema.TargetType
import std_kotlin_postgre_hibernate.db.HibernateUtil.sessionFactory
import std_kotlin_postgre_hibernate.db.HibernateUtil.shutdown
import std_kotlin_postgre_hibernate.db.entity.EmployeeEntity
import java.io.File
import java.util.*


class TestHibernate {
    private val SCRIPT_FILE = "exportScript.sql"

    private fun getSchemaExport(): SchemaExport {
        val export = SchemaExport()
        // Script file.
        val outputFile = File(this.SCRIPT_FILE)
        val outputFilePath: String = outputFile.absolutePath
        println("Export file: $outputFilePath")
        export.setDelimiter(";")
        export.setOutputFile(outputFilePath)

        // No Stop if Error
        export.setHaltOnError(false)
        //
        return export
    }

    fun createDataBase(export: SchemaExport, metadata: Metadata?) {
        // TargetType.DATABASE - Execute on Databse
        // TargetType.SCRIPT - Write Script file.
        // TargetType.STDOUT - Write log to Console.
        val targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT)
        val action = SchemaExport.Action.CREATE
        //
        export.execute(targetTypes, action, metadata)
        println("Export OK")
    }

    fun dropDataBase(export: SchemaExport, metadata: Metadata?) {
        // TargetType.DATABASE - Execute on Databse
        // TargetType.SCRIPT - Write Script file.
        // TargetType.STDOUT - Write log to Console.
        val targetTypes = EnumSet.of(TargetType.DATABASE, TargetType.SCRIPT, TargetType.STDOUT)
        export.drop(targetTypes, metadata)
    }

    fun testDrop() {

        // Using Oracle Database.
        val configFileName = "hibernate.cgf.xml"

        // Create the ServiceRegistry from hibernate-xxx.cfg.xml
        val serviceRegistry: ServiceRegistry = StandardServiceRegistryBuilder() //
            .configure(configFileName).build()
        // Create a metadata sources using the specified service registry.
        val metadata = MetadataSources(serviceRegistry).metadataBuilder.build()
        val export: SchemaExport = this.getSchemaExport()
        println("Drop Database...")
        // Drop Database
        this.dropDataBase(export, metadata)
        println("Create Database...")
        // Create tables
        this.createDataBase(export, metadata)
    }

    fun testDB() {
        val session = sessionFactory.openSession()
        session.beginTransaction()

        for (i in 0..10000) {
            val emp = EmployeeEntity()
            emp.setFirstName("First name $i")
            emp.setLastName("Last name $i")
            session.save(emp)
        }

        session.transaction.commit()
        shutdown()
    }
}