const p = require("./services/products").default;
const config = require("./services/config");
const dbSet = require("./services/database");
const { createUser } = require("./services/database");
createUser({ name : "João" });

async function main() {
    console.log("carrinho compra:");
    p.getFullName("403", "mousepad");
    p.getPrice("403", "mousepad\n");
    // console.log(config.client);
}

main(); 


