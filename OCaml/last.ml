(* Last element of a list. Usage: last [a;b;c];; *)
let rec last = function
    | [] -> None
    | [x] -> Some x
    | _ :: t -> last t;;
