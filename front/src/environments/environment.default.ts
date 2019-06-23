import * as project from "~root/package.json";

export const environment: any = {
    version: (project as any).version,
    name: (project as any).name,
    project: (project as any).project,
    production: false,
    ignorePermissions: false
};
