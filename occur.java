import java.io.*;
import java.util.*;
public class occur
{
public static void main(String[] arg)
{
Scanner sc=new Scanner(System.in);
String str=sc.next();
Map<Character , Integer> hmap = new HashMap<>();
for(char c: str.toCharArray())
{
if(hmap.containsKey(c))
{
hmap.put(c,hmap.get(c) +1);
}
else
{
hmap.put(c,1);
}}
System.out.println(hmap);
}
}