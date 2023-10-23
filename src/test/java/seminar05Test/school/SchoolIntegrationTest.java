package seminar05Test.school;

import org.junit.jupiter.api.Test;
import seminar05.school.Person;
import seminar05.school.School;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchoolIntegrationTest {
    @Test
    public void testSchoolIntegration(){
        // Задание
        // 1. Создайте учебное заведение
        School school = new School();

        // 2. Добавьте преподавателя (Леонид) и студентов (Петя, Вася) в учебное заведение
        Person person01 = new Person("Леонид", true);
        Person person02 = new Person("Петя", false);
        Person person03 = new Person("Вася", false);

        school.addPerson(person01);
        school.addPerson(person02);
        school.addPerson(person03);

        // 3. Проверьте что Леонид является преподавателем
        assertTrue(school.isTeacherInSchool("Леонид"));

        // 4. Проверьте что Вася является студентом
        assertTrue(school.isStudentInSchool("Вася"));

        // 5. Добавьте еще одного студента и убедитесь что он тоже является студентом.
        Person person04 = new Person("Lena", false);
        school.addPerson(person04);

        assertFalse(school.isTeacherInSchool("Lena"));
        assertTrue(school.isStudentInSchool("Lena"));

        // Используйте методы addPerson, isTeacherInSchool, isStudentInSchool из класса School
        // Проверьте что результаты соответствуют ожиданиям

    }
}
