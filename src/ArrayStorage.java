/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int a = 1;
        if (size() < 10) {
            storage[size()] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++)
            if (uuid == String.valueOf(storage[i])) {
                return storage[i];
            }
        return null;
    }

    void delete(String uuid) {
        Resume[] newStorage = new Resume[10];
        for (int i = 0, j = 0; i < size(); i++) {
            if (String.valueOf(storage[i]) != uuid)
                newStorage[j++] = storage[i];
        }
        storage = newStorage;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] getStorage = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            getStorage[i] = storage[i];
        }
        return getStorage;
    }

    int size() {

        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                count++;
            }
        }
        return count;

    }
}
