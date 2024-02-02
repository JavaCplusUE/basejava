package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int countResumes;

    public void clear() {
        Arrays.fill(storage, 0, countResumes, null);
        countResumes = 0;
    }

    public void update(Resume r) {
        if (getResume(r.getUuid()) != -1) {
            System.out.println("Resume " + r + " updated");
            storage[getResume(r.getUuid())] = r;
        } else System.out.println("Resume " + r + " no exists");
    }

    public void save(Resume r) {
        if (getResume(r.getUuid()) != -1) {
            System.out.println("Resume " + r + " exists");
        } else if (countResumes < storage.length) {
            storage[countResumes] = r;
            countResumes++;
        }
    }

    public Resume get(String uuid) {
        if (getResume(uuid) != -1) {
            return storage[getResume(uuid)];
        } else {
            System.out.println("Resume " + uuid + " no exists");
            return null;
        }
    }

    public void delete(String uuid) {
        if (getResume(uuid) != -1) {
            System.out.println("Resume " + uuid + " deleted");
            storage[getResume(uuid)] = storage[countResumes - 1];
            storage[countResumes - 1] = null;
            countResumes--;
        } else {
            System.out.println("Resume " + uuid + " no exists");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] allResume = Arrays.copyOf(storage, countResumes);
        return allResume;
    }

    public int size() {
        return countResumes;
    }

    public int getResume(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
