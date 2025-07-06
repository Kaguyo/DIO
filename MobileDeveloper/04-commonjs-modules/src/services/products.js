async function getFullName(codeId, productName){
    console.log("product: " + productName + " code: " + codeId);

}

async function getPrice(codeId, productName){
    if (codeId === "403" && productName === "mousepad") {
        console.log("price: R$ 19,90");
    }
}

module.exports = {
    getFullName,
    getPrice,
};