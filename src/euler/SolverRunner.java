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
        try{
          runner.run("euler.Solver" + args[i]);
        }catch(Exception e){
          //e.printStackTrace();
        }
      }
    }else{
      runner.runAll();
    }
  }
  
  public void run(String clsname) throws Exception
  {
    Class<?> cls = Class.forName(clsname);
    Solver solver = (Solver)cls.newInstance();
    long time = System.nanoTime();
    String out = "null";
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

  public void runAll()
  {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    JavaFileManager fm = compiler.getStandardFileManager(new DiagnosticCollector<JavaFileObject>(), null, null);
    Set<JavaFileObject.Kind> kinds = new HashSet<JavaFileObject.Kind>();
    kinds.add(JavaFileObject.Kind.CLASS);

    Iterable<JavaFileObject> list = null;
    try{
      list = fm.list(StandardLocation.CLASS_PATH, "euler", kinds, false);
    }catch(IOException e){
      e.printStackTrace();
    }
    for(JavaFileObject f : list){
      String clsname = "euler." + f.getName().substring(0, f.getName().lastIndexOf('.'));
      try{
        run(clsname);
      }catch(Exception e){
        //e.printStackTrace();
      }
    }
  }
  
}