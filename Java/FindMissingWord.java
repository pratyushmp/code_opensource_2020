

public class FindMissingWord {

    public static void main(String [] args)
    {
        String t = "I am using hackerrank to improve programming";
        String s = "am hackerrank to improve";
        String[] str = missingwords(t,s);
        for(int i=0;i<str.length;i++)
            System.out.println(str[i]);


    }
    public static String[] missingwords(String t,String s){

        String[] a = t.split(" ");
        String[] b = s.split(" ");
        int sz = a.length - b.length;
        String [] missing = new String[sz];
        int c = 0;
        for(int i=0;i<a.length;i++){
            int flag=0;
            for(int j=0;j<b.length;j++){
                if(a[i].equals(b[j]))
                    flag=1;
            }
            if(flag==0){
                missing[c++]=a[i];

            }
        }
        return missing;

    }

}

