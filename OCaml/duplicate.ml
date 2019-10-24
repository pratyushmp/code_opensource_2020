(* Duplicate each element of a list. Usage: duplicate [a;b;c];; *)
let rec duplicate = function
  | [] -> []
  | h :: t -> h :: h :: duplicate t;;
