/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int sizeStorage;


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
        sizeStorage += 1;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++)
            if (uuid == String.valueOf(storage[i])) {
                return storage[i];
            }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid == uuid) {
                storage[i].uuid = null;
                for (int j = i; j < sizeStorage - i + 1; j++) {
                    Resume temp = storage[j];
                    storage[j] = storage[j + 1];
                    storage[j + 1] = temp;
                }
                sizeStorage -= 1;
                break;
            }
        }



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
        //        int count = 0;
//        for (int i = 0; i < storage.length; i++) {
//            if (storage[i] != null) {
//                count++;
//            }
//        }
        return sizeStorage;

    }
}
