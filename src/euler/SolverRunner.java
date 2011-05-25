package euler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

public class SolverRunner
{
  public static void main(String[] args)
  {
    SolverRunner runner = new SolverRunner();
    if(args.length > 0){
      for(int i=0; i<args.length; i++){
        runner.run(args[i]);
      }
    }else{
      runner.runAll();
    }
  }
  
  public void run(String clsname)
  {
    Solver solver = null;
    try{
      Class<?> cls = Class.forName(clsname);
      Object obj = cls.newInstance();
      if(obj instanceof Solver){
        solver = (Solver)cls.newInstance();
      }
    }catch(ClassNotFoundException e){
    }catch(IllegalAccessException e){
    }catch(InstantiationException e){
    }
    if(solver != null){
      String out = "null";
      long time = System.nanoTime();
      try{
        out = solver.solve();
      }catch(Exception e){
        e.printStackTrace();
      }
      long nano = System.nanoTime() - time;
      System.out.println(
          solver.getClass().getSimpleName() +
          " (" + String.format("%10.3f", nano/1000000.) + "ms): " +
          out
      );
    }
  }

  public void runAll()
  {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    JavaFileManager fm = compiler.getStandardFileManager(new DiagnosticCollector<JavaFileObject>(), null, null);
    Set<JavaFileObject.Kind> kinds = new HashSet<JavaFileObject.Kind>();
    kinds.add(JavaFileObject.Kind.CLASS);

    Iterable<JavaFileObject> list = null;
    try{
      list = fm.list(StandardLocation.CLASS_PATH, "euler", kinds, true);
    }catch(IOException e){
      e.printStackTrace();
    }
    for(JavaFileObject f : list){
      run(getClassname(f.toUri().getPath()));
    }
  }
  
  public String getClassname(String path)
  {
    String[] arr = path.substring(0, path.lastIndexOf('.')).split("/");
    int idx = arr.length - 1;
    StringBuffer sb = new StringBuffer();
    while(true){
      sb.insert(0, arr[idx]);
      if(arr[idx].equals("euler")){
        break;
      }
      sb.insert(0, ".");
      idx --;
    }
    return sb.toString();
  }
  
}