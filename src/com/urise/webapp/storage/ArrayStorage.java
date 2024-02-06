package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int countResumes;

    int index;

    public void clear() {
        Arrays.fill(storage, 0, countResumes, null);
        countResumes = 0;
    }

    public void update(Resume r) {
        index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume " + r + " updated");
            storage[getIndex(r.getUuid())] = r;
        } else {
            System.out.println("Resume " + r + " no exists");
        }
    }

    public void save(Resume r) {
        index = getIndex(r.getUuid());
        if (countResumes > STORAGE_LIMIT) {
            System.out.println("Resume overflow");
        } else if (index != -1) {
            System.out.println("Resume " + r + " exists");
        } else {
            storage[countResumes] = r;
            countResumes++;
        }

    }

    public Resume get(String uuid) {
        index = getIndex(uuid);
        if (index != -1) {
            return storage[getIndex(uuid)];
        } else {
            System.out.println("Resume " + uuid + " no exists");
            return null;
        }
    }

    public void delete(String uuid) {
        index = getIndex(uuid);
        if (index != -1) {
            System.out.println("Resume " + uuid + " deleted");
            storage[getIndex(uuid)] = storage[countResumes - 1];
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
        return Arrays.copyOf(storage, countResumes);
    }

    public int size() {
        return countResumes;
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
