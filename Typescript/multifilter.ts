// Filter array of objects with multiple object enclosed keys
// like a multifilter used in e-commerce


export const MultiFilter = (item, condition) => {
    const filterKeys = Object.keys(condition);
    return item.filter((eachObj) =>  {
        return filterKeys.every(eachKey => {
            if(condition[eachKey] == null || !condition[eachKey].length){
                return true; // passing an empty filter means that filter is ignored
            }
            return (condition[eachKey].toString()).toLowerCase().includes((eachObj[eachKey]).toString().toLowerCase());
        })
    })
}