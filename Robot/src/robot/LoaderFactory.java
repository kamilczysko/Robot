package robot;

import com.sun.j3d.loaders.Loader;
import com.sun.j3d.loaders.objectfile.ObjectFile; 
import com.sun.j3d.loaders.lw3d.Lw3dLoader; 


/**
 * Creates loaders for different model types.
 *
 * @author Dalton Filho
 */
public class LoaderFactory {

    
    
    public static final Loader getLightwaveLoader() {
        return new Lw3dLoader();
    }
    

    public static final Loader getWavefrontLoader() {
        return new ObjectFile(ObjectFile.RESIZE); 
    } 
    /**
     * Returns a loader for the model on the given <code>path</code>.
     *
     * @param path the path of the model
     * @throws UnsupportedOperationException if the model type is not supported
     * @return a loader for the model on the given <code>path</code>
     */
    public static final Loader getLoaderForModel(String path) 
        throws UnsupportedOperationException {
        
        if (path.endsWith("obj")) {
        	  System.out.println("obj");
            return new ObjectFile(ObjectFile.RESIZE); 
          
        } else 
        if (path.endsWith("lwo")) {
        	 System.out.println("lwo");
            return new Lw3dLoader(); 
        }
        
        throw new UnsupportedOperationException("Unknown model type");
    }
    
    
}
