const p = require("./services/products");
const config = require("./services/config");

async function main() {
    console.log("carrinho compra:");
    p.getFullName("403", "mousepad");
    p.getPrice("403", "mousepad\n");
    // console.log(config.client);
}

main(); 


