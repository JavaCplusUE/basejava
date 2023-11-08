/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int countResumes;

    void clear() {
        for (int i = 0; i < countResumes; i++) {
            storage[i] = null;
        }
        countResumes = 0;
    }

    void save(Resume r) {
        if (r.uuid == null) {
            return;
        }
        if (countResumes < storage.length) {
            storage[countResumes] = r;
        }
        countResumes++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (uuid == storage[i].uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {

        for (int i = 0; i < countResumes; i++) {
            if (storage[i].uuid == uuid) {
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
    Resume[] getAll() {
        Resume[] allResume = new Resume[countResumes];
        for (int i = 0; i < countResumes; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    int size() {
        return countResumes;
    }
}
