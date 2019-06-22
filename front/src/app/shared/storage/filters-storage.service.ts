import { StorageService } from "./storage.service";

export class FiltersStorageService extends StorageService {
    private FILTERS_KEY = "SENIOR_FILTERS";

    public async storeFilters(key: string, filters: any) {
        const store = (await super.get(this.FILTERS_KEY)) || {};
        store[key] = filters;

        await super.store(this.FILTERS_KEY, store);
    }

    public async getFilters(key: string) {
        const store = (await super.get(this.FILTERS_KEY)) || {};
        return store[key] || {};
    }
}
