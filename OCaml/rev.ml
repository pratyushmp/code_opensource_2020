(* Reverse a list. Usage: rev [a;b;c];; *)
let rev list =
    let rec aux acc = function
      | [] -> acc
      | h::t -> aux (h::acc) t in
    aux [] list;;
