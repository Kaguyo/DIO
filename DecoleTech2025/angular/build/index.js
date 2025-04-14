"use strict";
function concatArray(...itens) {
    return new Array().concat(...itens);
}
const numArray = concatArray([1, 22], [3]);
const stgArray = concatArray(["goku", "vegeta"], ["trunks"]);
