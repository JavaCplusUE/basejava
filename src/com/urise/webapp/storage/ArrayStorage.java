package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int countResumes;

    public void clear() {
        for (int i = 0; i < countResumes; i++) {
            storage[i] = null;
        }
        countResumes = 0;
    }

    public void update(Resume r) {
        for (int i = 0; i < countResumes; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                System.out.println("Resume exists");
                return;
            }
        }
    }

    public void save(Resume r) {
        update(r);
        if (r.getUuid() == null) {
            return;
        }
        if (countResumes < storage.length) {
            storage[countResumes] = r;
        }
        countResumes++;
    }

    public Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (uuid == storage[i].getUuid()) {
                System.out.println("Resume exists");
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].getUuid() == uuid) {
                System.out.println("Resume exists");
                storage[i] = storage[countResumes - 1];
                storage[countResumes - 1] = null;
                countResumes--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] allResume = new Resume[countResumes];
        for (int i = 0; i < countResumes; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    public int size() {
        return countResumes;
    }
}
