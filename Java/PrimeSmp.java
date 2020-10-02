/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParallelPJ2;

import edu.rit.pj2.Loop;
import edu.rit.pj2.Task;

public class PrimeSmp
extends Task
{
// Main program.
public void main
(final String[] args)
throws Exception
{
// Validate command line arguments.
if (args.length < 1) usage();
// Test numbers for primality.
parallelFor (0, args.length - 1) .exec (new Loop()
{
public void run (int i)
{
if (isPrime (Long.parseLong (args[i])))
System.out.printf ("%s%n", args[i]);
}
});
}
// Test the given number for primality.
private static boolean isPrime
(long x)
{
if (x % 2 == 0) return false;
long p = 3;
long psqr = p*p;
while (psqr <= x)
{
if (x % p == 0) return false;
p += 2;
psqr = p*p;
}
return true;
}
// Print a usage message and exit.
private static void usage()
{
System.err.println ("Usage: java pj2 " +
"edu.rit.pj2.example.PrimeSmp <number> ...");
terminate (1);
}
}