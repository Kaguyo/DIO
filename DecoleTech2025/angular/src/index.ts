function SelectCharacterByIndex(index:number | string):string {
    let character:string = "";
    if (index == 1 || index == "1")
        character = "Ellie";
    else if (index == 2 || index == "2")
        character = "Joel";
    else if (index == 3 || index == "3")
        character = "Tommy";
    
    return character;
}

console.log(SelectCharacterByIndex(2));