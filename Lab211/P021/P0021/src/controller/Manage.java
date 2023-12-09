/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import model.Student;

/**
 *
 * @author d
 */
public class Manage {

    public ArrayList<Student> listStudent;

    public Manage() {
        listStudent = new ArrayList<>();
        listStudent.add(new Student("SE1", "long", "1", "Java"));
        listStudent.add(new Student("SE1", "long", "2", ".Net"));
        listStudent.add(new Student("SE1", "long", "3", "C/C++"));
        listStudent.add(new Student("SE2", "long", "1", "Java"));
        listStudent.add(new Student("SE2", "long", "2", "Java"));
        listStudent.add(new Student("SE3", "ha", "6", "C/C++"));
        listStudent.add(new Student("SE4", "nam", "1", "Java"));
        listStudent.add(new Student("SE5", "ha", "1", ".Net"));
        listStudent.add(new Student("SE5", "ha", "2", "Java"));
        //listStudent.add(new Student("SE6", "nam", "9", "Java"));
    }

    public void addStudent(Student student) {
        listStudent.add(student);
    }

    public boolean checkIDAndName(String id, String name) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id) && !student.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getListStudentByName(String name) {
        ArrayList<Student> listStudentByName = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getName().toUpperCase().contains(name.toUpperCase())) {
                listStudentByName.add(student);
            }
        }
        return listStudentByName;
    }

    public void sortStudentByName(ArrayList<Student> listStudent) {
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student firstStudent, Student secondStudent) {
                int sortName = firstStudent.getName().compareToIgnoreCase(secondStudent.getName());
                if (sortName == 0) {
                    int sortId = firstStudent.getId().compareToIgnoreCase(secondStudent.getId());
                    if (sortId == 0) {
                        int sortSemester = firstStudent.getSemester().compareToIgnoreCase(secondStudent.getSemester());
                        if (sortSemester == 0) {
                            return firstStudent.getCourse().compareToIgnoreCase(secondStudent.getCourse());
                        } else {
                            return firstStudent.getSemester().compareToIgnoreCase(secondStudent.getSemester());
                        }
                    } else {
                        return sortId;
                    }
                } else {
                    return sortName;
                }
            }
        });
    }

    public ArrayList<Student> getListStudentByID(String id) {
        ArrayList<Student> listStudentByID = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                listStudentByID.add(student);
            }
        }
        return listStudentByID;
    }

    public void displayStudent(ArrayList<Student> listStudentByID) {
        int numericalOrder = 1;
        for (Student student : listStudentByID) {
            System.out.printf("%-15d | ", numericalOrder++);
            student.display();
        }
    }

    public boolean isStudentExist(String id, String name, String semester, String course) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id) && student.getName().equalsIgnoreCase(name)
                    && student.getSemester().equalsIgnoreCase(semester) && student.getCourse().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIDSemesterCourse(String idUpdate, String semesterUpdate, String courseUpdate) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(idUpdate) && student.getSemester().equalsIgnoreCase(semesterUpdate)
                    && student.getCourse().equalsIgnoreCase(courseUpdate)) {
                return true;
            }
        }
        return false;
    }

    public Map<String, Integer> getListReport() {
        Map<String, Integer> listReport = new HashMap<>();
        for (Student student : listStudent) {
            String key = student.getId() + "|" + student.getName() + "|" + student.getCourse();
            if (listReport.containsKey(key.toLowerCase())) {
                int total = listReport.get(key.toLowerCase());
                listReport.put(key.toLowerCase(), total + 1);
            } else {
                listReport.put(key.toLowerCase(), 1);
            }
        }
        return listReport;
    }

    public void displayListReport(Map<String, Integer> listReport) {
        for (Map.Entry<String, Integer> entry : listReport.entrySet()) {
            String[] data = entry.getKey().split("[|]");
            String resultName = "";
            String name = data[1].trim();
            if (name.contains(" ")) {
                String listName[] = name.split("\\s+");
                for (int i = 0; i < listName.length; i++) {
                    resultName += listName[i].substring(0, 1).toUpperCase()
                            + listName[i].substring(1).toLowerCase() + " ";
                }
            } else {
                resultName = name.substring(0, 1).toUpperCase() + name.substring(1);
            }
            String course = data[2];
            System.out.printf("%-10s | %-10s | %-5d\n", resultName.trim(), course, entry.getValue());
        }
    }

    public void setAllNameStudent(String idUpdate, String nameUpdate) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(idUpdate)) {
                student.setName(nameUpdate);
            }
        }
    }
}
