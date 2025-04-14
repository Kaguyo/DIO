function apiVersion(version : string) {
    return (target: any) => {
        Object.assign(target.prototype, { __version: version});
        console.log(Object.getPrototypeOf(target.prototype));
    };
    
}

@apiVersion("1.0.0")
class Api {
    name: string = "api";
    version: string = "1.0.0";
}

const api = new Api();
console.log(Reflect.ownKeys(api));
console.log(Object.getOwnPropertyNames(api));