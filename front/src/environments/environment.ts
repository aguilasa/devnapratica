import "zone.js/dist/zone-error";

import { environment as def } from "~environments/environment.default";

export const environment: any = {
    ...def,
    restUrl: "https://platform-homologx.senior.com.br/t/senior.com.br/bridge/1.0/rest/furb/basico",
    // ignorePermissions: true,
};
